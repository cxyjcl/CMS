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
$("#upload").click(function (){
    var filePath=$("#excel").val();
    if(filePath.indexOf("xls")!=-1){
    	var url = $("#upload").parent();
        $("#excel-form").attr("action", "/dcs/excel/add?"+url);
        $("#excel-form").submit();
    }else{
        alert("您未上传文件，或者您上传文件类型非xls！");
    }
})