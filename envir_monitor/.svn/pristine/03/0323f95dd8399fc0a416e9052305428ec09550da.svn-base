<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(request.getAttribute("url") == null || "".equals(request.getAttribute("url").toString())){
	request.setAttribute("url",basePath);
}
%>
${requestScope.JSON_RESULT}
<script type="text/javascript">
	setTimeout(function(){
		top.location = '<%=request.getAttribute("url")%>';
	},1500);
</script>