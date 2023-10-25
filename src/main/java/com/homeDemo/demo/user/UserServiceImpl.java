package com.homeDemo.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserVO> getUserList() {
        return userRepository.getUserList();
    }

    @Override
    public UserVO getUserById(String id) {
        return userRepository.getUserById(id);
    }



    @Override
    public UserVO checkUser(UserVO checkuserVO) {
      return userRepository.checkUser(checkuserVO);
    }
}
