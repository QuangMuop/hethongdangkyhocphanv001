<%-- 
    Document   : jspChiTietGV
    Created on : 11-05-2011, 16:58:05
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsLecturer"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    clsLecturer lec = (clsLecturer) session.getAttribute("lec");
%>
<html>
    <head>
        <link href="../csss/general.css" rel="stylesheet" type="text/css" media="screen">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết giảng viên:</title>
        <style media="all" type="text/css">
            #tableinfo{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 400px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: left;
            }
            #tableinfo th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tableinfo td{
                background-color: #b1B700;
                padding: 2 5 2 5;
            }            
            #frminfo{
                margin-left: 25px;
                width: 400px;
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
                    Thông tin chi tiết giảng viên: <%=lec.getFullname()%>
                </p>
                <form action="#" id="frminfo">
                    <table id="tableinfo">
                        <tr>
                            <td>Mã GV:</td> <td><%=lec.getLecturerCode()%></td>
                        </tr>
                        <tr>
                            <td>Họ tên:</td> <td><%=lec.getFullname()%></td>
                        </tr>
                        <tr>
                            <td>Ngày sinh:</td> <td><%=lec.getBirthDay()%></td>
                        </tr>
                        <tr>
                            <td>Email:</td>  <td><%=lec.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Điện thoại:</td> <td><%=lec.getPhone()%></td>
                        </tr>
                        <tr>
                            <td>Địa chi:̉</td> <td><%=lec.getAddress()%></td>
                        </tr>
                        <tr>
                            <td>Học Hàm:</td> <td><%=lec.getHocHam()%></td>
                        </tr>
                        <tr>
                            <td>Học Vị:</td> <td><%=lec.getHocVi()%></td>
                        </tr>
                        <tr>
                            <td>Giới tính:</td> <td><%=lec.getGender()%></td>
                        </tr>
                        <tr>
                            <td>CMND:</td> <td><%=lec.getCMND()%></td>
                        </tr>

                    </table>
                    <a href="../servLecturerManager?code=<%=lec.getLecturerCode()%>&action=edit">Cập nhật thông tin</a>
                </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>