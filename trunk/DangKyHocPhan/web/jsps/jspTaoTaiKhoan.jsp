<%--
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>

<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo tài khoản mới</title>
        <style media="all" type="text/css">

        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u><b>Thêm môn học mới :</b></u><br/>
                <form id="frmInfo" action="../servAccount?action=create" method="post" name="frmInfo">
                    <u>Thông tin tài khoản.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Tên đăng nhập(*):</td>
                            <td><input type="text" name="txtusername" id="txtusername"></td>
                        </tr>
                        <tr>
                            <td>Mật khẩu(*):</td>
                            <td><input type="password" name="txtpass" id="txtpass"></td>
                        </tr>
                        <tr>
                            <td>Xác nhận mật khẩu(*):</td>
                            <td><input type="password" name="txtrepass" id="txtrepass"></td>
                        </tr>
                        <tr>
                            <td>Hộ tên(*):</td>
                            <td><input type="text" name="txtname" id="txtname"></td>
                        </tr>
                        <tr>
                            <td>Loại tài khoản:</td>
                            <td>
                                <select style="width:135px" name="txttype" id="txttype">
                                    <option value="0">Sinh viên</option>
                                    <option value="1">Quản lý</option>
                                </select>
                            </td>
                        </tr>

                    </table>
                    <br/>
                    <input type="button" value="Tạo Tài khoản" onclick="insertAcc()">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >


        function insertAcc(){
            txtusername=document.getElementById("txtusername").value;
            txtpass=document.getElementById("txtpass").value;
            txtrepass=document.getElementById("txtrepass").value;
            txtname=document.getElementById("txtname").value;
            if(txtusername.length==0){
                alert("Bạn chưa nhập tên đăng nhập");
            }else  if(txtusername.length>30){
                alert("Tên đăng nhập không quá 30 ký tự");
            }else  if(txtpass.length==0){
                alert("Bạn chưa nhập mật khẩu");
            }
            else  if(txtpass.length>30){
                alert("Mật khẩu không quá 30 ký tự");
            }else  if(txtpass != txtrepass){
                alert("Xác nhận mật khẩu không đúng");
            }else  if(txtname.length==0){
                alert("Bạn chưa nhập họ tên");
            }else  if(txtname.length > 50){
                alert("Họ tên không quá 50 ký tự");
            }
            else {
                document.forms["frmInfo"].submit();
            }
        }
    </script>
</html>
