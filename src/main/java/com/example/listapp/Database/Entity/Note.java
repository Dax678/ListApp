package com.example.listapp.Database.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Table(name = "note", schema = "public")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long Id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "creation_date")
    private Long creation_date;


    @ManyToOne(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id",
            referencedColumnName = "user_id",
            insertable = false, updatable = false)
    private User user;


    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "note_id")
    private NoteDetails noteDetails;
}
