package com.example.jrm.s06;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/// JAVABEAN
@Entity(name = "s06.Region")
@Table(name = "REGION")
public class Region {
    @Id //PK
    @Column(name = "REGION_ID") // la colonna di riferimento è region_id e si poteva evitare se la variabile sotto l'avessi chiamato regione_id
    private int id;
    private String name; // qui non metto @Column perché il nome è uguale a quello della tabella

    public Region() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Region other = (Region) obj;
        return id == other.id && Objects.equals(name, other.name);
    }

    @Override
    public String toString() {
        return "Region [id=" + id + ", name=" + name + "]";
    }
}
