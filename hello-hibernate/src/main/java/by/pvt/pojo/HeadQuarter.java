package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class HeadQuarter extends Company {

    @Column
    private String directorName;

    @Column
    private String bankAccount;

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String backAccount) {
        this.bankAccount = backAccount;
    }
}
