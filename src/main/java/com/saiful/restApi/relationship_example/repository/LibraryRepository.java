package com.saiful.restApi.relationship_example.repository;

import com.saiful.restApi.relationship_example.one2one_entity.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LibraryRepository extends JpaRepository<Library, Long> {}

