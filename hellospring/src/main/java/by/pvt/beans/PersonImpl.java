package by.pvt.beans;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class PersonImpl implements InitializingBean, BeanNameAware, DisposableBean {

    private String name;
    private String secondName;
    private Address address;

    public PersonImpl() {
    }

    public PersonImpl(String name, String secondName, Address address) {
        this.name = name;
        this.secondName = secondName;
        this.address = address;
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
}
