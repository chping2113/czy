
/*
 * Included in file listNotice.jsp
 * Copyrights: KJLink
 * Author: dingyong
 * Created at 2011.3.2
 */

		var noticeId = "";
		
		function add() {
			var loadContentUrl = "info/complaint_addReq.action?pageNo=" + pageNo + "&t=" + new Date().getTime();;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function show(id) {
			var loadContentUrl = "info/complaint_show.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_close");
		}
		
		function edit(id) {
			var loadContentUrl = "info/complaint_editReq.action?id=" + id + "&pageNo=" + pageNo;
			showDialog(loadContentUrl, "btn_ok_close");
		}
		
		function del(id) {
			noticeId = id;
			showConfirm("确定删除该条记录吗？", "doConfirmDelete()");
		}
		
		function doConfirmDelete(id) {
			location.href = "info/complaint_delete.action?pageNo=" + pageNo + "&id=" + noticeId;
		}
		
		var validator_config = {
			complaint_name: {
				text: "请输入姓名",
				validators: {
					required: {
						failmsg:"姓名不能为空"
					}
				}
			},
			complaint_dept: {
				text: "请输入单位",
				validators: {
					required: {
					failmsg:"单位不能为空"
					}
				}
			},
			complaint_tel: {
				text: "请输入联系电话",
				validators: {
					required: {
						failmsg:"联系电话不能为空"
					},
					phone: {
						failmsg:"请输入正确的联系电话"
					}
				}
			},
			complaint_email: {
				text: "请输入E-mail",
				validators: {
					required: {
						failmsg:"E-mail不能为空"
					},
					email: {
						failmsg:"请输入正确的邮箱格式"
					}
				}
			},
			complaint_title: {
				text: "请输入举报主题",
				validators: {
					required: {
						failmsg:"举报主题不能为空"
					}
				}
			},
			complaint_content: {
				text: "请输入举报内容",
				validators: {
					required: {
					failmsg:"举报内容不能为空"
					}
				}
			}
		};
		
		var validator_config1 = {
				complaint_deal: {
					text: "请输入处理意见",
					validators: {
						required: {
							failmsg:"处理意见不能为空"
						},
						maxBytes: {
							max:200,
							failmsg:"信息不能大于200个字节"
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
		
		function doSave1() {
			if($.brady.validator.validateForm("addForm", validator_config1)) {
				$("#addForm").get(0).submit();
				//closeDialog();
			}
		}
	
