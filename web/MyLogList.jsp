<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>

<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">校园宿舍管理系统</td>
    </tr>
    <tr>
      <td height="30" background="Images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="Images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">学生缺寝记录</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="MyLogList2.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td height="30" colspan="2" align="center" class="STYLE2"><span
                            style="color:red;">
                      ${msg}
                    </span></td>
                  </tr>
                  <tr>
                    <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="MyStudent.action">返回上层</a></td>
                    <td width="72%">查询：
                      <select name="Student_DomitoryID" id="Student_DomitoryID">
                        <option value="0">请选择</option>
                        <c:forEach items="${dsl}" var="d">
                        <option value="${d.domitory_ID}">${d.domitory_Name}</option>
                        </c:forEach>
                      </select>
                      学号:
                      <input name="Student_Username" type="text" class="text1" id="Student_Username">
                      <input type="submit" name="button" id="button" value="点击查询">
                      <label for="Building_ID"></label>
                      <input name="Building_ID" type="text" class="noshow" id="Building_ID" value="${Building_ID}"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>寝室号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>学号</strong></td>
                    <td bgcolor="#D5E4F4"><strong>姓名</strong></td>
                    <td bgcolor="#D5E4F4"><strong>性别</strong></td>
                    <td bgcolor="#D5E4F4"><strong>班级</strong></td>
                    <td bgcolor="#D5E4F4"><strong>日期</strong></td>
                    <td bgcolor="#D5E4F4"><strong>备注</strong></td>
                    </tr>
                  <c:forEach items="${dsl}" var="ds">
                    <c:set value="${ds.studentList}" var="ss"/>
                     <c:forEach items="${ss}" var="s">
                        <c:set value="${s.logList}" var="ll"/>
                          <c:forEach items="${ll}" var="l">
                    <tr align="center">
                      <td height="25" align="center">${ds.domitory_Name}</td>
                      <td>${s.student_Username}</td>
                      <td>${s.student_Name}</td>
                      <td>${s.student_Sex}</td>
                      <td>${s.student_Class}</td>
                      <td>${l.log_Date}</td>
                      <td>${l.log_Remark}</td>
                      </tr>
                  </c:forEach>
                     </c:forEach>
                        </c:forEach>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
      <td height="35" background="Images/bootBg.jpg">&nbsp;</td>
    </tr>
  </table>

</center>
</body>
</html>
