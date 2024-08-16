package Model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

/** This is the Divisions class where we construct the Divisions object and make manipulations to them. */
public class Divisions {

    private int divisionId;
    private String divisionName;
    private int countryId;

    /** Division Constructor
     * @param divisionId
     * @param divisionName
     * @param countryId
     * */
    public Divisions(int divisionId, String divisionName, int countryId) {
        this.divisionId = divisionId;
        this.divisionName = divisionName;
        this.countryId = countryId;
    }

    public int getDivisionId() {
        return divisionId;
    }
    public void setDivisionId(int divisionId) {
        this.divisionId = divisionId;
    }

    public String getDivisionName() {
        return divisionName;
    }
    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public int getCountryId() {
        return countryId;
    }
    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    public String toString() {
        return this.divisionName;
    }
}
