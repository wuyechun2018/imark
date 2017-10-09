<#assign ctx=rc.contextPath />
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
<head>
<base id="base" href="${ctx}">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<LINK href="${ctx}/resources/images/store.ico" type="image/x-icon" rel="icon">
<LINK href="${ctx}/imark/resources/images/store.ico" type="image/x-icon" rel="shortcut icon">
<script type="text/javascript" src="${ctx}/resources/jquery/jquery-1.9.1.js"></script>

<title>${appTitle}-注册</title>

<style type="text/css">

body{
	width: 100%; 
	height: 100%;
	margin: 0;
	color:#333;
	font-family: "Microsoft YaHei";
    font-size:14px;

}

ul,li,div{
	margin: 0;
	padding: 0;
}


.ihead{
	background-image: url("${ctx}/resources/images/nl-top.gif");
	height: 90px;
}

.ihead-content{
	width:985px;
	height:90px;
	margin: 0 auto;
    overflow: hidden;
    position: relative;
}




.ilogo{
	height: 60px;
	margin:18px 20px 17px 0;
	widht:165px;
	float:left;
}

.imenu{
	float:left;
	margin:35px 0;
	height:28px;
	line-height:26px;
	font-size:14px;
}

.imenu a{
	float:left;
	margin:0 0 0 30px;
	padding:0 3px;
	font-size: 14px;
	text-decoration:none;
	color:#333;

}

.icenter{
	width:965px;
	margin: 0 auto;
	padding: 0;
	overflow:hidden;
}

.icenter-left{
	float:left;
	width:645px;
}


.icenter-right{
	float:right;
	width:300px;
}

.iarticle{
	width: 615px;
    padding: 15px 14px;
    margin-bottom: 20px;
    overflow: hidden;
    background: #fff;
    border-radius: 3px;
    border: 1px #eee solid;
}

.imessage{
	border-radius:3px;
	padding：15px 0;
	width:298px;
	margin-bottom:20px;
	border:1px #eee solid;
}

.imessage h2{
	 width: 270px;
    height: 20px;
    padding: 0 15px 0 10px;
    border-left: 5px #f90 solid;
    line-height: 20px;
    font-weight: normal;
    font-size: 14px;
    letter-spacing: 1px;
    margin-bottom: 20px;

}



.irank {
    width: 270px;
    overflow: hidden;
    margin: 0 auto;
    background: url("${ctx}/resources/images/rank.png") 0 0 no-repeat;
}




ul{
list-style:none;

}

.irank ul li{
	width: 240px;
	height: 36px;
	padding-left: 30px;
	font-size:13px;
	vertical-align:top;
	white-space:nowrap;
	text-overflow:ellipsis;

}


.ibottom{
	width:963px;
	border-radius:3px 3px 0 0;
	border:1px #eee solid;
	color:#666;
	font-size:12px;
	border-bottom:0;
	padding:20px 0;
	margin:0 auto;
	line-height:26px;
	text-align:center;
	background:#f9f9f9;
	
}


.a-img{
	 float: left;
    width: 222px;
    height: 148px;
    overflow: hidden;
    margin-right: 15px;
    position: relative;
}


.a-content{
	float: left;
    width: 378px;
    height: 148px;
    overflow: hidden;

}

.a-content h1 {
    width: 378px;
    font-size: 18px;
    font-weight: 500;
    margin-bottom: 15px;
    height: 22px;
    line-height: 22px;
    letter-spacing: 1px;
    text-overflow: ellipsis;
    overflow: hidden;
    white-space: nowrap;
}


a:link, a:visited {
    color: #333;
    text-decoration:none;
}

.a-img-div{
 position: absolute;
    left: 0px;
    top: 0px;
    padding: 2px 6px;
    background: #000;
    text-align: center;
    color: #fff;
    border-radius: 0 0 3px 0;
    opacity: 0.3;
}

.a-img img{
 width: 222px;
 height: 148px;
}

.a-content-info{
    width: 378px;
    height: 20px;
    line-height: 20px;
    font-size: 12px;
    overflow: hidden;
    margin-bottom: 10px;
    color: #aaa;
}


.a-content-auth{
    float:left;
    margin-right: 15px;
}

.a-img-div .a-link{
	color:#fff;
	font-size:10px;

}

.a-summary {
    width: 378px;
    height: 25px;
    line-height: 22px;
    font-size: 14px;
    margin-bottom: 15px;
    color: #777;
    overflow: hidden;
}


.a-data {
    width: 378px;
    height: 20px;
    overflow: hidden;
    color: #aaa;
    font-size: 12px;
    line-height: 20px;
}

.a-data-left {
    float: left;
}

.a-data-text {
    float: left;
    height: 20px;
    margin-right: 12px;
}

.a-data-right {
    float: right;
}

.imenu .iselected{
	color:#f90;
}


