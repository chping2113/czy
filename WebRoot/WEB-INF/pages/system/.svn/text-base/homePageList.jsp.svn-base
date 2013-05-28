<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/pages/common/include/core.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>安徽项目公开网-首页管理</title>
	<script type="text/javascript">
		function doSubmit(){
			/*if(c<limit){
				alert("你只选择了"+c+"条，还需选择"+(limit-c)+"条");
				return ;
			}*/
			
			alert("页面修改成功,请重新登录!");
			var approve = $("#approve").val();
			var construct = $("#construct").val();
			var land = $("#land").val();
			var aim = $("#aim").val();
			var mining = $("#mining").val();
			if(approve==construct&&approve!=0){
				alert("项目审批信息和项目建设管理信息不能显示在同一位置");
				return ;
			}
			if(approve==land&&approve!=0){
				alert("项目审批信息和土地权审批信息不能显示在同一位置");
				return ;
			}
			if(construct==land&&construct!=0){
				alert("项目建设管理信息和土地权审批信息不能显示在同一位置");
				return ;
			}
			if(aim==approve&&aim!=0){
				alert("招标投标信息和项目审批信息不能显示在同一位置");
				return ;
			}
			if(aim==construct&&aim!=0){
				alert("招标投标信息和项目建设管理不能显示在同一位置");
				return ;
			}
			if(aim==land&&aim!=0){
				alert("招标投标信息和土地权审批信息不能显示在同一位置");
				return ;
			}
			if(mining==approve&&mining!=0){
				alert("矿业权审批信息和项目审批信息不能显示在同一位置");
				return ;
			}
			if(mining==construct&&mining!=0){
				alert("矿业权审批信息和项目建设管理不能显示在同一位置");
				return ;
			}
			if(mining==land&&mining!=0){
				alert("矿业权审批信息和土地权审批信息不能显示在同一位置");
				return ;
			}
			if(mining==aim&&mining!=0){
				alert("矿业权审批信息和招标投标信息不能显示在同一位置");
				return ;
			}
			var type = $("#attachFile").val();
			if(type.length>0){
			type = type.substring(type.length-4,type.length);
				if(type==".jpg"){
					$("#homePageForm").submit();
				}else{
					alert("标题图片必须是*.jpg文件类型");
				}
			}else{
				$("#homePageForm").submit();
			}
		}
		
		//var pageNo = "${pageNo}";
		function doDelete(pid) {
			showConfirm("确定删除该条记录吗？", "doConfirmDelete("+pid+")");
		}
		
		function doConfirmDelete(pid) {
			location.href = "system/homePage_delete.action?pid=" + pid;
		}
		
		function checkAll() {
			for (var i = 0; i < document.getElementsByName("selectProject").length; i++) {
				document.getElementsByName("selectProject")[i].checked = document.getElementById("ifAll").checked;
			}
		}
		
		/*var c=0,limit=5; 
		function  doCheck(obj){ 
			obj.checked?c++:c--;
		}
		*/
	
	</script>
