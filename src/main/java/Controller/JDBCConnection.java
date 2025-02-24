package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JDBCConnection {

    public static boolean Insert(String name, String email, String age, String phone, String gender){
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        boolean inserted = false;

        try{
            connection = JDBCUtil.getConnection();
            String sql = "Insert into registration_data(name, email, age, phone, gender) values(?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, name);
            preparedStatement.setString(2, email);
            preparedStatement.setString(3, age);
            preparedStatement.setString(4, phone);
            preparedStatement.setString(5, gender);

            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Data inserted Successfully");
                inserted = true;
            }
            else{
                System.out.println("Data Insertion failed");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        finally {
            try{
                JDBCUtil.closeConnection(connection, preparedStatement);
            }
            catch (Exception e){
                System.out.println(e);
            }
        }
        return inserted;
    }
}
