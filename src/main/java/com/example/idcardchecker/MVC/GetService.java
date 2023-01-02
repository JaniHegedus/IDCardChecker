package com.example.idcardchecker.MVC;


import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

//Path("/get") @GET
public interface GetService
{
    //Path("/usern")
    Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token);
    //Path("/usere")
    Response getUserDataEmail(@HeaderParam("email") String email, @HeaderParam("token") String token);
    //Path("/userbyidc")
    String getUserbyIdCard(@HeaderParam("idcardnumber") String idcardnumber);
    //Path("/users")
    Response getUsers();
    //Path("/idcards")
    Response getIdCards();
}

