<%-- 
    Document   : JSPSingleCourse
    Created on : Apr 24, 2024, 12:21:49 AM
    Author     : User
--%>
<%@ page import="java.util.List" %>
<%@ page import="com.fasterxml.jackson.databind.ObjectMapper" %>
<%@ page import="com.fasterxml.jackson.core.type.TypeReference" %>
<%@ page import="entity.Student" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="./css/styleSingleCourse.css">
        <title>JSP Single Course Page</title>
    </head>
    <body>
        
        <script>
            var mess = "${addStatus}";
            if(mess === "success!!" || mess === "error!!"){
                alert(mess);
            }
        </script>

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
                <select class="chooseType">
                    <option value="option1">Name</option>
                    <option value="option2">Year</option>
                  </select>
            </div>
            <div class="col-md-6 group-btn">
                <form class="btn btnSOY" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="student_course" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Student Of Year</a>
                </form>
                
                <form class="btn btnCourse" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="course" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;" style="color: white">Course</a>
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
            <h1><strong style="font-size:35px">${nameCourse}</strong></h1>
            <p style="font-size: 18px;margin-top: 27px;">${data.size()} Students</p>
        </div>
        <form class="col-md-6" action="./ViewStudentServlet" method="post">
          <input type="hidden" name="selectedPage" value="addStudentToCourse" />
          <input typ="hidden" name="idCourse" value="${idCourse}">
          <a href="#" onclick="this.parentNode.submit(); return false;">
            <img src="./media/add.png" alt="add button" class="btnAdd">
        </a>
        </form>

    </div>
    <hr>

    <!--parse table data--> 
    <div class="container table-sample">
        <main class="table">
            <table class="table_body">
                <thead>
                    <tr>
                        <th>ON</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BIRTHDAY</th>
                        <th>ADDRESS</th>
                        <th>NOTES</th>
                        <th>SORT</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${data}" varStatus="loop">
                   <tr>
                       <td>${loop.index + 1}</td>
                        <td>${item.getID()}</td>
                        <td>${item.getNAME()}</td>
                        <td>${item.getBIRTH()}</td>
                        <td>${item.getADDRESS()}</td>
                        <td>${item.getNOTES()}</td>
                        <td style="display:ruby;">
                            <span>
                                <form action="./updateDataServlet" method="post">
                                    <input type="hidden" name="type" value="delete-student-in-course">
                                    <input type="hidden" name="id-student" value="${item.getID()}">
                                    <input type="hidden" name="id-course" value="${idCourse}">
                                    <button class="delete-icon" type="submit" >
                                        <img src="./media/trash.png" alt="trash-icon">
                                    </button>
                                </form>
                            </span>
                        </td>
                    </tr>
                     </c:forEach>

                </tbody>
            </table>
   
    </body>
</html>
