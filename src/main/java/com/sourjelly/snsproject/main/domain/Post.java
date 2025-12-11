package com.sourjelly.snsproject.main.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Table(name="`post`")
@Entity
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private long userId;
    private String title;
    private String contents;
    private String imagePath;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
