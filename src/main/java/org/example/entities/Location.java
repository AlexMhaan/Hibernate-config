package org.example.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "locations")
@Audited
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

    @Column(name = "created_on")
    @CreationTimestamp
    LocalDateTime createdOn;

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

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
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
