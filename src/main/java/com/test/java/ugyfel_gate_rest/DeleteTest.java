package com.test.java.ugyfel_gate_rest;

import com.example.idcardchecker.DataBase.DeleteData;
import org.junit.Test;

public class DeleteTest
{
    @Test
    public void deleteUserTest()
    {
        DeleteData.deleteUser(3);
    }
    @Test
    public void deleteIDCardTest()
    {
        DeleteData.deleteIDCard(3);
    }
}
