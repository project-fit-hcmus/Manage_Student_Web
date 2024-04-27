//xử lý sự kiện nhấn vào row 
//document.addEventListener('DOMContentLoaded', function() {
//    // lấy tất cả các hàng trong bảng       --> (xung đột với chức năng edit course -- comment để chạy chức năng edit)
//    var rows = document.querySelectorAll('#myCourseTable tr');
//    //lặp qua từng hàng xử lý thao tác click 
//    rows.forEach(function(row){
//        var buttons = row.querySelectorAll('button');
//        var isButtonClick = false;
//        buttons.forEach(function(button){
//                isButtonClick=true;
//        });
//        
//        //CLICK ON SINGLE COURSE
//        row.addEventListener('click',function(){
//        if(!isButtonClick){
//            //lấy các thông tin trong hàng đó 
//            var tds = row.querySelectorAll('td');
//            var IDValue = tds[1].textContent;
//            var NameValue = tds[2].textContent;
//            var type = "singleCourse";
//            var url = "ViewStudentServlet?idCourse=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
//            window.location.href = url;
//        }
//        isButtonClick=false;
//        });   // END CLICK ON SINGLE COURSE
//    });
//    
    
    // CLICK ON SINGLE STUDENT (xung đột với chức năng edit - comment lại để chạy chức năng edit)
//    var STrows = document.querySelectorAll('#myStudentTable tr');
//    //lặp qua từng hàng xử lý thao tác click 
//    STrows.forEach(function(STrow){
//        var buttons = STrow.querySelectorAll('button');
//        var isButtonClick = false;
//        buttons.forEach(function(button){
//                isButtonClick=true;
//        });
//        
//        //CLICK ON SINGLE COURSE
//        STrow.addEventListener('click',function(){
//        if(!isButtonClick){
//            //lấy các thông tin trong hàng đó 
//            var tds = STrow.querySelectorAll('td');
//            var IDValue = tds[1].textContent;
//            var NameValue = tds[2].textContent;
//            var type = "singleStudent";
//            var url = "ViewStudentServlet?idStudent=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
//            window.location.href = url;
//        }
//        isButtonClick=false;
//        });   // END CLICK ON SINGLE COURSE
//    });
//});

// in alert ra màn hình 
function showAlert(errorMess){
    alert(errorMess);
}


