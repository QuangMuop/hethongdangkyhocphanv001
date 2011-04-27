<%-- 
    Document   : jspLogin
    Created on : Apr 23, 2011, 4:34:47 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng Nhập</title>

        <style media="all" type="text/css">
            table{
                margin-left: 250px;
                margin-top: 100px;
                margin-bottom: 120px;
                padding-top: 125px;
                padding-left: 25px;
                padding-right: 25px;
                padding-bottom: 120px;
                border: 2px solid #e3e4e4;
                background: #f2d3e4 url(../imgs/login.PNG) no-repeat left top;
                width: 340px;
                height: 470px;
            }
            #login-submit{
                background-color: #ff3edf;
                width: 75px;
                border: 2px solid #175F6E;
            }
        </style>>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form method="post" action="#">
                    <table>
                        <tr>
                            <td>Tên Đăng Nhập</td>
                            <td>
                                <input type="text" name="txtUsername" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td>Mật Khẩu</td>
                            <td>
                                <input type="password" name="txtPassword" value="" />
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="checkbox" name="chkRemember"/> Nhớ tên truy cập
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                                <input type="submit" id="login-submit" value="Đăng Nhập"/>
                            </td>
                        </tr>
                    </table>
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
