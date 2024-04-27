<%-- 
    Document   : JSPAddStudentToCourse
    Created on : Apr 26, 2024, 12:10:53 AM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Add Student To Course Page</title>
        <link rel="stylesheet" href="./css/styleAddOveral.css">
    </head>
    <body>
        <div class ="container overal">
            <div class="col-md-6 title">
                <h1>WELCOME BACK <br> ADD STUDENT IN COURSE SCREEN </h1>
                <p><em>If you want to add a new student to this course . <br> Please enter the information next to.</em></p>
            </div>
            <div class="col-md-6 content">
                <form class="container add-dialog" action="./updateDataServlet" method="post" accept-charset="UTF-8">
                    <input type="hidden" name="type" value="add-student-to-course">
                    <input type="hidden" name="idCourse" value="${idCourse}">

                    <!--<label for="id">ID Student: </label>-->
                    <input type="text" id="id" name="id" required maxlength="8" placeholder="ID"><br>

                    <!--<label for="grade">Grade: </label>-->
                    <input type="float" id="grade" name="grade" required placeholder="Grade"><br>

                    <button type="submit" name="button" value="cancel">Cancel</button>
                    <button type="submit" name="button" value="confirm">Confirm</button>

               </form>
            </div>
        </div>
        
        
    </body>
</html>
