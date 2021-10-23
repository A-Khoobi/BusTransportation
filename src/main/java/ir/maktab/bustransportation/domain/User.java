package ir.maktab.bustransportation.domain;

import ir.maktab.bustransportation.base.BaseEntity;

import javax.persistence.*;


@Entity

@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "user_type",
        discriminatorType = DiscriminatorType.INTEGER)
public class User extends BaseEntity<Integer> {

    protected String mobileNumber;
    protected String userName;
    protected String passWord;

    public User() {
    }

    public User(String mobileNumber, String userName, String passWord) {
        this.mobileNumber = mobileNumber;
        this.userName = userName;
        this.passWord = passWord;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
