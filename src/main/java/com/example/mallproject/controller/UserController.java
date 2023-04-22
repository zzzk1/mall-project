package com.example.mallproject.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.JwtUtil;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.controller.dto.UserDTO;
import com.example.mallproject.entity.Menu;
import com.example.mallproject.entity.User;
import com.example.mallproject.service.MenuService;
import com.example.mallproject.service.UserDTOService;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result<UserDTO> login(@RequestBody UserDTO userDTO) {
        ValidatorUtils.checkNull(userDTO, "user");
        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
        ValidatorUtils.checkNull(userDTO.getPassword(), "password");
        User loginUser = userService.login(userDTO);
        if (loginUser == null) {
            return Result.loginFailed();
        }
        String token = JwtUtil.sign(userDTO.getUsername(),userDTO.getPassword());
        setLoginUserInfo(loginUser, userDTO, token);
        return Result.Success(userDTO, "登录成功");
    }

    @PostMapping("/logout")
    public Result loginOut() {
        return null;
    }

    @PostMapping("/register")
    public Result<UserDTO> enroll(@RequestBody UserDTO userDTO) {
        ValidatorUtils.checkNull(userDTO, "userDTO");
        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
        ValidatorUtils.checkNull(userDTO.getPassword(), "password");
        userDTO.setRole("USER");
        User loginUser = userService.enroll(userDTO);
        String token = JwtUtil.sign(userDTO.getUsername(),userDTO.getPassword());
        if (token != null) {
            setLoginUserInfo(loginUser, userDTO, token);
            return Result.Success(userDTO, "注册成功");
        } else {
            return Result.registerFailed();
        }
    }

    //分页模糊查询
    @GetMapping("/page")
    public Result<Page<User>> pageResult(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                         @RequestParam(value = "username", defaultValue = "") String username) {
        return Result.Success(userService.selectAll(pageNum, pageSize, username));
    }

    //新增或修改
    @PostMapping
    public Result<Boolean> edit(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "user");
        return Result.Success(userService.saveOrUpdate(user));
    }

    @DeleteMapping(("{id}"))
    public Result<Boolean> delete(@PathVariable long id) {
        return Result.Success(userService.removeById(id));
    }

    @PostMapping("/del/batch")
    public Result<Boolean> deleteBatchId(@RequestBody List<Long> ids) {
        return Result.Success(userService.removeBatchByIds(ids));
    }

    @GetMapping("/username/{token}")
    public Result<User> findOne(@PathVariable String token) {
        DecodedJWT jwt = JWT.decode(token);
        String username = jwt.getClaim("username").asString();
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return Result.Success(userService.getOne(queryWrapper));
    }

    private void setLoginUserInfo(User user, UserDTO userDTO, String token) {
        userDTO.setUsername(user.getUsername());
        userDTO.setPassword(null);
        userDTO.setToken(token);
        userDTO.setRole(user.getRole());
        userDTO.setMenus(getAllMenu(userDTO.getRole()));
    }

    @Autowired
    private MenuService menuService;
    @Autowired
    private UserDTOService userDTOService;
    private List<Menu> getAllMenu(String role) {
        List<Integer> ids = userDTOService.getLoginUserMenuIds(role);
        List<Menu> menus = menuService.listByIds(ids);
        return mergedMenus(menus);
    }

    private List<Menu> mergedMenus(List<Menu> menus) {
        //将子菜单分入父菜单
        List<Menu> parentNode = menus.stream().filter(menu -> menu.getPid() == 0).collect(Collectors.toList());
        for (Menu menu : parentNode) {
            menu.setChildren(menus.stream().filter(m -> menu.getId().equals(m.getPid())).collect(Collectors.toList()));
        }
        List<Menu> mergedMenu = new ArrayList<>();
        //获取父菜单
        for (Menu menu : menus) {
            if (menu.getPid() == 0) {
                mergedMenu.add(menu);
            }
        }

        return mergedMenu;
    }
}
