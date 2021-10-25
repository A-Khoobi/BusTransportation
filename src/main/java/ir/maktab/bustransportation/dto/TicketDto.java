package ir.maktab.bustransportation.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class TicketDto {

    Integer originID;
    Integer destinationID;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate date;

    public Integer getOriginID() {
        return originID;
    }

    public void setOriginID(Integer originID) {
        this.originID = originID;
    }

    public Integer getDestinationID() {
        return destinationID;
    }

    public void setDestinationID(Integer destinationID) {
        this.destinationID = destinationID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
