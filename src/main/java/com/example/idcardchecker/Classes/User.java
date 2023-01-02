package com.example.idcardchecker.Classes;



import com.example.idcardchecker.Enums.Nationality;
import com.example.idcardchecker.Enums.Sex;

import java.util.Date;
public class User
{
    private int id;
    private String name;
    private String username;
    private String password;
    private String email;
    private Date birthDate;
    private String birthplace;
    private Sex sex;
    private boolean active;
    private boolean isMom;
    private String GirlName;
    private Nationality nationality;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthdate() {
        return birthDate;
    }
    public void setBirthdate(Date birthdate) {
        this.birthDate = birthdate;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isMom() {
        return isMom;
    }
    public void setMom(boolean mom) {
        isMom = mom;
    }

    public String getGirlName() {
        return GirlName;
    }
    public void setGirlName(String girlName) {
        GirlName = girlName;
    }

    public Nationality getNationality() {
        return nationality;
    }
    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getBirthplace() {
        return birthplace;
    }
    public void setBirthplace(String place) {
        this.birthplace = place;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = Sex.valueOf(sex);
    }

    public User(String name, String username, String password, String email, Date birthDate, String birthplace, String sex, boolean active, boolean isMom, String girlName, String nationality) {
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.sex = Sex.valueOf(sex);
        this.active = active;
        this.isMom = isMom;
        this.GirlName = girlName;
        this.nationality = Nationality.valueOf(nationality);
    }

    public User(int id, String name, String username, String password, String email, Date birthDate, String birthplace, Sex sex, boolean active, boolean isMom, String girlName, Nationality nationality) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthDate = birthDate;
        this.birthplace = birthplace;
        this.sex = sex;
        this.active = active;
        this.isMom = isMom;
        GirlName = girlName;
        this.nationality = nationality;
    }
}