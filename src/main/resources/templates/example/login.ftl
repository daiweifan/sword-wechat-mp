<#assign contentBody>  
<style>
	    html,body{
	    	width: 100%;
	    	height: 100%;
	    }
		body{
			background:url(images/temp/login.jpg) no-repeat;
			background-size:cover;
		}

		.logo{
			margin:0 auto;
			padding:6% 8%;
			text-align: center;
		}
		.logo img{
			width: 50%;
		}
		.weui-agree .weui-agree__text{
			color:#fff;
		}

		.weui-agree{
			width: 50%;
			font-size: 14px;
		}

		.weui-btn_yellow {
		  background-color: #ffbd30;
		}
		.weui-btn_yellow:not(.weui-btn_disabled):visited {
		  color: #FFFFFF;
		}
		.weui-btn_yellow:not(.weui-btn_disabled):active {
		  color: #fff;
		  background-color: #f3b125;
		}
		.wj-mm{
			text-align: right;
			line-height: 33px;
			padding-right: 10px;
			padding-top: 3px;
			font-size: 14px;
		}
		.wj-mm a{
			color:#ffbd30;
		}

		.loginPage{
			padding:10px;
		}
		.input-container{
			display: -webkit-box;
			border-radius: 5px;
			background:#7b9ec8;
			margin-bottom:15px;
			height: 43px;
			position: relative;
		}
		.input-container label{
			display: block;
			padding:0 5px;
		}
		.input-container label img{
			width: 28px;
			padding:8px 6px 0;
		}
		.input-container .flex{
			-webkit-box-flex:1;
		}
		.input-container input{
			padding:11px 10px 11px 0;
			width: 100%;
			-webkit-box-sizing:border-box;
			border:none;
			background:none;
			font-size: 15px;
			color:#fff;
		}

		.input-container input::-webkit-input-placeholder { 
		    color:#fff;
		}
		.input-container .delete{
			position: absolute;
			top: 50%;
			right: 0;
			-webkit-transform:translate(0,-50%);
			padding:5px 8px;
			display: none;
		}
		.input-container .delete img{
			width: 26px;
			padding-top: 5px;
		}

		.input-container.error{
			border:1px solid #ffbd30;
		}

		.error-txt{
			position: fixed;
			bottom:20px;
			left: 0;
			width: 100%;
			-webkit-box-sizing:border-box;
			
			text-align: center;
			background:;

		}
		.error-txt span{
			display: inline-block;
			padding:10px 20px;
			background:rgba(0,0,0,.3);
			border-radius: 5px;
			color:#fff;
		}

	</style>
<div class="logo">
        <img class="logo" src="images/temp/logo.png" alt="">	
    </div>

    <div class="loginPage">
    	<div class="input-container error"><label><img src="images/temp/icon1.png" alt=""></label><div class="flex"><input type="tel" maxlength="11" placeholder="请输入手机号"></div><div class="delete"><img src="images/temp/icon3.png" alt=""></div></div>
    	<div class="input-container"><label><img src="images/temp/icon2.png" alt=""></label><div class="flex"><input type="password" placeholder="请输入密码"></div><div class="delete"><img src="images/temp/icon3.png" alt=""></div></div>
    </div>

    <div class="weui-flex">
	  <div class="weui-flex__item">
	  	<label for="weuiAgree" class="weui-agree">
	      <input id="weuiAgree" type="checkbox" class="weui-agree__checkbox">
	      <span class="weui-agree__text">
	        自动登陆
	      </span>
	    </label>
	  </div>
	  <div class="weui-flex__item wj-mm"><a href="#">忘记密码?</a></div>
	</div>

    <div style="padding:10px;">
    	<button class="weui-btn weui-btn_yellow">登 录</button>
    </div>

    <div class="error-txt"><span>该手机号码未注册成为联营店！</span></div>
   

	<script src="js/jquery.min.js"></script>
	<script src="js/jquery-weui.min.js"></script>
	<script>
		$('.input-container input').keydown(function(){
			     $(this).parent().next('.delete').show();
		   });
		   $('.input-container input').focus(function(){
			     var Text = $(this).val();
			     if(Text != ""){
				     $(this).parent().next('.delete').show();
				 }else{
				     $(this).parent().next('.delete').hide();
				 } 
		   });
		   // $('.input-container input').blur(function(){
			  //    $(this).parent().next('.delete').hide();
		   // });
		   
		   $('.input-container .delete').on('click',function(){
		      $(this).prev('.flex').find('input').val('');
		      $(this).hide();
		   })
	</script>

</#assign>  
<#include "/shared/layout.ftl" />  
	
