window.onload=function(){
    resize();
    // $.ajax({
    //     contentType: "application/json",
    //     dataType: "json",
    //     type: "POST",
    //     url:"http://localhost:8080/info/user",
    //     success: function(data) {
    //         console.log(data.authorities.length);
    //         console.log(data);
    //         console.log(data.authorities[1].url);
    //         console.log(data.authorities[1].authorityName);
    //         for(var i = 0;i<data.authorities.length;i++) {
    //             $("#nav-ul").append("<li><a href='"+data.authorities[i].url+"'>"+data.authorities[i].authorityName+"</a></li>");
    //         }
    //         $("#username").html(data.userName);
    //         $("#character").html([data.characterName]);
    //         $("#department").html([data.department]);
    //     },
    //     error: function (data) {
    //         alert("你未登录！");
    //        window.location.href="http://localhost:8080/view/user/login.html"
    //     }
    // });
};

window.onresize=function(){
    resize();
};

/*var resize=function(){
    document.getElementById('container').style.width=document.body.clientWidth-200+"px"
};
*/
$("#log-out").click(function(){
    location.href="../user/login.html";
})
//$("#group a").click(function(){
//	var code=$(this).parent().attr('id');
//	var level=$(this).parent().parent().attr("id");
//	if(level=="student"){
//		console.log("dfadfa");
//		var _data ={
//	        	"code":code,
//	        	"level":"学工办",
//	        	"page":{
//	        		"pageIndex":"1",
//	        		"pageSize":"10",
//	        		"sortField":"id",
//	        		"orderType":"asc"
//	        	}
//		}
//		 $.ajax({
//			 contentType: "application/json; charset=utf-8",
//			 dataType:"json",
//	         type: "POST",
//	         url:"/dcs/excel/select_list",
//	         data: JSON.stringify(_data),
//	         success: function(data) {
//	            console.log(data);
//	         },
//	         error: function (data) {
//	        	 
//	         }
//	     });
//	}
//})