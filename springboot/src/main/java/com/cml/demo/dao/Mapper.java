package com.cml.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cml.demo.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface Mapper extends BaseMapper<User> {
//    @Select("select * from sys_user")
//    public List<User> selectAll();
//    @Insert("insert into sys_user(id,username,email,password,phoneNum) values (0,#{user.username},#{user.email},#{user.password},#{user.phoneNum})")
//    public Integer insert(@Param("user") User user);
//    @Delete("delete from sys_user where id=#{id}")
//    Integer deleteById(@Param("id")Integer id);
//    @Update("update sys_user set username=#{user.username} , email=#{user.email} ,phoneNum=#{user.phoneNum} " +
//            "where id=#{user.id}")
//    Integer update(@Param("user")User user);
//    @Select("select * from sys_user where username like #{username} and email like #{email} and " +
//            "phoneNum like #{phoneNum} limit #{pageNum}, #{pageSize}")
//    List<User>page(@Param("pageNum")Integer pageNum,@Param("pageSize")Integer pageSize,@Param("username")String username,
//                   @Param("email")String email,@Param("phoneNum")String phoneNum);
//   @Select("select count(id) from sys_user where username like #{username} and email like #{email} and " +
//           "phoneNum like #{phoneNum}")
//    Integer selectTotal(String username,String email,String phoneNum);
}
