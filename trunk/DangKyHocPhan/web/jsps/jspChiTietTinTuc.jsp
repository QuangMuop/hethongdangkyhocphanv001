<%-- 
    Document   : jspTrangChu
    Created on : Apr 23, 2011, 10:59:14 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.ClsNews"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ClsNews newsinfo = (ClsNews) session.getAttribute("news");
%>
<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết bản tin</title>
        <style media="all" type="text/css">
            #frmimg{
                margin-left: 50px;
                border: 5px solid #98AFC7;
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
                <br><br>
                <p>
                    <u>Chi tiết thông báo:</u><br>
                    <%=newsinfo.GetContent()%>

                </p>
                <%--<img src="../imgs/hpimg.JPG" alt="Angry face" id="frmimg"/>--%>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>