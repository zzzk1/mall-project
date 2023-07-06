package com.system.design.mapper;

import com.system.design.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-05
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
