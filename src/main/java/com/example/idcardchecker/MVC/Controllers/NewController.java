package com.example.idcardchecker.MVC.Controllers;


import com.example.idcardchecker.Classes.ID_CARD;
import com.example.idcardchecker.Classes.User;
import com.example.idcardchecker.DataBase.Insert_Into_DataBase;
import com.example.idcardchecker.Enums.Nationality;
import com.example.idcardchecker.MVC.NewService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.json.*;

import java.util.Arrays;
import java.util.Objects;

import static com.example.idcardchecker.DataBase.GetObject.getUserById;
import static java.sql.Date.valueOf;


@Path("/new")
public class NewController implements NewService
{
    Insert_Into_DataBase insert = new Insert_Into_DataBase();
    @Path("/user")
    @Override
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createNewUser(@HeaderParam("uname") String name,
                                  @HeaderParam("userName") String username,
                                  @HeaderParam("email") String email,
                                  @HeaderParam("token") String token,
                                  @HeaderParam("birthPlace") String birthPlace,
                                  @HeaderParam("birthDate") String birthDate,
                                  @HeaderParam("sex") String sex,
                                  @HeaderParam("isMom") String isMom,
                                  @HeaderParam("girlName") String girlName,
                                  @HeaderParam("nationality") String nationality)
    {
        boolean mom = false;
        if(Objects.equals(isMom, "true")) mom = true;
        try
        {
            insert.insertIntoUserTable(new User(name,username,token,email, valueOf(birthDate),birthPlace,sex,true,mom,girlName,nationality));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            JSONObject object = new JSONObject();
            try {
                object.put("Name",name);
                object.put("UserName",username);
                object.put("Email",email);
                object.put("Token",token);
                object.put("BirthPlace",birthPlace);
                object.put("Birth Date",birthDate);
                object.put("SEX",sex);
                object.put("MoM",isMom);
                object.put("GirlName",girlName);
                object.put("Nationality",nationality);
                object.put("Message",ex.getMessage());
                object.put("StackTraceToString", Arrays.toString(ex.getStackTrace()));
                object.put("StackTrace",ex.getStackTrace());
                object.put("Cause",ex.getCause());
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }

            return Response.ok(object).type(MediaType.APPLICATION_JSON).build();
        }

    }

    @Path("/IDCard")
    @Override
    @POST
    public Response createNewIDCard(@HeaderParam("can_number") String can_number,
                                    @HeaderParam("userid") String userid,
                                    @HeaderParam("organname") String orgname,
                                    @HeaderParam("idNum") String idNum,
                                    @HeaderParam("fingerPrint") String fingerPrint,
                                    @HeaderParam("expiry") String Expiry,
                                    @HeaderParam("nationality") String nation)
    {
        try
        {
            insert.insertIntoIDCardTable(new ID_CARD(Integer.parseInt(can_number), getUserById(Integer.parseInt(userid)), orgname,idNum,Boolean.parseBoolean(fingerPrint),valueOf(Expiry), Nationality.valueOf(nation)));
            return Response.status(Response.Status.CREATED).type(MediaType.APPLICATION_JSON).build();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).type(MediaType.APPLICATION_JSON).build();
        }

    }
}
