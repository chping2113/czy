
/**
* included in index.jsp
*/

		function add(creditType, creditId) {
			var loadContentUrl = "pub/pub_addRequest.action?creditType=" + creditType +"&creditId=" + creditId;
			showDialog(loadContentUrl, "btn_ok_close");
		}   
		
		var validator_config1 = {
				creditPassword: {
					text: "请输入查询密码",
					validators: {
						required: {
							failmsg:"查询密码不能为空"
						}
					}
				}
		}

		var validator_config = {
				applyDept: {
					text: "请输入申请单位",
					validators: {
						required: {
							failmsg:"申请单位不能为空"
						}
					}
				},
				applyer: {
					text: "请输入申请人",
					validators: {
						required: {
							failmsg:"申请人不能为空"
						}
					}
				},
				phone: {
					text: "请输入联系手机",
					validators: {
						required: {
							failmsg:"联系手机不能为空"
						},
						phone: {
							failmsg:"请输入正确的联系电话"
						}
					}
				},
				email: {
					text: "请输入邮箱",
					validators: {
						required: {
							failmsg:"邮箱不能为空"
						},
						email: {
							failmsg:"请输入正确的邮箱格式"
						}
					}
				},
				purpose: {
					text: "请输入查询目的",
					validators: {
						required: {
							failmsg:"查询目的不能为空"
						}
					}
				}
		};
		
		function doSave() {
			if($("#applyDept").val() == "" || $("#applyDept").val() == null){
				
				var temp= $("#tab1").is(":visible");
				if(temp){
					if($.brady.validator.validateForm("checkForm", validator_config1)) {
						$.post(  
							'pub_creditPasswordCheck.action',  
							{  
								creditType:$('#creditType').val(),  
								creditId:$('#creditId').val(),
								creditPassword:$('#creditPassword').val()
							},  
							function (data) //回传函数  
							{  
//								alert(data);
								if(data == "ok"){
									if($('#creditType').val() == 1){
										location.href="pub_showCompanyApprove.action?id="+$('#creditId').val();
									}else{
										location.href="pub_showPersonApprove.action?id="+$('#creditId').val();
									}
								}else{
									if(data == "no"){
										showMessage("该密码不存在，请重新申请！");
									}
									if(data == "state_err"){
										showMessage("该密码已作废，请重新申请！");
									}
									$('#tab1').hide();
									$('#tab2').show();
								}
							}  
						);  
					}
				}else{

					if($.brady.validator.validateForm("addForm", validator_config)) {
						$.post(  
							'pub_add.action',  
							{  
								creditType:$('#creditType').val(),  
								creditId:$('#creditId').val(),
								applyDept:$('#applyDept').val(),
								applyer:$('#applyer').val(),
								phone:$('#phone').val(),
								email:$('#email').val(),
								purpose:$('#purpose').val()
							},  
							function (data) //回传函数  
							{  
								//alert(data);
								if(data == "ok"){
									closeDialog();
									showMessage(" 你的档案查询申请已经提交成功，我们会在最短时间内审批并把查询密码发送到您的邮箱！");
									//$("#addForm").get(0).submit();
								}else{
									closeDialog();
									showMessage("您的查询申请已提交，经审批后我们将以邮件的形式将密码发送到您的邮箱！");
								}
							}  
						);  
					
				}
				}
		}else{
			if($.brady.validator.validateForm("addForm", validator_config)) {
					$.post(  
						'pub_add.action',  
						{  
							creditType:$('#creditType').val(),  
							creditId:$('#creditId').val(),
							applyDept:$('#applyDept').val(),
							applyer:$('#applyer').val(),
							phone:$('#phone').val(),
							email:$('#email').val(),
							purpose:$('#purpose').val()
						},  
						function (data) //回传函数  
						{  
							//alert(data);
							if(data == "ok"){
								closeDialog();
								showMessage(" 你的档案查询申请已经提交成功，我们会在最短时间内审批并把查询密码发送到您的邮箱！");
								//$("#addForm").get(0).submit();
							}else{
								closeDialog();
								showMessage("您的查询申请已提交，经审批后我们将以邮件的形式将密码发送到您的邮箱！");
							}
						}  
					);  
				
			}
			}
			
		}
		
		function checkTab(){
			$('#tab1').hide();
			$('#tab2').show();
		}

