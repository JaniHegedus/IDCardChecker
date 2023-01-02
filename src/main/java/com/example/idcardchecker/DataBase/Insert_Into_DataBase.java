package com.example.idcardchecker.DataBase;


import com.example.idcardchecker.Classes.ID_CARD;
import com.example.idcardchecker.Classes.User;
import com.example.idcardchecker.Enums.Nationality;
import com.example.idcardchecker.Enums.Sex;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;

public class Insert_Into_DataBase
{
    public Insert_Into_DataBase()
    {
        new LoadMySQL();
    }
    public void insertIntoUserTable(@NotNull User user) throws SQLException, ClassNotFoundException {
        String Uname = user.getName();
        String UserName =user.getUsername();
        String Password = user.getPassword();
        String Email = String.valueOf(user.getEmail());
        Date BirthDate= (Date) user.getBirthdate();
        String BirthPlace=user.getBirthplace();
        Sex sex = user.getSex();
        boolean isActive=user.isActive();
        boolean IsMom=user.isMom();
        String GirlName=user.getGirlName();
        Nationality Nationality = user.getNationality();
        Statement st;
        int active= 0;
        int Mom =0;
        if(isActive) active = 1;
        if(IsMom) Mom = 1;
        Class.forName(LoadMySQL.getDriverName());
        Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
        ArrayList<User> users = GetArray.getDataFromUserTable();
        ArrayList<String> userNamesTaken = new ArrayList<>();
        for (User user0 : users)
        {
            userNamesTaken.add(user0.getUsername());
        }
        if(!userNamesTaken.contains(UserName))
        {
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into Users("
                        + "uname,"
                        + "userName,"
                        + "password,"
                        + "email,"
                        + "birthDate,"
                        + "birthPlace,"
                        + "sex,"
                        + "isActive,"
                        + "isMom,"
                        + "girlName,"
                        + "nationality)"
                        + " values('"
                        +Uname+"','"
                        +UserName+"','"
                        +Password+"','"
                        +Email+"','"
                        +BirthDate+"','"
                        +BirthPlace+"','"
                        +sex+"','"
                        +active+"','"
                        +Mom+"','"
                        +GirlName+"','"
                        +Nationality+"') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else {
            System.out.println("UserName is Taken!");
        }
    }

    public void insertIntoIDCardTable(@NotNull ID_CARD id_card) throws SQLException, ClassNotFoundException {
        ArrayList<ID_CARD> usedlocations = GetArray.getDataFromIDCardTable();
        ArrayList<String> alltogethers =new ArrayList<>();
        for (ID_CARD usedid : usedlocations)
        {
            String allintogether = usedid.getId_num();
            alltogethers.add(allintogether);
        }
        String given = id_card.getId_num();
        if(!alltogethers.contains(given))
        {
            String id_num = id_card.getId_num();
            int userid = GetId.getUserId(id_card.getUser());
            //System.out.println(GetId.getUserId(id_card.getUser()));
            String orgname =id_card.getOrgan();
            //System.out.println(GetId.getOrgId(id_card.getOrgan()));
            int CAN_number = id_card.getCAN_number();
            int fingerprint =0;
            if(id_card.isFinger_print()) fingerprint = 1;
            Date from_date = (Date) id_card.getExpiry();
            Class.forName(LoadMySQL.getDriverName());
            Connection con = DriverManager.getConnection(LoadMySQL.getAddress() + LoadMySQL.getDBName(), LoadMySQL.getUserName(), LoadMySQL.getPassword());
            Statement st;
            try
            {
                st = con.createStatement();
                String accessDatabase = "insert into IDCard("
                        + "userid,"
                        + "cardNumber,"
                        + "can,"
                        + "fingerprint,"
                        + "orgname,"
                        + "expirationDate"
                        + ")"
                        + " values('"
                        + userid + "','"
                        + id_num + "','"
                        + CAN_number + "','"
                        + fingerprint + "','"
                        + orgname + "','"
                        + from_date
                        + "') ";
                int result = st.executeUpdate(accessDatabase);

                if (result > 0)
                {
                    System.out.println("Record Inserted! Check your table now!");
                }
                con.close();
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }else{
            System.out.println("Record already Created");
        }
    }
}
