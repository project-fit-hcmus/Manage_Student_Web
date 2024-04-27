<%-- 
    Document   : JSPViewStudent
    Created on : Apr 18, 2024, 9:36:15 PM
    Author     : User
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP View Student Page</title>
        <link rel="stylesheet" href="./css/styleStudent.css">
        <script src="./script/main.js"> </script>
    </head>
    <body>
        
        <div class="container-fluid header">
        <div class="row">
            <div class="col-md-6 group-search">
                <form class="col-md-6 title" action="./ViewStudentServlet" method="post" style="padding-top:15px">
                    <input type="hidden" name="selectedPage" value="home" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;" style="text-decoration: none;"><strong>List Student</strong></a>
                </form>  
                <form class="col-md-4" action="./ViewStudentServlet" method="post" style="display:flex">
                    <input type="search" class="search" placeholder="  Entey your keyword..." name="keyword">
                    <input type="hidden" name="selectedPage" value="findStudent">
                    <a href="#" onclick="this.parentNode.submit(); return false;">
                        <img src="./media/search.png" alt="find" class="search-icon">
                    </a>                    
                </form>

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
     
                <a href="#" class="btn btnStudent">Student</a>     
            </div>
        </div>
    </div>
    <div class="container-fluid title-content">
        <div class="col-md-6 title">
            <h1><strong>Student</strong></h1>
            <p>${data.size()} Student</p>
        </div>
        <form class="col-md-6" action="./ViewStudentServlet" method="post">
          <input type="hidden" name="selectedPage" value="addStudent" />
          <a href="#" onclick="this.parentNode.submit(); return false;">
            <img src="./media/add.png" alt="add button" class="btnAdd">
          </a>
        </form>
        
    </div>
    <hr>
    <!--Hiển thị bảng danh sách dữ liệu-->
    <div class="container table-sample">
        <main class="table">
            <table class="table_body" id="myStudentTable" >
                <thead>
                    <tr>
                        <th>ON</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BIRTHDAY</th>
                        <th>ADDRESS</th>
                        <th>NOTES</th>
                        <th>
<!--                            <form action="./ViewStudentServlet" method="post">
                                <input type="hidden" name="selectedPage" value="sortStudent" />
                                <input type="hidden" name="list" value="${data}">-->
                                <button  onclick="SortTable();">
                                  <img src="./media/ascending.png" alt="sort button" class="btnSort" ">
                                </button>
                            <!--</form>-->
                            <script>
                                document.getElementById("myStudentTable").setAttribute("data-sort", "none");
                            </script>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    
                   <c:forEach var="item" items="${data}" varStatus="loop">
                     
                    <tr>
                        <td><strong>${loop.index + 1}</strong></td>
                        <td>${item.getID()}</td>
                        <td>${item.getNAME()}</td>
                        <td>${item.getBIRTH()}</td>
                        <td>${item.getADDRESS()}</td>
                        <td>${item.getNOTES()}</td>
                        <td style="display:ruby;">
                            <span>
                                <form action="./updateDataServlet" method="post">
                                    <input type="hidden" name="type" value="delete-student">
                                    <input type="hidden" name="id" value="${item.getID()}">
                                    <button class="delete-icon" type="submit" >
                                        <img src="./media/trash.png" alt="trash-icon">
                                    </button>
                                </form>
                                    <!--chưa xử lý-->
                                <button class="edit-icon" type="submit" formaction="" method="post">
                                    <img src="./media/edit.png" alt="edit-icon">
                                </button>
                            </span>
                        </td>
                    </tr>
                    
                     </c:forEach>

                </tbody>
            </table>

        </main>
    </div>
    
    </body>

</html>
<!-- create table instruction: https://www.youtube.com/watch?v=Ay8BXbAmEYM -->
