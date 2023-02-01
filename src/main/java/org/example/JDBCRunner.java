package org.example;

import org.example.util.ConnectionManager;

import java.sql.SQLException;

public class JDBCRunner {
    public static void main(String[] args) {
        try(var connection = ConnectionManager.open()) {
            System.out.println(connection.getTransactionIsolation());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
