package com.example.bilyzna1.service;

import com.example.bilyzna1.dto.CredentialsDto;
import com.example.bilyzna1.dto.SignUpDto;
import com.example.bilyzna1.dto.UserDto;
import com.example.bilyzna1.entity.User;
import com.example.bilyzna1.exception.AppException;
import com.example.bilyzna1.mapper.UserMapper;
import com.example.bilyzna1.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class userService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;
    public UserDto findByLogin(String login){
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }
    public UserDto login(CredentialsDto credentialsDto){
       User user = userRepository.findByLogin(credentialsDto.getLogin())
                .orElseThrow(()->new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if(passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()),user.getPassword())){
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password",HttpStatus.BAD_REQUEST);
    }
    public UserDto register(SignUpDto userDto){
       Optional<User> optionalUser = userRepository.findByLogin(userDto.getLogin());

       if(optionalUser.isPresent()){
           throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
       }
       User user = userMapper.signUpToUser(userDto);

       user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

      User savedUser = userRepository.save(user);

      return userMapper.toUserDto(user);
    }
}
