package com.example.idcardchecker.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_DataBase_With_Tables
{
    private final String jdbcDriver = LoadMySQL.getDriverName();
    private final String dbAddress = LoadMySQL.getAddress();
    private final String userPass = LoadMySQL.getUserPass();
    private final String dbName = LoadMySQL.getDBName();
    private final String userName = LoadMySQL.getUserName();
    private final String password = LoadMySQL.getPassword();

    private Statement statement;
    private Connection con;
    public Create_DataBase_With_Tables() {
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            try
            {
                new LoadMySQL();
                createDatabase();
                createUsersTable();
                createIDCardTable();
            }
            catch (Exception exception)
            {
                System.out.println("An error occured: "+exception);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            createDatabase();
        }
    }
    void createDatabase()
    {
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + userPass);
            Statement s = con.createStatement();
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS " + dbName);
        }
        catch (ClassNotFoundException | SQLException e)
        {
            throw new RuntimeException(e);
        }
    }
    void createUsersTable()
    {
        String myTableName = "CREATE TABLE Users ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "uname VARCHAR(236),"
                + "userName VARCHAR(236),"
                + "password VARCHAR(236),"
                + "email VARCHAR(236),"
                + "birthDate DATE,"
                + "birthPlace VARCHAR(36),"
                + "sex VARCHAR(10),"
                + "isActive INT(1),"
                + "isMom INT(1),"
                + "girlName VARCHAR(236),"
                + "nationality VARCHAR(36))";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
    void createIDCardTable()
    {
        String myTableName = "CREATE TABLE IDCard ("
                + "id INT(64) NOT NULL AUTO_INCREMENT Primary Key,"
                + "userid INT(64),"
                + "FOREIGN KEY (userid)  REFERENCES users(id) ON DELETE Cascade,"
                + "cardNumber VARCHAR(10),"
                + "can INT(6),"
                + "fingerprint INT(1),"
                + "orgname VARCHAR(64),"
                + "expirationDate DATE)";
        try
        {
            Class.forName(jdbcDriver);
            con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            statement = con.createStatement();
            //The next line has the issue
            statement.executeUpdate(myTableName);
            System.out.println("Table Created");
        }
        catch (SQLException e )
        {
            System.out.println("An error has occurred on Table Creation: "+e);
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("An Mysql drivers were not found"+e);
        }
    }
}
