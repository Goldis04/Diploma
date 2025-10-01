package ru.netology.test;

import org.junit.jupiter.api.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class DatabaseTest {
    @Test
    public void testPaymentRecord() throws Exception {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT status FROM payments WHERE id = 1");
        if (resultSet.next()) {
            String status = resultSet.getString("status");
            assertEquals("success", status);
        }
        connection.close();
    }
}
