package com.sourjelly.snsproject.user.domain;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
public class User {

    private long id;
    private String loginId;
    private String password;
    private String phoneNumber;
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
