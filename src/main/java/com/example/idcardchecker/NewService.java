package com.example.idcardchecker;


import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

//Path("/new") @POST
public interface NewService
{
    //Path("/user")
    Response createNewUser(@HeaderParam("uname") String name,
                           @HeaderParam("userName") String username,
                           @HeaderParam("email") String email,
                           @HeaderParam("token") String token,
                           @HeaderParam("birthPlace") String birthPlace,
                           @HeaderParam("birthDate") String birthDate,
                           @HeaderParam("sex") String sex,
                           @HeaderParam("isMom") String isMom,
                           @HeaderParam("girlName") String girlName,
                           @HeaderParam("natinality") String nationality);
    //Path("/IDCard")
    Response createNewIDCard(@HeaderParam("can_number") String can_number,
                             @HeaderParam("userid") String userid,
                             @HeaderParam("organid") String organid,
                             @HeaderParam("idNum") String idNum,
                             @HeaderParam("fingerPrint") String fingerPrint,
                             @HeaderParam("expiry") String Expiry,
                             @HeaderParam("nationality") String nation);
}
