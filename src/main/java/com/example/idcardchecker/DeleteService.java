package com.example.idcardchecker;

import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.core.Response;

//Path("/delete") @POST
public interface DeleteService
{
    //Path("/username")
    Response deleteUser(@HeaderParam("userName") String userName,
                        @HeaderParam("token") String token);
    //Path("/user")
    Response deleteUser(@HeaderParam("Userid") int userid);

    //Path("/IDCard")
    Response deleteIDCard(@HeaderParam("IDCardid") int IDCardid);

}
