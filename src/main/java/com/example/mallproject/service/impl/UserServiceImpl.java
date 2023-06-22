package com.example.mallproject.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mallproject.common.utils.JwtTokenUtil;
import com.example.mallproject.common.utils.ThreadLocalUtil;
import com.example.mallproject.common.utils.ValidatorUtils;
import com.example.mallproject.entity.dto.UserDTO;
import com.example.mallproject.entity.vo.UserVO;
import com.example.mallproject.entity.User;
import com.example.mallproject.mapper.UserMapper;
import com.example.mallproject.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.mallproject.service.UserVOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zzzk1
 * @since 2023-04-19
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> selectAll(int curr, int size, String name) {
        Page<User> page = new Page<>(curr,size, false);
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().like("username", name);
        return userMapper.selectPage(page, queryWrapper);
    }


    @Autowired
    private UserService userService;
    @Autowired
    private UserVOService userVOService;
    @Override
    public UserVO login(UserDTO userDTO) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", userDTO.getEmail());
        queryWrapper.eq("password", userDTO.getPassword());
        User loginUser = userService.getOne(queryWrapper);
        ValidatorUtils.checkNull(loginUser, "loginUser");

        String token = JwtTokenUtil.createToken(JSONObject.toJSONString(loginUser.getUsername()));
        UserVO userVO = new UserVO();
        userVOService.setLoginUserInfo(loginUser, userVO, token);

        ThreadLocalUtil.put("userVO", userVO);
        return userVO;
    }

    @Override
    public User register(UserDTO userDTO) {
        if (userService.getOne(new QueryWrapper<User>().eq("email", userDTO.getEmail())) != null) {
            return null;
        }
        User user = new User();
        user.setEmail(userDTO.getEmail());
        user.setUsername(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        if (userService.save(user)) {
            return user;
        } else {
            return null;
        }
    }

    @Override
    public User getUser(String username) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        return userService.getOne(queryWrapper);
    }
}
