package kz.aitu.oop.practice.assignment5.data;

import kz.aitu.oop.practice.assignment5.data.interfaces.IDBManager;

import java.sql.Connection;
import java.sql.DriverManager;


public class DBManager implements IDBManager {

    public Connection getConnection() {

        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:1337/IT Company", "postgres", "talgat140502");
            return connection;
        } catch (Exception e) {

            System.out.println(e);
            return null;
        }
    }
}
