package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    private static String url = "jdbc:mariadb://localhost:3306/db_empledos";
    private static String user = "root";
    private static String pass = "";
    private static Connection con = null;

    public static Connection getConnection() {
        if(con == null) {
            try {
                con = DriverManager.getConnection(url, user, pass);
                System.out.println("Conexion establecida.");
                System.out.println(con.getCatalog()); //Nombre de la base de datos
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
        return con;
    }

}
