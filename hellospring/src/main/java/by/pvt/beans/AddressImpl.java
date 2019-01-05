package by.pvt.beans;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class AddressImpl implements Address {

    private List flats;

    private Map coordinaty;

    private Double home;

    private String street;

    private String zipCode;

    private boolean endOfStreet;

    private boolean endSameStreet;

    private Collection<String> inhabitants;

    public AddressImpl(Double s) {
        this.home = s;
    }

    public AddressImpl() {

    }

    public Collection<String> getInhabitants() {
        return inhabitants;
    }

    public void setInhabitants(Collection<String> inhabitants) {
        this.inhabitants = inhabitants;
    }

    public boolean isEndSameStreet() {
        return endSameStreet;
    }

    public void setEndSameStreet(boolean endSameStreet) {
        this.endSameStreet = endSameStreet;
    }

    public boolean isEndOfStreet() {
        return endOfStreet;
    }

    public void setEndOfStreet(boolean endOfStreet) {
        this.endOfStreet = endOfStreet;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Double getHome() {
        return home;
    }

    public void setHome(Double home) {
        this.home = home;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet() {
        return street != null ? street : "строителей ";
    }

    public String getCity() {
        return "Stambul";
    }

    public List getFlats() {
        return flats;
    }

    public void setFlats(List flats) {
        this.flats = flats;
    }

    public Map getCoordinaty() {
        return coordinaty;
    }

    public void setCoordinaty(Map coordinaty) {
        this.coordinaty = coordinaty;
    }
}
