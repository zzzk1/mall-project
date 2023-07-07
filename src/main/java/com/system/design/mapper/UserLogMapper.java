package com.system.design.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.system.design.entity.UserLogDO;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzzk1
 * @since 2023-07-07
 */
@Mapper
public interface UserLogMapper extends BaseMapper<UserLogDO> {

}
