
/*
 * Included in file
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.2
 */

		var keyid = "";
		
		function add() {
			var loadContentUrl = "project/projectAegis_addReq.action?pageNo=" + pageNo + "&t=" + new Date().getTime();;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function show(id) {
			var loadContentUrl = "project/projectAegis_show.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "project/projectAegis_editReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function dele(id) {
			keyid = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "project/projectAegis_delete.action?pageNo=" + pageNo + "&id=" + keyid;
		}
		
		var validator_config = {
			name: {
				text: "请输入类型名称",
				validators: {
					required: {
						failmsg:"类型名称不能为空"
					}
				}
			},
			showOrder: {
				text: "请输入显示顺序",
				validators: {
					required: {
						failmsg:"显示顺序不能为空"
					},
					number: {
						failmsg:"显示顺序必须为整数"
					}
				}
			}
		};
		var validator_projectIssue = {
				projectName: {
					text: "",
					msg_panel_id: "fail_msg_span",
					validators: {
						required: {
							failmsg:"项目名称不能为空!"
						}
					}
				}
		};
		var validator_config1 = {
			//projectName: {
			//	text: "请输入重点项目",
			//	validators: {
			//		required: {
			//			failmsg:"重点项目不能为空"
			//		}
			//	}
			//}
		};
		
		//jQuery(function() {
		//	//一级资源
		//	$("#keyproject_id").each(function(index, domEle) {
		//		$(domEle).click(function() {
		//			var checked = $(domEle).attr("checked");
		//			var firstLevelId = $(domEle).val();
		//			var childs = $("input[name='projectIds']").attr("checked", checked);
		//		});
		//	});
		//	
		//	$("input[name='projectIds']").each(function(index, domEle) {
		//		var val = $(domEle).val();
		//		$(domEle).click(function() {
		//			var checked = $(domEle).attr("checked");
		//			var firstLevelId = $(domEle).val();
		//			var childs = $("#keyproject_id").attr("checked", checked);
		//		});
		//	});
		//});
		
		function addIssue() {
			var loadContentUrl = "project/projectIssue_addRequest.action?pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function deleIssue(id,kid) {
			keyid = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete1("+id+","+kid+")");
		}
		
		function doConfirmDelete1(id,kid) {
			location.href = "project/projectIssue_delete.action?pageNo=" + pageNo + "&id=" + keyid + "&keyid="+kid;
		}
		
		function doSave() {
			if($.brady.validator.validateForm("addForm", validator_config)) {
				$("#addForm").get(0).submit();
				//closeDialog();
			}
		}
	
