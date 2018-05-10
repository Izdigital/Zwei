<!DOCTYPE html>
<html>
<#assign base=request.contextPath />
<head>
	<title>注册</title>
	<#import "spring.ftl" as spring />  
</head>
<body>

<form class="m-form m-form-ht n-login" action="register" method="post" id="register">
    <div class="fmitem">
        <label class="fmlab">用户名：</label>
        <div class="fmipt">
            <input class="u-ipt" id="userName" name="userName" value="${(registerModel.userName)!}" autofocus/>
            <#if registerModel??>
	            <@spring.bind "registerModel.userName" />
	            <@spring.showErrors " "/>
            </#if>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">密码：</label>
        <div class="fmipt">
            <input class="u-ipt" id="password" type="password" name="password" value="${(registerModel.password)!}" />
            <#if registerModel??>
	            <@spring.bind "registerModel.password" />
	            <@spring.showErrors " "/>
            </#if>
        </div>
    </div>
    <div class="fmitem">
        <label class="fmlab">确认密码：</label>
        <div class="fmipt">
            <input class="u-ipt" id="confirmPassword" type="password" name="confirmPassword" value="${(registerModel.confirmPassword)!}" />
            <#if registerModel??>
	            <@spring.bind "registerModel.confirmPassword" />
	            <@spring.showErrors " "/>
            </#if>
        </div>
    </div>
    <div class="fmitem fmitem-nolab fmitem-btn">
        <div class="fmipt">
            <button type="submit" class="u-btn u-btn-primary u-btn-lg u-btn-block">注册</button>
        </div>
    </div>
</form>
<script type="text/javascript" src="${base}/js/jquery-1.11.1.js"></script>
<script type="text/javascript" src="${base}/js/jquery.validate.js"></script>
<@valid className="cn.izdigital.zwei.web.viewmodel.RegisterEditModel" formName="register"> </@valid>
</body>
</html>