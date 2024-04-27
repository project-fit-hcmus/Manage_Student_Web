/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import DAO.StudentDAO;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import entity.*;
import java.io.PrintWriter;


/**
 *
 * @author User
 */
@WebServlet("/updateDataServlet")
public class updateDataServlet extends HttpServlet  {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=UTF-8");
        
        StudentDAO studentDAO = new StudentDAO();   
        String id = req.getParameter("id");
        String type = req.getParameter("type");
//        System.out.println(id);
        if(type==null){
            resp.getWriter().println("Empty Action");
        }
        else{
            if(type.equals("delete-course")){
                studentDAO.DeleteCourseByID(id);
                //chuyển hướng về lại trang JSPViewCourse
                req.setAttribute("data", studentDAO.getAllCourse());
                req.getRequestDispatcher("view/JSPViewCourse.jsp").forward(req, resp);
            }//END DELETE COURSE
            else if(type.equals("delete-student")){
                
                studentDAO.DeleteStudentByID(id);
                System.out.println("id student delte: " +id );
                System.out.println("After Delete: " + studentDAO.getAllStudent());
                //chuyển hướng về lại trang JSPViewCourse
                req.setAttribute("data", studentDAO.getAllStudent());
                req.getRequestDispatcher("view/JSPViewStudent.jsp").forward(req, resp);
            }//END DELETE STUDENT
            else if(type.equals("add-student")){
                String button =req.getParameter("button");
                if(button != null){
                    if(button.equals("confirm")){
                        String birth = req.getParameter("birth");
                        Date date = null;
                        try{
                            date = (new SimpleDateFormat("yyyy-mm-dd")).parse(birth);
                        }catch(ParseException e){
                            e.printStackTrace();
                        }
                        Student student = new Student(id,req.getParameter("name"),date,req.getParameter("address"),req.getParameter("notes"));
                        studentDAO.AddStudent(student);
                    }
                    //lấy lại danh sách học sinh và điều hướng về lại trang viewStudent   
                    req.setAttribute("data", studentDAO.getAllStudent());
                    req.getRequestDispatcher("view/JSPViewStudent.jsp").forward(req, resp);
                    
                }
            }//END ADD STUDENT
            else if(type.equals("add-course")){
                String button =req.getParameter("button");
                if(button != null){
                    if(button.equals("confirm")){
                        Course course = new Course(id,req.getParameter("name"),req.getParameter("lecture"),Integer.parseInt(req.getParameter("year")),req.getParameter("notes"));
                        studentDAO.AddCourse(course);
                    }
                    //lấy lại danh sách học sinh và điều hướng về lại trang viewStudent   
                    req.setAttribute("data", studentDAO.getAllCourse());
                    req.getRequestDispatcher("view/JSPViewCourse.jsp").forward(req, resp);
                    
                }
            }//END ADD COURSE
            else if(type.equals("delete-student-in-course")){
                String idCourse = req.getParameter("id-course");
                String idStudent = req.getParameter("id-student");
//                System.out.println("IDCourse: " + idCourse);
//                System.out.println("IDStudent: " + idStudent);

                // xóa trong database
                boolean result = studentDAO.deleteStudentInCourse(idStudent, idCourse);
//                System.out.println("result-delete: " + result);
//                System.out.println(studentDAO.getStudentInCourse(idCourse).size());
                req.setAttribute("data", studentDAO.getStudentInCourse(idCourse));
                req.setAttribute("idCourse", idCourse);
                req.setAttribute("nameCourse", studentDAO.getCourseName(idCourse));
                req.getRequestDispatcher("view/JSPSingleCourse.jsp").forward(req, resp);
            }
            else if(type.equals("add-student-to-course")){
                //get data from request 
                String idCourse = req.getParameter("idCourse");
                String idStudent = req.getParameter("id");
                float grade = Float.parseFloat(req.getParameter("grade"));
                int before = studentDAO.getStudentInCourse(idCourse).size();
                int after = 0;
                
                String button =req.getParameter("button");
                if(button != null){
                    if(button.equals("confirm")){
                        //Thêm dữ liệu vào database
                        studentDAO.AddStudentToCourse(idStudent, idCourse, grade);
                        after = studentDAO.getStudentInCourse(idCourse).size();
                    }
                    // trở về trang single course 
                    req.setAttribute("data",studentDAO.getStudentInCourse(idCourse));
                    req.setAttribute("idCourse", idCourse);
                    req.setAttribute("nameCourse", studentDAO.getCourseName(idCourse));
                    if(after > before)
                        req.setAttribute("addStatus", "success!!");
                    else req.setAttribute("addStatus", "error!!");
                    req.getRequestDispatcher("/view/JSPSingleCourse.jsp").forward(req, resp);
                }
            }
            else if(type.equals("updateStudent")){
                Student student;
                student = new Student();
                student.setID(req.getParameter("idStudent"));
                student.setADDRESS(req.getParameter("newAddr"));
                student.setNAME(req.getParameter("newName"));
                student.setNOTES(req.getParameter("newNotes"));
                

                studentDAO.updateStudent(student);
                // gửi phản hồi 
                resp.setContentType("text/plain");
                PrintWriter out = resp.getWriter();
                out.print("Success"); // Hoặc bất kỳ thông báo thành công nào khác
                out.flush();
            }
            else if(type.equals("updateCourse")){
                 String idCourse = req.getParameter("idCourse");
                 String name = req.getParameter("newName");
                 String notes = req.getParameter("newNotes");
                 String lecture = req.getParameter("newLecture");
                 String year = req.getParameter("newYear");
                 
//                 System.out.println("ID Course: " + idCourse);
//                 System.out.println("Name: " + name);
//                 System.out.println("Lecture: " + lecture);
//                 System.out.println("Year: " + year);
//                 System.out.println("Notes: " + notes);
                 
                 studentDAO.updateCourse(idCourse, name, lecture, Integer.parseInt(year), notes);
                 resp.setContentType("text/plain");
                PrintWriter out = resp.getWriter();
                out.print("Success"); // Hoặc bất kỳ thông báo thành công nào khác
                out.flush();
                 
                
            }
                
         
            
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
    
    
    
}
