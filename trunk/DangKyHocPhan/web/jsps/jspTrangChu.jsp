<%-- 
    Document   : jspTrangChu
    Created on : Apr 23, 2011, 10:59:14 PM
    Author     : ngloc_it
--%>

<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Chủ</title>
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
                <p>
                    
                <h4>Thông báo về việc đổi phòng thi môn Cấu trúc dữ liệu và giải thuật 1 ngày 22/06/2011 của lớp DSAL1.B24 ( 20/06/2011 )</h4></br>

Phòng Đào tạo ĐH&SĐH thông báo cho các sinh viên thi môn Cấu trúc dữ liệu và giải thuật 1 ngày 22/06/2011 của lớp DSAL1.B24 sẽ chuyển từ phòng 101 và 106 sang phòng 201 và 202. Giờ thi sẽ bắt đầu vào ca 2 lúc 9 giờ 30 phút
Phòng Đào tạo

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