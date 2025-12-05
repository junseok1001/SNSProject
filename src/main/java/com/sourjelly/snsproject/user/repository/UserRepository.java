package com.sourjelly.snsproject.user.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserRepository {

    public int insertUser(
            @Param("loginId") String loginId
            , @Param("password") String password
            , @Param("phoneNumber") String phoneNumber
            , @Param("email") String email
    );



}
