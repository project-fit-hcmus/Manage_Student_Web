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
//        System.out.println(action);
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
//                System.out.println(list.get(0).getNAME());
//                System.out.println(list.get(1).getNAME());
                request.setAttribute("nameStudent", studentDAO.getStudentName(idStudent));     
                request.getRequestDispatcher("/view/JSPSingleStudent.jsp").forward(request, response);
            }
            else if(action.equals("findStudent")){
                String keyword = request.getParameter("keyword");
                request.setAttribute("data", studentDAO.findStudentByName(keyword));
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
                request.getRequestDispatcher("/view/JSPViewCourse.jsp").forward(request, response);
            }
     
        }
 
        
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
    }
    // sắp xếp tăng dần theo tên 
    public List<Student> SortAToZ(List<Student> input){
        List<Student> studentList = new ArrayList<>(input);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s1.getNAME().compareTo(s2.getNAME());
            }
        });
        return studentList;
    }
    // sắp xếp giảm dần theo tên 
    public List<Student> SortZToA(List<Student> input){
        List<Student> studentList = new ArrayList<>(input);
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return s2.getNAME().compareTo(s1.getNAME());
            }
        });
        return studentList;
    }
    // kiểm tra danh sách đã được sắp xếp tăng dần hay chưa
    public static boolean isSortedAscending(List<Student> studentList) {
        for (int i = 0; i < studentList.size() - 1; i++) {
            String currentName = studentList.get(i).getNAME();
            String nextName = studentList.get(i + 1).getNAME();
            if (currentName.compareTo(nextName) > 0) {
                return false;
            }
        }
        return true;
    }
    // kiểm tra danh sách đã được sắp xếp giảm dần hay chưa
    public static boolean isSortedDescending(List<Student> studentList) {
        for (int i = 0; i < studentList.size() - 1; i++) {
            String currentName = studentList.get(i).getNAME();
            String nextName = studentList.get(i + 1).getNAME();
            if (currentName.compareTo(nextName) < 0) {
                return false;
            }
        }
        return true;
    }                         

}
    


//some problems: 
//1. hiện chữ tiếng việt trong bảng data(tên, địa chỉ, note)
//2. Hiện ngày tháng năm sinh dạng yyyy/mm/dd

// giả sử 0 tức là k sắp xếp 
// 1 là sắp xếp tăng dần theo tên 
// -1 là sắp xếp giảm dần theo tên