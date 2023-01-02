package com.example.test.java.ugyfel_gate_rest;


import com.example.idcardchecker.DataBase.LoadMySQL;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LoadMySQLTest
{
    public LoadMySQLTest() {
        LoadMySQL load = new LoadMySQL();
    }
    @Test
    public void DriverTest() {
        assertEquals("com.mysql.cj.jdbc.Driver", LoadMySQL.getDriverName());
    }
    @Test
    public void AddressTest() {
        assertEquals("jdbc:mysql://localhost:3306/", LoadMySQL.getAddress());
    }
    @Test
    public void UserPassTest() {
        assertEquals("?user=root&password=", LoadMySQL.getUserPass());
    }

    @Test
    public void DBNameTest() {
        assertEquals("projekt", LoadMySQL.getDBName());
    }
    @Test
    public void UserNameTest() {
        assertEquals("root", LoadMySQL.getUserName());
    }
    @Test
    public void PasswordTest() {
        assertEquals("", LoadMySQL.getPassword());
    }
}
