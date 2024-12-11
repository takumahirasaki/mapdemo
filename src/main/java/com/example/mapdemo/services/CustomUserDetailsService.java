package com.example.mapdemo.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.mapdemo.entity.UserEntity;
import com.example.mapdemo.repositries.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optionalUser = userRepository.findByUsername(username);

        if (optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found: " + username);
        }

        UserEntity userEntity = optionalUser.get();

        return User.builder()
            .username(userEntity.getUsername())
            .password(userEntity.getPassword()) // ハッシュ化されたパスワード
            .roles(userEntity.getRole()) // ユーザーのロールを設定
            .build();
    }
}
