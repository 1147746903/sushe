<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Title</title>
</head>
<body>
<tr>
    <td width="22%" height="30" style="padding-left:20px;"> 功能导航： <a href="DomitoryAdd.action">添加宿舍</a></td>
    <td width="78%">查询：
        <select name="Domitory_BuildingID" id="Domitory_BuildingID">
            <option value="">全部楼宇</option>
            <c:forEach items="${building}" var="b">
                <option value="${b.building_ID}">${b.building_Name}</option>
            </c:forEach>
        </select>
        <select name="SearchRow" id="SearchRow">
            <option value="寝室号">寝室号</option>
            <option value="有空床">有空床</option>
        </select>
        <input name="SearchKey" type="text" class="text1" id="SearchKey">
        <input type="submit" name="button" id="button" value="点击查询"></td>
</tr>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr align="center"  class="t1">
        <td height="25" bgcolor="#D5E4F4"><strong>楼宇</strong></td>
        <td bgcolor="#D5E4F4"><strong>寝室号</strong></td>
        <td bgcolor="#D5E4F4"><strong>寝室人数</strong></td>
        <td bgcolor="#D5E4F4"><strong>空床数</strong></td>
        <td bgcolor="#D5E4F4"><strong>备注</strong></td>
        <td bgcolor="#D5E4F4"><strong>操作</strong></td>
    </tr>
    <c:forEach items="${domitory}" var="d" varStatus="loop">
        <tr align="center">
            <td height="25" align="center">${building[loop.count-1].building_Name}</td>
            <td>${d.domitory_Name}</td>
            <td>${d.domitory_Number}</td>
            <td align="center">${d.domitory_NullNumber}</td>
            <td align="center">${d.domitory_Remarks}</td>
            <td align="center"><a href="DomitoryUpdate.action?Domitory_ID=${Domitory_ID}">修改</a> <a href="DomitoryDel.action?Domitory_ID=${Domitory_ID}" onClick="return confirm('确定要删除该宿舍吗？')">删除</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
