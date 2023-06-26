package com.example.demo.entity;

import lombok.*;
import org.hibernate.annotations.NaturalId;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String expireDate;
    @NotNull
    @NotBlank
    private String number; // или тут лучше использовать только long?
    private String cvv; //как кодировать такие вещи? С помощью какого механизма?
    private int balance;
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    //    @OneToOne(
//            mappedBy = "card",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true,
//            fetch = FetchType.LAZY
//    )
//    private User user;
//    public void addUser(User user) {
//        user.setCard( this );
//        this.user = user;
//    }
//
//    public void removeUser() {
//        if ( user != null ) {
//            user.setCard( null );
//            this.user = null;
//        }
//    }

//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }



    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", cvv='" + cvv + '\'' +
                ", balance='" + balance + '\'' +
                ", user=" + user +
                '}';
    }
}

