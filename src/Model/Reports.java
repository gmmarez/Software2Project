package Model;

/** This is the Reports class where we construct the Reports object and make manipulations to them. */
public class Reports {
    private String type;
    private String month;
    private int total;

    /** Reports Constructor. This is used when creating the Month and Type table in the Reports Screen.
     * @param type
     * @param month
     * @param total
     * */
    public Reports(String type, String month, int total) {
        this.type = type;
        this.month = month;
        this.total = total;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getMonth() {
        return month;
    }
    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotal() {
        return total;
    }
    public void setTotal(int total) {
        this.total = total;
    }

}
