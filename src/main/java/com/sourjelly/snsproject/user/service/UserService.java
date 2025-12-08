package com.sourjelly.snsproject.user.service;

import com.sourjelly.snsproject.common.SHA256HashingEncoder;
import com.sourjelly.snsproject.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //회원가입
    public boolean createUser(
            String loginId
            , String password
            , String phoneNumber
            , String email
    ){
        String encodingPassword = SHA256HashingEncoder.encode(password);

        int count = userRepository.insertUser(loginId, encodingPassword, phoneNumber, email);

        return count ==1;
    }


//     아이디 중복
    public boolean isDuplicateId(String loginId){

        int count = userRepository.isDupulicateId(loginId);

        return count == 1;
    }
}
