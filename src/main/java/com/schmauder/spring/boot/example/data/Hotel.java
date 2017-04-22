package com.schmauder.spring.boot.example.data;

public class Hotel {

    private String key;
    private String code;
    private String name;

    public Hotel() {
    }

    public Hotel(String key, String code, String name) {
        this.key = key;
        this.code = code;
        this.name = name;
    }

    public String getKey() {

        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Hotel hotel = (Hotel) o;

        if (key != null ? !key.equals(hotel.key) : hotel.key != null) return false;
        if (code != null ? !code.equals(hotel.code) : hotel.code != null) return false;
        return name != null ? name.equals(hotel.name) : hotel.name == null;
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (code != null ? code.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
