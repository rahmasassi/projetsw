package com.codingworld.numberconversion;

public class NumberConversion {

    private Integer id;
    private String number;

    public NumberConversion () { super();}

    public NumberConversion(Integer id, String number) {
        this.id = id;
        this.number = number;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
