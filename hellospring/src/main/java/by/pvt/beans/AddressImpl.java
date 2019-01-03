package by.pvt.beans;

import java.util.List;
import java.util.Map;

public class AddressImpl implements Address {

    private List flats;

    private Map coordinaty;

    public String getStreet() {
        return "Fish street";
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
