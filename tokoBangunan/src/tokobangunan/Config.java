package tokobangunan;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class Config {
    private static Connection mysqlConfig;
    public static Connection configDB() throws SQLException {
        try {
            String url;
            url = "jdbc:mysql://localhost:3306/aplikasigudang";
            String user = "root";
            String password = "";

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            mysqlConfig = DriverManager.getConnection(url, user, password);

        }
        catch (SQLException e){
            System.err.println("Koneksi gagal: " + e.getMessage());
        }
        
        return mysqlConfig;
        
    }
    
    public static void main(String[] args) throws SQLException {
        configDB();
    }
}
