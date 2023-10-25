package com.homeDemo.demo.user;


import java.util.List;

public  interface UserService {
    public List<UserVO> getUserList();

    UserVO getUserById(String id);

    UserVO checkUser(UserVO checkuserVO);
}
