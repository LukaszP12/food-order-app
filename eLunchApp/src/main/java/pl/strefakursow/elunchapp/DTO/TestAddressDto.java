package pl.strefakursow.elunchapp.DTO;

import javax.annotation.Nullable;
import java.util.Objects;

public class TestAddressDto {

    private String street;
    private String streetNumber;
    private String localNumber;
    private String city;
    private String borough;
    private String county;
    private String state;

    public TestAddressDto(String street, String streetNumber, String localNumber, String city, String borough, String county, String state) {
        this.street = street;
        this.streetNumber = streetNumber;
        this.localNumber = localNumber;
        this.city = city;
        this.borough = borough;
        this.county = county;
        this.state = state;
    }

    public TestAddressDto() {
    }

    @Nullable
    public String getStreet() {
        return street;
    }

    public void setStreet(@Nullable String street) {
        this.street = street;
    }

    @Nullable
    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(@Nullable String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Nullable
    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(@Nullable String localNumber) {
        this.localNumber = localNumber;
    }

    @Nullable
    public String getCity() {
        return city;
    }

    public void setCity(@Nullable String city) {
        this.city = city;
    }

    @Nullable
    public String getBorough() {
        return borough;
    }

    public void setBorough(@Nullable String borough) {
        this.borough = borough;
    }

    @Nullable
    public String getCounty() {
        return county;
    }

    public void setCounty(@Nullable String county) {
        this.county = county;
    }

    @Nullable
    public String getState() {
        return state;
    }

    public void setState(@Nullable String state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestAddressDto that = (TestAddressDto) o;
        return Objects.equals(street, that.street) && Objects.equals(streetNumber, that.streetNumber) && Objects.equals(localNumber, that.localNumber) && Objects.equals(city, that.city) && Objects.equals(borough, that.borough) && Objects.equals(county, that.county) && Objects.equals(state, that.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, streetNumber, localNumber, city, borough, county, state);
    }

    public static class Builder {
        private String street;
        private String streetNumber;
        private String localNumber;
        private String city;
        private String borough;
        private String county;
        private String state;

        public Builder() {
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setLocalNumber(String localNumber) {
            this.localNumber = localNumber;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setBorough(String borough) {
            this.borough = borough;
            return this;
        }

        public Builder setCounty(String county) {
            this.county = county;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public TestAddressDto build() {
            return new TestAddressDto(street, streetNumber, localNumber, city, borough, county, state);
        }
    }

}
