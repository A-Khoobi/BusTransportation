package ir.maktab.bustransportation.domain;

import ir.maktab.bustransportation.base.BaseEntity;

import javax.persistence.Entity;

@Entity
public class Location extends BaseEntity<Integer> {

    String name;

    public Location(String name) {
        this.name = name;
    }

    public Location() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
