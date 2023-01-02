package com.example.idcardchecker.DataBase;

import com.example.idcardchecker.Classes.ID_CARD;
import com.example.idcardchecker.Classes.User;
import com.example.idcardchecker.Enums.Nationality;
import com.example.idcardchecker.Enums.Sex;
import org.jetbrains.annotations.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.Objects;

public class GetArray
{
    private static final String jdbcDriver = LoadMySQL.getDriverName();
    private static final String dbAddress = LoadMySQL.getAddress();
    private static final String userPass = LoadMySQL.getUserPass();
    private static final String dbName = LoadMySQL.getDBName();
    private static final String userName = LoadMySQL.getUserName();
    private static final String password = LoadMySQL.getPassword();

    public GetArray()
    {
        new LoadMySQL();
        Create_DataBase_With_Tables create = new Create_DataBase_With_Tables();
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            try
            {
                new LoadMySQL();
                create.createUsersTable();
                create.createIDCardTable();
            }
            catch (Exception exception)
            {
                System.out.println("An error occured: "+exception);
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            create.createDatabase();
        }
    }
    @NotNull
    public static ArrayList<User> getDataFromUserTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<User> users = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM Users ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                String uname = rs.getString("uname");
                String userName = rs.getString("userName");
                String password = rs.getString("password");
                String email = rs.getString("email");
                Date birthDate = rs.getDate("birthDate");
                String birthPlace = rs.getString("birthPlace");
                Sex sex = Sex.valueOf(rs.getString("sex"));
                int isActive = rs.getInt("isActive");
                int isMom = rs.getInt("isMom");
                String girlName = rs.getString("girlName");
                Nationality nationality = Nationality.valueOf(rs.getString("nationality"));
                //System.out.println(id+", "+uname+", "+userName+", "+password+", "+email+", "+birthDate.toString()+", "+birthPlace+", "+sex+", "+isActive+", "+isMom+", "+girlName+", "+nationality);
                boolean aktiv = false;
                boolean Mom = false;
                if(isActive==1) aktiv = true;
                if(isMom==1)Mom = true;
                users.add(new User(id,uname,userName,password,email,birthDate,birthPlace,sex,aktiv,Mom,girlName, nationality));
            }
            con.close();
            return users;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
    @NotNull
    public static ArrayList<ID_CARD> getDataFromIDCardTable()
    {
        try
        {
            Class.forName(jdbcDriver);
            Connection con = DriverManager.getConnection(dbAddress + dbName, userName, password);
            ArrayList<ID_CARD> cards = new ArrayList<>();
            Statement st = con.createStatement();
            String sql = ("SELECT * FROM IDCard ORDER BY id DESC;");
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                int id = rs.getInt("id");
                int userid = rs.getInt("userid");
                String cardNumber = rs.getString("cardNumber");
                int cam = rs.getInt("can");
                int fingerprint = rs.getInt("fingerprint");
                String org = rs.getString("orgname");
                Date expiration_date = rs.getDate("expirationDate");
                //System.out.println(country+", "+county+", "+city+", "+street+", "+rest+", "+house_number+", "+registration_date+", "+expiration_date);
                User user = GetObject.getUserById(userid);
                Nationality nationality = Objects.requireNonNull(user).getNationality();
                boolean finger = fingerprint == 1;
                cards.add(new ID_CARD(id,cam,user,org,cardNumber,finger,expiration_date,nationality));
            }
            con.close();
            return cards;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    @NotNull
    public static ArrayList<Object> getData(String Username, String MD5Password) {
        ArrayList<Object> objects = new ArrayList<>();
        User user = GetObject.getUserUserName(Username,MD5Password);
        objects.add(user);
        ID_CARD id_card = GetObject.getID_CARDByUserid(Objects.requireNonNull(user).getId());
        objects.add(id_card);
        return objects;
    }
}
