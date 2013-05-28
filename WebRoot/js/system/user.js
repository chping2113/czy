
/*
 * Included in file organTree.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var userId = "";
		var selectedOrganId = "";
		
		function doExecute(action, id) {
			var loadContentUrl = "system/user_addReq.action?id=" + id + "&pageNo=" + pageNo;
			var dialogType = "btn_ok_close";
			
			if(action == "view") {
				loadContentUrl = "system/user_show.action?id=" + id;
				dialogType = "btn_close";
			}
			showDialog(loadContentUrl, dialogType);
		}
		
		function doDelete(id) {
			userId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/user_delete.action?pageNo=" + pageNo + "&id=" + userId;
		}
		
		var validator_config = {
				code: {
					text: "在此输入审批用户的登录帐号,该帐号不能重复!",
					validators: {
						required: {
							failmsg:"用户登录帐号不能为空!"
						},
						ajax: {
							url:'system/user_checkCode.action',
							param:"code",
							returnText:'ok',
							failmsg:"该登录帐号已经存在，请重新输入!"
						}
					}
				},
				password: {
					text: "在此输入审批用户的登录密码!",
					validators: {
						required: {
							failmsg:"用户登录密码不能为空!"
						}
					}
				},
				password2: {
					text: "请再此输入与上面相同的登录密码!",
					validators: {
						required: {
							failmsg:"用户登录确认密码不能为空!"
						},
						equalsTo: {
							failmsg:"两次输入的登录密码不一致!",
							to: "password"
						}
					}
				},
				roleId: {
					text: "请选择一个角色",
					validators: {
						selected: {
							ignoreEmpty:false, 
							failmsg:"必须选择一个角色"
						}
					}
				},
				organName: {
					text: "请为当前用户选择一个组织机构！",
					msg_panel_id: "fail_msg_span",
					validators: {
						required: {
							failmsg:"组织机构不能为空!"
						}
					}
				},
				email: {
					text: "请输入邮箱地址！",
					validators: {
						required: {
							failmsg:"邮箱地址不能为空!"
						},
						email: {
							failmsg:"邮箱地址的格式不正确!"
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
				}
		};
		
		function doSave() {
			if($.brady.validator.validateForm("addForm", validator_config)) {
				$("#addForm").get(0).submit();
				closeDialog();
			}
		}
	
		var ztreeSetting = {
				expandSpeed: "",
				checkable: false,
				showLine: true,
				callback:{
					click:zTreeOnClick
				}
			};
			
			function buildTree() {
				zTree = $("#organTree").zTree(ztreeSetting, organTreeData);
			}
			
			function zTreeOnClick(event, treeId, treeNode) {
				//alert( "id=" + treeNode.id + "; name=" + treeNode.name);
				
				selectedOrganId = treeNode.id;
				$("#organName").val(treeNode.name);
				$("#organId").val(selectedOrganId);
				$("#organDiv").hide("fast");
				$("#organName").get(0).focus();
			}
			
			function selectOrgan() {
				var organNameObj = $("#organName");
				var organNameOffset = $("#organName").offset();
				$("#organDiv").css({left:organNameOffset.left - 80 + "px", top: "5px"});
				$("#organDiv").show("fast");
			}