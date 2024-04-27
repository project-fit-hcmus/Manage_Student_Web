<%-- 
    Document   : JSPViewCourse
    Created on : Apr 18, 2024, 9:37:37 PM
    Author     : User
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP View Course Page</title>
        <link rel="stylesheet" href="./css/styleCourse.css">
        <script src="./script/main.js"></script>
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
                    <input type="hidden" name="selectedPage" value="findCourse">
                    <a href="#" onclick="this.parentNode.submit(); return false;">
                        <img src="./media/search.png" alt="find" class="search-icon">
                    </a>
                    <select class="chooseType" name="criteria">
                        <option value="name">Name</option>
                        <option value="year">Year</option>
                    </select>
                </form>
                
            </div>
            <div class="col-md-6 group-btn">
                <form class="btn btnSOY" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="student_course" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Student Of Year</a>
                </form>
                <a href="#" class="btn btnCourse">Course</a>
                <form class="btn btnStudent" action="./ViewStudentServlet" method="post">
                    <input type="hidden" name="selectedPage" value="student" />
                    <a href="#" class="col-md-4" onclick="this.parentNode.submit(); return false;">Student</a>
                </form>
            </div>
        </div>
    </div>
    <div class="container-fluid title-content">
        <div class="col-md-6 title">
            <h1><strong>Course</strong></h1>
            <p>${data.size()} Courses</p>
        </div>
        <form class="col-md-6" action="./ViewStudentServlet" method="post">
            <input type="hidden" name="selectedPage" value="addCourse" />
            <a href="#" onclick="this.parentNode.submit(); return false;">
                <img src="./media/add.png" alt="add button" class="btnAdd">
            </a>
        </form>

    </div>
    <hr>
    <!--Hiển thị bảng danh sách dữ liệu-->
    
    <div class="container table-sample">
        <main class="table">
            <table class="table_body" id="myCourseTable">
                <thead>
                    <tr>
                        <th>ON</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>LECTURE</th>
                        <th>YEAR</th>
                        <th>NOTES</th>
                        <th>SORT</th>
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
                        <td style="display:ruby;">
                            <span>
                                <form action="./updateDataServlet" method="post">
                                    <input type="hidden" name="type" value="delete-course">
                                    <input type="hidden" name="id" value="${item.getID()}">
                                    <button class="delete-icon" type="submit" >
                                        <img src="./media/trash.png" alt="trash-icon">
                                    </button>
                                </form>
                               
                                <!--chưa xử lý : vì người dùng chỉnh sửa mộc lúc nhiều nội dung 
                                nên khi người dùng chọn chỉnh sửa tức là xóa đi nội dung hàng đó 
                                trong database và thêm mới một hàng với nội dung mới vào databse-->
<!--                                <button class="edit-icon" type="submit" formaction="" method="post" onclick="enableEdit(this)">
                                    <img src="./media/edit.png" alt="edit-icon">
                                </button>-->
                                
                                <!--<form >-->
<!--                                    <input type="hidden" name="type" value="edit-course">
                                    <input type="hidden" name="id" value="${item.getID()}">  id là giá trị không cho phép chính sửa 
                                    các thuộc tính của course sau khi người dùng chỉnh sửa
                                    <input type="hidden" name="new-name" value="">
                                    <input type="hidden" name="new-lecture" value="">
                                    <input type="hidden" name="new-year" value="">
                                    <input type="hidden" name="new-notes" value="">-->

                                    <button class="edit-icon" type="submit" onclick="enableEdit(this);" >
                                        <img src="./media/edit.png" alt="edit-icon">
                                    </button>
                                    
                                <!--</form>-->
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
