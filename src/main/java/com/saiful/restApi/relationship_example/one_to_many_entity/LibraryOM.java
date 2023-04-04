package com.saiful.restApi.relationship_example.one_to_many_entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
public class LibraryOM {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    //    @OneToMany(cascade = CascadeType.ALL)
    //    @OneToMany(mappedBy = "libraryOM", fetch = FetchType.LAZY,
    //    cascade = CascadeType.ALL)
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "library_id", referencedColumnName = "id")
    private Set<Book> books;

    //...

}