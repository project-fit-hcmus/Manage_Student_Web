/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class CourseOfStudent {
    private String COURSE_ID;
    private String NAME;
    private String LECTURE;
    private int YEAR;
    private String NOTES;
    private float GRADE;
    
    public CourseOfStudent(){}
    public CourseOfStudent(String id, String name, String lecture, int year, String notes, float grade){
        this.COURSE_ID = id;
        this.NAME = name;
        this.LECTURE = lecture;
        this.YEAR = year;
        this.NOTES = notes;
        this.GRADE = grade;
    }
    public void setID(String id){this.COURSE_ID = id;}
    public void setNAME(String name){this.NAME = name;}
    public void setLECTURE(String lecture){this.LECTURE = lecture;}
    public void setYEAR(int year){this.YEAR = year;}
    public void setNOTES(String notes){this.NOTES = notes;}
    public void setGRADE(float grade){this.GRADE = grade;}
    
    public String getID(){return this.COURSE_ID;}
    public String getNAME(){return this.NAME;}
    public String getLECTURE(){return this.LECTURE;}
    public int getYEAR(){ return this.YEAR;}
    public String getNOTES(){return this.NOTES;}
    public float getGRADE(){return this.GRADE;}
}
