var btn = document.getElementsByClassName("btn")[0];
var p= document.getElementsByTagName("p");
var xmlhttp;

var app = angular.module('myApp', []);
app.controller('myCtrl',function($scope, $http, $interval) {
   var update = function () {
       $http.get("/getInformationHtml")
           .success(
               function (data) {
                   $scope.Inf = data;
                   check();
               }
           );
   } ;
   $interval(function () {
       update()},
       3000);
});



function loadXMLDoc()
{
    if (window.XMLHttpRequest)
    {
        // IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
        xmlhttp=new XMLHttpRequest();
    }
    else
    {
        // IE6, IE5 浏览器执行代码
        xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
    }
}

//风扇
function fengsan(){
    loadXMLDoc();
    if(p[0].style.backgroundColor=='red'){
        p[0].style.backgroundColor='transparent';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnDownFan");
    }
    else{
        p[0].style.backgroundColor='red';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnOnFan");
    }
}
//电灯
function diandeng(){
    loadXMLDoc();
    if(p[1].style.backgroundColor=='red'){
        p[1].style.backgroundColor='transparent';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnDownLight");
    }
    else{
        p[1].style.backgroundColor='red';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnOnLight");
    }
}
//水泵
function shuibeng(){
    loadXMLDoc();
    if(p[2].style.backgroundColor=='red'){
        p[2].style.backgroundColor='transparent';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnDownWaterPump");
    }
    else{
        p[2].style.backgroundColor='red';
        xmlhttp.open("POST","/controlHtml");
        xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
        xmlhttp.send("order=turnOnWaterPump");
    }
}

//弹窗
var mask=document.getElementsByClassName("mask")[0];
function close_mask(){
    mask.style.display='none';
}


//获取湿度、温度、光照强度值
function check(){
    var a1= document.getElementById("a1").value;
    var a2 = document.getElementById("a2").value;
    var a3 = document.getElementById("a3").value;
    var a4 = document.getElementById("a4").value;
    var a5 = document.getElementById("a5").value;
    var err = document.getElementById("err");
    var span1 = document.getElementsByTagName("span")[0];

    if(a1<10){
        mask.style.display='block';
        span1.innerHTML=" 土壤温度过低！"+"<br/>";
    } else if(a1>40){
        mask.style.display='block';
        span1.innerHTML=" 土壤温度过高！"+"<br/>";
    } else {
        mask.style.display='none';
    }


    if(a2<200){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  土壤湿度过低，应该打开水泵！"+"<br/>";
    }else if(a2>1500 ){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        err.innerHTML="  土壤湿度过高，应该关闭水泵！"+"<br/>";
    }

    if(a3<10){
        mask.style.display='block';
        span1.appendChild(span);
        span.innerHTML="  空气温度过低！"+"<br/>";
    }else if(a3>30){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  空气温度过高！"+"<br/>";
    }


    if(a4<300){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  空气湿度过低，应该关闭电扇！"+"<br/>";

    }else if(a4>1500){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  空气湿度过高，应该打开电扇！"+"<br/>";
    }


    if(a5<50){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  光照强度过低，应该打开电灯！"+"<br/>";


    }else if(a5>10000){
        mask.style.display='block';
        var span = document.createElement("span");
        span1.appendChild(span);
        span.innerHTML="  光照强度过高，应该关闭电灯！"+"<br/>";
    }
};