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
		"divId":id,
		"infoMap":{
			"col":col,
			"value":value
		}
}
$.ajax({
	contentType: "application/x-www-form-urlencoded;charset=utf-8",
//	dataType:"json",
    type: "POST",
//    headers: {
//        'Accept': 'application/json',
//        'Content-Type': 'application/json'
//    },
    url:"/dcs/excel/update",
    data: _data,
    success: function(data) {
       $(e).closest("tr").find("a").html(value)
    },
    error: function (data) {
   	 	console.log(data.msg)
    }
});
}