package com.vti;

import java.sql.*;

public class ConnectBasic {

    public static void main(String[] args) throws SQLException {
	    // Khai báo thông tin kết nối tới Database
        String urlDb = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "root";

        // Tạo kết nối vật lý tới DB:
        Connection connection = DriverManager.getConnection(urlDb, username, password);

        // Tạo đối tượng statement để thực hiện querry
        Statement myStatement = connection.createStatement();

        // Querry và hứng kết quả vào ResultSet
        ResultSet resultSet = myStatement.executeQuery("SELECT  * FROM student");

        // Thực hiện in danh sách Result Set
        while (resultSet.next()){
            System.out.println(resultSet.getString("id"));
            System.out.println(resultSet.getString("name"));
            System.out.println(resultSet.getString("age"));
            System.out.println(resultSet.getString("hometown"));
        }

    }
}