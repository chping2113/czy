//弹出式查询窗口的确定按钮的click事件处理函数
function doQueryOK(_id,_name) {
	var id = $("input[name='radioEmp']:checked").val();
	if(id) {
		$("#"+_id).val(id);
		$("#"+_name).val($.trim($("#name_" + id).text()));
		$("#"+_name).focus().blur();
	}
}
function doQueryOK2(_id,_name,_code) {
	var id = $("input[name='radioEmp']:checked").val();
	if(id) {
		$("#"+_id).val(id);
		$("#"+_name).val($.trim($("#name_" + id).text()));
		$("#"+_name).focus().blur();

		$("#"+_code).val($.trim($("#code_" + id).text()));
		$("#"+_code).focus().blur();
	}
}
function changePersonBadrecord(obj){
	var url = "credit/personBadrecord_changeAdd.action";
	var param = {"type":obj.value};
	$.post(url,param,function(date) {
		$("#personBadrecordType").empty().html(date);
	});
}

function changeCompanyBadrecord(obj){
	var url = "credit/companyBadrecord_changeAdd.action";
	var param = {"type":obj.value};
	$.post(url,param,function(date) {
		$("#companyBadrecordType").html(date);
	});
}


var validator_personQualification = {
		name: {
			text: "",
			validators: {
				required: {
					failmsg:"证书名称不能为空!"
				}
			}
		},personName: {
			text: "",
			msg_panel_id: "fail_msg_span",
			validators: {
				required: {
					failmsg:"姓名不能为空!"
				}
			}
		},certificateCode: {
			text: "",
			validators: {
				required: {
					failmsg:"证件号码不能为空!"
				},
				personID: {
					failmsg:"你输入的不是一个有效的身份证号码!"
				}
			}
		}
	};
var validator_personHonor = {
	personName: {
		text: "",
		msg_panel_id: "fail_msg_span",
		validators: {
			required: {
				failmsg:"姓名不能为空!"
			}
		}
	},
	honorOrgan: {
		text: "请输入颁发机构!",
		validators: {
			required: {
				failmsg:"颁发机构不能为空!"
			}
		}
	},
	honorCode: {
		text: "请输入荣誉文书编号!",
		validators: {
			required: {
				failmsg:"荣誉文书编号不能为空!"
			}
		}
	},
	honorDate: {
		text: "请输入荣誉认证日期!",
		validators: {
			required: {
				failmsg:"荣誉认证日期不能为空!"
			}
		}
	},
	honorContent: {
		text: "",
		validators: {

			maxBytes: {
				max:500,
				failmsg:"荣誉内容不能大于500个字节"
			}
		}
	},
	certificateCode: {
		text: "",
		validators: {
			required: {
				failmsg:"证件号码不能为空!"
			},
			personID: {
				failmsg:"你输入的不是一个有效的身份证号码!"
			}
		}
	}
};

var validator_personBadrecord = {
	personName: {
		text: "",
		msg_panel_id: "fail_msg_span",
		validators: {
			required: {
				failmsg:"姓名不能为空!"
			}
		}
	},
	adjudgeOrgan: {
		text: "请输入判决机关!",
		validators: {
			required: {
				failmsg:"判决机关不能为空!"
			}
		}
	},
	certificateCode:{
		text: "请输入证件号码!",
		validators: {
			required: {
				failmsg:"证件号码不能为空!"
			},
			personID: {
				failmsg:"你输入的不是一个有效的身份证号码!"
			}
		}
	}
};

var validator_personIllegal = {
	personName: {
		text: "",
		validators: {
			required: {
				failmsg:"人员不能为空!"
			}
		}
	},
	adjudgeOrgan: {
		text: "请输入判决机关!",
		validators: {
			required: {
				failmsg:"判决机关不能为空!"
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
				failmsg:"你输入的不是一个有效的身份证号码!"
			}
		}
	}
};

