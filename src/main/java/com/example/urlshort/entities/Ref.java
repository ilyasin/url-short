package com.example.urlshort.entities;

import javax.persistence.*;

@Entity
@Table(name = "refs")
public class Ref {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ref_id")
    private Long id;

    @Column(name = "long_ref")
    private String longRef;

    @Column(name = "short_key")
    private String shortKey;

    public Ref() {
    }

    public Ref(String longRef, String shortKey) {
        this.longRef = longRef;
        this.shortKey = shortKey;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLongRef() {
        return longRef;
    }

    public void setLongRef(String longRef) {
        this.longRef = longRef;
    }

    public String getShortKey() {
        return shortKey;
    }

    public void setShortKey(String shortKey) {
        this.shortKey = shortKey;
    }

    @Override
    public String toString() {
        return "Ref{" +
                "id=" + id +
                ", longRef='" + longRef + '\'' +
                ", shortKey='" + shortKey + '\'' +
                '}';
    }
}
