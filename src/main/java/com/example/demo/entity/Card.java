package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "cards")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Date validity; //Для бд можно ли использовать Data?
    @ElementCollection
    private Set<Long> numberCard; // или тут лучше использовать только long?
    @ElementCollection
    private Set<Integer> cvvCode; //как кодировать такие вещи? С помощью какого механизма?

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Set<Long> getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Set<Long> numberCard) {
        this.numberCard = numberCard;
    }

    public Set<Integer> getCvvCode() {
        return cvvCode;
    }

    public void setCvvCode(Set<Integer> cvvCode) {
        this.cvvCode = cvvCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", validity=" + validity +
                ", numberCard=" + numberCard +
                ", cvvCode=" + cvvCode +
                '}';
    }
}
