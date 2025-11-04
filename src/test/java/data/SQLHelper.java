package data;

import lombok.SneakyThrows;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLHelper {
    private static final QueryRunner runner = new QueryRunner();

    private static String getUrl() {
        return System.getProperty("db.url");
    }

    private static String getUser() {
        return System.getProperty("db.user");
    }

    private static String getPassword() {
        return System.getProperty("db.password");
    }

    @SneakyThrows
    private static Connection getConnection() throws SQLException {
        System.out.println("Connecting to: " + getUrl() + " as user: " + getUser());
        return DriverManager.getConnection(getUrl(), getUser(), getPassword());
    }

  @SneakyThrows
//    public static String getPaymentStatus() {
//        var conn = getConnection();
//        var sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
//        return runner.query(conn, sql, new ScalarHandler<>());
//    }
public static String getCreditPaymentStatus() {
    var conn = getConnection();

    // Сначала проверим количество записей
    var countSql = "SELECT COUNT(*) FROM credit_request_entity";
    long count = runner.query(conn, countSql, new ScalarHandler<>());
    System.out.println("=== DEBUG: Total credit records: " + count + " ===");

    // Затем получим статус
    var sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
    String result = runner.query(conn, sql, new ScalarHandler<>());
    System.out.println("=== DEBUG: Credit status from DB: '" + result + "' ===");

    return result;
//    @SneakyThrows
//    public static String getCreditPaymentStatus() {
//        var conn = getConnection();
//        var sql = "SELECT status FROM credit_request_entity ORDER BY created DESC LIMIT 1";
//        return runner.query(conn, sql, new ScalarHandler<>());
//
//
    }

    @SneakyThrows
    public static String getDebitPaymentId() {
        var conn = getConnection();
        var sql = "SELECT transaction_id FROM payment_entity ORDER BY created DESC LIMIT 1";
        return runner.query(conn, sql, new ScalarHandler<>());
    }

    @SneakyThrows
    public static String getCreditPaymentId() {
        var conn = getConnection();
        var sql = "SELECT credit_id FROM order_entity ORDER BY created DESC LIMIT 1";
        return runner.query(conn, sql, new ScalarHandler<>());
    }

    @SneakyThrows
    public static void cleanDatabase() {
        var conn = getConnection();
        runner.execute(conn, "DELETE FROM payment_entity");
        runner.execute(conn, "DELETE FROM order_entity");

    }
    @SneakyThrows
    public static String getPaymentStatus() {
        var conn = getConnection();
        var sql = "SELECT status FROM payment_entity ORDER BY created DESC LIMIT 1";
        String result = runner.query(conn, sql, new ScalarHandler<>());
        System.out.println("DEBUG: Payment status from DB: '" + result + "'");
        return result;
    }
}