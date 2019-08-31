$(function(){
    $(".left-nav li:first").addClass("selected");
    $(".left-nav li").click(function(){
        $(this).addClass("selected").siblings().removeClass("selected");
    });
});
