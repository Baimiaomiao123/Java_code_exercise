package bean;

import java.util.Objects;

public class Address {
    private String no;
    private String zipcode;
    private String city;

    public Address(String no, String zipcode, String city) {
        this.no = no;
        this.zipcode = zipcode;
        this.city = city;
    }

    public Address() {
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(no, address.no) && Objects.equals(zipcode, address.zipcode) && Objects.equals(city, address.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(no, zipcode, city);
    }

    @Override
    public String toString() {
        return "Address{" +
                "no='" + no + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
