package com.example.listapp.Database.View;

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
@Table(name = "show_users_notes", schema = "public")
public class ShowUserNotesView {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "note_id")
    private Long note_id;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "title")
    private String title;

    @Column(name = "body")
    private String body;

    @Column(name = "card_color")
    private String card_color;
}
