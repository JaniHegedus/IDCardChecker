package com.example.idcardchecker.DataBase;

import com.example.idcardchecker.Classes.ID_CARD;
import com.example.idcardchecker.Classes.User;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.idcardchecker.DataBase.GetArray.getDataFromIDCardTable;
import static com.example.idcardchecker.DataBase.GetArray.getDataFromUserTable;


public class GetObject
{

    @Nullable
    public static User getUserById(int id)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(user.getId()==id)
            {
                return user;
            }
        }
        return null;
    }

    @Nullable
    public static User getUserUserName(String UserName, String MD5Password)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(Objects.equals(user.getUsername(), UserName)
                    && Objects.equals(user.getPassword(), MD5Password))
            {
                return user;
            }
        }
        return null;
    }
    @Nullable
    public static User getUserEmail(String Email, String MD5Password)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(Objects.equals(user.getEmail(), Email)
                    && Objects.equals(user.getPassword(), MD5Password))
            {
                return user;
            }
        }
        return null;
    }

    @Nullable
    public static ID_CARD getID_CARDByUserid(int id)
    {
        ArrayList<ID_CARD> id_cards = getDataFromIDCardTable();
        for (ID_CARD id_card : id_cards)
        {
            if(Objects.equals(id_card.getUser().getId(), id))
            {
                return id_card;
            }
        }
        return null;
    }
    @Nullable
    public static String getUserbyIdCard(String idcardnumber)
    {
        ArrayList<User> users = getDataFromUserTable();
        for (User user : users)
        {
            if(Objects.equals(getID_CARDByUserid(user.getId()).getId_num(), idcardnumber))
            {
                return user.getName();
            }
        }
        return null;
    }
}
