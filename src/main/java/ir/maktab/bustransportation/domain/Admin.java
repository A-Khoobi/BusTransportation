package ir.maktab.bustransportation.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class Admin extends User {
    public Admin(String mobileNumber, String userName, String passWord) {
        super(mobileNumber, userName, passWord);
    }

    public Admin() {
    }
}
