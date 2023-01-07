<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>登录界面</title>
    <meta name="viewport" content="width=device-width,initial-scale=1.0,user-scalable=no">
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <link href="/css/style.css" type="text/css" rel="stylesheet">
    <style>
        body{color:#fff; font-family:"微软雅黑"; font-size:14px;}
        .wrap1{position:absolute; top:0; right:0; bottom:0; left:0; margin:auto }/*把整个屏幕真正撑开--而且能自己实现居中*/
        .main_content{background:url(/static/images/main_bg.png) repeat; margin-left:auto; margin-right:auto; text-align:left; float:none; border-radius:8px;}
        .form-group{position:relative;}
        .login_btn{display:block; background:#3872f6; color:#fff; font-size:15px; width:100%; line-height:50px; border-radius:3px; border:none; }
        .login_input{width:100%; border:1px solid #3872f6; border-radius:3px; line-height:40px; padding:2px 5px 2px 30px; background:none;}
        .icon_font{position:absolute; bottom:15px; left:10px; font-size:18px; color:#3872f6;}
        .font16{font-size:16px;}
        .mg-t20{margin-top:20px;}
        @media (min-width:200px){.pd-xs-20{padding:20px;}}
        @media (min-width:768px){.pd-sm-50{padding:50px;}}

    </style>

</head>

<body >

<div class="container wrap1" style="height:450px;">
    <h2 class="mg-b20 text-center">
        学生管理系统登录页面<br />
    </h2>
    <h4  class="mg-b20 text-center" style="color: red">
    </h4>
    <div class="col-sm-8 col-md-5 center-auto pd-sm-50 pd-xs-20 main_content">
        <p class="text-center font16">用户登录</p>
        <form action="adminlogin" method="post" >
            <div class="form-group mg-t20">
                <i class="icon-user icon_font"></i>
                <input type="text" class="login_input" id="userName" name="userName" placeholder="请输入用户名" />
            </div>
            <div class="form-group mg-t20">
                <i class="icon-lock icon_font"></i>
                <input type="password" class="login_input" id="userPwd" name="userPwd" placeholder="请输入密码" />
            </div>
            <div class="checkbox mg-b25">
                <label>
                    <input type="checkbox" />记住我的登录信息
                </label>
            </div>
            <button type="submit" class="login_btn">登 录</button>
        </form>
    </div><!--row end-->
</div><!--container end-->

<canvas id="canvas" style="background:#000" width="1920" height="1050"></canvas>
<script>
    // 代码雨
    window.onload = function () {
        var canvas = document.getElementById("canvas");
        var context = canvas.getContext("2d");
        // 浏览器宽高
        var W = window.screen.availWidth;
        var H = window.screen.availHeight;
        canvas.width = W;
        canvas.height = H;
        var fontSize = 18;
        var colunms = Math.floor(W / fontSize);
        // 坐标
        var coordinate = [];
        for (var i = 0; i < colunms; i++) {
            coordinate.push(0);
        }
        var str = "javascript html5 canvas";
        function draw() {
            // 背景色
            context.fillStyle = "rgba(0,0,0,0.05)";
            context.fillRect(0, 0, W, H);
            context.font = "800 " + fontSize + "px  宋体";
            // 字体颜色
            context.fillStyle = "#01fef5";
            for (var i = 0; i < colunms; i++) {
                var index = Math.floor(Math.random() * str.length);
                var x = i * fontSize;
                var y = coordinate[i] * fontSize;
                context.fillText(str[index], x, y);
                if (y >= canvas.height && Math.random() > 0.88) {
                    coordinate[i] = 0;
                }
                coordinate[i]++;
            }
        }

        function randColor() {
            var r = Math.floor(Math.random() * 256);
            var g = Math.floor(Math.random() * 256);
            var b = Math.floor(Math.random() * 256);
            return "rgb(" + r + "," + g + "," + b + ")";
        }

        draw();
        setInterval(draw, 30);
    };
</script>

</body>
</html>

