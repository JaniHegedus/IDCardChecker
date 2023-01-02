package com.example.idcardchecker.MVC.Controllers;


import com.example.idcardchecker.DataBase.GetObject;
import com.example.idcardchecker.MVC.GetService;
import com.example.idcardchecker.DataBase.GetJSON;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.*;

import static com.example.idcardchecker.DataBase.GetJSON.getJSONIDCards;
import static com.example.idcardchecker.DataBase.GetJSON.getJSONUsers;
import static com.example.idcardchecker.DataBase.GetObject.getUserEmail;
import static com.example.idcardchecker.DataBase.GetObject.getUserUserName;

@Path("/get")
public class GetController implements GetService
{

    @Override
    @Path("/usern")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserData(@HeaderParam("userName") String username, @HeaderParam("token") String token){
        JSONObject resp = new JSONObject();
        try {
            resp.put("Username",username);
            resp.put("Token",token);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        if(!token.equals("") && (getUserUserName(username, token) != null))
        {
            //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20"))); //testData
            try {
                resp.put("Data", GetJSON.getJSONDataUserName(username,token));
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
            return Response.ok(resp.toString()).type(MediaType.APPLICATION_JSON).build();
        }
        else
        {
            try {
                resp.put("error","No Token");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        //
        try {
            resp.put("Data", GetJSON.getJSONDataUserName(username,token));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    @Override
    @Path("/usere")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserDataEmail(@HeaderParam("email") String email, @HeaderParam("token") String token)
    {
        JSONObject resp = new JSONObject();
        try{
            resp.put("Username",email);
            resp.put("Token",token);

            if(!token.equals("") && (getUserEmail(email, token) != null))
            {
                //resp.put("Data", GetJSON.getJSONData("JaniHegedus",MD5.Translate_to_MD5_HASH("Jancsika20"))); //testData
                resp.put("Data", GetJSON.getJSONDataUserName(email,token));
                return Response.ok(resp.toString()).type(MediaType.APPLICATION_JSON).build();
            }
            else
            {
                resp.put("error","No Token");
            }
            //
            resp.put("Data", GetJSON.getJSONDataUserName(email,token));
        }catch (JSONException e)
        {
            throw new RuntimeException(e);
        }

        return Response.status(Response.Status.UNAUTHORIZED).type(MediaType.APPLICATION_JSON).entity(resp).build();
    }
    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public Response getUsers()
    {
        return Response.ok(getJSONUsers().toString()).type(MediaType.APPLICATION_JSON).build();
    }

    @Override
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/idcards")
    public Response getIdCards()
    {
        return Response.ok(getJSONIDCards().toString()).type(MediaType.APPLICATION_JSON).build();
    }
    @Override
    @GET
    @Produces("text/plain")
    @Path("/userbyidc")
    public String getUserbyIdCard(@HeaderParam("idcardnumber") String idcardnumber)
    {
        return GetObject.getUserbyIdCard(idcardnumber);
    }
}