.iwelcome {
    position: absolute;
    top: 33px;
    right: 0;
    width: 220px;
    height: 32px;
    border: 1px #eee solid;
    border-radius: 3px;
    overflow: hidden;
    background: #f9f9f9;
    color: #ccc;
    font-family: Arial,Verdana,Helvetica,sans-serif;
    font-size: 12px;
}


.iwelcome .isearch {
    float: left;
    width: 150px;
    height: 24px;
    margin: 4px 0 4px 4px;
    background: #fff;
    overflow: hidden;
}

.isearch .stext {
    float: left;
    width: 120px;
    height: 24px;
    line-height: 24px;
    padding: 0 0 0 5px;
    font-size: 12px;
    border: 0;
    color: #666;
}

.isearch .sbutton {
    float: right;
    width: 24px;
    height: 24px;
    background: url("${ctx}/resources/images/sbutton.png") center center no-repeat;
    border: 0;
    cursor: pointer;
}

.iwelcome .ihello {
    float: right;
    overflow: hidden;
    padding: 0 10px;
    width: 35px;
    height: 22px;
    line-height: 22px;
    margin: 5px 0;
    border-left: 1px #eee solid;
    cursor: pointer;
}

.login-user {
    width: 965px;
    margin: 0 auto;
    overflow: hidden;
}

.login {
    width: 935px;
    height: 26px;
    padding: 15px 14px;
    font-size: 12px;
    margin: 0 auto 20px;
    overflow: hidden;
    background: #fff;
    border-radius: 3px;
    border: 1px #eee solid;
}

.login .login-email, .login .login-pass, .login .login-button, .login .login-remember, .login .lost-pass {
    float: left;
    margin-right: 15px;
    height: 26px;
    vertical-align: middle;
}

.login .login-others {
    float: right;
    height: 26px;
}
.login .lost-pass {
    height: 26px;
    line-height: 26px;
}
.login .login-remember {
    height: 26px;
    line-height: 26px;
}
.login .login-email input, .login .login-pass input {
    width: 120px;
    height: 24px;
    line-height: 24px;
    border: 1px #eee solid;
    border-radius: 3px;
    background-color: white;
}

input {
    -webkit-appearance: textfield;
    background-color: white;
    -webkit-rtl-ordering: logical;
    user-select: text;
    cursor: auto;
    padding: 1px;
    border-width: 2px;
    border-style: inset;
    border-color: initial;
    border-image: initial;

}

.login .login-button input {
    width: 60px;
    height: 26px;
    line-height: 24px;
    background: #3498db;
    border: 0;
    color: #fff;
    border-radius: 3px;
}

