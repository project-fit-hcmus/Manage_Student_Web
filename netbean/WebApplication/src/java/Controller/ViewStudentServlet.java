/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import DAO.StudentDAO;

import jakarta.servlet.annotation.WebServlet;
import entity.Student;
import java.util.List;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
/**
 *
 * @author User
 */
@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet{

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        StudentDAO studentDAO = new StudentDAO();   
        String action = request.getParameter("selectedPage");
        System.out.println(action);
        if(action ==  null){
            response.setContentType("text/html");
            response.getWriter().println("Nothing to show");
        }else 
        {
            if(action.equals("student")){
                request.setAttribute("data",studentDAO.getAllStudent());
                request.getRequestDispatcher("view/JSPViewStudent.jsp").forward(request,response);
            }else if(action.equals("course")){
                request.setAttribute("data",studentDAO.getAllCourse());
                request.getRequestDispatcher("view/JSPViewCourse.jsp").forward(request,response);

            }else if(action.equals("student_course")){
                request.getRequestDispatcher("view/JSPStudentCourse.jsp").forward(request,response);
            }else if(action.equals("addStudent")){
                request.getRequestDispatcher("view/JSPAddStudent.jsp").forward(request, response);
            }else if(action.equals("addCourse")){
                request.getRequestDispatcher("view/JSPAddCourse.jsp").forward(request, response);
            }else if(action.equals("home")){
                request.getRequestDispatcher("index.html").forward(request, response);
            }
            else if(action.equals("singleCourse")){
                String id=request.getParameter("idCourse");
                List<Student> students = studentDAO.getStudentInCourse(id);
                request.setAttribute("data", students);
                request.setAttribute("idCourse", id);
                request.setAttribute("nameCourse", studentDAO.getCourseName(id));          
                request.getRequestDispatcher("view/JSPSingleCourse.jsp").forward(request, response);
            }else if(action.equals("addStudentToCourse")){
                String idCourse = request.getParameter("idCourse");
                request.setAttribute("idCourse", idCourse);
                request.getRequestDispatcher("/view/JSPAddStudentToCourse.jsp").forward(request,response);
            }
     
        }
 
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
    }
    // Hàm mã hóa UTF-8 cho chuỗi đầu vào (lỗi)
    private String encodeUTF8(String input) {
//        byte[] bytes = input.getBytes(StandardCharsets.UTF_8);
//        String output = new String(bytes,StandardCharsets.UTF_8);
//        return output;
    return input;
    }
}
    


//some problems: 
//1. hiện chữ tiếng việt trong bảng data(tên, địa chỉ, note)
//2. Hiện ngày tháng năm sinh dạng yyyy/mm/dd