package com.harishtcx.Library.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private Long id;
    private String title;
    private String author;
    private boolean borrowed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User borrowed_by;


}
