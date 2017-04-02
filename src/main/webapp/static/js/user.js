$("#confirm").click(function (){
	var email=$("#email").val();
	var login_id=$("#login-id").val();
    var real_name=$("#real_name").val();
    var password=$("#password").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var mailcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    var level = $("#select-id").find("option:selected").text();
    console.log(level)
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
        	"loginId":login_id,
        	"realName":real_name,
        	"password":password,
        	"level":level
        };
        $.ajax({
            url: "http://localhost:8080/add/user",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                $("#error-message").html("添加成功！");
            },
            error: function (data) {
                $("#error-message").html("添加数据库失败！")
            }
        });
    }
})