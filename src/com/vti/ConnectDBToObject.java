package com.vti;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ConnectDBToObject {
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

        List<Student> list = new ArrayList<>();

        // Thực hiện gán dữ liệu từ DB vào ArrayList:
        while (resultSet.next()){
            int tempId = resultSet.getInt("id");
            String tempName = resultSet.getString("name");
            int tempAge = resultSet.getInt("age");
            String tempHometown = resultSet.getString("hometown");

            Student student = new Student(tempId, tempName, tempAge, tempHometown);
            list.add(student);
        }

        // Thực hiện in danh sách Student thông qua array list:
        for(Student s : list){
            System.out.println(s);
        }
    }
}
