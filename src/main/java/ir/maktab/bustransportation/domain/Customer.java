package ir.maktab.bustransportation.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("2")
public class Customer extends User {

    public Customer(String mobileNumber, String userName, String passWord) {
        super(mobileNumber, userName, passWord);
    }

    public Customer() {
    }

    @OneToMany(mappedBy = "customer")
    private List<CustomerTicket> customerTickets = new ArrayList<CustomerTicket>();


}
