package com.example.llq_training.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectJDBC {
    private String hostName = "localhost:8082";
    private String dbName = "my_database";
    private String username = "root";
    private String password = "123";

//   private String connectionURL = "jdbc:mysql://"+hostName+"/"+dbName;
    private String connectionURL = "jdbc:oracle:thin:@10.10.0.203:1521:orcl";
    public Connection connect(){
        //Tạo đối tượng Connection
        Connection conn = null;

        try {
            conn = DriverManager.getConnection(connectionURL, username, password);
            System.out.println("Connect successfully!!!");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }


        return conn;
    }
}
