var video = document.getElementById("video");
var canvas = document.getElementById("canvas");
var capture = document.getElementById("capture");
var restartcapture = document.getElementById("restartcapture");
var upload = document.getElementById("upload");
var context = canvas.getContext("2d");

function getUserMedia(constrains,success,error){
    if(navigator.mediaDevices.getUserMedia){
        navigator.mediaDevices.getUserMedia(constrains).then(success).catch(error);
    } else if (navigator.webkitGetUserMedia){
        navigator.webkitGetUserMedia(constrains).then(success).catch(error);
    } else if (navigator.mozGetUserMedia){
        navagator.mozGetUserMedia(constrains).then(success).catch(error);
    } else if (navigator.getUserMedia){
        navigator.getUserMedia(constrains).then(success).catch(error);
    }
}

function success(stream){
	video.style.display="";
	capture.style.display="";
    var CompatibleURL = window.URL || window.webkitURL;
    video.src = CompatibleURL.createObjectURL(stream);
    video.play();
}

function error(error){
    alert("访问用户媒体设备失败：",error.name,error.message);
}

if (navigator.mediaDevices.getUserMedia || navigator.getUserMedia || navigator.webkitGetUserMedia || navigator.mozGetUserMedia){
    getUserMedia({
        video:{width:640,height:360}
    },success,error);
} else {
    alert("你的浏览器不支持访问用户媒体设备");
}

function takephoto(){
    context.drawImage(video,0,0,640,360);
    canvas.style.display="";
    video.style.display="none";
    capture.style.display="none";
    restartcapture.style.display="";
    upload.style.display="";
}

function retakephoto() {
	canvas.style.display="none";
    video.style.display="";
    capture.style.display="";
    restartcapture.style.display="none";
    upload.style.display="none";
}

function uploadphoto() {
	
}