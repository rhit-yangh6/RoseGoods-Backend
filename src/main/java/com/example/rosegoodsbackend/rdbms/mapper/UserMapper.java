package com.example.rosegoodsbackend.rdbms.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.rosegoodsbackend.rdbms.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Chet Zhang
 * @since 2021-09-17
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