function doSubmit(type){
	var code = ""; //取框中的用户名
	var password = "";//取框中的密码
	var state = "";
	var input = "";
	
	

	if(type == 1) {
		code = $("#code").val();//取框中的用户名
		password = $("#password").val();//取框中的密码
		input = $("#input1").val();
		state = 3;
	} else if(type == 2) {
		code = $("#code2").val();//取框中的用户名
		password = $("#password2").val();//取框中的密码
		input = $("#input2").val();
		state = $("input[name='state2']:checked").val();
	}else if(type == 0){
		code = $("#code3").val();//取框中的用户名
		password = $("#password3").val();//取框中的密码
		input = $("#input3").val();
		state = 0;
	}
	if(code == "" || password == "") {
		showMessage("请输入用户名和密码");
		return;
	}
	
    $.post(  
      'pub_indexLogin.action',  
      {  
    	"code": code,  
        "password": password,
        "state": state,
        "input":input
      },  
      function (data) //回传函数  
      {  
        if(data == "no_access") {
        	showMessage("您没有权限登录本系统，请与管理员联系！");
        } else if(data == "0" || data == "1" || data == "2") {
        	location.href="system/account_showAccount.action";
        } else if(data == "no"){
        	showMessage("登录失败，系统中无此帐号或选择了错误的登录类型！");
        } else if(data == "pass_err"){
        	showMessage("登录失败，您输入的密码不正确或验证码不正确!");
        } else if(data == "no_approve"){
        	showMessage("登录失败，该帐号尚未审批通过！");
        } else if(data == "no_valid"){
        	showMessage("登录失败，该帐号已被禁用，请与系统管理员联系！");
        } else {
        	showMessage("登录失败，请查检您输入的帐号及密码是否正确！");
        }
      }
    );  
}

function test(objId){
	return document.getElementById(objId);
}

function changeId(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
	$("#tab11").hide();
	$("#tab22").hide();
	$("#tab33").hide();
	$(tab).show();	
}

function changeId2(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
	$("#tab44").hide();
	$("#tab55").hide();
	$("#tabcc").hide();
	$(tab).show();	
}
function changeId3(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
	$("#tab66").hide();
	$("#tab77").hide();
	$(tab).show();	
}
function changeId4(currentId, obj ,tab){
	$("a[tab='tab2']").attr("id", "");
	obj.id = currentId;
	
	$("div[tab='tab']").hide();
	$(tab).show();	
}

function changeId5(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
	$("#tab223").hide();
	$("#tab224").hide();
	$("#tab225").hide();
	$(tab).show();	
}

function changeId6(idName,obj,tab){
	test(idName).id="";
	obj.id=idName;
	obj.blur();
	$("#tab88").hide();
	$("#tab99").hide();
	$(tab).show();	
}


/**
 * 在页面上移动浮动公告显示面板
 */
var floatX = 0;
var floatType = "right";
var screenWidth = screen.availWidth;
var floatTimer;
function moveFloatNoticepane() {
	if(floatType == "right") {
		floatX ++;
	} else {
		floatX --;
	}
	
	if((floatX + 603 ) > screenWidth) {
		floatType = "left";
	} else if(floatX <= 0){
		floatType = "right";
	}
	
	$("#floatNoticePane").css("left", floatX);
}

/**
 * 关闭浮动公告显示面板
 */
function closeFloatNoticePane() {
	clearInterval(floatTimer);
	$("#floatNoticePane").hide();
}

/**
 * 首页加载完执行的code
*/
$(function() {
	//启动浮动通知公告显示面板
	var floatNoticeListSize = $("#floatNoticeListSize").val();
	if(floatNoticeListSize != "0") {
		$("#floatNoticePane").show();
		floatTimer = setInterval("moveFloatNoticepane()", 200);
	}
	//初始化标题图片轮播功能
	$('#imageSliderBox').smallslider({
        onImageStop:true,
        switchMode: 'hover',
        showText: false
        });
	
	//为密码输入表单项加一个onkeypress事件处理
	$("#password").keypress(function(evt) {
		if(evt.keyCode == 13) {
			doSubmit();
		}
	});
});

/**
* 找回密码
*/
function getPassword() {
	var type = $(":radio[name='state']:checked").val();
	window.location.href = "pub_showPassword.action?loginType=" + type;
}