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
ArrayList<clsClass> clases=(ArrayList<clsClass>) session.getAttribute("clases");
String time=(String) session.getAttribute("time");
int n=clases.size();
int j=0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách lớp học</title>
        <style media="all" type="text/css">
            #tablelistclass{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
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
                background-color: #b1B700;
                padding: 2 5 2 5;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 220px;
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
                <h3>Danh sách các môn học trong <%=time%>:</h3>
                <form id="classlist">
                  <table id="tablelistclass">
                    <tr>
                        <th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Số TC</th><th>Ngày</th><th>Phòng</th><th>Ca</th>
                    </tr>
                     <%for(j=0;j<n;j++){%>
                     <tr>
                         <td><%=j+1%></td>
                         <td><a href="../servClassView?action=detail&classname=<%=clases.get(j).getClassName()%>"><%=clases.get(j).getClassName() %></a></td>
                         <td><%=clases.get(j).getSubName()%></td>
                         <td><%=clases.get(j).getLecturerName()%></td>
                         <td><%=clases.get(j).getNumTC()%></td>
                         <td>Thứ <%=clases.get(j).getDate()%></td>
                         <td><%=clases.get(j).getRoom()%></td>
                         <td><%=clases.get(j).getShift()%></td>
                         </tr>
                     <%}%>
                </table>
                </form>
                <hr><hr>
                <h1>Tìm kiếm lớp học:</h1>
                <form id = "formsearch" action="../ViewListClass?searchengine=true" method="post">
                     <table>
                        <tr>
                            <td><input type="checkbox" name="chkSearchByName"></td>
                            <td>
                                <select name="sName">
                                   <option>Đồ án mã nguồn mở</option>
                                </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td><input type="checkbox" name="chkSearchByTeacher"></td>
                            <td>
                                <select name="sTeacherName">
                                  <option>Nguyễn Trung Thành</option>
                               </select>
                            </td>
                            <td></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Tìm Kiếm"></td>
                        </tr>
                    </table>
                </form>
               </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
