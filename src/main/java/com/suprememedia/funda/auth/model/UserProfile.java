package com.suprememedia.funda.auth.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
public class UserProfile {
    @Id
    @SequenceGenerator(
            sequenceName = "author_sequence"
            ,name = "author_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "author_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Long id;
    private  String profileImageUrl;

    private String bio;
    private String userName;
    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinTable(name = "relation" ,
        joinColumns = @JoinColumn(name = "user_id") ,
        inverseJoinColumns = @JoinColumn(name = "following")
    )
    private List<UserProfile> following;

    @ManyToMany(mappedBy = "following" ,fetch = FetchType.LAZY)
    private List<UserProfile> followers;

}
