$(function (){
    $("[data-toggle='popover']").popover({html : true });
});
$("#delete").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked){
        	var id = $(box[i]).parent().parent().attr("id");
        	var code =$(box[i]).closest("table").attr("id");
        	var _data = {
        			"code":code,
        			"id":id
        	}
		    $.ajax({
		        url: "/dcs/excel/delete",
		        type: "POST",
		        contentType: "application/x-www-form-urlencoded",
		        data: _data,
		        success: function (data) {
		             $(box[i]).parent().parent().remove();
		             alert("删除成功");
		        },
		       error: function (data) {
		            alert(data.msg);
		       }
		    });
        }
    };
});
function change(e){
	var id = $(e).closest("tr").attr("id")
	var col = $(e).closest("td").attr("class")
	var value = $(e).parent().prev().find("input").val();
	var code = $(e).closest("table").attr("id");
	var _data = {
			"code":code,
			"id":id,
			"col":col,
			"value":value
	}
	$.ajax({
	    type: "POST",
	    url:"/dcs/excel/update",
	    contentType: "application/json",
	    dataType: "json",
	    data: JSON.stringify(_data),
	    success: function(data) {
	       $(e).closest("td").find("a").html(value)
	    },
	    error: function (data) {
	   	 	console.log(data.msg)
	    }
	});
}
$("#download").click(function () {
	var code =  $(this).parent().parent().attr("id");
	var id =  $(this).parent().attr("id");
    console.log(id);
	window.open("/dcs/excel/file/download?code="+code+"&id="+id);
})
function file(e){
	 var file = new FormData();   
	 var code =  $(e).closest("table").attr("id");
	 var id = $(e).closest("tr").attr("id")
	 console.log(code);
	 console.log(id);
	 file.append("code",code);
	 file.append("id",id);
	 file.append("file",document.getElementById('uploadFile').files[0]);
	 if (document.getElementById('uploadFile').files[0] != null && document.getElementById('uploadFile').files[0] != "") {
	    var filepath=$("#uploadFile").val();
	    var extStart=filepath.lastIndexOf(".");
	    var ext=filepath.substring(extStart,filepath.length).toUpperCase();
	    if(ext!=".XLS"&&ext!=".DOC"&&ext!=".JPG"){
	       alert("文件仅限于XLS与DOC和JPG");
	    }else{
	       $.ajax({
	          type:"POST",
	          contentType:false,
	          processData:false,
	          url:"/dcs/excel/extra_file",
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