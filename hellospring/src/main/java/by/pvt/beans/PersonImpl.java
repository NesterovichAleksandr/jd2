package by.pvt.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonImpl implements InitializingBean, BeanNameAware, DisposableBean {

    private long id;
    private String name;
    private String secondName;
    private Address address;
    private String fullAddress;

    public PersonImpl() {
    }

    public PersonImpl(String name, String secondName, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public String getName() {
        System.out.println("getName()");
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    void init() {
        System.out.println("init bean " + getClass().getName());
    }

    public void destroy() {
        System.out.println("destroy bean " + getClass().getName());
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ");
    }

    public void setBeanName(String s) {
        System.out.println("setBeanName " + s);
    }

    @Override
    public String toString() {
        return "Person name" + "[" + name + "]";
    }
}
