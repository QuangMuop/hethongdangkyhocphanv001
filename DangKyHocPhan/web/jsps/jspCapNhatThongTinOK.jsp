<%--
    Document   : jspLienHe
    Created on : Apr 23, 2011, 4:35:14 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsComment;"%>
<%@page import="system.access.mapper.clsMapperComment;"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style media="all" type="text/css">
            table{
                margin-left: 20px;
                margin-top: 100px;
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
                   Thông tin cập nhật của bạn đã được gởi tới quản lý khoa, xin cảm ơn!
                </p>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
