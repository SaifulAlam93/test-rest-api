package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
}
