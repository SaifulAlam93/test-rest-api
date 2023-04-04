package com.saiful.restApi.relationship_example.repository;


import com.saiful.restApi.relationship_example.many_2_many_entity.BookMM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface BookMMRepository extends JpaRepository<BookMM, Long> { }

