$(function (){
    $("[data-toggle='popover']").popover({html : true });
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
$("#print").click(function(){
	
})