package ir.maktab.bustransportation.service.comprator;

import ir.maktab.bustransportation.domain.Ticket;

import java.util.Comparator;

public class TimeComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket o1, Ticket o2) {
        return o1.getTime().compareTo(o2.getTime());
    }
}
