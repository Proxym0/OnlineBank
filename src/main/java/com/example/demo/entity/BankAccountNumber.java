package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accountNumbers")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class BankAccountNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ElementCollection
    private Set<Long> accountNumber; //Set?

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Long> getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Set<Long> accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public String toString() {
        return "BankAccountNumber{" +
                "id=" + id +
                ", accountNumber=" + accountNumber +
                '}';
    }
}
