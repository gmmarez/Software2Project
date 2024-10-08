package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/** This is the Country class where we construct the Country object and make manipulations to them. */
public class Country {

    private int countryId;
    private String countryName;

    /** Country Constructor
     * @param countryId
     * @param countryName
     * */
    public Country(int countryId, String countryName) {
        this.countryId = countryId;
        this.countryName = countryName;

    }

    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String toString() {
        return this.countryName;
    }
}
