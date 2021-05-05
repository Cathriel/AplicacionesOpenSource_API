package com.roomies.roomies.domain.repository;

import com.roomies.roomies.domain.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
}
