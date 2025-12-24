package com.sourjelly.snsproject.user.service;

import com.sourjelly.snsproject.common.SHA256HashingEncoder;
import com.sourjelly.snsproject.user.domain.User;
import com.sourjelly.snsproject.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User getUser(String loginId, String password){

        String encodePassword = SHA256HashingEncoder.encode(password);

        User user = userRepository.selectUser(loginId, encodePassword);

        return user;
    }


    //회원가입
    public boolean createUser(
            String loginId
            , String password
            , String name
            , String phoneNumber
            , String email
    ){
        String encodingPassword = SHA256HashingEncoder.encode(password);

        int count = userRepository.insertUser(loginId, encodingPassword, name ,phoneNumber, email);

        return count ==1;
    }


//     아이디 중복
    public boolean isDuplicateId(String loginId){

        int count = userRepository.isDupulicateId(loginId);

        return count == 1;
    }
    // post에서 쓸 사용자의 정보 가져오기
    public User getUserById(long id){
        return userRepository.selectUserById(id);
    }

    public List<User> findAllUser(){

        return userRepository.selectAll();
    }
}
