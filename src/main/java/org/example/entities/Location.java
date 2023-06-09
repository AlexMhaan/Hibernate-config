package org.example.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "locations")
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="street_name")
    private String streetName;

    @Column(name="ZIP_code")
    private String ZIPCode;

    @Column(name="city_name")
    private String cityName;

    @Column(name="country_name")
    private String countryName;

    public Location(){}

    public Location(
            Long id,
            String streetName,
            String ZIPCode,
            String cityName,
            String countryName
    ) {
        this.id = id;
        this.streetName = streetName;
        this.ZIPCode = ZIPCode;
        this.cityName = cityName;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZIPCode() {
        return ZIPCode;
    }

    public void setZIPCode(String ZIPCode) {
        this.ZIPCode = ZIPCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", streetName='" + streetName + '\'' +
                ", ZIPCode='" + ZIPCode + '\'' +
                ", cityName='" + cityName + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
