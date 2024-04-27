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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
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
            <p >${data.size()} Courses</p>
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
                                    <button class="delete-icon" type="submit" >Delete   </button>
                                </form>
                                <span class="edit-group">
                                    <button class="edit-icon" type="submit" onclick="enableEdit(this);" >Edit</button>
                                </span> 
                               
                            </span>
                        </td>
                    </tr>               
                     </c:forEach>
                </tbody>
            </table>
        </main>
    </div>
    <script>
        var isEditing = false; 
        $(document).ready(function (){
        // xử lý button edit
        var originName;
        var originLecture;
        var originYear;
        var originNote;
        $('#myCourseTable').on('click','.edit-icon',function(){
            alert("click on edit button");
            isEditing = true;

        var row = $(this).closest('tr');
        var name = row.find('td').eq(2).text();
        var lecture = row.find('td').eq(3).text();
        var year = row.find('td').eq(4).text();
        var notes = row.find('td').eq(5).text();
        originName = name;
        originLecture = lecture;
        originYear = year;
        originNote = notes;

        row.find('td').eq(2).html('<input type="text" name="name" value="' + name + '" class="edit-name" placeholder="' + name + '" accept-charset="UTF-8">');
        row.find('td').eq(3).html('<input type="text" class="edit-lecture" name="lecture" value="' + lecture + '" placeholder="enter-lecture" accept-charset="UTF-8">');
        row.find('td').eq(4).html('<input type="text" class="edit-year" name="year" value="' + year + '" placeholder="enter-year" accept-charset="UTF-8">');
        row.find('td').eq(5).html('<input type="text" class="edit-notes" name="notes" value="' + notes + '" placeholder="enter-notes" accept-charset="UTF-8">');
        row.find('.edit-group').html('<button type="submit" name="button" value="save" class="btn-save">Save</button> <button type="submit" name="button" value="cancel" class="btn-cancel">Cancel</button>')
        });
        // xử lý button cancel (không lưu) 
        $('#myCourseTable').on('click', '.btn-cancel', function() {
            isEditing = false;
            var row = $(this).closest('tr');
            row.find('td').eq(2).html(originName);
            row.find('td').eq(3).html(originLecture);
            row.find('td').eq(4).html(originYear);
            row.find('td').eq(5).html(originNote);
            row.find('.edit-group').html('<button class="edit-icon" type="submit" >Edit </button>');
        });
        
        // xử lý button save (lưu vào database)
        $('#myCourseTable').on('click', '.btn-save', function() {
            isEditing = false;

            var row = $(this).closest('tr');
            var id = row.find('td').eq(1).text();
            var name = row.find('td').eq(2).find('input').val();
            var lecture = row.find('td').eq(3).find('input').val();
            var year = row.find('td').eq(4).find('input').val();
            var notes = row.find('td').eq(5).find('input').val();

            row.find('td').eq(2).html(name);
            row.find('td').eq(3).html(lecture);
            row.find('td').eq(4).html(year);
            row.find('td').eq(5).html(notes);
            row.find('.edit-group').html('<button class="edit-icon" type="submit" >Edit </button>');
            
            // chuyển tới servlet để lưu data(phần này phải sử dụng ajax để tránh xung đột giữa các button
            $.ajax({
                url: "updateDataServlet",
                method: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: $.param({
                    idCourse: id,
                    newName: name,
                    newNotes: notes,
                    newLecture: lecture,
                    newYear: year,
                    type: "updateCourse"
                }),
                success: function(response) {
                    // Cập nhật dữ liệu trên trang web
                    row.find('td').eq(2).html(name);
                    row.find('td').eq(3).html(lecture);
                    row.find('td').eq(4).html(year);
                    row.find('td').eq(5).html(notes);
                    row.find('.edit-group').html('<button class="edit-icon" type="submit" >Edit </button>');
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });
            
        });
          
        // xử lý cho sự kiện nhấn chọn 1 hàng 
        $('#myCourseTable').on('click','tr',function(){
            if ($(event.target).is('button')) {
                event.stopPropagation(); // Ngăn sự kiện click lan ra các phần tử con
                return; // Không thực hiện gì nếu người dùng nhấp vào nút
            }
            
            if(isEditing){
                //to do nothing
                return;
            } 
            var tds = $(this).find('td');
            var IDValue = tds.eq(1).text();
            var NameValue = tds.eq(2).text();
            var type = "singleCourse";
            var url = "ViewStudentServlet?idCourse=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
            window.location.href=url;
             
        });   
    });          
    </script>    
    </body>
</html>
