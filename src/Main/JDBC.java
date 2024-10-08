package Main;
import java.sql.Connection;
import java.sql.DriverManager;

/** This is the JDBC file in which configure the connection to the MySQL Workbench database. */
public abstract class JDBC {
 private static final String protocol = "jdbc";
    private static final String vendor = ":mysql:";
    private static final String location = "//localhost/";
    private static final String databaseName = "client_schedule";
    private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
    private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
    private static final String userName = "sqlUser"; // Username
    private static String password = "Passw0rd!"; // Password
    public static Connection connection;  // Connection Interface

    public static Connection conn = null;

    /** This is the method called when opening the connection to the MySQL Database.
     *
     */
        public static Connection openConnection()
    {
        try {
            Class.forName(driver); // Locate Driver
            conn = (Connection) DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
            System.out.println("Connection successful!");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
        return conn;
    }

    /** This method will get a connection when needed to the MySQL Database.
     * */
    public static Connection getConnection() {
        return conn;
    }

    /** This is the method called when closing the connection to the MySQL Database.
     *
     */
    public static void closeConnection() {
        try {
            conn.close();
            System.out.println("Connection closed!");
        }
        catch(Exception e)
        {
            System.out.println("Error:" + e.getMessage());
        }
    }
}