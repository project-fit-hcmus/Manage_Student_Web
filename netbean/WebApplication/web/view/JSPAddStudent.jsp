<%-- 
    Document   : JSPAddStudent
    Created on : Apr 25, 2024, 4:30:11 PM
    Author     : User
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Add Student Page</title>
        <link rel="stylesheet" href="./css/styleAddOveral.css">
    </head>
    <body>
        <div class ="container overal">
            <div class="col-md-6 title">
                <h1>WELCOME BACK <br> ADD STUDENT SCREEN </h1>
                <p><em>If you want to add a new student to your list. <br> Please enter the information next to.</em></p>
            </div>
            <div class="col-md-6 content">
                
                <form class="container add-dialog" action="./updateDataServlet" method="post" accept-charset="UTF-8">
                     <input type="hidden" name="type" value="add-student">

                    <input type="text" id="id" name="id" required maxlength="8" placeholder="ID"><br>

                    <input type="text" id="name" name="name" required maxlength="50" accept-charset="UTF-8" placeholder="Name"><br>

                    <input type="date" id="birth" name="birth" required style="color: gray"><br>

                    <input type="text" id="address" name="address" required maxlength="50" accept-charset="UTF-8" placeholder="Address"><br>

                    <input type="text" id="notes" name="notes" maxlength="100" accept-charset="UTF-8" placeholder="Notes"><br>

                    <button type="submit" name="button" value="cancel">Cancel</button>
                    <button type="submit" name="button" value="confirm">Confirm</button>


                </form>
            </div>
        </div>

        
    </body>
</html>
