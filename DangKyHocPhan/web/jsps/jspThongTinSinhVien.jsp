<%-- 
    Document   : jspThongTinSinhVien
    Created on : 08-05-2011, 15:37:42
    Author     : ngloc_it
--%>

<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin sinh viên</title>
        <style media="all" type="text/css">
            #frmaccount{
                background-color: #E3E4FA;
                width: 250px;
                float: left;
                margin-left: 20px;
            }

            #frmaccount table{
                border: 1px solid;
                width: 100%;
                background-color: #ADDFFF
            }

            #frminfomation{
                background-color: #E3E4FA;
                width: 400px;
                float: right;
                margin-right: 20px;
            }

            #frminfomation table{
                border: 1px solid;
                width: 100%;
                background-color: #ADDFFF
            }

            #frmaction{
                padding-top: 50px;
                clear: both;
                margin-left: 30%;
                padding-top: 25px;
                padding-bottom: 50px;
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
                <h1>BẠN ĐANG Ở TRANG XEM THÔNG TIN SINH VIÊN!</h1><br/>
                <form action="#" method="post" id="frmaccount">
                    <h3>Thông tin tài khoản sinh viên</h3>
                    <table>
                        <tr>
                            <td>Tên đăng nhập</td>
                            <td>07520210</td>
                        </tr>
                        <tr>
                            <td>Mật khẩu</td>
                            <td>*******</td>
                        </tr>
                        <tr>
                            <td>Role</td>
                            <td>Normal</td>
                        </tr>
                    </table>
            </form>

            <form action="#" method="post" id="frminfomation">
                <h3>Thông tin sinh viên</h3>
                <table id="infomation">
                    <tr>
                        <td>Họ và tên</td>
                        <td>Nguyễn Văn Lộc</td>
                    </tr>
                    <tr>
                        <td>MSSV</td>
                        <td>07520210</td>
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td>10-04-1988</td>
                    </tr>
                    <tr>
                        <td>Lớp</td>
                        <td>CNPM02</td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td>locnv.uit@gmail.com</td>
                    </tr>
                    <tr>
                        <td>Số ĐT</td>
                        <td>01683508402</td>
                    </tr>
                    <tr>
                        <td>Tạm trú</td>
                        <td>Tp. Hồ Chí Minh</td>
                    </tr>
                    <tr>
                        <td>Thường trú</td>
                        <td>Tp. Ninh Bình</td>
                    </tr>
                    <tr>
                        <td>Tình Trạng</td>
                        <td>Chưa ra trường</td>
                    </tr>
                </table>
            </form>
            <form action="jspCapNhatThongTin.jsp" method="post" id="frmaction">
                <input type="submit" value="Cập Nhật Thông Tin">
            </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>