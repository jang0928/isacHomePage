package com.homeDemo.demo.security;

import com.homeDemo.demo.user.UserService;
import com.homeDemo.demo.user.UserServiceImpl;
import com.homeDemo.demo.user.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthProvider implements AuthenticationProvider {
    @Autowired
    UserServiceImpl userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String id = (String) authentication.getPrincipal(); // 로그인 창에 id
        String userPw = (String) authentication.getCredentials(); // 로그인  password
        UserVO checkuserVO = new UserVO();
        checkuserVO.setUSER_ID(id);
        checkuserVO.setUSER_PWD(userPw);
        UsernamePasswordAuthenticationToken token;
        UserVO userVo = userService.checkUser(checkuserVO);

        if (userVo != null &&  userPw.equals(userVo.getUSER_PWD())) { // 일치하는 user 정보가 있는지 확인


            List<GrantedAuthority> roles = new ArrayList<>();
            roles.add(new SimpleGrantedAuthority(userVo.getAUTH())); // 권한 부여

            token = new UsernamePasswordAuthenticationToken(userVo.getUSER_ID(), null, roles);
            // 인증된 user 정보를 담아 SecurityContextHolder에 저장되는 token

            return token;
        }

        throw new BadCredentialsException("No such user or wrong password.");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }
}

