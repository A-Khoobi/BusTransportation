package ir.maktab.bustransportation.domain;

import ir.maktab.bustransportation.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Location extends BaseEntity<Integer> {

    private String name;

    @OneToMany(mappedBy = "originLocation")
    private List<Ticket> originTickets = new ArrayList<Ticket>();
    @OneToMany(mappedBy = "destinationLocation")
    private List<Ticket> destinationLocation = new ArrayList<Ticket>();

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

    public List<Ticket> getOriginTickets() {
        return originTickets;
    }

    public void setOriginTickets(List<Ticket> originTickets) {
        this.originTickets = originTickets;
    }

    public List<Ticket> getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(List<Ticket> destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
