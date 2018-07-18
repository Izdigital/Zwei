<style>
.modal-dialog {
    position: absolute;
    top: 50%;
    left: 50%;
    z-index: 3;
    margin: auto; 
    -webkit-transform: translate(-30%, -90%) !important;
    -moz-transform: translate(-50%, -90%) !important;
    -ms-transform: translate(-50%, -90%) !important;
    -o-transform: translate(-50%, -90%) !important;
    transform: translate(-50%, -90%) !important;
}
</style>

<#if currentUser??>
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="top-bar-info pull-right">
						<a href="#">个人中心</a>
						<a href="#">|</a>
						<a href="#">管理中心</a>
						<a href="#">通知<span class="label label-primary tag-circle">2</span></a>
						<a href="#">这是当前用户名</a>
						<a href="#">退出登陆</a>
					</div>
				</div>
			</div>
		</div>
	</div>
<#else>
	<div class="top-bar">
		<div class="container">
			<div class="row">
				<div class="col-xs-12">
					<div class="top-bar-info pull-right">
						<a href="#" data-toggle="modal" data-target="#loginModal">登陆</a>
						<a href="#">|</a>
						<a href="#">注册</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</#if>
<div class="modal in" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel">
	<div class="modal-dialog modal-sm" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
				<h4 style="text-align:center" class="modal-title" id="myModalLabel">用户登陆</h4>
			</div>
			<div class="modal-body">
				<form class="form-horizontal" style="padding:15px">
	                <div class="form-group">
	                	<input type="text" id="user_code" name="user_code" class="form-control" placeholder="账号/邮箱/手机" />
	                </div>
	                <div class="form-group">
	                	<input type="password" id="user_account" name="user_account" class="form-control" placeholder="密码" />
	                </div>    
	                <div class="form-group">
	                	<div class="col-sm-7" style="padding:0">
	                	<input type="text" id="captcha" name="captcha" class="form-control" autocomplete="off" placeholder="验证码" />
	                	</div>
	                	<div class="col-sm-5" style="padding-left:10px">
	                	<a href="javascript:void(0);" onclick="RefreshCaptcha()">
	                		<img id="captchaImg" alt="验证码"  src="${base}/account/captchaGenerate"/>
	                	</a>
	                	</div>
	                </div>
	                <div class="form-group">
	                	<button type="button" class="btn btn-info btn-block">LOGIN</button>
	                </div>    
                </form>      
			</div>
		</div>
	</div>
</div>
<script type="text/javascript"> 

	/**
    * 验证码刷新
    */
    function RefreshCaptcha(){
        var rad = Math.floor(Math.random() * Math.pow(10, 8));
        //uuuy是随便写的一个参数名称，后端不会做处理，作用是避免浏览器读取缓存的链接
        $("#captchaImg").attr("src", "${base}/account/captchaGenerate?uuuy="+rad);
    }

</script>