package entities;

import javax.persistence.*;


@Entity
@DiscriminatorValue("Customer")
public class Customer extends Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "surname")
    private String surname;

    public Customer() {
    }

    public Customer(int id, String name, String nationality, String surname) {
        super(id, name, nationality);
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
