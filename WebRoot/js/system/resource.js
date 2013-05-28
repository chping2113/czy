
/*
 * Included in file resourceTree.jsp
 * Copyrights: KJLink
 * Author: zhanggj
 * Created at 2011.2.23
 */

	var setting = {
		expandSpeed: "",
		checkable: false,
		showLine: true,
		callback:{
			click:zTreeOnClick
		}
	};
	
	function buildTree() {
		zTree = $("#tree_div").zTree(setting, zNodes);
	}
	
	function zTreeOnClick(event, treeId, treeNode) {
		//alert( "id=" + treeNode.id + "; name=" + treeNode.name);
		selectedResId = treeNode.id;
		$.post("system/role_showResource.action", {"resourceId": selectedResId}, function(data) {
        	$("#tree_node").html(data);
    	})
	}
	
	function addFirstRes() {
		var loadContentUrl = "system/role_addFirstResReq.action?roleId=" + roleId;
		showDialog(loadContentUrl, "btn_ok_close");
	}
	
	function addChildRes() {
		if(selectedResId == "") {
    		alert("必须选择一个具体的系统资源才能进行操作！");
    		return;
    	}
		var loadContentUrl = "system/role_addChildResReq.action?roleId=" + roleId + "&parentResourceId=" + selectedResId;
		showDialog(loadContentUrl, "btn_ok_close");
	}
	
    function edit() {
    	if(selectedResId == "") {
    		alert("必须选择一个具体的系统资源才能进行操作！");
    		return;
    	}
    	
    	var loadContentUrl = "system/role_editResReq.action?roleId=" + roleId + "&resourceId=" + selectedResId;
    	showDialog(loadContentUrl, "btn_ok_close");
    }
    
    function del() {
    	showConfirm("确定删除该系统资源吗？", "doDelete()");
    }
    
    function doDelete() {
    	location.href = "system/role_deleteResource.action?roleId=" + roleId + "&resourceId=" + selectedResId;
    }

    function doSave() {
		if($.brady.validator.validateForm("addForm", validator_config)) {
			$("#addForm").get(0).submit();
		}
	}
    
	var validator_config = {
			res_title: {
				text: "请输入资源名称!",
				validators: {
					required: {
						failmsg:"资源名称不能为空!"
					}
				}
			},
			position: {
				text: "请输入显示顺序！",
				validators: {
					required: {
						failmsg:"显示顺序不能为空!"
					},
					digit: {
						failmsg:"显示顺序必须是一个整数!"
					}
				}
			}
	};
	