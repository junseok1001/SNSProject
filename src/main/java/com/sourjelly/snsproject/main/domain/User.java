package com.sourjelly.snsproject.main.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.Update;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`user`")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String loginId;
    private String password;
    private String name;
    private String phoneNumber;
    private String email;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

//    @OneToMany(mappedBy = "user")
//    private List<Post> post = new ArrayList<>();


    // 내가 생각한 방법 fetch join 임 그리고 fech join은 jpa n+1 문제를 해결함. 근데 n+1이 정확히 어떤 문제지를 모르겠음
    // 조회 문제인거 같은데 흐음....
}
