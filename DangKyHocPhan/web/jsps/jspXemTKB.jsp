<%-- 
    Document   : jspXemTKB
    Created on : Apr 23, 2011, 4:29:26 PM
    Author     : ngloc_it
--%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thời Khóa Biểu</title>
        <style media="all" type="text/css">
            table{
                margin-left: 20px;
                margin-top:20px;
                margin-bottom: 20px;
                width: 650px;
                padding: 10 10 10 10;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
            }
            table td{
                border: 1px solid #461B7E;
                background-color: #C8BBBE;
                padding: 5 10 5 10;
            }
            table a{
                background-color: 	#B93B8F;
            }
        </style>
    </head>
    <body>
        <!--Get data from controller-->
        <%
        ArrayList<String> listData;
        listData = (ArrayList<String>)session.getAttribute("listdata");
        int i=0, n;
        n = listData.size();
        %>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <MARQUEE onmouseover="this.stop();" onmouseout="this.start();" HEIGHT=25 BGCOLOR=#C0C6CE BEHAVIOR=scroll SCROLLAMOUNT="4">
                    Thời khóa biểu Học Kỳ 1 năm học 2012.
                </MARQUEE>
                <br/><br/><br/>
                <table>
                    <!--Thu 2, clasname, sub name, phong, ca, giang vien-->
                    <tr>
                        <td><a href="#">Thứ 2</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    </tr>
                    <%while((i<n) && listData.get(i).equals("2")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>
                <table>
                    <tr><td><a href="#">Thứ 3</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    <%while((i<n) && listData.get(i).equals("3")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>
                <table>
                    <tr><td><a href="#">Thứ 4</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    <%while((i<n) && listData.get(i).equals("4")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>

                <table>
                    <tr><td><a href="#">Thứ 5</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    <%while((i<n) && listData.get(i).equals("5")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>

                <table>
                    <tr><td><a href="#">Thứ 6</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                   <%while((i<n) && listData.get(i).equals("2")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>

                <table>
                    <tr><td><a href="#">Thứ 7</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    <%while((i<n) && listData.get(i).equals("2")){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>

                <table>
                    <tr><td><a href="#">Chủ Nhật</a></td><td>Mã lớp</td><td>Tên Môn Học</td><td>Phòng</td><td>Ca</td><td>Giảng Viên</td>
                    <%while((i<n) && ((listData.get(i).equals("chunhat"))||(listData.get(i).equals("8")))){
                        i++;%>
                        <tr>
                            <td></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                            <td><%=listData.get(i++)%></td>
                        </tr>
                    <%}%>
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
