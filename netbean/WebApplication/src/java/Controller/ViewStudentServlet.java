/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import DAO.StudentDAO;
import entity.*;

import jakarta.servlet.annotation.WebServlet;
import entity.Student;
import java.util.*;
import java.time.LocalDate;

import java.util.ArrayList;
/**
 *
 * @author User
 */
@WebServlet("/ViewStudentServlet")
public class ViewStudentServlet extends HttpServlet{
    

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        StudentDAO studentDAO = new StudentDAO();   
        String action = request.getParameter("selectedPage");
        if(action ==  null){
            response.setContentType("text/html");
            response.getWriter().println("Nothing to show");
        }else 
        {
            if(action.equals("student")){
                request.setAttribute("data",studentDAO.getAllStudent());
                request.setAttribute("kindOfSort", "desc");     
                request.getRequestDispatcher("view/JSPViewStudent.jsp").forward(request,response);
            }else if(action.equals("course")){
                request.setAttribute("data",studentDAO.getAllCourse());
                request.setAttribute("kindOfSort", "desc");
                request.getRequestDispatcher("view/JSPViewCourse.jsp").forward(request,response);

            }else if(action.equals("student_course")){
                int currentYear = LocalDate.now().getYear();
                List<StudentOfYear> lists = studentDAO.getAllStudentInYear(currentYear);
                request.setAttribute("data", lists);
                request.setAttribute("year", currentYear);
                request.getRequestDispatcher("view/JSPStudentOfYear.jsp").forward(request,response);
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
            else if (action.equals("singleStudent")){
                String idStudent = request.getParameter("idStudent");
                request.setAttribute("idStudent", idStudent);
                // lấy danh sách các khóa học để hiển thị lên màn hình Single Student 
                List<CourseOfStudent> list  = studentDAO.getAllCourseOfStudent(idStudent);
                request.setAttribute("data", list);
                request.setAttribute("nameStudent", studentDAO.getStudentName(idStudent));     
                request.getRequestDispatcher("/view/JSPSingleStudent.jsp").forward(request, response);
            }
            else if(action.equals("findStudent")){
                String keyword = request.getParameter("keyword");
                request.setAttribute("data", studentDAO.findStudentByName(keyword));
                request.setAttribute("kindOfSort", "desc");       // TEST
                request.getRequestDispatcher("/view/JSPViewStudent.jsp").forward(request, response);
            }
            else if(action.equals("findCourse")){
                String criteria = request.getParameter("criteria");
                String keyword = request.getParameter("keyword");
                List<Course> lists = null;
//                System.out.println(criteria);
//                System.out.println(keyword);
                if(criteria.equals("name")){        // find by name
                    lists = studentDAO.findCourseByName(keyword);
                }else{      //find by year
                    lists = studentDAO.findCourseByYear(Integer.parseInt(keyword));
                }
                request.setAttribute("data", lists);
                request.setAttribute("kindOfSort", "desc");
                request.getRequestDispatcher("/view/JSPViewCourse.jsp").forward(request, response);
            }
            else if(action.equals("sortStudent")){
                List<Student> lists = null;
                String kind = request.getParameter("kindOfSort");
                String type = "";
                if(kind.equals("asc")){
                    lists = studentDAO.getAllStudentSortAsc();
                    type = "desc";
                }else if(kind.equals("desc")){
                    lists = studentDAO.getAllStudentSortDesc();
                    type = "asc";
                }
                request.setAttribute("data", lists);
                request.setAttribute("kindOfSort", type);
                request.getRequestDispatcher("/view/JSPViewStudent.jsp").forward(request, response);
            }
            else if(action.equals("sortCourse")){
                List<Course> courses = new ArrayList<>();
                String kind = request.getParameter("kindOfSort");
                String type = "";
                if(kind.equals("desc")){
                    courses = studentDAO.getAllCourseSortDesc();
                    type = "asc";                    
                }else if(kind.equals("asc")){
                    courses = studentDAO.getAllCourseSortAsc();
                    type = "desc";
                }
                request.setAttribute("data", courses);
                request.setAttribute("kindOfSort", type);
                request.getRequestDispatcher("/view/JSPViewCourse.jsp").forward(request, response);                
            }     
        }        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
    }
    
}
    

