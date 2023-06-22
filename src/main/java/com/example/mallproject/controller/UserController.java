package com.example.mallproject.controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.api.JwtIgnore;
import com.example.mallproject.common.api.Result;
import com.example.mallproject.common.utils.JwtTokenUtil;
import com.example.mallproject.common.utils.ThreadLocalUtil;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.User;
import com.example.mallproject.entity.dto.UserDTO;
import com.example.mallproject.entity.vo.UserVO;
import com.example.mallproject.service.UserVOService;
import com.example.mallproject.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
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

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @JwtIgnore
    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody UserDTO userDTO) {
        UserVO userVO = userService.login(userDTO);
        return Result.Success(userVO);
    }

    @GetMapping("/page")
    public Result<Page<User>> pageResult(@RequestParam(value = "pageNum", defaultValue = "1") int pageNum,
                                         @RequestParam(value = "pageSize", defaultValue = "5") int pageSize,
                                         @RequestParam(value = "username", defaultValue = "") String username) {
        return Result.Success(userService.selectAll(pageNum, pageSize, username));
    }

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
    public Result findByUsername(@PathVariable String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return Result.Success(userService.getOne(queryWrapper));
    }
}
