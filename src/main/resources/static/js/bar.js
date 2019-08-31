$(document).ready(function () {
    //
    $(".msg").mouseenter(function () {
        $(".hide-msg-container").css("display","block");
    });
    $(".msg").mouseleave(function () {
        $(".hide-msg-container").css("display","none");
    });
    $(".hide-msg-container").mouseenter(function () {
        $(".hide-msg-container").css("display","block");
    });
    $(".hide-msg-container").mouseleave(function () {
        $(".hide-msg-container").css("display","none");
    });
    //
    $(".user-head").mouseenter(function () {
        $(".hide-user-head-container").css("display","block");
    });
    $(".user-head").mouseleave(function () {
        $(".hide-user-head-container").css("display","none");
    });
    $(".hide-user-head-container").mouseenter(function () {
        $(".hide-user-head-container").css("display","block");
    });
    $(".hide-user-head-container").mouseleave(function () {
        $(".hide-user-head-container").css("display","none");
    });
})