input[type="checkbox" i] {
    -webkit-appearance: checkbox;
    box-sizing: border-box;
}
a:link,a:visited {color:#333;}
a:active,a:hover {color:#3498db;}
img {border:0;}
::selection {color:#FFF;background:#3498db;}

a.link4:link, a.link4:visited {
    color: #3498db;
}

a.link5:link, a.link5:visited {
    color: #f90;
}

.noback{
    -webkit-box-shadow: 0 0 0px 1000px white inset
}

.iwelcome .ihello img {
    width: 22px;
    height: 22px;
    border-radius: 11px;
    background: #ddd;
}

.user-menu {
    width: 935px;
    height: 26px;
    padding: 28px 14px 12px;
    font-size: 14px;
    margin: 0 auto 20px;
    overflow: hidden;
    background: #fff;
    border-radius: 3px;
    border: 1px #eee solid;
    background: url("${ctx}/resources/images/user-menu.png") #fff center -16px no-repeat;
}

.user-menu .user-menu-left {
    float: left;
    height: 22px;
    line-height: 22px;
}

.user-menu .user-menu-right {
    float: right;
    height: 26px;
    line-height: 26px;
}

.user-menu .user-menu-left a, .user-menu .user-menu-left span {
    display: inline-block;
    margin-right: 15px;
}

a.link6:link, a.link6:visited {
    color: #65b916;
}

.link5 {
    color: #f90;
}

.user-menu .user-menu-right a {
    display: inline-block;
    margin-left: 15px;
    height: 26px;
    background: #65b916;
    padding: 0 10px;
    color: #fff;
    border-radius: 3px;
}

/**以下是注册页面**/

.register-box {
    width: 360px;
    margin: 0 auto 20px;
    padding: 20px 150px;
    background: #f9f9f9;
    border-radius: 3px;
}

.register-box p {
    text-align: center;
    font-size: 14px;
    margin-bottom: 20px;
}

.register-box div {
    height: 30px;
    line-height: 30px;
    margin: 6px 0;
}

.register-box div .reginfo {
    border: #eee 1px solid;
    height: 16px;
    padding: 4px 5px;
    width: 160px;
    border-radius: 3px;

}

.register-box div .regbutton {
    width: 360px;
    height: 36px;
    background: #65b916;
    color: #fff;
    border-radius: 3px;
    border: 0;
    font-size: 16px;
    font-weight: bold;
    font-family: "微软雅黑","Microsoft YaHei","STHeiti","WenQuanYi Micro Hei",SimSun,Verdana,Helvetica,sans-serif;
    letter-spacing: 2px;
}

.register-box div .vercode {
    border: #eee 1px solid;
    height: 16px;
    padding: 4px 5px;
    width: 90px;
    border-radius: 3px;
}

.register-box div .verimg {
    float: right;
    cursor: pointer;
    margin-top: 0;
}

</style>



<script type="text/javascript">
 //显示登录窗口
 function showLoginWin() {
     if($('#div_status').is(":hidden")){
         $('#div_status').show();

     }else{
         $('#div_status').hide();
     }
 }


function setBgColor(color){
	document.bgColor=color;
}


//在注册页面直接跳到首页面
function display(obj,articleType){
    location.href="${ctx}/html/index?curType="+articleType;
};

$(function () {
    //绑定注册按钮点击事件
    $("#btn_register").click(function(event){
        var loginPwd=$('#loginPwd').val();
        var configLoginPwd=$('#configLoginPwd').val();
        var vcode=$('#vcode').val();

        if(vcode){
            $.ajax({
                type: "POST",
                url:'${ctx}/captcha/validate',
                data: {
                    vcode:vcode
                },
                success: function (data) {
                    if(!data.success){
                        $('#showMsg').html(data.msg);
                        return;
                    }
                },
                error: function(data) {
                    alert("error:"+data.responseText);
                }
            });
        }else {
            $('#showMsg').html("请输入验证码");
            return;
        }




        if(loginPwd&&configLoginPwd){
            if(loginPwd==configLoginPwd){
                $.ajax({
                    type: "POST",
                    url:'${ctx}/sysLoginUser/save',
                    data: $('#register_form').serialize(),
                    success: function (data) {
                        location.href="${ctx}/html/regLogin";
                    },
                    error: function(data) {
                        alert("error:"+data.responseText);
                    }
                });
            }else {
                $('#showMsg').html("两次输入的密码不一致，请重新输入!");
            }
        }else{
            if(!loginPwd){
                $('#showMsg').html("请输入登录密码!");
                return;
            }

            if(!configLoginPwd){
                $('#showMsg').html("请确认登录密码!");
            }

        }

    });

    //点击验证码
    $("#vimg").click(function(event){
        $("#vimg").attr("src","${ctx}/captcha/getKaptchaImage");
    })


})


</script>

</head>
<body>
	<div class="ihead">
		<div class="ihead-content">
			<div class="ilogo">
				<a>
					<!-- <img alt="520" src="http://static.u148.net/images/logo.gif">-->
					<img alt="520" src="${ctx}/resources/images/${appLogo}">
				</a>
			</div>
			
			<div class="imenu">
				<#list typeList as item>
					<#if item.id == curType>
						<a id='${item.id?if_exists}' href="javascript:void(0)" onclick="display(this,'${item.id?if_exists}')" class="iselected">${item.text?if_exists}</a>
						<#else>
						<a id='${item.id?if_exists}' href="javascript:void(0)" onclick="display(this,'${item.id?if_exists}')">${item.text?if_exists}</a>
					 </#if>
				</#list>
			</div>

            <div class="iwelcome">
                <div class="isearch">
                    <input id="search_tag" type="text" class="stext" placeholder="搜索内容" onclick="this.select();">
                    <input id="search_btn" type="button" value="" class="sbutton" >
                </div>
                <div class="ihello" id="top_status" onclick="showLoginWin()">


                <#if CURRENT_USER?exists>
                    <img src="${ctx}/resources/images/t_1.jpg">
                <#else>
                    <img src="${ctx}/resources/images/hello-img.gif">
                </#if>

                    <span class="caret"></span>
                </div>
            </div>


		</div>
	</div>


	<div class="icenter">
        <div class="register-box">
            <form action="" id="register_form">
                <p id="showMsg" style="color: red;font-weight: bold;"></p>
                <div><label>手机号码：<input id="mobilePhone" name="mobilePhone" type="text" class="reginfo"> * 个人手机号</label></div>
                <div><label>昵　　称：<input id="userAlias" name="userAlias" type="text" class="reginfo"> * 2-24个字符组成</label></div>
                <div><label>密　　码：<input id="loginPwd" name="loginPwd" type="password" class="reginfo"> * 6-16个字符组成</label></div>
                <div><label>确认密码：<input id="configLoginPwd" type="password" class="reginfo"> * 6-16个字符组成</label></div>
                <div><label><img class="verimg" id="vimg" src="${ctx}/captcha/getKaptchaImage" title="点击更换验证码">验&nbsp;&nbsp;证&nbsp;&nbsp;码：<input id="vcode" type="text" class="vercode" maxlength="4"> *</label></div>
                <center>
                    <div><input id="accept" type="checkbox" value="1" checked="checked"> 我已阅读并接受“<a href="/user/agreement.html" target="_blank">注册条款</a>”</div>
                    <div><input id="btn_register" type="button" value="创建账号" class="regbutton"></div>
                </center>
            </form>
        </div>
	</div>
	<#include "inc/page-bottom.ftl"/>
</body>
</html>