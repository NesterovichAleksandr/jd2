package com.reserved.utils;

public interface Patterns {
    String LOGIN = "\\w+";
    String EMAIL = "(\\w{2,})@([a-z]+\\.)([a-z]{2,4})";
    String PASSWORD = "\\w+";
    String FIRSTNAME = "[a-zA-Zа-яА-Я]+";
    String LASTNAME = "[a-zA-Zа-яА-Я]+";
    String PHONENUMBER = "[0-9]{8,12}";
    String NAMEFILM = "\\w+";
    String COUNTRY = "[a-zA-Z]+";
    String GENRE = "[a-zA-Z]+";
    String YEAROFISSUE = "[0-9]{4}";
    String DURATION = "[0-9]{1,3}";
}
