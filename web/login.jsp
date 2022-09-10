<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>校园宿舍管理系统</title>
    <link href="Style/Style.css" rel="stylesheet" type="text/css"/>
</head>
<script language="JavaScript">
    function mycheck() {
        if (form1.type.value == "") {
            alert("请选择身份！");
            return false;
        }
        if (form1.username.value == "") {
            alert("请输入用户名！");
            return false;
        }
        if (form1.password.value == "") {
            alert("请输入密码！");
            return false;
        }
        return true;
    }
</script>

<body>
<center>
    <br><br><br><br><br>
    <table width="684" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="292" align="center" valign="top" background="Images/LoginBg.jpg">
                <table width="350" height="201" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="72" align="center"><h3>校园宿舍管理系统</h3></td>
                    </tr>
                    <tr>
                        <td align="center" valign="top">
                            <form name="form1" action="${pageContext.request.contextPath}/login.action" method="post"
                                  onSubmit="return mycheck()">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td height="30" colspan="2" align="center" class="STYLE2"><span
                                                style="color:red;">
                                            ${msg}
                                        </span></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">身份：</td>
                                        <td align="left"><select name="type" id="type">
                                            <option value="">请选择</option>
                                            <option value="系统管理员">系统管理员</option>
                                            <option value="楼宇管理员">楼宇管理员</option>
                                            <option value="学生">学生</option>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td width="37%" height="30" align="right" class="STYLE2">用户名：</td>
                                        <td width="300" align="left"><input type="text" name="username" id="username"
                                                                            class="text1"/></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">密码：</td>
                                        <td align="left"><input type="password" name="password" id="password"
                                                                class="text1"/></td>
                                    </tr>
                                    <tr>
                                        <td height="30" colspan="2" align="center"><label>
                                            <input type="submit" name="button" id="button" value="登录">
                                        </label></td>
                                    </tr>
                                </table>
                            </form>

                        </td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
</center>
</body>
</html>
