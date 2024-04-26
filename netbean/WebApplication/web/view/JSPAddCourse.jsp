<%-- 
    Document   : JSPAddCourse
    Created on : Apr 25, 2024, 10:06:06 PM
    Author     : User
--%>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Add Course Page</title>
    </head>
    <body>
        <h1><strong>Add New Course</strong></h1>
        <form class="container add-dialog" action="./updateDataServlet" method="post" accept-charset="UTF-8">
             <input type="hidden" name="type" value="add-course">
            
            <label for="id">ID: </label>
            <input type="text" id="id" name="id" required maxlength="8"><br>

            <label for="name">Name: </label>
            <input type="text" id="name" name="name" required maxlength="50" accept-charset="UTF-8"><br>

            <label for="lecture">Lecture: </label>
            <input type="text" id="lecture" name="lecture" required maxlength="50" accept-charset="UTF-8"><br>
            
            <label for="year">Year: </label>
            <input type="int" id="year" name="year" required><br>
            
            <label for="notes">Notes: </label>
            <input type="text" id="notes" name="notes" maxlength="100" accept-charset="UTF-8"><br>

            <button type="submit" name="button" value="cancel">Cancel</button>
            <button type="submit" name="button" value="confirm">Confirm</button>
    
            
        </form>
    </body>
</html>
