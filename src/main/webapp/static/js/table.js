$("#all").click(function() {
    var box = $(":checked").size();
    if(box<10)
        $(":checkbox").prop("checked",'true');
    else{
        $(":checkbox").removeAttr("checked",'false');
    }
});
$("#delete").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked){
        	var id = $(box[i]).parent().parent().attr("id");
        	console.log(id);
		    $.ajax({
		        url: "/dcs/excel/delete_list",
		        type: "POST",
		        contentType: "application/json",
		        dataType: "json",
		        data: id,
		        success: function (data) {
		             $(box[i]).parent().parent().remove();
		             alert(data.msg);
		             window.location.reload();
		        },
		       error: function (data) {
		            alert(data.msg);
		       }
		    });
        }
    };
});
function file(e){
	 var file = new FormData();   
	 file.append("file",document.getElementById('uploadFile').files[0]);
	 var code =  $(e).parent().parent().parent().attr("id");
	 var level = $(e).parent().attr("id");
	 console.log(code);
	 file.append("code",code);
	 file.append("level",level);
	 if (document.getElementById('uploadFile').files[0] != null && document.getElementById('uploadFile').files[0] != "") {
	    var filepath=$("#uploadFile").val();
	    var extStart=filepath.lastIndexOf(".");
	    var ext=filepath.substring(extStart,filepath.length).toUpperCase();
	    if(ext!=".XLS"&&ext!=".DOC"){
	       alert("文件仅限于XLS与DOC");
	    }else{
	       $.ajax({
	          type:"POST",
	          contentType:false,
	          processData:false,
	          url:"/dcs/excel/add",
	          data:file,
	          success:function(data){
	        	  alert("上传成功！");
	        	  window.location.reload();
	          },
	       	  error:function(data){
	       		alert(data.msg);
	       	  }
	       });
	    }
	}
}
$("#download").click(function () {
	var code =  $(this).parent().parent().attr("id");
    window.open("/dcs/excel/model/download?code="+code);
});
$("#search").click(function(){
	var code =  $(this).closest(".clearfix").attr("id");
	var level =  $(this).parent().attr("class");
  	var value = $("#search-value").val();
  	location.href="/dcs/excel/find_list?code="+code+"&level="+level+"&value="+value;
});