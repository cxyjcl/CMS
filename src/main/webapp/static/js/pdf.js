$(function (){
    $("[data-toggle='popover']").popover({html : true });
});
$("#download").click(function () {
	var code =  $(this).parent().parent().attr("id");
	var id =  $(this).parent().attr("id");
	window.open("/dcs/excel/word/download?code="+code+"&id="+id);
})