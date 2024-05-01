package org.ge.tbcitacademy.data.Database;

import org.ge.tbcitacademy.data.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseSteps {
    Connection connect = DbConnect.getConnection();
    public UserModel selectUser(String username) {
        UserModel userInstance = null;
        String sql = "SELECT * FROM users WHERE username = ?";
        try (PreparedStatement preparedStatement = connect.prepareStatement(sql)) {
            preparedStatement.setString(1, username);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    userInstance = new UserModel(resultSet.getString("username"), resultSet.getString("password"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userInstance;
    }
}
