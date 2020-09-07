package no.hvl.dat250.jpa.bankexample;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String name;

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public List<Address> getHasAddresses() {
        return hasAddresses;
    }

    public void setHasAddresses(List<Address> hasAddress) {
        this.hasAddresses = hasAddress;
    }

    @OneToMany
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();

    @ManyToMany(mappedBy = "personsWithAddress")
    private List<Address> hasAddresses;

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


}
