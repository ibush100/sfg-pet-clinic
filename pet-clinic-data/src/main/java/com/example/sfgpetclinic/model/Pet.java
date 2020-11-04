package com.example.sfgpetclinic.model;

import java.time.LocalDate;

public class Pet extends BaseEntity {
    private petType petType;
    private Owner owner;

    public com.example.sfgpetclinic.model.petType getPetType() {
        return petType;
    }

    public void setPetType(com.example.sfgpetclinic.model.petType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    private LocalDate birthday;
}