package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findAllByActiveTrue();
    List<Post> findAllByBody(String body);


    @Query(value = " Select * from post where active =true ", nativeQuery = true)
    List<Post> findAllByActive();
//   List<Post> findAllByActiveTrue();

    @Query(value = " SELECT * FROM post WHERE DATE(Created_at) =:cr_date ", nativeQuery = true)
    List<Post> findAllByCreatedAt(@Param("cr_date") String date);

    @Query(value = " SELECT * FROM post WHERE DATE(Created_at) =:cr_date ", nativeQuery = true)
    List<Post> findAllByCreatedAtAndBody(@Param("cr_date") String date, @Param("body") String body);

    @Query(value = " SELECT * FROM post ", nativeQuery = true)
    List<Object[]> customQuery();
}
