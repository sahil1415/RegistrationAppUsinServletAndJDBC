package Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCUtil {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/java_db";
        String user = "root";
        String password = "sahil1415";

        return DriverManager.getConnection(url, user, password);
    }

    public static void closeConnection(Connection con, PreparedStatement pstm) throws Exception{
        try {
            if (pstm != null) pstm.close();
            if (con != null) con.close();
        } catch (Exception e) {
            System.out.println("Error closing connection: " + e);
        }

    }
}
