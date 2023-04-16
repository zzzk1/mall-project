package com.example.mallproject.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.Annotation.LoginRequired;
import com.example.mallproject.Annotation.PermissionRequired;
import com.example.mallproject.common.api.Logical;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.api.UserType;
import com.example.mallproject.common.api.WebConstant;
import com.example.mallproject.common.utils.ValidatorUtils;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserService userService;
    @Autowired
    HttpSession session;

    @PostMapping("/login")
    public Result<User> login(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "user");
        ValidatorUtils.checkNull(user.getName(), "username");
        ValidatorUtils.checkNull(user.getPassword(), "password");

        User loginUser = userService.login(user);
        if (loginUser == null) {
            return Result.Failed(null, "密码错误或用户名错误");
        }
        session.setAttribute(WebConstant.CURRENT_USER_IN_SESSION, loginUser);

        return Result.Success(loginUser, "登录成功");
    }

    @PostMapping("/register")
    public Result<Boolean> enroll(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "user");
        ValidatorUtils.checkNull(user.getName(), "username");
        ValidatorUtils.checkNull(user.getPassword(), "password");

        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("name", user.getName());

        if (userService.getOne(userQueryWrapper) != null) {
            return Result.Failed( false,"用户名已存在");
        }
        userService.enroll(user);
        session.setAttribute("user", user);
        return Result.Success(true, "注册成功");
    }

    @LoginRequired
    @GetMapping("logout")
    public Result<Boolean> logout() {
        User loginUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        ValidatorUtils.checkLogin(loginUser);
        session.removeAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        return Result.Success(true, "退出成功");
    }

    //用户查询自身信息
    @PermissionRequired(userType = {UserType.USER, UserType.ADMIN}, logical = Logical.OR)
    @GetMapping("user/self")
    public Result<User> getUser() {
        User loginUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        return Result.Success(userService.getById(loginUser.getId()));
    }

    //管理员信息修改
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @PutMapping("/admin")
    public Result<Boolean> updateAdminById(@RequestBody User user) {
        User loginUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        user.setId(loginUser.getId());
        return Result.Success(userService.updateById(user));
    }

    //用户与角色信息
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @GetMapping("/role/{id}")
    public Result<User> getUsersAndRole(@PathVariable int id) {
        return Result.Success(userService.getUserAndRoleById(id));
    }

    //查询所有用户
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @GetMapping("/admin/all")
    public Result<Page<User>> getUsers(@RequestParam int curr, @RequestParam int size) {
        return Result.Success(userService.selectAll(curr, size));
    }
    //查询指定用户
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @GetMapping("/admin/{id}")
    public Result<User> getUserById(@PathVariable long id) {
        return Result.Success(userService.getById(id));
    }

    //用户删除
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @DeleteMapping("/admin/{id}")
    public Result<Boolean> deleteById(@PathVariable long id) {
        return Result.Success(userService.removeById(id));
    }

    //用户添加
    @PermissionRequired(userType = {UserType.ADMIN}, logical = Logical.OR)
    @PostMapping("/admin")
    public Result<Boolean> add(@RequestBody User user) {
        ValidatorUtils.checkNull(user, "用户");
        return Result.Success(userService.save(user));
    }

    //用户信息修改
    @PermissionRequired(userType = {UserType.USER}, logical = Logical.OR)
    @PutMapping("/user")
    public Result<Boolean> updateUserById(@RequestBody User user) {
        User loginUser = (User) session.getAttribute(WebConstant.CURRENT_USER_IN_SESSION);
        user.setId(loginUser.getId());
        return Result.Success(userService.updateById(user));
    }

}
