var id;
$("#confirm").click(function (){
	var email=$("#email").val();
	var login_id=$("#login-id").val();
    var real_name=$("#real-name").val();
    var password=$("#password").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var mailcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var level = $("#select-id").find("option:selected").text();
    if(check()){
	    if(login_id==""){
	        $("#error-message").html("用户名不得为空");
	    }
	    else if(real_name==""){
	        $("#error-message").html("真实姓名不得为空");
	    }
	    else if(email==""){
	        $("#error-message").html("邮箱不得为空");
	    }
	    else if(strcheck.test(login_id)){
	        $("#error-message").html("用户名不能包含空格\\<>等非法字符");
	    }
	    else if(strcheck.test(real_name)){
	        $("#error-message").html("真实名不能包含空格\\<>等非法字符");
	    }
	    else if(strcheck.test(password)){
	        $("#error-message").html("密码不能包含空格\\<>等非法字符");
	    }
	    else if(!mailcheck.test(email)){
	        $("#error-message").html("邮箱格式不正确");
	    }
	    else
	    {
	        var _data = {
	        	"email":email,
	        	"loginName":login_id,
	        	"realName":real_name,
	        	"password":password,
	        	"level":level
	        };
	        $.ajax({
	            url: "http://localhost:8080/dcs/add/user",
	            type: "POST",
	            contentType: "application/json",
	            dataType: "json",
	            data: JSON.stringify(_data),
	            success: function (data) {
	            	$("#error-message").html(data.msg);
	            },
	            error: function (data) {
	                $("#error-message").html(data.msg)
	            }
	        });
	    }
    }
})
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
		    $.ajax({
		        url: "http://localhost:8080/dcs/delete/user",
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
$(".toggle-button").click(function(){
	 id = $(this).closest("tr").attr("id");
})
$("#change-buton").click(function(){
	var email=$("#email").val();
	var login_id=$("#login-id").val();
    var real_name=$("#real_name").val();
    var password=$("#password").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var mailcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var level = $("#select-id").find("option:selected").text();
    var status = $("#status").find("option:selected").text();
    if(check()){
	    if(email==""){
	    	email=null;
	    } else if(!mailcheck.test(email)){
	        $("#error-message").html("邮箱格式不正确");
	    }
	    if(login_id==""){
	    	login_id=null;
	    }
	    if(real_name==""){
	    	real_name=null;
	    }
	    if(password==""){
	    	password=null;
	    }
	    if(strcheck.test(login_id)){
	        $("#error-message").html("用户名不能包含空格\\<>等非法字符");
	    }
	    else if(strcheck.test(real_name)){
	        $("#error-message").html("真实名不能包含空格\\<>等非法字符");
	    }
	    else if(strcheck.test(password)){
	        $("#error-message").html("密码不能包含空格\\<>等非法字符");
	    }
	    else{
	    	   var _data = {
	    	    		"email":email,
	    	    		"loginName":login_id,
	    	    		"realName":real_name,
	    	    		"password":password,
	    	    		"level":level,
	    	    		"id":id,
	    	    		"dataStatus":status
	    	    }
	    	    $.ajax({
	    	        url: "/dcs/update/user",
	    	        type: "POST",
	    	        contentType: "application/json",
	    	        dataType: "json",
	    	        data: JSON.stringify(_data),
	    	        success: function (data) {
	    	             $("#error-message").html(data.msg);
	    	             location.reload();
	    	        },
	    	       error: function (data) {
	    	            $("#error-message").html(data.msg)
	    	       }
	    	    });
	    }
    }
})
function check(){
	var login_id=$("#login-id").val();
    var _data={
    	"loginName":login_id
    }
    if(login_id!=null){
    	$.ajax({
			url:"/dcs/check",
			type: "POST",
			contentType: "application/json",
	        dataType: "json",
	        data: JSON.stringify(_data),
		   success:function(data){
				$("#error-message").html(data.msg);
				return true;
		   },
		   error:function(data){
			   $("#error-message").html(data.msg);
		   }
		});
    }
}