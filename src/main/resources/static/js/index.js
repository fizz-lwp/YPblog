let slideIndex = 0; // 幻灯片自动播放索引
showSlides(); // 初始化幻灯片
setInterval(showSlides,2000); // 设置幻灯片自动播放
function currentSlide(index) { // 手动切换幻灯片
    slideIndex = index-1;
    showSlides();
}
function showSlides() { // 展示幻灯片
    let i;
    let slides = document.getElementsByClassName("slide-element");
    let dots = document.getElementsByClassName("dot");
    for (i = 0; i < slides.length; i++) {
        slides[i].style.display = "none";
    }
    for (i = 0; i < dots.length; i++) {
        dots[i].className = dots[i].className.replace(" active", "");
    }
    slideIndex++;
    if (slideIndex >= slides.length) {slideIndex = 0}
    slides[slideIndex].style.display = "block";
    dots[slideIndex].className += " active";
}

// 滚动条在Y轴上的滚动距离
// function getScrollTop(){
//     let scrollTop = 0, bodyScrollTop = 0, documentScrollTop = 0;
//     if(document.body)
//         bodyScrollTop = document.body.scrollTop;
//     if(document.documentElement)
//         documentScrollTop = document.documentElement.scrollTop;
//     scrollTop = (bodyScrollTop - documentScrollTop > 0) ? bodyScrollTop : documentScrollTop;
//     return scrollTop;
// }
// 文档的总高度
// function getScrollHeight(){
//     let scrollHeight = 0, bodyScrollHeight = 0, documentScrollHeight = 0;
//     if(document.body)
//         bodyScrollHeight = document.body.scrollHeight;
//     if(document.documentElement)
//         documentScrollHeight = document.documentElement.scrollHeight;
//     scrollHeight = (bodyScrollHeight - documentScrollHeight > 0) ? bodyScrollHeight : documentScrollHeight;
//     return scrollHeight;
// }
// 浏览器视口的高度
// function getWindowHeight(){
//     let windowHeight = 0;
//     if(document.compatMode == "CSS1Compat")
//         windowHeight = document.documentElement.clientHeight;
//     else
//         windowHeight = document.body.clientHeight;
//     return windowHeight;
// }
// js原生监听滚动事件
// window.onscroll = function() {
//     if(getScrollTop() + getWindowHeight() == getScrollHeight()){
//         alert("hello");
//     }
// }