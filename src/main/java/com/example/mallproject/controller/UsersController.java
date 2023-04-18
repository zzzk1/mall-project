package com.example.mallproject.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.Annotation.LoginRequired;
import com.example.mallproject.common.api.*;
import com.example.mallproject.common.utils.JwtUtil;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.controller.dto.UserDTO;
import com.example.mallproject.entity.User;
import com.example.mallproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-12
 */
@RestController
@RequestMapping("/user")
public class UsersController {

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
    public Result<String> login(@RequestBody UserDTO userDTO) {
        ValidatorUtils.checkNull(userDTO, "user");
        ValidatorUtils.checkNull(userDTO.getUsername(), "username");
        ValidatorUtils.checkNull(userDTO.getPassword(), "password");

        String token = JwtUtil.sign(userDTO.getUsername(),userDTO.getPassword());
        if (token != null) {
            return Result.Success(token, "登录成功");
        } else {
            return Result.loginFailed();
        }
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

    @GetMapping("/username/{username}")
    public Result<User> findOne(@PathVariable(value = "username") String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return Result.Success(userService.getOne(queryWrapper));
    }

}
