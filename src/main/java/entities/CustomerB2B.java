package entities;


import javax.persistence.*;

@Entity
@DiscriminatorValue("CustomerB2B")
public class CustomerB2B extends Client{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "nip")
    private String nip;

    public CustomerB2B() {
    }
    public CustomerB2B(int id, String name, String nationality, String nip) {
        super(id, name, nationality);
        this.nip = nip;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }
}
