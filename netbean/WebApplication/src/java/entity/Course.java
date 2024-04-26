/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class Course {
     private String ID;
    private String NAME;
    private String LECTURE;
    private int YEAR;
    private String NOTES;
    
    public Course(){}
    public Course(String id, String name, String lecture, int year, String notes){
        this.ID = id;
        this.NAME = name;
        this.LECTURE = lecture;
        this.YEAR = year;
        this.NOTES = notes;
    }
    public String getID(){return this.ID;}
    public String getNAME(){return this.NAME;}
    public String getLECTURE(){return this.LECTURE;}
    public String getNOTES(){return this.NOTES;}
    public int getYEAR(){return this.YEAR;}
    
    public void setID(String value){this.ID = value;}
    public void setNAME(String value){this.NAME = value;}
    public void setLECTURE(String value){this.LECTURE = value;}
    public void setNOTES(String value){this.NOTES = value;}
    public void setYEAR(int value){this.YEAR = value;}
}
