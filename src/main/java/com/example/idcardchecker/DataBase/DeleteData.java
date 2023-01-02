package com.example.idcardchecker.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteData
{
    private static final String jdbcDriver = LoadMySQL.getDriverName();
    private static final String dbAddress = LoadMySQL.getAddress();
    private static final String dbName = LoadMySQL.getDBName();
    private static final String userName = LoadMySQL.getUserName();
    private static final String password = LoadMySQL.getPassword();

    public static void deleteUser(int userid)
    {
        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from Users where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, userid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }

    public static void deleteIDCard(int idcardid)
    {
        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from IDCard where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, idcardid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
    public static void deleteLocationCard(int loccid)
    {
        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from LocationCard where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, loccid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
    public static void deleteDriversLicense(int did)
    {
        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from DriversLicense where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, did);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
    public static void deleteMessage(int mid)
    {
        try
        {
            // create the mysql database connection
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbAddress+dbName, userName, password);

            // create the mysql delete statement.
            // i'm deleting the row where the id is "3", which corresponds to my
            // "Barney Rubble" record.
            String query = "Delete from Messages where id = ?";
            PreparedStatement preparedStmt = conn.prepareStatement(query);
            preparedStmt.setInt(1, mid);

            // execute the preparedstatement
            preparedStmt.execute();

            conn.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }

    }
}
