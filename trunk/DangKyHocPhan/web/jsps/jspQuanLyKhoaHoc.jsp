<%--
    Document   : jspXemDSLop
    Created on : Apr 23, 2011, 4:29:09 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsCourse> course=(ArrayList<clsCourse>) session.getAttribute("course");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý khóa học</title>
        <style media="all" type="text/css">
            #tblcourselist{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 10px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #tblcourselist th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #tblcourselist td{
                background-color: #b1B700;
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
                <p align="right"><b><a href="../servCourse?action=create">Mở khóa học mới</a></b></p>
                <hr><hr>
                <h3>Danh sách các khóa học của khoa :</h3>
                <form id="classlist">
                  <table id="tblcourselist" name="tblcourselist">
                    <tr>
                        <th>STT</th><th>Khóa học</th><th>Năm bắt đầu</th><th>Năm kết thúc</th><th>Số SV hiện tại</th><th>Chương trình đào tạo</th>
                    </tr>
                    <%for(int i=0;i<course.size();i++){%>
                    <tr>
                        <td><%=i+1%></td><td><%=course.get(i).getCourseCode()%></td>
                        <td><%=course.get(i).getYearIn()%></td><td><%=course.get(i).getYearOut()%></td>
                        <td><%=course.get(i).getNumOfStudent()%></td><td><%=course.get(i).getProgramCode()%></td>
                    </tr>
                    <%}%>
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
