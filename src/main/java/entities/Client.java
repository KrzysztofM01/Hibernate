package entities;

import javax.persistence.*;


@Entity
@Table (name = "Client")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn (name = "ClientType", discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue(value = "C")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private int id;
    @Column (name = "name")
    private String name;
    @Column (name = "nationality")
    private String nationality;

    public Client() {
    }

    public Client(String name, String nationality) {
        this.name = name;
        this.nationality = nationality;
    }

    public Client(int id, String name, String nationality) {
        this.id = id;
        this.name = name;

        this.nationality = nationality;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
}
