package no.hvl.dat250.jpa.bankexample;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String PERSISTENCE_UNIT_NAME = "banking";
    private static EntityManagerFactory factory;

    public static void main(String[] args) {
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Query q = em.createQuery("select m from Person m");

        List<Person> resultList = q.getResultList();
        for(Person result : resultList) {
            System.out.println(result.getName());
        }

        em.getTransaction().begin();

        // Lager addresse
        Address address1 = new Address();
        address1.setStreet("Ubaatsvingen");
        address1.setNumber(13);

        //Lager person
        Person person1 = new Person();
        person1.setName("Jostein D");

        // Lager person- og addresselister
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);

        // Legger til lister til person og addresse
        address1.setPersonsWithAddress(personList);
        person1.setHasAddresses(addressList);

        // Lager bank
        Bank bank1 = new Bank();
        bank1.setName("Barespanken 1");

        // Lager kredittkort og legger til bank
        CreditCard cc1 = new CreditCard();
        cc1.setBank(bank1);

        // Legger til kredittkort i liste og så til bank
        List<CreditCard> ccs = new ArrayList<>();
        ccs.add(cc1);
        bank1.setCreditCards(ccs);
        person1.setCreditCards(ccs);

        // Legger til kredittkortattributter
        cc1.setBalance(100);
        cc1.setLimit(30000);
        cc1.setNumber(12345678);

        // Lager pincode
        Pincode pin1 = new Pincode();
        pin1.setPincode("1234");
        pin1.setCount(0);

        // Legger pincode til kredittkort
        cc1.setPincode(pin1);

        em.persist(pin1);
        em.persist(bank1);
        em.persist(cc1);
        em.persist(person1);
        em.persist(address1);

        em.getTransaction().commit();

        em.close();

    }
}
