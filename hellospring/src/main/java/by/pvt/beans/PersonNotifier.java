package by.pvt.beans;

import java.util.Arrays;

public class PersonNotifier {

    private String message;

    private int[] value;

    public PersonNotifier(String message) {
        this.message = message;
    }

    public PersonNotifier(String message, int... value) {
        this.message = message;
        this.value = value;
    }

    public void before() {
        System.out.println("before " + message + " " + Arrays.toString(value));
    }

    public void after() {
        System.out.println("after " + message + " " + Arrays.toString(value));
    }
}
