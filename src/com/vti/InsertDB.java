package com.vti;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDB {
    public static void main(String[] args) throws SQLException {
        // Khai báo thông tin kết nối tới Database
        String urlDb = "jdbc:mysql://localhost:3306/java";
        String username = "root";
        String password = "root";

        // Tạo kết nối vật lý tới DB:
        Connection connection = DriverManager.getConnection(urlDb, username, password);

        // Tạo câu SQL có parameter:
        String sqlQuery = "insert into student (id, name, age, hometown) values (?, ?, ?, ?)";

        // Tạo đối tượng preparedStatement:
        PreparedStatement statement = connection.prepareStatement(sqlQuery);

        // Gán các tham số vào trong preparedStatement:
        statement.setInt(1, 6);
        statement.setString(2, "Minh");
        statement.setInt(3, 30);
        statement.setString(4, "Nam Định");

        // Thực hiện insert:
        int numberOfRowsEffect = statement.executeUpdate();

        System.out.println("Đã ảnh hưởng " + numberOfRowsEffect + " bản ghi");
    }
}
