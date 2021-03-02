package kz.aitu.oop.practice.assignment5.data.interfaces;
import java.sql.Connection;
import java.sql.SQLException;

public interface IDBManager {
   Connection getConnection();

}
