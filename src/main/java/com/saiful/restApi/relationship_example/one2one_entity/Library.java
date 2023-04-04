package com.saiful.restApi.relationship_example.one2one_entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
//@AllArgsConstructor
//@NoArgsConstructor
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id")
//    @RestResource(path = "libraryAddress", rel="address")
    private Address address;

    // standard constructor, getters, setters

}