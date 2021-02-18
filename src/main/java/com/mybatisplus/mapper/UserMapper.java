package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mybatisplus.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Auther: GongXl
 * @Date: 026 21:24
 * @Description:
 */
@Repository
@Mapper
public interface UserMapper extends BaseMapper<User> {
}