/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class StudentOfYear {
    private String ID;
    private String NAME;  
    private String COURSE;
    private float GRADE;
    
    public StudentOfYear(){}
    public StudentOfYear(String id, String name, String course, float grade){
        this.ID = id;
        this.NAME = name;
        this.COURSE = course;
        this.GRADE = grade;
    }
    
    public void setID(String id){ this.ID = id;}
    public void setNAME(String name){this.NAME = name;}
    public void setCOURSE(String course){this.COURSE = course;}
    public void setGRADE(float grade){this.GRADE = grade;}
    
    public String getID(){return this.ID;}
    public String getNAME(){return this.NAME;}
    public String getCOURSE(){return this.COURSE;}
    public float getGRADE(){return this.GRADE;}
    
}