var validator_personPunish = {
	personName: {
		text: "",
		validators: {
			required: {
				failmsg:"人员不能为空!"
			}
		}
	},
	punishOrgan: {
		text: "请输入处罚机关!",
		validators: {
			required: {
				failmsg:"处罚机关不能为空!"
			}
		}
	},
	punishObject: {
		text: "请输入处罚对象!",
		validators: {
			required: {
				failmsg:"处罚对象不能为空!"
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
				failmsg:"你输入的不是一个有效的身份证号码!"
			}
		}
	}
};

var validator_companyQualification = {
		companyName: {
	text: "",
	msg_panel_id: "fail_msg_span",
	validators: {
		required: {
			failmsg:"企业名称不能为空!"
		}
	}
},
licenseCode: {
	text: "",
	validators: {
		required: {
			failmsg:"营业执照注册号不能为空!"
		}
	}
},
		name: {
			text: "",
			validators: {
				required: {
					failmsg:"资质等级名称不能为空!"
				}
			}
		}
	};
var validator_companyHonor = {
	companyName: {
		text: "",

		msg_panel_id: "fail_msg_span",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	},
	honorOrgan: {
		text: "请输入颁发机构!",
		validators: {
			required: {
				failmsg:"颁发机构不能为空!"
			}
		}
	},
	honorCode: {
		text: "请输入荣誉文书编号!",
		validators: {
			required: {
				failmsg:"荣誉文书编号不能为空!"
			}
		}
	},
	honorContent: {
		text: "",
		validators: {

			maxBytes: {
				max:500,
				failmsg:"荣誉内容不能大于500个字节"
			}
		}
	}
};

var validator_companyBadrecord = {
	companyName: {
		text: "",
		msg_panel_id: "fail_msg_span",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	},
	adjudgeOrgan: {
		text: "请输入判决机关!",
		validators: {
			required: {
				failmsg:"判决机关不能为空!"
			}
		}
	},
	punishObject: {
		text: "请输入处罚对象!",
		validators: {
			required: {
				failmsg:"处罚对象不能为空!"
			}
		}
	}
};

