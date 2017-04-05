$("#all").click(function() {
    var box = $(":checked").size();
    if(box<10)
        $(":checkbox").prop("checked",'true');
    else{
        $(":checkbox").removeAttr("checked",'false');
    }
})
$("#delete").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked){
        	var id = $(box[i]).parent().parent().attr("id");
        	console.log(id);
		    $.ajax({
		        url: "http://localhost:8080/dcs/excel/delete_list",
		        type: "POST",
		        contentType: "application/json",
		        dataType: "json",
		        data: id,
		        success: function (data) {
		             $(box[i]).parent().parent().remove();
		        },
		       error: function (data) {
		            alert(data.msg)
		       }
		    });
        }
    };
})
function file(e){
	 var file = new FormData();   
	 file.append("file",document.getElementById('uploadFile').files[0]);
	 var code =  $(e).parent().parent().attr("id");
	 file.append("code",code);
	 if (document.getElementById('uploadFile').files[0] != null && document.getElementById('uploadFile').files[0] != "") {
	    var filepath=$("#uploadFile").val();
	    var extStart=filepath.lastIndexOf(".");
	    var ext=filepath.substring(extStart,filepath.length).toUpperCase();
	    if(ext!=".XLS"){
	       alert("文件仅限于XLS");
	    }else{
	       $.ajax({
	          type:"POST",
	          contentType:false,
	          processData:false,
	          url:"/dcs/excel/add",
	          data:file,
	          success:function(data){
	          
	          }
	       });
	    }
	}
}
$("#download").click(function () {
	var code =  $(this).parent().parent().attr("id");
    window.open("/dcs/excel/model/download?code="+code);
})