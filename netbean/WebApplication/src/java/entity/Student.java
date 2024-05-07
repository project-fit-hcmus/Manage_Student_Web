/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Student {
    private String ID;
    private String NAME;        
    private Date BIRTH;
    private String ADDRESS;
    private String NOTES;
    
    public Student(){}
    public Student(String id, String name, String date, String address,String notes) throws ParseException{
        this.ID = id;
        this.NAME = name;
        this.BIRTH =(new SimpleDateFormat("yyyy-mm-dd")).parse(date);
        this.ADDRESS = address;
        this.NOTES = notes;
    }
    public Student(String id, String name, Date birth, String address, String notes){
        this.ID = id;
        this.NAME = name;
        this.BIRTH = birth;
        this.ADDRESS = address;
        this.NOTES = notes;
    }
    public String getID(){return this.ID;}
    public String getNAME(){
        return this.NAME;
    }
    public Date getBIRTH(){return this.BIRTH;}
    public String getADDRESS(){return this.ADDRESS;}
    public String getNOTES(){return this.NOTES;}
    public void setID(String value){ this.ID = value;}
    public void setNAME(String value){this.NAME = value;}
    public void setBIRTH(Date value){this.BIRTH = value;}
    public void setADDRESS(String value){this.ADDRESS = value;}
    public void setNOTES(String value){this.NOTES = value;}
}
