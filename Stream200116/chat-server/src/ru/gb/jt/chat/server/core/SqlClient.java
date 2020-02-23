package ru.gb.jt.chat.server.core;

import java.sql.*;

public class SqlClient {

    private static Connection connection;
    private static Statement statement;

    synchronized static void connect() {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:chat-server/chat.db");
            statement = connection.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static void disconnect() {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    synchronized static String getNickname(String login, String password) {
        String query = String.format("Select nickname from users where login = '%s' and password = '%s'", login, password);
        try (ResultSet set = statement.executeQuery(query);) {
            if(set.next()) {
                return set.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * получение ника по логину Java 3_2
     * @param login
     * @return
     */
    synchronized static String getNickname(String login) {
        String query = String.format("Select nickname from users where login = '%s'", login);
        try (ResultSet set = statement.executeQuery(query);) {
            if(set.next()) {
                return set.getString(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * создание пользователя Java 3_2
     * @param login
     * @param password
     * @throws SQLException
     */
    synchronized static void  createUser(String login, String password) throws SQLException {
        String query = String.format("INSERT INTO users (login, password, nickname) VALUES ('%s', '%s', '%s')", login, password, login);
        statement.execute(query);
    }
}
