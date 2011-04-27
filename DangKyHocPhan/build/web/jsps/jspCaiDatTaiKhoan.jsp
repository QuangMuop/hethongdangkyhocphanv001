<%-- 
    Document   : jspTaoTaiKhoan
    Created on : Apr 24, 2011, 2:49:42 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo Tài Khoản Mơi.</title>
        <style media="all" type="text/css">
            #table-info{
                margin-left: 240px;
                margin-top: 75px;
                padding: 22 5 22 5;
                width: 350px;
                border: 3px solid #503438;
                background-color: #737CA1;
            }
            #table-info tr{
            }
            #text-label{
                color: #F6358A;
                font-weight: bold;
                border: 1px solid #EBDDE2;
            }
            #text-input{
                width: 200px
            }
            #btn-submit{
                width: 70px;
                background-color: #ff4455;
            }
            #table-list{
                margin-left: 15px;
                margin-top: 50px;
                margin-bottom: 150px;
                width: 700px;
                padding: 22 5 22 5;
                border: 3px solid #503438;
                background-color: #737CA1;
                color: red;
            }
            #table-list-header{
                background-color: #FDEEF4;
                font-weight: bold;
                color: blue;
            }
        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <h3>Phần thông tin cho tài khoản</h3> <br/>
        <form method="post" action="#">
            <table id="table-info">
                <tr>
                    <td id="text-label">Tên Đăng Nhập</td>
                    <td><input id="text-input" type="text" name="txtUsername"></td>
                </tr>
                <tr>
                    <td id="text-label">Mật Khẩu</td>
                    <td><input id="text-input" type="text" name="txtPassword"></td>
                </tr>
                <tr>
                    <td id="text-label">Nhập lại Mật khẩu</td>
                    <td><input id="text-input" type="text" name="txtRePassword"></td>
                </tr>
                <tr>
                    <td id="text-label">Họ</td>
                    <td><input id="text-input" type="text" name="txtFirstname"></td>
                </tr>
                <tr>
                    <td id="text-label">Tên</td>
                    <td><input id="text-input" type="text" name="txtLasttname"></td>
                </tr>
                <tr>
                    <td id="text-label">Ngày Sinh</td>
                    <td>
                        <select name="sDay">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                        <select name="sMonth">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                        </select>
                        <select name="sYear">
                            <option>1991</option>
                            <option>1992</option>
                            <option>1993</option>
                            <option>1994</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td id="text-label">Email</td>
                    <td><input id="text-input" type="text" name="txtEmail"></td>
                </tr>
                <tr>
                    <td id="text-label">Số ĐT</td>
                    <td><input id="text-input" type="text" name="txtPhonenumber"></td>
                </tr>
                <tr>
                    <td id="text-label">Quyền truy cập</td>
                    <td>
                        <select name="sRole">
                            <option>Admin</option>
                            <option>Normal</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td></td>
                    <td><input id="btn-submit" type="submit" name="btnCreate" value="Tạo Mới"></td>
                </tr>
            </table>
            </form>
            <br/><br/>
            <hr/><hr/>
            <!--Danh sach accounts-->
            <h3>Danh sách các tài khoản đã có</h3><br/><br/>
                <table id = "table-list">
                    <tr id = "table-list-header">
                        <th>Tài khoản</th><th>Mật khẩu</th><th>Quyền</th><th>Ngày tạo</th><th>...</th><th>...</th><th>...</th><th width="75px"></th>
                    </tr>
                    <tr>
                        <td><a href="jspCapNhatTaiKhoan.jsp?username=ngloc_it">ngloc_it</a></td><td>unknown</td><td>1</td><td>1-1-2001</td><td>...</td><td>...</td><td>...</td>
                        <td><form action="#" method="post"><input type="submit" value="Delete"></form></td>
                    </tr>
                    <tr>
                        <td><a href="jspCapNhatTaiKhoan.jsp?username=trungthanh_xlt">trungthanhxl</a></td><td>unknown</td><td>1</td><td>1-1-2001</td><td>...</td><td>...</td><td>...</td>
                        <td><form action="#" method="post"><input type="submit" value="Delete"></form></td>
                    </tr>
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
