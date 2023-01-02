package com.example.test.java.ugyfel_gate_rest;


import com.example.idcardchecker.Classes.*;
import com.example.idcardchecker.DataBase.Insert_Into_DataBase;
import com.example.idcardchecker.DataBase.*;
import com.example.idcardchecker.Enums.*;
import org.junit.Test;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;

import static junit.framework.Assert.assertEquals;


public class IdTest
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();

    User user= new User("Hegedüs János", "JaniHegedus", MD5.Translate_to_MD5_HASH("Jancsika20"), "hegedusjanos2002@gmail.com", Date.valueOf("2002-11-13"), "Szigetvár","Ferfi", true, false, "", "HUNGARIAN");
    User user1= new User("Cool Michael", "KingM", MD5.Translate_to_MD5_HASH("nopassword"), "cool69@gmail.com", Date.valueOf("1999-06-07"), "Nyíregyháza","Ferfi", true, true, "misipisi", "JAPANESE");
    User user2= new User("Poor Michael", "PoorM", MD5.Translate_to_MD5_HASH("FAILURE"), "failure96@gmail.com", Date.valueOf("1999-07-06"), "Poorháza","Egyeb", true, true, "", "RUSSIAN");
    ID_CARD idCard = new ID_CARD(2123,user,"organisation","21321139es",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    ID_CARD idCard1 = new ID_CARD(2133,user1,"organisation1","21321139ed",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    ID_CARD idCard2 = new ID_CARD(2143,user2,"organisation","21321139ef",false,Date.valueOf("2022-11-13"),Nationality.HUNGARIAN);
    public IdTest() throws NoSuchAlgorithmException {

    }

    @Test
    public void UserIdTest() {
        assertEquals(1,GetId.getUserId(user));
        assertEquals(2,GetId.getUserId(user1));
    }

}
