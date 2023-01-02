package com.example.idcardchecker.DataBase;


import com.example.idcardchecker.Classes.User;

import java.util.ArrayList;
import java.util.Objects;

import static com.example.idcardchecker.DataBase.GetArray.getDataFromUserTable;

public class GetId
{
    public static int getUserId(User user) {
        ArrayList<User> users = getDataFromUserTable();
        for (User user0 : users)
        {
            //System.out.println(user0.getUsername()+" "+user.getUsername());
            //System.out.println(user0.getPassword()+" "+user.getPassword().toString());
            if(Objects.equals(user0.getUsername(), user.getUsername()) && Objects.equals(user0.getPassword(), user.getPassword()))
            {
                return user0.getId();
            }
        }
        return 0;
    }
}
