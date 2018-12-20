package by.pvt.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Branch extends Company {

    @Column
    private String branchName;

    @Column
    private String branchDirector;

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchDirector() {
        return branchDirector;
    }

    public void setBranchDirector(String branchDirector) {
        this.branchDirector = branchDirector;
    }
}
