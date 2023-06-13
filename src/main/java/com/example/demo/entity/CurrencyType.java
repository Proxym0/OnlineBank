package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "currencys")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CurrencyType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private Set<String> currency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<String> getCurrency() {
        return currency;
    }

    public void setCurrency(Set<String> currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "CurrencyType{" +
                "id=" + id +
                ", currency=" + currency +
                '}';
    }
}
