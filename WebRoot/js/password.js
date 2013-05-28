
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.2
 */

		var validator_config = {
			username: {
				text: "请输入您的登录帐号名称",
				validators: {
					required: {
						failmsg:"登录帐号名称不能为空"
					}
				}
			},
			useremail: {
				text: "请输入你注册的邮箱地址！",
				validators: {
					required: {
						failmsg:"邮箱地址不能为空!"
					},
					email: {
						failmsg:"邮箱地址的格式不正确!"
					}
				}
			}
		};
		
		function doSave() {
			if($.brady.validator.validateForm("addForm", validator_config)) {
				$("#addForm").get(0).submit();
				//closeDialog();
			}
		}
	
