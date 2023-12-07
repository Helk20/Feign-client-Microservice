package org.ensaj.voiture.beans;

public class clientbeans {
    private Long Id;

    private String Nom;
    private Float Age;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public Float getAge() {
        return Age;
    }

    public void setAge(Float age) {
        Age = age;
    }
}
