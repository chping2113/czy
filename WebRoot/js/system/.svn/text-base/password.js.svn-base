		
		var validator_config = {};
		var validator_config0 = {
				password0: {
					text: "请输入原始密码",
					validators: {
						required: {
							failmsg:"原始密码不能为空"
						},
						ajax: {
							url:'system/account_checkAccountPw.action',
							param:"password",
							returnText:'ok',
							failmsg:"密码不正确，请重新输入!"
						}
					}
				},
				new_password0: {
					text: "请输入新密码",
					validators: {
						required: {
							failmsg:"新密码不能为空"
						},
						passwordID: {
						failmsg:"密码必须是由6-20位的字母和数字组成!"
						}
					}
				},
				confirm_password0: {
					text: "请输入确认密码",
					validators: {
						required: {
							failmsg:"确认密码不能为空"
						},
						equalsTo: {
							failmsg:"两次输入的登录密码不一致!",
							to: "new_password0"
						}
					}
				}
		};
		
		var validator_config1 = {
				password1: {
					text: "请输入原始密码",
					validators: {
						required: {
							failmsg:"原始密码不能为空"
						},
						ajax: {
							url:'system/account_checkAccountPw.action',
							param:"password",
							returnText:'ok',
							failmsg:"密码不正确，请重新输入!"
						}
					}
				},
				new_password1: {
					text: "请输入新密码",
					validators: {
						required: {
							failmsg:"新密码不能为空"
						},
						passwordID: {
						failmsg:"密码必须是由6-20位的字母和数字组成!"
						}
					}
				},
				confirm_password1: {
					text: "请输入确认密码",
					validators: {
						required: {
							failmsg:"确认密码不能为空"
						},
						equalsTo: {
							failmsg:"两次输入的登录密码不一致!",
							to: "new_password1"
						}
					}
				}
		};
		
		var validator_config2 = {
				password2: {
					text: "请输入原始密码",
					validators: {
						required: {
							failmsg:"原始密码不能为空"
						},
						ajax: {
							url:'system/account_checkAccountPw.action',
							param:"password",
							returnText:'ok',
							failmsg:"密码不正确，请重新输入!"
						}
					}
				},
				new_password2: {
					text: "请输入新密码",
					validators: {
						required: {
							failmsg:"新密码不能为空"
						},
						passwordID: {
						failmsg:"密码必须是由6-20位的字母和数字组成!"
						}
					}
				},
				confirm_password2: {
					text: "请输入确认密码",
					validators: {
						required: {
							failmsg:"确认密码不能为空"
						},
						equalsTo: {
							failmsg:"两次输入的登录密码不一致!",
							to: "new_password2"
						}
					}
				}
		};
		
		var validator_config3 = {
				password3: {
					text: "请输入原始密码",
					validators: {
						required: {
							failmsg:"原始密码不能为空"
						},
						ajax: {
							url:'system/account_checkAccountPw.action',
							param:"password",
							returnText:'ok',
							failmsg:"密码不正确，请重新输入!"
						}
					}
				},
				new_password3: {
					text: "请输入新密码",
					validators: {
						required: {
							failmsg:"新密码不能为空"
						},
						passwordID: {
						failmsg:"密码必须是由6-20位的字母和数字组成!"
						}
					}
				},
				confirm_password3: {
					text: "请输入确认密码",
					validators: {
						required: {
							failmsg:"确认密码不能为空"
						},
						equalsTo: {
							failmsg:"两次输入的登录密码不一致!",
							to: "new_password3"
						}
					}
				}
		};


		function doSave(str) {
			
			//alert(str);
			if(str==0){
				if($.brady.validator.validateForm("addForm", validator_config0)) {
				 	$.post(  
				 		'system/account_editPassword.action',  
						{  
				 			newPassword:$('#new_password0').val(),
				 			password:$('#password0').val()
						},  
					  	function (data) //回传函数  
					  	{  
					        //alert(data);
					        if(data == "ok"){
					        	showMessage("密码修改成功，请退出系统重新登录！");
					        }else{
					        	showMessage("密码修改不成功，请联系管理员！");
					        }
					   	}  
					);  
				}
			}else if(str==1){
				if($.brady.validator.validateForm("addForm", validator_config1)) {
				 	$.post(  
				 		"system/account_editPassword.action",
				 		//$("#addForm").get(0).submit(),
						{  
				 			newPassword:$('#new_password1').val(),
				 			password:$('#password1').val()
						},  
					  	function (data) //回传函数  
					  	{  
					        //alert(data);
					        if(data == "ok"){
					        	showMessage("密码修改成功，请退出系统重新登录！");
					        }else{
					        	showMessage("密码修改不成功，请联系管理员！");
					        }
					   	}

					);  
				}
			}else if(str==2){
				if($.brady.validator.validateForm("addForm", validator_config2)) {
				 	$.post(  
				 		'system/account_editPassword.action',  
						{  
				 			newPassword:$('#new_password2').val(),
				 			password:$('#password2').val()
						},  
					  	function (data) //回传函数  
					  	{  
					        //alert(data);
					        if(data == "ok"){
					        	showMessage("密码修改成功，请退出系统重新登录！");
					        }else{
					        	showMessage("密码修改不成功，请联系管理员！");
					        }
					   	}  
					);  
				}
			}else if(str==3){
				if($.brady.validator.validateForm("addForm", validator_config3)) {
				 	$.post(  
				 		'system/account_editPassword.action',  
						{  
				 			newPassword:$('#new_password3').val(),
				 			password:$('#password3').val()
						},  
					  	function (data) //回传函数  
					  	{  
					        //alert(data);
					        if(data == "ok"){
					        	showMessage("密码修改成功，请退出系统重新登录！");
					        }else{
					        	showMessage("密码修改不成功，请联系管理员！");
					        }
					   	}  
					);  
				}
			}
			
			
		}