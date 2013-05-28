
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.2
 */

		var validator_config = {
			code: {
				text: "请输入帐号",
				validators: {
					required: {
						failmsg:"帐号不能为空"
					},
					ajax: {
						url:'pub/pub_checkPersonCode.action',
						param:"person.code",
						returnText:'ok',
						failmsg:"该帐号已经存在，请重新输入!"
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
			name: {
				text: "请输入姓名",
				validators: {
					required: {
						failmsg:"姓名不能为空"
					}
				}
			},
			dept: {
				text: "请输入所属单位",
				validators: {
					required: {
						failmsg:"所属单位不能为空"
					},
					maxBytes: {
						max:50,
						failmsg:"所属单位不能大于50个字节"
					}
				}
			},
			sex: {
				text: "请输入性别",
				validators: {
					required: {
						failmsg:"性别不能为空"
					}
				}
			},
			certificateType:{
				text: "请选择证件类型",
				validators: {
					required: {
						failmsg:"证件类型不能为空"
					}
				}
			},
			certificateCode: {
				text: "请输入证件号码",
				validators: {
					required: {
						failmsg:"证件号码不能为空"
					},
					personID: {
						failmsg:"你输入的不是一个有效的证件号码!"
					},
					ajax: {
						url:'pub/pub_checkPersonDoc.action',
						param:"person.certificateCode",
						returnText:'ok',
						failmsg:"该证件号码已经存在，请重新输入!"
					}
				}
			},
			tel: {
				text: "在此输入电话,如:13911110000或0551-1234567",
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
						url:'pub/pub_checkPersonEmail.action',
						param:"person.email",
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
	
