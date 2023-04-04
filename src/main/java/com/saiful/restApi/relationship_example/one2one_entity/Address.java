package com.saiful.restApi.relationship_example.one2one_entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue
    private long id;
    private String location;
    @OneToOne(mappedBy = "address")
//    @ToString.Exclude
//    @JsonIgnore
    private Library library;
}
