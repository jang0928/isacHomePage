
package com.homeDemo.demo.user;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserRepository {
    List<UserVO> getUserList();
    UserVO getUserById(String id);

    UserVO getUserByEmail(String email);

    UserVO checkUser(UserVO checkuserVO);
}
