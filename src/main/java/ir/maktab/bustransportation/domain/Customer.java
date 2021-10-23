package ir.maktab.bustransportation.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Customer extends User {

    public Customer(String mobileNumber, String userName, String passWord) {
        super(mobileNumber, userName, passWord);
    }

    public Customer() {
    }
}
