package org.ge.tbcitacademy.data.Database;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbConnect {
    public static Connection getConnection() {
        Connection conn = null;

        try (FileInputStream f = new FileInputStream("db.properties")){
            Properties prop = new Properties();
            prop.load(f);
            String url = prop.getProperty("url");
            String user = prop.getProperty("user");
            String password = prop.getProperty("password");
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}