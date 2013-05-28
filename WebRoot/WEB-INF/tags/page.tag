<%@ tag body-content="empty" import="java.util.* , com.brady.common.page.PageInfoImpl" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<%@ attribute name="pageInfo" required="true" rtexprvalue="true" type="com.brady.common.page.PageInfo"%>
<%@ attribute name="url" required="true" rtexprvalue="true"%>
<%@ attribute name="params" required="false" rtexprvalue="true"%>

<script type="text/javascript">
<!--
var url = "${url}";
var params = "${params}";

function gotoPage(page) {
	var tmp = "";
	if(url.indexOf("?") >= 0) {
		tmp = url + "&pageNo=" + page;
	} else {
		tmp = url + "?pageNo=" + page;
	}
	if(params != null && params.length > 0) {
		tmp = tmp + "&" + encodeURI(params);
	}
	//tmp = tmp + "&t=" + new Date().getTime();

	window.location.href = tmp;
	
	/*
	$.post(tmp, function(date) {
		$("#right_main").html(date);
	});
	*/
}

function page_stopEvent(evt) {
	if(window.addEventListener) {
		evt.stopPropagation();
		evt.preventDefault();
	} else {
		evt.cancelBubble = true;
		evt.returnValue = false;
	}
}

function page_changed(evt){
	if(evt.keyCode == 13) {
		var pa = parseInt(document.getElementById('gogogo').value);
		if(pa >= 1 &&pa <= ${pageInfo.pageCount }){
			gotoPage(pa);
			page_stopEvent(evt);
		}else{
			alert("跳转的页面数必须是一个1和${pageInfo.pageCount }之间的整数!");
			document.getElementById('gogogo').value = '';
			document.getElementById('gogogo').focus();
			page_stopEvent(evt);
		}
	}
	return true;
}

function jumpPage() {
		var pa = parseInt(document.getElementById('gogogo').value);
		if(pa >= 1 &&pa <= ${pageInfo.pageCount }){
			gotoPage(pa);
		}else{
			alert("跳转的页面数必须是一个1和${pageInfo.pageCount }之间的整数!");
			document.getElementById('gogogo').value = '';
			document.getElementById('gogogo').focus();
		}
}
//-->
</script>
 <s:if test="pageInfo.totalRecords > 0">
 	<div class="righ_page">
    	 跳转至<input id="gogogo" type="text" class="page_input" value="${pageInfo.currentPageNo}"  onkeypress="page_changed(event)" />页<a href="javascript:jumpPage()"><img src="images/go.gif" border="0"/></a>
    	 共${pageInfo.pageCount }页/${pageInfo.totalRecords }条数据
     </div>
     
	<div class="page_spanone">
    	<ul>
	 	<% 
			Object obj = this.getJspContext().getAttribute("pageInfo");
			PageInfoImpl map = (PageInfoImpl)obj;
			
			int max = map.getPageCount(); //共有多少页
			int c = map.getCurrentPageNo();//当前页码
			
			int i = 1; //循环起始编号
			int k = max; //循环结束编号
			
			if(max<=6){//每页显示6个
				
			}else if(c<=3){
				k = 6;
			}else if(c+5>=max){
				i = max-5;
			}else{
				i = c - 2;
				k = c + 3;
			}
			
			if(c <= 1) {
				out.print("<li><span class='disabled'>&lt;&lt;</span></li>");
			} else {
				out.print("<li><a href='javascript: gotoPage(" + (c-1) + ")'>&lt;&lt;</a></li>");
			}
			
			if(i > 1) {
				out.print("<li><a href='javascript: gotoPage(1)'>1</a></li>");
				out.print("<li><span class='dot'>...</span></li>");
			}
			
			for(; i<=k; i++){
				this.getJspContext().setAttribute("i",i);
				
				if(i == c) {
					out.print("<li><span class='page_in'>" + i + "</span></li>");
				} else {
					out.println("<li><a href='javascript: gotoPage(" + i + ")'>" + i + "</a></li>");
				}
			}
			
			if(k < max) {
				out.print("<li><span class='dot'>...</span></li>");
				out.print("<li><a href='javascript: gotoPage(" + max + ")'>" + max + "</a></li>");
			}
			
			if(c >= max) {
				out.print("<li><span class='disabled'>&gt;&gt;</span></li>");
			} else {
				out.print("<li><a href='javascript: gotoPage(" + (c+1) + ")'>&gt;&gt;</a></li>");
			}
		%>
		
     	</ul>
     </div>
     
</s:if>
<s:else>
	<div style="text-align:center; font-size:12px;">没有搜索到符合条件的结果！</div>
</s:else>
