<%-- 
    Document   : jspQuanLySinhVien
    Created on : 19-05-2011, 22:10:10
    Author     : ngloc_it
--%>

<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý sinh viên</title>
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
                
                <h4><a href="../RegistryStudent?function=nothing">Tiếp nhận sinh viên</a></h4>                
                <h4><a href="../ViewListStudent?search=no&order=FullName">Cập nhật thông tin SV</a></h4>
                <h4><a href="../UpdateScore?function=loaddata">Ghi Nhận Điểm SV</a> </h4>
                <br/>

                <!--
                    Show list of student
                    link to delete, update, insert student
                    just all.
                -->
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
