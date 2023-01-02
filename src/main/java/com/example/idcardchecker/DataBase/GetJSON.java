package com.example.idcardchecker.DataBase;



import com.example.idcardchecker.Classes.ID_CARD;
import com.example.idcardchecker.Classes.User;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

public class GetJSON
{
    public static @NotNull JSONObject getJSONUser(@NotNull User user){
        JSONObject usero = new JSONObject();
        try {
            usero.put("id",Objects.requireNonNull(user).getId());
            usero.put("Name", user.getName());
            usero.put("Girl Name",user.getGirlName());
            usero.put("Email",user.getEmail());
            usero.put("User Name",user.getUsername());
            usero.put("Token",user.getPassword());
            usero.put("Birth Date",user.getBirthdate());
            usero.put("Sex",user.getSex());
            usero.put("Is Mom",user.isMom());
            usero.put("Nationality",user.getNationality());
            usero.put("Active",user.isActive());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return usero;
    }
    public static @NotNull JSONObject getJSONIDCard(@NotNull User user)
    {
        ID_CARD id_card = GetObject.getID_CARDByUserid(user.getId());
        JSONObject id_cardO = new JSONObject();
        try {
            id_cardO.put("id",Objects.requireNonNull(id_card).getId());
            id_cardO.put("Number", Objects.requireNonNull(id_card).getId_num());
            id_cardO.put("CAN Number",id_card.getCAN_number());
            id_cardO.put("From Date",id_card.getExpiry());
            id_cardO.put("Organisation",id_card.getOrgan());
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return id_cardO;
    }
    public static @NotNull JSONArray getJSONDataUserName(String Username, String MD5Password)
    {
        User user = GetObject.getUserUserName(Username,MD5Password);
        JSONArray userO = new JSONArray();
        userO.put(Objects.requireNonNull(user).getId());
        userO.put(Objects.requireNonNull(user).getName());
        userO.put(user.getUsername());
        userO.put(user.getEmail());
        userO.put(user.getGirlName());
        userO.put(user.getSex());
        userO.put(user.getBirthdate());
        userO.put(user.getNationality());
        userO.put(getJSONIDCard(user));
        return userO;

    }
    public static @NotNull JSONArray getJSONDataEmail(String Email, String MD5Password)
    {
        User user = GetObject.getUserEmail(Email,MD5Password);
        JSONArray userO = new JSONArray();

        userO.put(Objects.requireNonNull(user).getId());
        userO.put(Objects.requireNonNull(user).getName());
        userO.put(user.getUsername());
        userO.put(user.getEmail());
        userO.put(user.getGirlName());
        userO.put(user.getSex());
        userO.put(user.getBirthdate());
        userO.put(user.getNationality());
        userO.put(getJSONIDCard(user));
        return userO;

    }
    public static @NotNull JSONArray getJSONUsers()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONUser(user));
        }
        return object;
    }

    public static @NotNull JSONArray getJSONIDCards()
    {
        JSONArray object = new JSONArray();
        for(User user : GetArray.getDataFromUserTable())
        {
            object.put(GetJSON.getJSONIDCard(user));
        }
        return object;
    }


}
