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
        <link rel="stylesheet" href="./css/styleAddOveral.css">
    </head>
    <style>
        
    </style>
    <body>
        <div class ="container overal">
            <div class="col-md-6 title">
                <h1>WELCOME BACK <br> ADD COURSE SCREEN </h1>
                <p><em>If you want to add a new course to your list. <br> Please enter the information next to.</em></p>
            </div>
            <div class="col-md-6 content">
                <form class="container add-dialog" action="./updateDataServlet" method="post" accept-charset="UTF-8">
                    <input type="hidden" name="type" value="add-course">

                    <!--<label for="id">ID: </label>-->
                    <input type="text" id="id" name="id" required maxlength="8" placeholder="ID"><br>

                    <!--<label for="name">Name: </label>-->
                    <input type="text" id="name" name="name" required maxlength="50" accept-charset="UTF-8" placeholder="Name"><br>

                    <!--<label for="lecture">Lecture: </label>-->
                    <input type="text" id="lecture" name="lecture" required maxlength="50" accept-charset="UTF-8" placeholder="Lecture"><br>

                    <!--<label for="year">Year: </label>-->
                    <input type="int" id="year" name="year" required placeholder="Year"><br>

                    <!--<label for="notes">Notes: </label>-->
                    <input type="text" id="notes" name="notes" maxlength="100" accept-charset="UTF-8" placeholder="Notes"><br>

                    <button type="submit" name="button" value="cancel">Cancel</button>
                    <button type="submit" name="button" value="confirm">Confirm</button>
    
            
                </form>
            </div> 
            
        </div>
        
    </body>
</html>
