<%-- 
    Document   : jspThongTinSinhVien
    Created on : 08-05-2011, 15:37:42
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsStudent;"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
clsStudent student =(clsStudent) session.getAttribute("student");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thông tin sinh viên</title>
        <style media="all" type="text/css">
            #frminfomation{
                background-color: #E3E4FA;
                width: 400px;
                float: left;
                margin-left:  50px;
            }

            #frminfomation table{
               
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
            <form action="#" method="post" id="frminfomation">
                <br>
                <h3>Thông tin sinh viên</h3>
                <h1>MSSV:<%=student.getCode()%></h1>
                 <br>
                <table id="infomation">
                    <tr>
                        <td>Họ và tên</td>
                        <td><%=student.getFullname()%></td>
                    </tr>
                    <tr>
                        <td>Ngày sinh</td>
                        <td><%=student.getBirthDay()%></td>
                    </tr>
                     <tr>
                        <td>Giới tính</td>
                        <td><%=student.getGender()%></td>
                    </tr>
                    <tr>
                        <td>Lớp</td>
                        <td><%=student.getClasss()%></td>
                    </tr>
                     <tr>
                        <td>Khóa</td>
                        <td><%=student.getCourse()%></td>
                    </tr>
                    <tr>
                        <td>Loại hình học</td>
                        <td><%=student.getType()%></td>
                    </tr>
                    <tr>
                        <td>Bậc học</td>
                        <td><%=student.getBacHoc()%></td>
                    </tr>
                    <tr>
                        <td>Email</td>
                        <td><%=student.getEmail()%></td>
                    </tr>
                    <tr>
                        <td>Điện thoại</td>
                        <td><%=student.getPhone()%></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ liên lạc</td>
                        <td><%=student.getAddress()%></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ thường trú</td>
                        <td><%=student.getHome()%></td>
                    </tr>
                    <tr>
                        <td>CMND</td>
                        <td><%=student.getCMND()%></td>
                    </tr>
                     <tr>
                        <td>Tình trạng</td>
                        <td><%=student.getIsStuding()%></td>
                    </tr>
                 </table>
            </form>
                    <a href="jspCapNhatThongTin.jsp">Sửa đổi thông tin</a>
            </div><!--End Contents-->
            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>