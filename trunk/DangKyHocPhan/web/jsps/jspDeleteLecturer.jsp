<%--
    Document   : jspCapNhatGV
    Created on : 22-05-2011, 10:35:49
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsLecturer"%>
<%@include file="jspmenu.jsp" %>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    clsLecturer lec = (clsLecturer) session.getAttribute("lec");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xóa giảng viên</title>
        <style media="all" type="text/css">
            #tableinfo{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
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

        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->

                <form id="formaddone" name="formaddone" action="../servLecturerManager?action=delete" method="post">
                    <u>Xóa giảng viên: <%=lec.getFullname()%></u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td width="120px">Mã GV</td>
                            <td width="200px"><%=lec.getLecturerCode()%></td>
                        </tr>
                        <tr>
                            <td>Họ tên</td>
                            <td><%=lec.getFullname()%></td>
                        </tr>
                        <tr>
                            <td>Ngày Sinh</td>
                            <td><%=lec.getBirthDay()%></td>
                        </tr>
                        <tr>
                            <td>Giới Tính</td>
                            <td><%=lec.getGender()%></td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td>
                            <td><%=lec.getAddress()%></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td>
                            <td><%=lec.getPhone()%></td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td><%=lec.getEmail()%></td>
                        </tr>
                        <tr>
                            <td>Học Hàm</td>
                            <td><%=lec.getHocHam()%></td>
                        </tr>
                        <tr>
                            <td>Học Vị</td>
                            <td><%=lec.getHocVi()%></td>
                        </tr>
                        <tr>
                            <td>CMND</td>
                            <td><%=lec.getCMND()%></td>
                        </tr>
                    </table>
                    <input type="submit" value="Xóa giảng viên">
                    <input type="hidden" name="txtcode" value="<%=lec.getLecturerCode()%>">
                </form>

                <br/><br/>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
