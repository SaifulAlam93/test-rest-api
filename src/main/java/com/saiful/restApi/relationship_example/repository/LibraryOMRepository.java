package com.saiful.restApi.relationship_example.repository;

import com.saiful.restApi.relationship_example.one_to_many_entity.LibraryOM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibraryOMRepository extends JpaRepository<LibraryOM, Long> {}

