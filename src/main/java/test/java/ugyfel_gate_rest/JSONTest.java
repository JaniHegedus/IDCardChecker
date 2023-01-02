package test.java.ugyfel_gate_rest;

import com.example.idcardchecker.Classes.*;
import com.example.idcardchecker.DataBase.*;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.Assert.assertEquals;

public class JSONTest
{
    User user = GetArray.getDataFromUserTable().get(2);
    User user1 = GetArray.getDataFromUserTable().get(1);
    User user2 = GetArray.getDataFromUserTable().get(0);
    @Test
    public void UserJSONTest() throws NoSuchAlgorithmException
    {
        GetJSON.getJSONDataUserName("JaniHegedus", MD5.Translate_to_MD5_HASH("Jancsika20"));
    }

    @Test
    public void IdCardJSONTest()
    {
        GetJSON.getJSONIDCard(user);
    }
    @Test
    public void UsersJSONTest() {
        assertEquals(3,GetJSON.getJSONUsers().length());
    }
}
