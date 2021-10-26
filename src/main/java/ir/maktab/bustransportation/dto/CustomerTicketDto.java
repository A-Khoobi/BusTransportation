package ir.maktab.bustransportation.dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class CustomerTicketDto {
    private Integer customerTicketId;

    private Integer ticketId;

    private String passengerName;

    private String gender;

    private String origin;

    private String destination;

    private LocalDate date;

    private LocalTime time;

    private Integer tripID;

    public Integer getCustomerTicketId() {
        return customerTicketId;
    }

    public void setCustomerTicketId(Integer customerTicketId) {
        this.customerTicketId = customerTicketId;
    }

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
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

    public Integer getTripID() {
        return tripID;
    }

    public void setTripID(Integer tripID) {
        this.tripID = tripID;
    }
}
