<%--
    Document   : jspLienHe
    Created on : Apr 23, 2011, 4:35:14 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    String pass = (String) session.getAttribute("pass");
    String user = (String) session.getAttribute("username");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thay đổi mật khẩu</title>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form id="changepass" name="changepass" action="../servChangePass?change=change" method="post">
                    <h3>Thay đổi mật khẩu:</h3>
                    <table>
                        <tr>
                            <td>Mật khẩu hiện tại:</td>
                            <td><input type="password" id="OldPass" name="OldPass"</td>
                        </tr>
                        <tr>
                            <td>Mật khẩu mới:</td>
                            <td><input type="password" id="newpass" name="newpass"</td>
                        </tr>
                        <tr>
                            <td>Nhắc lại mật khẩu mới:</td>
                            <td><input type="password" id="retype" name="retype"</td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="complete()" value="Hoàn tất" </td>
                            <td><input type="button" onclick="reset()" value="Hủy"</td>
                        </tr>
                    </table>
                    <input type="text" id="curentpass" name="curentpass" value="<%=pass%>" hidden="true">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function reset(){
            document.getElementById("OldPass").value="";
            document.getElementById("newpass").value="";
            document.getElementById("newpass").value="";
        }
        function complete(){
            var old=document.getElementById("OldPass").value;
            var newpass=document.getElementById("newpass").value;
            var renew=document.getElementById("retype").value;
            var curentpass=document.getElementById("curentpass").value;
            if(old.length==0){
                alert("Hãy nhập mật khẩu hiện tại");
            }
            else if(newpass.length==0){
                alert("Hãy nhập mật khẩu mới");
            }
            else if(renew.length==0){
                alert("Hãy xác nhận lại mật khẩu mới");
            }
            else if(newpass!=renew){
                alert("Xác nhận mật khẩu không khớp");
            }
            else if(old!=curentpass){
                alert("Mật khẩu hện tại không đúng");
            }
            else{
                document.forms["changepass"].submit();
            }
        }
    </script>
</html>
