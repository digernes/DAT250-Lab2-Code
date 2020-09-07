package no.hvl.dat250.jpa.bankexample;

import javax.persistence.*;
import java.util.List;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private String id;
    private String street;
    private int number;

    @ManyToMany
    @JoinTable(name = "jnd_add_per",
        joinColumns = @JoinColumn(name = "address_fk"),
        inverseJoinColumns = @JoinColumn(name = "person_fk"))
    private List<Person> personsWithAddress;

    public List<Person> getPersonsWithAddress() {
        return personsWithAddress;
    }

    public void setPersonsWithAddress(List<Person> personsWithAddress) {
        this.personsWithAddress = personsWithAddress;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
