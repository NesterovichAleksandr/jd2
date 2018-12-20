package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("e")
public class Employer extends Person {

    @Column
    private String companyTitle;

    @Column
    private String corporatePhoneNumber;

    public String getCompanyTitle() {
        return companyTitle;
    }

    public void setCompanyTitle(String companyTitle) {
        this.companyTitle = companyTitle;
    }

    public String getCorporatePhoneNumber() {
        return corporatePhoneNumber;
    }

    public void setCorporatePhoneNumber(String corporatePhoneNumber) {
        this.corporatePhoneNumber = corporatePhoneNumber;
    }
}
