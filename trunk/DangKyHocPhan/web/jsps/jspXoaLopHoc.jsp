<%--
    Document   : jspLienHe
    Created on : Apr 23, 2011, 4:35:14 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsClass"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    clsClass cls = (clsClass) session.getAttribute("classdetail");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông báo</title>
        <style media="all" type="text/css">
            table{
                margin-left: 20px;
                margin-top: 20px;
                margin-bottom: 120px;
                width: 550px;
                padding: 50 10 20 10;

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
                <br> <h3>Xóa lớp học:</h3>
                <form id="deleteclass" action="../servClassView?action=deletecom&classname=<%=cls.getClassName()%>" method="post">
                    <table>
                        <tr>
                            <td>Mã lớp:</td><td><%=cls.getClassName()%></td>
                        </tr>
                        <tr>
                            <td>Môn học:</td><td><%=cls.getSubName()%></td>
                        </tr>
                        <tr>
                            <td>Giảng viên:</td><td><%=cls.getLecturerName()%></td>
                        </tr>
                        <tr>
                            <td>Ngày:</td><td>Thứ <%=cls.getDate()%></td>
                        </tr>
                        <tr>
                            <td>Ca:</td><td><%=cls.getShift()%></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Xóa"></td>
                            <td><a href="../servClassView?action=view">Quay lại danh sách lớp</a></td>
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
