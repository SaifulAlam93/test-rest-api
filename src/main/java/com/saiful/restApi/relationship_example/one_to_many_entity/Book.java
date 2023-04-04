package com.saiful.restApi.relationship_example.one_to_many_entity;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable=false)
    private String title;

//    @ManyToOne
//    @ToString.Exclude
//    @JoinColumn(name="library_id")
//    private LibraryOM libraryOM;

    // standard constructor, getter, setter
}
