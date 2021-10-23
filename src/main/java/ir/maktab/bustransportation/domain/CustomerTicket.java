package ir.maktab.bustransportation.domain;

import ir.maktab.bustransportation.base.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerTicket extends BaseEntity<Integer> {

    private String passenger;
    private String gender;
    @ManyToOne
    @JoinColumn(name = "CustomerId", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "TicketId", nullable = false)
    private Ticket ticket;

    public CustomerTicket(String passenger, String gender, Customer customer, Ticket ticket) {
        this.passenger = passenger;
        this.gender = gender;
        this.customer = customer;
        this.ticket = ticket;
    }

    public CustomerTicket() {
    }

    public String getPassenger() {
        return passenger;
    }

    public void setPassenger(String passenger) {
        this.passenger = passenger;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }
}
