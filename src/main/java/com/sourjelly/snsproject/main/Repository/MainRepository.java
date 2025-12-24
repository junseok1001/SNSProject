package com.sourjelly.snsproject.main.Repository;

import com.sourjelly.snsproject.main.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MainRepository extends JpaRepository<Post, Long> {



}
