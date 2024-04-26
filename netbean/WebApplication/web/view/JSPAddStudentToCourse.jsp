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
    </head>
    <body>
        <<h1><strong>Add New Student To Couse</strong></h1>
        <form class="container add-dialog" action="./updateDataServlet" method="post" accept-charset="UTF-8">
             <input type="hidden" name="type" value="add-student-to-course">
             <input type="hidden" name="idCourse" value="${idCourse}">
            
            <label for="id">ID Student: </label>
            <input type="text" id="id" name="id" required maxlength="8"><br>

            <label for="grade">Grade: </label>
            <input type="float" id="grade" name="grade" required><br>

            <button type="submit" name="button" value="cancel">Cancel</button>
            <button type="submit" name="button" value="confirm">Confirm</button>
            
        </form>
    </body>
</html>
