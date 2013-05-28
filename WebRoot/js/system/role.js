
/*
 * Included in file listRole.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

		var roleId = "";
		var selectedRoleId = "";
		
		function add() {
			var loadContentUrl = "system/role_addReq.action?pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function edit(id) {
			var loadContentUrl = "system/role_editReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function show(id) {
			var loadContentUrl = "system/role_show.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function del(id) {
			roleId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "system/role_delete.action?pageNo=" + pageNo + "&id=" + roleId;
		}
		
		var validator_config = {
				name: {
					text: "请输入唯一的角色名称",
					validators: {
						required: {
							failmsg:"角色名称不能为空!"
						},
						ajax: {
							url:'system/role_checkName.action',
							param:"name",
							returnText:'ok',
							failmsg:"该角色已经存在!"
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
				
				selectedRoleId = treeNode.id;
				$("#organName").val(treeNode.name);
				$("#organId").val(selectedRoleId);
				$("#organDiv").hide("fast");
				$("#organName").get(0).focus();
			}
			
			function selectOrgan() {
				var organNameObj = $("#organName");
				var organNameOffset = $("#organName").offset();
				$("#organDiv").css({left:organNameOffset.left - 80 + "px", top: "5px"});
				$("#organDiv").show("fast");
			}