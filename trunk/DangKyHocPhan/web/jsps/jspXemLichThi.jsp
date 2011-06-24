<%-- 
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<clsClass> clases = (ArrayList<clsClass>) session.getAttribute("list");
    String time = (String) session.getAttribute("time");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lịch thi</title>
        <style media="all" type="text/css">
            #tablelistclass{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 10px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #tablelistclass th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tablelistclass td{
                background-color: #028347;
                padding: 2 5 2 5;
            }
           
        </style>
    </head>
    <body>
        <!--Get data from controller-->

        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <br>
                <h3>Lịch thi chi tiết ch0 các lớp học trong <%=time%>:</h3>
                <form id="classlist">
                    <table id="tablelistclass" name="tablelistclass">
                        <tr>
                            <th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Ngày thi</th><th>Phòng thi</th><th>Giờ thi</th>
                        </tr>
                        <%
                            for (int i = 0; i < clases.size(); i++) {
                        %>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=clases.get(i).getClassName()%></td>
                            <td><%=clases.get(i).getSubName()%></td>
                            <td><%=clases.get(i).getLecturerName()%></td>
                            <td><%=clases.get(i).getTestDate()%></td>
                            <td><%=clases.get(i).getTestRoom()%></td>
                            <td><%=clases.get(i).getTestTime()%></td>
                        </tr>
                        <%
                            }
                        %>
                    </table>
                </form>
                <hr><hr>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
