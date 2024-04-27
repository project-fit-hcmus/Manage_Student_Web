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
    
    
    // CLICK ON SINGLE STUDENT 
    var STrows = document.querySelectorAll('#myStudentTable tr');
    //lặp qua từng hàng xử lý thao tác click 
    STrows.forEach(function(STrow){
        var buttons = STrow.querySelectorAll('button');
        var isButtonClick = false;
        buttons.forEach(function(button){
                isButtonClick=true;
        });
        
        //CLICK ON SINGLE COURSE
        STrow.addEventListener('click',function(){
        if(!isButtonClick){
            //lấy các thông tin trong hàng đó 
            var tds = STrow.querySelectorAll('td');
            var IDValue = tds[1].textContent;
            var NameValue = tds[2].textContent;
            var type = "singleStudent";
            var url = "ViewStudentServlet?idStudent=" + encodeURIComponent(IDValue) + "&selectedPage=" + encodeURIComponent(type);
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

// ERROr METHOD 
//function SortTable(){
//    var table = document.getElementById("myStudentTable");
//    var rows = Array.from(table.getElementByTagName("tr"));
//    // lấy giá trị trạng thái sắp xếp hiện tại từ thuộc tính data-sort 
//    var currentSort = table.getAttribute("data-sort");
//    //đảo ngược giá trị trạng thái sắp xếp 
//    var newSort = currentSort === "asc" ? "desc" : "asc";
//    // sắp xếp hàng dữ liệu theo tên 
//    rows.sort(function(rowA, rowB){
//        var nameA = rowA.getElementsByTagName("td")[2].textContent;
//        var nameB = rowB.getElementsByTagName("td")[2].textContent;
//        System.out.println(nameA);
//        System.out.println(nameB);
//        if(newSort === "asc"){
//            return nameA.localeCompare(nameB);
//        }
//        else {
//            return nameB.localeCompare(nameA);
//        }
//    }) ;
//    //xóa các hàng hiện tại trong bảng 
//    while(table.rows.length > 1){
//        table.deleteRow(1);
//    }
//    // thêm các hàng đã sắp xếp vào bảng 
//    rows.forEach(function(row){
//       table.appendChild(row); 
//    });
//    //cập nhật giá trị trạng thái sắp xếp mới vào thuộc tính data-sort 
//    table.setAttribute("data-sort",newSort);
//}

function SortTable(){
    let table, i, x, y;
    table = document.getElementById("myStudentTable");
    let Switching = true;
    
    while(Switching){
        Switching = false;
        let rows = table.rows;
        
        for ( i = 1; i < (rows.length - 1); i++){
            var Switch = false;
            x = rows[i].getElementsByTagName("td")[2];
            x = rows[i+1].getElementsByTagName("td")[2];
            
            if(x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()){
                Switch = true;
                break;
            }
        }
        if(Switch){
            rows[i].parentNode.insertBefore(rows[i+1],rows[i]);
            Switching = true;
        }
    }
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