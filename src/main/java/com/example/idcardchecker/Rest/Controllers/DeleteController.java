package com.example.idcardchecker.Rest.Controllers;


import com.example.idcardchecker.DataBase.*;
import com.example.idcardchecker.DeleteService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;

@Path("/delete")
public class DeleteController implements DeleteService
{
    @Path("/username")
    @Override
    @POST
    public Response deleteUser(@HeaderParam("userName") String userName,
                               @HeaderParam("token") String token)
    {
        try{
            DeleteData.deleteUser(GetId.getUserId(GetObject.getUserUserName(userName,token)));
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }
    @Path("/user")
    @Override
    public Response deleteUser(@HeaderParam("Userid") int userid)
    {
        try{
            DeleteData.deleteUser(userid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @Path("/IDCard")
    @Override
    @POST
    public Response deleteIDCard(@HeaderParam("IDCardid") int IDCardid)
    {
        try{
            DeleteData.deleteIDCard(IDCardid);
            return Response.ok().build();
        }catch (Exception e)
        {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
