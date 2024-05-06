package Model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Customer {

    private int customerId;
    private String customerName;
    private String customerAddress;
    private int customerPostalCode;
    private int customerPhone;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private String lastUpdateBy;
    private int divisionId;

    public Customer(int customerId, String customerName, String customerAddress, int customerPostalCode, int customerPhone,
                    LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdateBy, int divisionId) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPostalCode = customerPostalCode;
        this.customerPhone = customerPhone;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdateBy = lastUpdateBy;
        this.divisionId = divisionId;
    }

}
