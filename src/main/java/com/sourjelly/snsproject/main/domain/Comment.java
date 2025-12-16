package com.sourjelly.snsproject.main.domain;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder(toBuilder = true)
@Entity
@Table(name="`comment`")
public class Comment {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String comment;

    private long postId;

    private long userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
