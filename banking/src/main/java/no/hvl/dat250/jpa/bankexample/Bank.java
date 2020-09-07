package no.hvl.dat250.jpa.bankexample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
    @Id
    @GeneratedValue (strategy = GenerationType.TABLE)
    private String id;

    @OneToMany(mappedBy = "bank")
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
}
