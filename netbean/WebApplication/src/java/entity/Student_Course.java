/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author User
 */
public class Student_Course {
    private String ID;
    private String ID_ST;
    private String ID_CR;
    private float GRADE;
    
    public Student_Course(){}
    public String getID(){return this.ID;}
    public String getIDST(){return this.ID_ST;}
    public String getIDCR(){return this.ID_CR;}
    public float getGRADE(){return this.GRADE;}
    
    public void setID(String value){this.ID = value;}
    public void setIDST(String value){this.ID_ST =value;}
    public void setIDCR(String value){this.ID_CR = value;}
    public void setGRADE(float value){this.GRADE = value;}
}
