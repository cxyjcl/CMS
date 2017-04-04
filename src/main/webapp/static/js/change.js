$("#confirm").click(function (){
    var password=$("#password").val();
    var re_pass=$("#re-pass").val();
    var email=$("#email").val();
    var strcheck=/[`~!@#$%^&*()_+<>?:"{},.\/;'[\]]/im;
    var mailcheck=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
    console.log(password=="")
    if(email==""){
    	email=null;
    }
    else if(!mailcheck.test(email)){
        $("#error-message").html("邮箱格式不正确");
    }
    if(re_pass=="" || password==""){
        $("#error-message").html("密码不得为空");
    }
    else if(password!=re_pass){
        $("#error-message").html("两次密码不一致");
    }
    else if(email==""){
        $("#error-message").html("邮箱不得为空");
    }
    else if(strcheck.test(password)){
        $("#error-message").html("密码不能包含空格\\<>等非法字符");
    }
    else if(strcheck.test(re_pass)){
        $("#error-message").html("密码不能包含空格\\<>等非法字符");
    }
    else
    {
        var _data = {
            'password': password,
            'email' : email,
        };
        $.ajax({
            url: "http://localhost:8080/dcs/change/user",
            type: "POST",
            contentType: "application/json",
            dataType: "json",
            data: JSON.stringify(_data),
            success: function (data) {
                $("#error-message").html(data.msg);
            },
            error: function (data) {
                $("#error-message").html(data.msg);
            }
        });
    }
})