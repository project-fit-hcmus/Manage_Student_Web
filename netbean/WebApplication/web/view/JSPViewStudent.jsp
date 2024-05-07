<%-- 
    Document   : JSPViewStudent
    Created on : Apr 18, 2024, 9:36:15 PM
    Author     : User
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP View Student Page</title>
        <link rel="stylesheet" href="./css/styleStudent.css">
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
                        <th>INDEX</th>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BIRTHDAY</th>
                        <th>ADDRESS</th>
                        <th>NOTES</th>
                        <th>
                            <form action="./ViewStudentServlet" method="post">
                                <input type="hidden" name="selectedPage" value="sortStudent" />
                                <input type="hidden" name="kindOfSort" value="${kindOfSort}"/>
                                <button class="sort-icon">
                                    <img src="./media/ascending.png" alt="sort button" class="btnSort" name="KindOfSort" value="desc">
                                </button>
                            </form>
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
                                    <button class="delete-icon" type="submit" >Delete</button>
                                </form>
                                
                                <span class="edit-group">
                                    <button class="edit-icon" type="submit" formaction="" method="post">Edit </button>
                                </span>
                            </span>
                        </td>
                    </tr>
                    
                     </c:forEach>

                </tbody>
            </table>

        </main>
    </div>
    <script contentType="text/javascript; charset=UTF-8" pageEncoding="UTF-8">           
    var isEditing = false;
    $(document).ready(function (){
        // xử lý button edit
        var originName;
//        var originBirth;
        var originAddr;
        var originNote;
        $('#myStudentTable').on('click','.edit-icon',function(){
//            alert("click on edit button");
            isEditing = true;

            var row = $(this).closest('tr');
            var name = row.find('td').eq(2).text();
//            var birthday = row.find('td').eq(3).text();
            var address = row.find('td').eq(4).text();
            var notes = row.find('td').eq(5).text();
            originName = name;
//            originBirth = birthday;
            originAddr = address;
            originNote = notes;

            row.find('td').eq(2).html('<input type="text" name="name" value="' + name + '" class="edit-name" placeholder="' + name + '" accept-charset="UTF-8">');
//            row.find('td').eq(3).html('<input type="date" class="edit-birth" name="birth" value="' + birthday + '" placeholder="dd/mm/yyyy">');
            row.find('td').eq(4).html('<input type="text" class="edit-address" name="address" value="' + address + '" placeholder="enter-address" accept-charset="UTF-8">');
            row.find('td').eq(5).html('<input type="text" class="edit-notes" name="notes" value="' + notes + '" placeholder="enter-notes" accept-charset="UTF-8">');
            row.find('.edit-group').html('<button type="submit" name="button" value="save" class="btn-save">Save</button> <button type="submit" name="button" value="cancel" class="btn-cancel">Cancel</button>')
        });
        // xử lý button cancel (không lưu) 
        $('#myStudentTable').on('click', '.btn-cancel', function() {
            isEditing = false;
            var row = $(this).closest('tr');
            row.find('td').eq(2).html(originName);
//            row.find('td').eq(3).html(originBirth);
            row.find('td').eq(4).html(originAddr);
            row.find('td').eq(5).html(originNote);
            row.find('.edit-group').html('<button class="edit-icon" type="submit">Edit </button>');
        });
        
        // xử lý button save (lưu vào database)
        $('#myStudentTable').on('click', '.btn-save', function() {
            isEditing = false;
            var row = $(this).closest('tr');
            var id = row.find('td').eq(1).text();
            var name = row.find('td').eq(2).find('input').val();
//            var birthday = row.find('td').eq(3).find('input').val();
            var address = row.find('td').eq(4).find('input').val();
            var notes = row.find('td').eq(5).find('input').val();

            row.find('td').eq(2).html(name);
//            row.find('td').eq(3).html(birthday);
            row.find('td').eq(4).html(address);
            row.find('td').eq(5).html(notes);
            row.find('.edit-group').html('<button class="edit-icon" type="submit" >Edit </button>');
            
            // chuyển tới servlet để lưu data(phần này phải sử dụng ajax để tránh xung đột giữa các button
            $.ajax({
                url: "updateDataServlet",
                method: "POST",
                contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
                data: $.param({
                    idStudent: id,
                    newName: name,
                    newNotes: notes,
                    newAddr: address,
//                    newBirthday: birthday,
                    type: "updateStudent"
                }),
                success: function(response) {
                    // Cập nhật dữ liệu trên trang web
                    row.find('td').eq(2).html(name);
//                    row.find('td').eq(3).html(birthday);
                    row.find('td').eq(4).html(address);
                    row.find('td').eq(5).html(notes);
                    row.find('.edit-group').html('<button class="edit-icon" type="submit" >Edit </button>');
                },
                error: function(xhr, status, error) {
                    console.log(error);
                }
            });
            
        });
        //XỬ LÝ SỰ KIỆN CHỌN VÀO 1 HÀNG     
        $('#myStudentTable').on('click','tr',function(){
            if($(event.target).is('button')){
                event.stopPropagation();        // ngăn chặn sự kiện click lan ra các phần tử con
                return;     // không thực hiện xử lý gì nếu người dùng chọn vào nút 
            }
            if(isEditing){
                //to do nothing
                return;
            }
            
            var tds = $(this).find('td');
            var IDValue = tds.eq(1).text();
            var NameValue = tds.eq(2).text();
            var type = "singleStudent";
            var url = "ViewStudentServlet?idStudent=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
            window.location.href=url;
        });
    });                 
    </script>                                
    </body>
</html>
