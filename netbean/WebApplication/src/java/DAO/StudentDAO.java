/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;
import Database.DBConnection;
import entity.*;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author User
 */
public class StudentDAO {
    private Connection connect = null;
    private PreparedStatement statement = null;
    
    
    public StudentDAO(){
        DBConnection dbConnect = new DBConnection();
        connect = dbConnect.Connect();            
    }
    
    public List<Student> getAllStudent(){
        List<Student> students =new ArrayList<>();
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT * FROM STUDENT";
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Student student = new Student();
                student.setID(rs.getString(1));
                student.setNAME(rs.getNString(2));
                student.setADDRESS(rs.getNString(4));
                student.setBIRTH(rs.getDate(3));
                student.setNOTES(rs.getNString(5));
                students.add(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        System.out.println(students.size());
        
        return students; 
    }
    
    public List<Student> getAllStudentSortAsc(){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT *\n" +
                        "FROM STUDENT \n" +
                        "ORDER BY NAME ASC";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                Student st = new Student();
                st.setID(rs.getString(1));
                st.setNAME(rs.getString(2));
                st.setBIRTH(rs.getDate(3));
                st.setADDRESS(rs.getString(4));
                st.setNOTES(rs.getString(5));
                students.add(st);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }       
        return students;
    }
    
    public List<Student> getAllStudentSortDesc(){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT *\n" +
                        "FROM STUDENT \n" +
                        "ORDER BY NAME DESC";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                Student st = new Student();
                st.setID(rs.getString(1));
                st.setNAME(rs.getString(2));
                st.setBIRTH(rs.getDate(3));
                st.setADDRESS(rs.getString(4));
                st.setNOTES(rs.getString(5));
                students.add(st);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }       
        return students;
    }
    
    public List<Student> findStudentByName(String name){
        List<Student> students =new ArrayList<>();
        statement = null;
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT ST.*\n" +
                        "FROM STUDENT ST\n" +
                        "WHERE ST.NAME LIKE N'%" + name + "%'  ";
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Student student = new Student();
                student.setID(rs.getString(1));
                student.setNAME(rs.getNString(2));
                student.setADDRESS(rs.getNString(4));
                student.setBIRTH(rs.getDate(3));
                student.setNOTES(rs.getNString(5));
                students.add(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        return students;
    }
    
    public List<Course> getAllCourse(){
        List<Course> courses =new ArrayList<>();
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT * FROM COURSE";
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Course course = new Course();
                course.setID(rs.getString(1));
                course.setNAME(rs.getNString(2));
                course.setLECTURE(rs.getNString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getNString(5));
                courses.add(course);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        return courses;
    }
    
    public List<Course> getAllCourseSortAsc(){
        List<Course> lists = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT *\n" +
                        "FROM COURSE \n" +
                        "ORDER BY NAME ASC";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setID(rs.getString(1));
                course.setNAME(rs.getString(2));
                course.setLECTURE(rs.getString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getString(5));
                lists.add(course);    
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lists;
    }
    
    public List<Course> getAllCourseSortDesc(){
        List<Course> lists = new ArrayList<>();
        ResultSet rs = null;
        try{
            String sql = "SELECT *\n" +
                        "FROM COURSE \n" +
                        "ORDER BY NAME DESC ";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            while(rs.next()){
                Course course = new Course();
                course.setID(rs.getString(1));
                course.setNAME(rs.getString(2));
                course.setLECTURE(rs.getString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getString(5));
                lists.add(course);    
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lists;
    }
    
    public List<Course> findCourseByName(String name){
        List<Course> courses =new ArrayList<>();
        
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT CR.*\n" +
                        "FROM COURSE CR\n" +
                        "WHERE CR.NAME LIKE N'%" + name + "%'";
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Course course = new Course();
                course.setID(rs.getString(1));
                course.setNAME(rs.getNString(2));
                course.setLECTURE(rs.getNString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getNString(5));
                courses.add(course);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        return courses;
    }
    
    public List<Course> findCourseByYear(int year){
        List<Course> courses =new ArrayList<>();
      
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT CR.*\n" +
                        "FROM COURSE CR\n" +
                        "WHERE CR.YEAR = "+ year;
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Course course = new Course();
                course.setID(rs.getString(1));
                course.setNAME(rs.getNString(2));
                course.setLECTURE(rs.getNString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getNString(5));
                courses.add(course);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        return courses;
    }
     
    public void DeleteStudentByID(String id){
        try{
            String sql = "DELETE FROM COURSE_STUDENT WHERE STUDENT_ID=?\n" +
                          "DELETE FROM STUDENT WHERE ID_STUDENT = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2,id);
            statement.executeQuery();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(statement!= null)
                    statement.close();
            }catch(SQLException m){
                m.printStackTrace();
            }
        }
    }
    
    public boolean deleteStudentInCourse(String idStudent, String idCourse) {
    int rowsUpdated = 0;
    try {
        String sql = "DELETE FROM COURSE_STUDENT WHERE STUDENT_ID = ? AND COURSE_ID = ?";
        PreparedStatement statement = connect.prepareStatement(sql);
        statement.setString(1, idStudent);
        statement.setString(2, idCourse);

        rowsUpdated = statement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException m) {
            m.printStackTrace();
        }
    }
    return rowsUpdated > 0;
}   
    
    public void DeleteCourseByID(String id){
        try{
            String sql = "DELETE FROM COURSE_STUDENT WHERE COURSE_ID=?\n" +
                        "DELETE FROM COURSE WHERE ID_COURSE =?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, id);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(statement!= null)
                    statement.close();
            }catch(SQLException m){
                m.printStackTrace();
            }
        }
    }
    
    public List<Student> getStudentInCourse(String courseID){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        try{
            //tạo truy vấn SQL 
            String sql = "SELECT ST.* \n" +
                        "FROM STUDENT ST,  COURSE_STUDENT CS\n" +
                        "WHERE ST.ID_STUDENT = CS.STUDENT_ID AND CS.COURSE_ID='"+ courseID + "'";
            // tạo preparedStatement và thực hành truy vấn 
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            // lặp qua các kết quả và tạo đối tượng Student từ dữ liệu 
            while(rs.next()){
                Student student = new Student();
                student.setID(rs.getString(1));
                student.setNAME(rs.getNString(2));
                student.setADDRESS(rs.getNString(4));
                student.setBIRTH(rs.getDate(3));
                student.setNOTES(rs.getNString(5));
                students.add(student);
            }
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs == null){
                    rs.close();
                }
                if(statement != null){
                    statement.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            } 
        }
        return students;
    }

    public void AddStudent(Student student){
        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?)";
        try(PreparedStatement statement=connect.prepareStatement(sql)){
            statement.setString(1, student.getID());
            statement.setString(2, student.getNAME());
            statement.setDate(3, new java.sql.Date(student.getBIRTH().getTime()));
            statement.setString(4, student.getADDRESS());
            statement.setString(5, student.getNOTES());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(statement != null)
                    statement.close();
            }catch(SQLException m){
                m.printStackTrace();
            }
        }
    }
    
    public void AddCourse(Course course){
        String sql = "INSERT INTO COURSE VALUES(?,?,?,?,?)";
        try(PreparedStatement statement = connect.prepareStatement(sql)){
            statement.setString(1, course.getID());
            statement.setString(2, course.getNAME());
            statement.setString(3, course.getLECTURE());
            statement.setInt(4, course.getYEAR());
            statement.setString(5,course.getNOTES());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                if(statement != null)
                    statement.close();
            }catch(SQLException m){
                m.printStackTrace();
            }
        }
    }

    public String getCourseName(String courseID){
        ResultSet rs = null;
        String courseName = null;
        try{
            String sql = "SELECT NAME \n" +
                        "FROM COURSE \n" +
                        "WHERE ID_COURSE = '" + courseID+"'";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                courseName = rs.getString("NAME");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return courseName;
    }

    public String getStudentName(String studentID){
        ResultSet rs = null;
        String studentName = null;
        try{
            String sql = "SELECT NAME \n" +
                        "FROM STUDENT \n" +
                        "WHERE ID_STUDENT = '" + studentID+"'";
            statement = connect.prepareStatement(sql);
            rs = statement.executeQuery();
            if (rs.next()) {
                studentName = rs.getString("NAME");
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return studentName;
    }
    
    public void AddStudentToCourse(String idStudent, String idCourse, float grade){
        // tạo id mới cho student-course 
        String id = null;
        do{
            id = RandomIDSC();
        }while(IsIDSCExist(id));
        // nếu trong danh sách đã tồn tại idStudent và idCourse thì sẽ không thêm nữa 
        // nếu sinh viên chưa tồn tại trong danh sách sinh viên thì không thêm được
        if(IsStudentInCourse(idStudent, idCourse) || !IsStudentExist(idStudent))
            return;
        try{
            String sql = "INSERT COURSE_STUDENT VALUES(?,?,?,?)";
            statement = connect.prepareStatement(sql);
            statement.setString(1, id);
            statement.setString(2, idStudent);
            statement.setString(3, idCourse);
            statement.setFloat(4, grade);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }   
    }
    
    public boolean IsIDSCExist(String id){
        boolean check = false;
        String sql = "SELECT ID FROM COURSE_STUDENT WHERE ID = '" + id + "'";
        try{
            statement = connect.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                check = true;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return check;
    }
    
    public String RandomIDSC(){
         Random random = new Random();
    
        // Tạo chuỗi 5 ký tự số ngẫu nhiên
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            int digit = random.nextInt(10); // Số ngẫu nhiên từ 0 đến 9
            builder.append(digit);
        }
    
        return builder.toString();
    }

    public boolean IsStudentInCourse(String idStudent, String idCourse){
        ResultSet rs = null;
        boolean exist = false;
        try{
            String sql = "SELECT * FROM COURSE_STUDENT WHERE STUDENT_ID = ? AND COURSE_ID=?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, idStudent);
            statement.setString(2, idCourse);
            rs = statement.executeQuery();
            if(rs.next())
                exist = true;  
        }catch(SQLException e){
            e.printStackTrace();
        }
        return exist;
    }

    public boolean IsStudentExist(String id){
        boolean exists = false;
        ResultSet rs = null;
        try{
            String sql = "SELECT * FROM STUDENT WHERE ID_STUDENT = ?";
            statement = connect.prepareStatement(sql);
            statement.setString(1, id);
            rs = statement.executeQuery();
            if(rs.next())
                exists = true;
        }catch(SQLException e){
             e.printStackTrace();
        
        }
        return exists;
    }

    public List<CourseOfStudent> getAllCourseOfStudent(String studentId){
        ResultSet rs = null;
        List<CourseOfStudent> lists = new ArrayList<>();
        try{
            String sql = "SELECT CR.*, CS.GRADE\n" +
                        "FROM COURSE CR, COURSE_STUDENT CS\n" +
                        "WHERE CR.ID_COURSE = CS.COURSE_ID AND CS.STUDENT_ID = ? ";
            statement = connect.prepareStatement(sql);
            statement.setString(1, studentId);
            rs = statement.executeQuery();
            while(rs.next()){
                CourseOfStudent course = new CourseOfStudent();
                course.setID(rs.getString(1));
                course.setNAME(rs.getString(2));
                course.setLECTURE(rs.getString(3));
                course.setYEAR(rs.getInt(4));
                course.setNOTES(rs.getString(5));
                course.setGRADE(rs.getFloat(6));
                lists.add(course);
            }
                
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lists;
    }

    public List<StudentOfYear> getAllStudentInYear(int year){
        ResultSet rs = null;
        List<StudentOfYear> lists =  new ArrayList<>();
        try{
            String sql = "SELECT ST.ID_STUDENT, ST.NAME, CR.NAME, CS.GRADE\n" +
                        "FROM STUDENT ST, COURSE CR, COURSE_STUDENT CS\n" +
                        "WHERE ST.ID_STUDENT = CS.STUDENT_ID AND CR.ID_COURSE = CS.COURSE_ID AND CR.YEAR = ?";
            statement = connect.prepareStatement(sql);
            statement.setInt(1, year);
            rs = statement.executeQuery();
            while(rs.next()){
                StudentOfYear temp = new StudentOfYear();
                temp.setID(rs.getString(1));
                temp.setNAME(rs.getString(2));
                temp.setCOURSE(rs.getString(3));
                temp.setGRADE(rs.getFloat(4));
                lists.add(temp);
            }
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lists;
    }

    
    
    
    public void updateCourse(String id, String name, String lecture, int year, String notes){
        try{
            String sql = "UPDATE COURSE\n" +
                        "SET NAME = N'"+ name +"', LECTURE = N'"+lecture+"' , NOTES = N'"+notes+"' , YEAR = " + year +"\n" +
                        "WHERE ID_COURSE ='"+id+"' ";
            statement = connect.prepareStatement(sql);
            System.out.println(sql);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
    public void updateStudent(Student st){
   
        try{
            String sql = "UPDATE STUDENT\n" +
                        "SET NAME = N'"+ st.getNAME() +"', ADDRESS = N'"+st.getADDRESS()+"' , NOTES = N'"+st.getNOTES()+"'\n" +
                        "WHERE ID_STUDENT ='"+st.getID()+"' ";
            statement = connect.prepareStatement(sql);
            System.out.println(sql);
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}






//public void updateStudent(String id, String name, String address, String notes) throws UnsupportedEncodingException{
//        String encodeName = new String(name.getBytes("UTF-8"),"UTF-8");
//        System.out.println("Name after encode : " + encodeName);
//                System.out.println("Name before encode : " + name);
//
//        
//            
//        try{
//            String sql = "UPDATE STUDENT\n" +
//                        "SET NAME = '"+ encodeName +"', ADDRESS = '"+address+"' , NOTES ='"+notes+"'\n" +
//                        "WHERE ID_STUDENT ='"+id+"' ";
//            statement = connect.prepareStatement(sql);
//            System.out.println(sql);
//            statement.executeUpdate();
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
//    }