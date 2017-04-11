$(function (){
    $("[data-toggle='popover']").popover({html : true });
});
$("#delete").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked){
        	var id = $(box[i]).parent().parent().attr("id");
        	var code =$(box[i]).closest("table").attr("id");
        	console.log(code)
        	var _data = {
        			"code":code,
        			"id":id
        	}
		    $.ajax({
		        url: "http://localhost:8080/dcs/excel/delete",
		        type: "POST",
		        contentType: "application/json",
		        dataType: "json",
		        data: JSON.stringify(_data),
		        success: function (data) {
		             $(box[i]).parent().parent().remove();
		             alert(data.msg);
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
