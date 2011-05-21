<%--
    Document   : jspLienHe
    Created on : Apr 23, 2011, 4:35:14 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsLecturer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="system.dto.clsClass"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
clsClass cls=(clsClass) session.getAttribute("classdetail");
ArrayList<clsLecturer> lec=(ArrayList<clsLecturer>) session.getAttribute("lecturer");
int n=lec.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sửa thông tin lớp học</title>
        <style media="all" type="text/css">
            table{
                margin-left: 20px;
                margin-top: 20px;
                margin-bottom: 20px;
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
                <br> <h3>Sửa thông tin lớp học:</h3>
                <form id="deleteclass" action="../servClassView?action=update" method="post">
                <table>
                    <tr>
                        <td>Mã lớp:</td><td><%=cls.getClassName()%></td>
                    </tr>
                    <tr>
                        <td>Môn học:</td><td><%=cls.getSubName()%></td>
                    </tr>
                    <tr>
                        <td>Giảng viên:</td>
                        <td>
                            <select  id="lecturer" name="lecturer">
                                <%for(int i=0;i<n;i++){%>
                                <option value="<%=lec.get(i).getLecturerCode()%>"><%=lec.get(i).getFullname()%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Ngày:</td>
                        <td>
                            <select  id="date" name="date">
                                <%for(int i=2;i<8;i++){%>
                                <option value="<%=i%>">Thứ <%=i%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Phòng</td>
                        <td><input type="text" name="room" id="room" value=<%=cls.getRoom()%>></td>
                    </tr>
                    <tr>
                        <td>Ca:</td>
                        <td>
                            <select id="shift" name="shift" >
                                <option value="1">Sáng</option>
                                <option value="2">Chiều</option>
                            </select>
                        </td>
                    </tr>
                     <tr>
                         <td><input type="submit" value="Hoàn tất"></td>
                         <td><a href="../servClassView?action=view">Quay lại danh sách lớp</a></td>
                    </tr>
                </table>
                        <input type="hidden" name="classname" id="classname" value=<%=cls.getClassName()%> >
                        <input type="hidden" name="subcode" id="subcode" value=<%=cls.getSubCode()%> >
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
