//xử lý sự kiện nhấn vào row 
document.addEventListener('DOMContentLoaded', function() {
    // lấy tất cả các hàng trong bảng 
    var rows = document.querySelectorAll('#myCourseTable tr');
    //lặp qua từng hàng xử lý thao tác click 
    rows.forEach(function(row){
        var buttons = row.querySelectorAll('button');
        var isButtonClick = false;
        buttons.forEach(function(button){
                isButtonClick=true;
        });
        
        //CLICK ON SINGLE COURSE
        row.addEventListener('click',function(){
        if(!isButtonClick){
            //lấy các thông tin trong hàng đó 
            var tds = row.querySelectorAll('td');
            var IDValue = tds[1].textContent;
            var NameValue = tds[2].textContent;
            var type = "singleCourse";
            var url = "ViewStudentServlet?idCourse=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
            window.location.href = url;
        }
        isButtonClick=false;
        });   // END CLICK ON SINGLE COURSE
    });
});

// in alert ra màn hình 
function showAlert(errorMess){
    alert(errorMess);
}
//xử lý sự kiện nhấn vào nút edit 

function enableEdit(button){
    var row = button.parentNode.parentNode; // lấy ra row là cha của button 
    
    // lấy các giá trị trong hàng 
    var idCell = row.cells[1];
    var nameCell = row.cells[2];
    var birthCell = row.cells[3];
    var addressCell =  row.cells[4];
    var notesCell = row.cells[5];
    
    var idValue = idCell.innerText;
    var nameValue = nameCell.innerText;
    var birthValue = birthCell.innerText;
    var addressValue = addressCell.innerText;
    var notesValue = notesCell.innerText;
    Console.log(idValue);
    
//    idCell.innerHTML='<input type="text" value="' + idValue + '">';
    nameCell.innerHTML=`<input type="text" value="` + encodeURIComponent(nameValue) + `">`;
    birthCell.innerHTML=`<input type="text" value="` + encodeURIComponent(birthValue) + `">`;
    addressCell.innerHTML=`<input type="text" value="` + encodeURIComponent(addressValue) + `">`;
    notesCell.innerHTML=`<input type="text" value="` + encodeURIComponent(notesValue) + `">`;
    
    button.addEventListener('click',function(){
       saveChanges(button,nameCell,birthCell,addressCell,notesCell); 
    });
//    button.onclick = function(){
//        saveChanges(button, nameCell,birthCell,addressCell,notesCell);
//    };

    
}


function saveChanges(button, nameCell, birthCell, addressCell, notesCell){
    
    var newName = nameCell.querySelector('input').value;
    var newBirth = birthCell.querySelector('input').value;
    var newAddress = addressCell.querySelector('input').value;
    var newNotes = notesCell.querySelector('iput').value;
    
    // gửi yêu cầu tới servlet để câp nhập dữ liệu(chỉ cần cập nhật trong database, không cần điều hướng trang 
    //    [handle here ... ]
    
    // cập nhật lại giao diện 
    button.onclick = function(){
        enableEdit(button);
    };
    
}

function redirectToSingleCourseServlet(button ){
    //lấy data để request(ở đây chỉ cần ID course
    var row = button.parentNode.parentNode;
    var IDCell = row.cell[1];
    var IDValue = IDCell.innerText();
    
    
    ajax({
       type: POST,
       url:"ViewStudentServlet",
       data:{selectedPage: "singleCourse", value: IDValue}
              
    });
    
}