var validator_companyIllegal = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	adjudgeOrgan: {
		text: "请输入判决机关!",
		validators: {
			required: {
				failmsg:"判决机关不能为空!"
			}
		}
	},
	punishObject: {
		text: "请输入处罚对象!",
		validators: {
			required: {
				failmsg:"处罚对象不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};

var validator_companyPunish = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	punishOrgan: {
		text: "请输入判决机关!",
		validators: {
			required: {
				failmsg:"判决机关不能为空!"
			}
		}
	},
	punishObject: {
		text: "请输入处罚对象!",
		validators: {
			required: {
				failmsg:"处罚对象不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};

var validator_companyQuality = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	},
	accidentInfo: {
		text: "",
		validators: {

			maxBytes: {
				max:500,
				failmsg:"荣誉内容不能大于500个字节"
			}
		}
	},
	criticize: {
		text: "",
		validators: {

			maxBytes: {
				max:500,
				failmsg:"荣誉内容不能大于500个字节"
			}
		}
	}
};
var validator_companyRuling = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	rulingOrgan: {
		text: "请输入行政裁决机关!",
		validators: {
			required: {
				failmsg:"行政裁决机关不能为空!"
			}
		}
	},
	rulingCode: {
		text: "请输入行政裁决书编号!",
		validators: {
			required: {
				failmsg:"行政裁决书编号不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};

var validator_companyMalicious = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	maliciousBegin: {
		text: "请输入欠薪开始时间!",
		validators: {
			required: {
				failmsg:"欠薪开始时间不能为空!"
			}
		}
	},
	maliciousEnd: {
		text: "请输入欠薪结束时间!",
		validators: {
			required: {
				failmsg:"欠薪结束时间不能为空!"
			}
		}
	},
	maliciousMoney: {
		text: "请输入欠薪总额!",
		validators: {
			number: {
				failmsg:"欠薪总额必须为数字!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};
var validator_companyWage = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	wageBegin: {
		text: "请输入欠薪开始时间!",
		validators: {
			required: {
				failmsg:"欠薪开始时间不能为空!"
			}
		}
	},
	wageEnd: {
		text: "请输入欠薪结束时间!",
		validators: {
			required: {
				failmsg:"欠薪结束时间不能为空!"
			}
		}
	},
	wageMoney: {
		text: "请输入欠薪总额!",
		validators: {
			number: {
				failmsg:"欠薪总额必须为数字!"
			}
		}
	},wageInsurance:{
		text: "请输入欠缴社会保险各类及金额",
		validators: {
			maxBytes: {
				max:500,
				failmsg:"欠缴社会保险各类及金额不能大于500个字节"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};

var validator_companyForce = {
	companyName: {
		text: "",
		validators: {
			required: {
				failmsg:"企业名称不能为空!"
			}
		}
	},
	forceOrgan: {
		text: "请输入行政强制机关!",
		validators: {
			required: {
				failmsg:"行政强制机关不能为空!"
			}
		}
	},
	forceCode: {
		text: "请输入行政强制决定文书编号!",
		validators: {
			required: {
				failmsg:"行政强制决定文书编号不能为空!"
			}
		}
	},
	licenseCode: {
		text: "",
		validators: {
			required: {
				failmsg:"营业执照注册号不能为空!"
			}
		}
	}
};

var validator_companyCredit = {
		companyName: {
			text: "请输入企业名称!",
			msg_panel_id: "fail_msg_span",
			validators: {
				required: {
					failmsg:"企业名称不能为空!"
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
					url:'credit/companyCredit_checkCode.action',
					param:"companyCredit.licenseCode",
					returnText:'ok',
					failmsg:"该营业执照注册号已经存在，请重新输入!"
				}
			}
		},
	evaluateOrgan: {
		text: "请输入评价机构!",
		validators: {
			required: {
				failmsg:"评价机构不能为空!"
			}
		}
	},
	evaluateDate: {
		text: "请输入评价日期!",
		validators: {
			required: {
				failmsg:"评价日期不能为空!"
			}
		}
	},
	industryCredit: {
		text: "请输入行业信用评价结果!",
		validators: {
			required: {
				failmsg:"行业信用评价结果不能为空!"
			}
		}
	}
};
var validator_companyAchieve = {
		companyName: {
			text: "请输入企业名称!",
			msg_panel_id: "fail_msg_span",
			validators: {
				required: {
					failmsg:"企业名称不能为空!"
				}
			}
		},
		licenseCode: {
			text: "请输入营业执照注册号!",
			validators: {
				required: {
					failmsg:"营业执照注册号不能为空!"
				}
			}
		},
		name: {
			text: "请输入项目名称!",
			validators: {
				required: {
					failmsg:"项目名称不能为空!"
				}
			}
		}
	};
var validator_companyInfo = {
		companyName: {
			text: "请输入企业名称!",
			validators: {
				required: {
					failmsg:"企业名称不能为空!"
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
					url:'credit/companyInfo_checkCode.action',
					param:"companyInfo.licenseCode",
					returnText:'ok',
					failmsg:"该营业执照注册号已经存在，请重新输入!"
				}
			}
		},
		
		registerMoney:{
			text: "",
			validators: {
				number: {
					failmsg:"注册资本必须为数字!"
				}
			}
		},
		realMoney:{
			text: "",
			validators: {
				number: {
					failmsg:"实缴注册资本必须为数字!"
				}
			}
		}
		
		
	};
var validator_personInfo = {
		name: {
			text: "请输入姓名",
			validators: {
				required: {
					failmsg:"姓名不能为空"
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
					failmsg:"你输入的不是一个有效的身份证号码!"
				},
				ajax: {
					url:'credit/personInfo_checkCode.action',
					param:"personInfo.certificateCode",
					returnText:'ok',
					failmsg:"该证件号码已经存在，请重新输入!"
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
				}
			}
		}
	};