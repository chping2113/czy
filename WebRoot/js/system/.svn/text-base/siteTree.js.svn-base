
/*
 * Included in file organTree.jsp
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
		selectedOrganId = treeNode.id;
		$.post("system/site_show.action", {"id": selectedOrganId}, function(data) {
        	$("#tree_node").html(data);
    	})
	}
	
    function mod(type) {
    	if(selectedOrganId == "") {
    		alert("必须选择一个具体的组织机构才能进行操作！");
    		return;
    	}
    	
    	var loadContentUrl = "system/organ_addChildReq.action?parentId=" + selectedOrganId;
    	if(type == 'edit') {
    		loadContentUrl = "system/organ_editReq.action?id=" + selectedOrganId;
    	}
    	showDialog(loadContentUrl, "btn_ok_close");
    }
    
    function del() {
    	showConfirm("确定删除该组织机构吗？", "doDelete()");
    }
 
    function doDelete() {
    	location.href = "system/organ_delete.action?id=" + selectedOrganId;
    }

  
    
	var validator_config = {
			code: {
				text: "在此输入组织机构代码,该代码不能重复!",
				validators: {
					required: {
						failmsg:"组织机构代码不能为空!"
					}
				}
			},
			name: {
				text: "在此输入组织机构名称!",
				validators: {
					required: {
						failmsg:"组织机构名称不能为空!"
					}
				}
			},
			tel: {
				text: "在此输入电话,如:13911110000或0551-1234567",
				validators: {
					phone: {
						failmsg:"您输入的不是一个有效的电话号码!"
					}
				}
			},
			report: {
				text: "在此输入电话,如:13911110000或0551-1234567",
				validators: {
					phone: {
						failmsg:"您输入的不是一个有效的电话号码!"
					}
				}
			}
	};
	