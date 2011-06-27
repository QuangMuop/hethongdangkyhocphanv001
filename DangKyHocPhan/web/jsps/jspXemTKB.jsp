<%-- 
    Document   : jspXemTKB
    Created on : Apr 23, 2011, 4:29:26 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsClass"%>
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
                background: url("../imgs/opaque_10.png") repeat scroll 0 0 transparent;
                border: 3px solid #73726E;
                -moz-border-radius:5px 5px 5px 5px;
            }
            table td{
                border: 1px solid #461B7E;
                background: url("../imgs/opaque_10.png") repeat scroll 0 0 transparent;
                padding: 5 10 5 10;
            }
            table u{
                background-color: 	#B93B8F;
            }
        </style>
    </head>
    <body>
        <!--Get data from controller-->
        <%
            ArrayList<clsClass> list = (ArrayList<clsClass>) session.getAttribute("list");
            String time = (String) session.getAttribute("time");
        %>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <MARQUEE onmouseover="this.stop();" onmouseout="this.start();" HEIGHT=25 BGCOLOR=#B93B8F BEHAVIOR=scroll SCROLLAMOUNT="4">
                    <%=time%>
                </MARQUEE>
                <br/>
                <u>Chi tiết thời khóa biểu học kỳ:</u>
                <table>
                    <!--Thu 2, clasname, sub name, phong, ca, giang vien-->
                    <tr>
                        <td><u>Thứ 2</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                    </tr>
                    <%for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getDate().equalsIgnoreCase("2")) {
                    %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>
                <table>
                    <tr><td><u>Thứ 3</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                        <%for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getDate().equalsIgnoreCase("3")) {
                        %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>
                <table>
                    <tr><td><u>Thứ 4</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                        <%for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getDate().equalsIgnoreCase("4")) {
                        %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>

                <table>
                    <tr><td><u>Thứ 5</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                        <%for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getDate().equalsIgnoreCase("5")) {
                        %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>

                <table>
                    <tr><td><u>Thứ 6</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                        <%for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getDate().equalsIgnoreCase("6")) {
                        %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>

                <table>
                    <tr><td><u>Thứ 7</u></td><td>Mã lớp</td><td>Môn học</td><td>Phòng</td><td>Ca</td><td>Giảng viên</td>
                        <%for (int i = 0; i < list.size(); i++) {
                                if (list.get(i).getDate().equalsIgnoreCase("7")) {
                        %>
                    <tr>
                        <td></td>
                        <td><%=list.get(i).getClassName()%></td>
                        <td><%=list.get(i).getSubName()%></td>
                        <td><%=list.get(i).getRoom()%></td>
                        <td><%=list.get(i).getShift()%></td>
                        <td><%=list.get(i).getLecturerName()%></td>
                    </tr>
                    <%
                            }
                        }%>
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
