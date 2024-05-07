<%-- 
    Document   : JSPSingleStudent
    Created on : Apr 26, 2024, 12:03:50 PM
    Author     : User
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Single Student Page</title>
        <link rel="stylesheet" href="./css/styleSingleStudent.css">
    </head>
    <body>
        <div class="container-fluid header">
        <div class="row">
            <div class="col-md-6 group-search">
                <form class="col-md-6 title" action="./ViewStudentServlet" method="post" style="padding-top:15px">
                    <input type="hidden" name="selectedPage" value="home" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;" style="text-decoration: none;"><strong>List Student</strong></a>
                </form>  
                
                <input type="search" class="col-md-4 search" placeholder="  Entey your keyword...">
                <a href="#">
                    <img src="./media/search.png" alt="find" class="search-icon">
                </a>
            </div>
            <div class="col-md-6 group-btn">
                <form class="btn btnSOY" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="student_course" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Student Of Year</a>
                </form>
                <form class="btn btnCourse" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="course" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Course</a>
                </form>
                <form class="btn btnStudent" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="student" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Student</a>
                </form>  
            </div>
        </div>
    </div>
    <div class="container-fluid title-content">
        <div class="col-md-6 title">
            <h1><strong>${nameStudent}</strong></h1>
            <p>${data.size()} courses</p>
        </div>        
    </div>
    <hr>
    <!--Hiển thị bảng danh sách các khóa học dưới dạng bảng -->
    
    <div class="container table-sample">
        <main class="table">
            <table class="table_body" id="myCourseTable">
                <thead>
                    <tr>
                        <th>INDEX</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>LECTURE</th>
                        <th>YEAR</th>
                        <th>NOTES</th>
                        <th>GRADE</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${data}" varStatus="loop">
                        <tr>
                            <td><strong>${loop.index + 1}</strong></td>
                            <td>${item.getID()}</td>
                            <td>${item.getNAME()}</td>
                            <td>${item.getLECTURE()}</td>
                            <td>${item.getYEAR()}</td>
                            <td>${item.getNOTES()}</td>
                            <td>${item.getGRADE()}</td>
                        </tr>                    
                     </c:forEach>
                </tbody>
            </table>
    </body>
</html>
