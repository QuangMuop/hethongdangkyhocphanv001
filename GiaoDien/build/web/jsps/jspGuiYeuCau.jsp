<%-- 
    Document   : jspGuiYeuCau
    Created on : Apr 23, 2011, 4:34:30 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Gửi yêu cầu</title>
        <style media="all" type="text/css">
            table{
                margin-left: 20px;
                margin-top: 120px;
                margin-bottom: 120px;
                width: 650px;
                border: 2px solid;
                padding: 50 10 20 10;
                background-color: #495C28;
            }
            #txt-info{
                width:250px;
                background-color: #028347;
            }
            table a{
                color: #FEFAB9;
            }
            table textarea{
                width: 98%;
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
                <p>
                    Vui lòng ghi yêu cầu vào ô bên dưới và click Gửi Yêu Cầu.
                </p>
                <form method="post" action="#">
                     <table>
                        <tr>
                            <td><a>Họ Tên</a></td>
                            <td><input type="text" name="txtName" id="txt-info"></td>
                        </tr>
                        <tr>
                            <td><a>MSSV</a></td>
                            <td><input type="text" name="txtMSSV" id="txt-info"></td>
                        </tr>
                        <tr>
                            <td><a>Email</a></td>
                            <td><input type="text" name="txtName" id="txt-info"></td>
                        </tr>
                        <tr>
                            <td><a>Nội dung:</a></td>
                            <td></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><textarea type="textarea" name="txtContent" rows="12" cols="50"></textarea></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td align="right"><input type="submit" name="btnSend" id="btn-send" value="Gửi"></td>
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
