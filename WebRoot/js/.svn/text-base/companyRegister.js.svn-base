
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.2
 */

		var validator_config = {
			code: {
				text: "请输入登录帐号",
				validators: {
					required: {
						failmsg:"帐号不能为空"
					},
					ajax: {
						url:'pub/pub_checkCompanyCode.action',
						param:"company.code",
						returnText:'ok',
						failmsg:"账号已经存在，请重新输入!"
					}
				}
			},
			password: {
				text: "请输入密码",
				validators: {
					required: {
						failmsg:"密码不能为空"
					},
					passwordID: {
						failmsg:"密码必须是由6-20位的字母和数字组成!"
					}
					
				}
			},
			comfirm_pw: {
				text: "请输入密码",
				validators: {
					required: {
						failmsg:"密码不能为空"
					},
					equalsTo: {
						failmsg:"两次输入的登录密码不一致!",
						to: "password"
					}
				}
			},
			licenseCode: {
				text: "请输入营业执照注册号",
				validators: {
					required: {
						failmsg:"营业执照注册号不能为空"
					},
					ajax: {
						url:'pub/pub_checkCompanylicenseCode.action',
						param: "company.licenseCode",
						returnText:'ok',
						failmsg:"营业执照注册号已经存在，请重新输入!"
					}
				}
			},
			name: {
				text: "请输入企业名称",
				validators: {
					required: {
						failmsg:"企业名称不能为空"
					}
				}
			},
			linkman: {
				text: "请输入联系人",
				validators: {
					required: {
						failmsg:"联系人不能为空"
					}
				}
			},
			tel: {
				text: "请输入电话,如13911110000或0551-1234567",
				validators: {
					required: {
						failmsg:"联系电话不能为空"
					},
					phone: {
						failmsg:"您输入的不是一个有效的电话号码!"
					}
				}
			},
			email: {
				text: "请输入邮件",
				validators: {
					required: {
						failmsg:"邮件不能为空"
					},
					email: {
						failmsg:"请输入正确的邮箱格式"
					},
					ajax: {
						url:'pub/pub_checkCompanyEmail.action',
						param:"company.email",
						returnText:'ok',
						failmsg:"该邮箱已被使用，请重新输入!"
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
	
