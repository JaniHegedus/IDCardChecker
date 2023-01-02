package com.example.idcardchecker;


import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

//Path("/get") @GET
public interface GetService
{
    //Path("/usern")
    Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token);
    //Path("/usere")
    Response getUserDataEmail(@HeaderParam("Email") String email, @HeaderParam("token") String token);
    //Path("/users")
    Response getUsers();
    //Path("/idcards")
    Response getIdCards();
}