</head>
<body>
   <div class="right_main">
    <div class="add_top">您当前的位置：系统管理 > 首页管理</div>
    <div class="nav">
	<ul>
	<li><a id="curTab">首页管理</a></li>
	<li><a href="system/navigate_init.action">专栏快速导航</a></li>
	</ul>
	</div>
	<form id="homePageForm" action="system/homePage_add.action" method="post" enctype="multipart/form-data">
    <div class="listop_other_bg">首页样式管理 
	</div>
     
    <table cellpadding="0" cellspacing="0" class="table_add">
    <tr>
      <th width="20%">标题图片</th>
      <td>
      	<s:if test="model.logoName != null && model.logoName != ''">
      		<img style="width: 500px;height: 76px;" border="0" src="${model.logoName }" />
      	</s:if>
	  	<input type="file" name="attachFile" id="attachFile" onkeydown="return false"/>
	  	<input type="hidden" name="id" id="id" value="${model.id }"/>
	  	<input type="hidden" name="pid" id="pid" value="${pm.id }"/>
	  </td>
    </tr>
    <tr>
      <th>页脚内容</th>
      <td>
	  	<textarea name="footer" id="footer" class="input_text_area">${model.footer }</textarea>
	  </td>
    </tr>
    <tr>
      <th>投诉举报电话</th>
      <td>
	  	<textarea name="report" id="report" class="input_text_area">${model.report }</textarea>
	  </td>
    </tr>
    <s:iterator value="#list10" var="list10" >
    <tr>
      <th>${list10.title}</th>
      <td>
	  	<select name="approve" id="approve">
	  		<option value="0" ${model.approve == 0 ? "selected" : "" }>--不显示--</option>
	  		<option value="1" ${model.approve == 1 ? "selected" : "" }>--位置1--</option>
	  		<option value="2" ${model.approve == 2 ? "selected" : "" }>--位置2--</option>
	  		<option value="3" ${model.approve == 3 ? "selected" : "" }>--位置3--</option>
	  		<option value="4" ${model.approve == 4 ? "selected" : "" }>--位置4--</option>
	  		<option value="5" ${model.approve == 5 ? "selected" : "" }>--位置5--</option>
	  	</select>
	  </td>
    </tr>
    </s:iterator>
    <s:iterator value="#list11" var="list11 ">
    <tr>
      <th>${list11.title}</th>
      <td>
	  	<select name="construct" id="construct">
	  		<option value="0" ${model.construct == 0 ? "selected" : "" }>--不显示--</option>
	  		<option value="1" ${model.construct == 1 ? "selected" : "" }>--位置1--</option>
	  		<option value="2" ${model.construct == 2 ? "selected" : "" }>--位置2--</option>
	  		<option value="3" ${model.construct == 3 ? "selected" : "" }>--位置3--</option>
	  		<option value="4" ${model.construct == 4 ? "selected" : "" }>--位置4--</option>
	  		<option value="5" ${model.construct == 5 ? "selected" : "" }>--位置5--</option>
	  	</select>
	  </td>
    </tr>
    </s:iterator>
    <s:iterator value="#list12" var="list12" >
    <tr>
      <th>${list12.title}</th>
      <td>
	  	<select name="land" id="land">
	  		<option value="0" ${model.land == 0 ? "selected" : "" }>--不显示--</option>
	  		<option value="1" ${model.land == 1 ? "selected" : "" }>--位置1--</option>
	  		<option value="2" ${model.land == 2 ? "selected" : "" }>--位置2--</option>
	  		<option value="3" ${model.land == 3 ? "selected" : "" }>--位置3--</option>
	  		<option value="4" ${model.land == 4 ? "selected" : "" }>--位置4--</option>
	  		<option value="5" ${model.land == 5 ? "selected" : "" }>--位置5--</option>
	  	</select>
	  </td>
    </tr> 
    </s:iterator>
    <s:iterator value="#list13" var="list13" >
    <tr>
      <th>${list13.title}</th>
      <td>
	  	<select name="mining" id="mining">
	  		<option value="0" ${model.mining == 0 ? "selected" : "" }>--不显示--</option>
	  		<option value="1" ${model.mining == 1 ? "selected" : "" }>--位置1--</option>
	  		<option value="2" ${model.mining == 2 ? "selected" : "" }>--位置2--</option>
	  		<option value="3" ${model.mining== 3 ? "selected" : "" }>--位置3--</option>
	  		<option value="4" ${model.mining == 4 ? "selected" : "" }>--位置4--</option>
	  		<option value="5" ${model.mining == 5 ? "selected" : "" }>--位置5--</option>
	  	</select>
	  </td>
    </tr>
    </s:iterator>
    <s:iterator value="#list14" var="list14" >
    <tr>
      <th>${list14.title}</th>
      <td>
	  	<select name="aim" id="aim">
	  		<option value="0" ${model.aim == 0 ? "selected" : "" }>--不显示--</option>
	  		<option value="1" ${model.aim == 1 ? "selected" : "" }>--位置1--</option>
	  		<option value="2" ${model.aim == 2 ? "selected" : "" }>--位置2--</option>
	  		<option value="3" ${model.aim == 3 ? "selected" : "" }>--位置3--</option>
	  		<option value="4" ${model.aim == 4 ? "selected" : "" }>--位置4--</option>
	  		<option value="5" ${model.aim == 5 ? "selected" : "" }>--位置5--</option>
	  	</select>
	  </td>
    </tr>
    </s:iterator>
    <!-- 项目管理 -->
   
      	
    
    <table cellpadding="0" cellspacing="0" class="table_list">
    	
		项目管理<a href="system/homePage_addProject.action"><img 
		src="images/add.jpg" border="0"/></a>
		
    <tr>
    	 <th><input type="checkbox" name="ifAll" id="ifAll" onclick="checkAll()" /></th>
    	 
      <th>专栏名称 </th>
      
		
	  <th>链接URL</th>
	
	  
	  <th>顺序</th>
	  <th>操作</th>
     </tr>
     	    
    <s:iterator value="#session.projectManager" var="pm" >
     <tr>
     <td><input type="checkbox" name="selectProject" id="selectProject" value="${pm.id}" onclick="doCheck(this)" /></td>
       <td>${pm.title}</td> 
       <td>
       ${pm.url } 
	   </td>
	   
	   <td>
	  ${pm.position}
		</td>
		
		<td class="table_list_add">
      	<a href="system/homePage_view.action?pid=${pm.id}">查看</a>
		<a href="system/homePage_initEdit.action?pid=${pm.id }">修改</a>
		<a href="javascript:doDelete(${pm.id })">删除</a>
      	
      </td>
     </tr>
     </s:iterator>
     </table>
	
    
    
    </table>
    </form>
    <div class="add_savebtn">
    	<a href="javascript:doSubmit()"><img src="images/save.gif" border="0"/></a>
    	<a href="javascript:history.back()"><img src="images/back00.gif" border="0" /></a>
    </div>
 </div>  <!--right_main-->
<brady:confirm />
</body>