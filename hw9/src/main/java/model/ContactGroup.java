package model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "contact_group")
public class ContactGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "group_name", nullable = false)
    private String name;

    private String description;

    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
    private List<Contact> contacts;

    public ContactGroup() {}

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public List<Contact> getContacts() { return contacts; }
    public void setContacts(List<Contact> contacts) { this.contacts = contacts; }
}