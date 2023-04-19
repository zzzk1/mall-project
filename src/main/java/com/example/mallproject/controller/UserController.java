package com.example.mallproject.controller;


import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.JwtUtil;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.controller.dto.UserDTO;
import com.example.mallproject.entity.User;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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

//    @PostMapping("/login")
//    public Result<User> login(@RequestBody UserDTO userDTO) {
//        ValidatorUtils.checkNull(userDTO, "user");
//        System.out.println(userDTO);
//        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
//        ValidatorUtils.checkNull(userDTO.getPassword(), "password");
//
//        User loginUser = userService.login(userDTO);
//        if (loginUser == null) {
//           return Result.loginFailed();
//        }
//        session.setAttribute(WebConstant.CURRENT_USER_IN_SESSION, loginUser);
//        return Result.Success(loginUser);
//    }

    @PostMapping("/login")
    public Result<HashMap<String, Object>> login(@RequestBody UserDTO userDTO) {
        ValidatorUtils.checkNull(userDTO, "user");
        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
        ValidatorUtils.checkNull(userDTO.getPassword(), "password");

        String token = JwtUtil.sign(userDTO.getUsername(),userDTO.getPassword());
        if (token != null) {
            HashMap<String, Object> map = new HashMap<>();
            map.put("token", token);
            return Result.Success(map);
        } else {
            return Result.loginFailed();
        }
    }
    @GetMapping("/info")
    public Result<HashMap<String, Object>> info() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roles", "[admin]");
        map.put("name", "admin");
        map.put("avatar", "h");
        return Result.Success(map);
    }

    @PostMapping("/logout")
    public Result loginOut() {
        return null;
    }

    @PostMapping("/register")
    public Result<User> enroll(@RequestBody UserDTO userDTO) {
        ValidatorUtils.checkNull(userDTO, "userDTO");
        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
        ValidatorUtils.checkNull(userDTO.getPassword(), "password");
        User loginUser = userService.enroll(userDTO);
        if (loginUser != null) {
            return Result.Success(loginUser, "注册成功");
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
}
