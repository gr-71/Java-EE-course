package ru.geekbrains.persist;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "categories")
@NamedQueries({
        @NamedQuery(name = "findAll", query = "from Category"),
        @NamedQuery(name = "countAll", query = "select count(*) from Category"),
        @NamedQuery(name = "deleteById", query = "delete from Category c where c.id = :id")
})
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 1024)
    private String name;

    public Category() {
    }

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
