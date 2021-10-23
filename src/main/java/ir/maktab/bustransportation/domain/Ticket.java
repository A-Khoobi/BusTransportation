package ir.maktab.bustransportation.domain;

import ir.maktab.bustransportation.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Ticket extends BaseEntity<Integer> {

    LocalDate date;
    LocalTime time;
    Integer tripId;
    @ManyToOne
    @JoinColumn(name = "OriginLocation_ID", nullable = false)
    private Location originLocation;
    @ManyToOne
    @JoinColumn(name = "DestinationLocation_ID", nullable = false)
    private Location destinationLocation;
    @OneToMany(mappedBy = "ticket")
    private List<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();

    public Ticket(LocalDate date, LocalTime time, Integer tripId, Location originLocation, Location destinationLocation) {
        this.date = date;
        this.time = time;
        this.tripId = tripId;
        this.originLocation = originLocation;
        this.destinationLocation = destinationLocation;
    }

    public Ticket() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Location getOriginLocation() {
        return originLocation;
    }

    public void setOriginLocation(Location originLocation) {
        this.originLocation = originLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public List<CustomerTicket> getCustomerTickets() {
        return customerTickets;
    }

    public void setCustomerTickets(List<CustomerTicket> customerTickets) {
        this.customerTickets = customerTickets;
    }
}