$("#all").click(function() {
    var box = $(":checked").size();
    alert(box);
    if(box<10)
        $(":checkbox").prop("checked",'true');
    else{
        $(":checkbox").removeAttr("checked",'false');
        // $(":checkbox").removeAttr("checked");
    }
})
$("#delete").click(function(){
    var box = $("input:checkbox");
    for(var i = 0 ;i<box.size();i++){
        if(true==box[i].checked)
            $(box[i]).parent().parent().remove();
    };

})