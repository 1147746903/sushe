<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>校园宿舍管理系统</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="Style/Style.css" rel="stylesheet" type="text/css" />
</head>
<script language="JavaScript">


function mycheck(){
   if(isNull(form1.Domitory_BuildingID.value)){  
   alert("请选择楼宇！"); 
   return false;
   }
   if(isNull(form1.Domitory_Name.value)){
   alert("请输入寝室号！");
   return false;
   }
   if(isNull(form1.Domitory_NullNumber.value)){
   alert("请输入寝室床位数！");
   return false;
   }
}

function isNull(str){
if ( str == "" ) return true;
var regu = "^[ ]+$";
var re = new RegExp(regu);
return re.test(str);
}
   
   
</script>
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
              <td height="30" background="Images/mainMenuBg.jpg" style="padding-left:25px;">修改宿舍</td>
            </tr>
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="DomitoryUpdateSave.action" onSubmit="return mycheck()" >
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
                    <td width="33%" height="30" align="right">&nbsp;</td>
                    <td width="67%"><input name="Domitory_ID" type="text" class="noshow" id="Domitory_ID" value="${domitory.domitory_ID}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>楼宇：</td>
                    <td><select name="Domitory_BuildingID" id="Domitory_BuildingID">
                      <option value="">请选择</option>
                      <c:forEach items="${building}" var="b">
                        <option value="${b.building_ID}"
                                <c:if test="${domitory.domitory_BuildingID == b.building_ID}">selected</c:if>
                        >${b.building_Name}</option>
                      </c:forEach>
                    </select></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>寝室号：</td>
                    <td><input name="Domitory_Name" type="text" class="text2" id="Domitory_Name" value="${domitory.domitory_Name}"></td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>床位数：</td>
                    <td><select name="Domitory_NullNumber" id="Domitory_NullNumber">
                      <option value="0"
                              <c:if test="${domitory.domitory_NullNumber == 0 }">selected</c:if>
                      >请选择</option>
                      <option value="4"
                              <c:if test="${domitory.domitory_NullNumber == 4 }">selected</c:if>
                      >4人寝</option>
                      <option value="6"
                              <c:if test="${domitory.domitory_NullNumber == 6 }">selected</c:if>
                      >6人寝</option>
                      <option value="8"
                              <c:if test="${domitory.domitory_NullNumber == 8 }">selected</c:if>
                      >8人寝</option>
                    </select>
                    </td>
                  </tr>
                  <tr>
                    <td height="30" align="right"><span style="color:red;">*</span>备注：</td>
                    <td><textarea name="Domitory_Remarks" id="Domitory_Remarks" cols="45" rows="5">${domitory.domitory_Remarks}</textarea></td>
                  </tr>
                  <tr>
                    <td height="30">&nbsp;</td>
                    <td><input type="submit" name="button" id="button" value="修改宿舍">
                      &nbsp;&nbsp;
                      <input type="button" name="button2" id="button2" value="返回上页" onClick="javascript:history.back(-1);"></td>
                  </tr>
                </table>
              </form></td>
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
