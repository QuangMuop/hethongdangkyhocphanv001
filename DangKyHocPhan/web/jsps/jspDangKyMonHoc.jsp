<%-- 
    Document   : jspDanhKyMonHoc
    Created on : Apr 23, 2011, 4:32:56 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<clsClass> clases = (ArrayList<clsClass>) session.getAttribute("clases");
    clsStudent student = (clsStudent) session.getAttribute("student");
    String time = (String) session.getAttribute("time");
    int n = clases.size();
    int j = 0;
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng ký môn học.</title>
        <style media="all" type="text/css">
            #tablelistclass{
                margin-left: 10px;
                margin-top: 10px;
                width: 750px;
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
                background-color:#2f4e3d;
                padding: 2 5 2 5;
            }
            #formaction{
                margin-left: 10%;
                margin-top: 30px;
                padding: 0 2 0 2;
            }
            #formaction table{
                width: 155px;
            }
            #formrequest{
                margin-left: 10%;
                margin-top: 10px;
                margin-bottom: 120px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
                width: 350px;
            }
            #formrequest table{
                margin-top: 10px;
                margin-right: 10px;
                padding-left: 20px;
                padding-right: 20px;
                background-color: #e60ff0
            }
        </style>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents--><br>
                <h3 align="center">ĐĂNG KÝ HỌC PHẦN</h3>
                <p align="right"><b>Khoa : Kỹ Thuật Phần Mềm</b></p>
                <hr/><hr/>
                <b>MSSV: <%=student.getCode()%> </b><br>
                <b>Họ Tên: <%=student.getFullname()%></b><br>
                <u>Đăng ký học phần:<%=time%></u><br>
                <i>Lưu ý: Mỗi sinh viên đưang ký học phần không dưới 14 tín chỉ và không quá 25 tín chỉ.</i>
                <form id="registry" name="registry" action="../servRegistration?reg=registry" method="post">
                    <table id="tablelistclass">
                        <tr>
                            <th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Số TC</th><th>Giảng viên</th><th>Thứ</th><th>Ca</th><th>Phòng</th><th>SV tối đa</th><th>SV Đã ĐK</th><th><th>
                        </tr>
                        <%
                        for (j = 0; j < n; j++) {%>
                        <tr>
                            <td><%=j + 1%></td>
                            <td><%=clases.get(j).getClassName()%></td>
                            <td><%=clases.get(j).getSubName()%></td>
                            <td><%=clases.get(j).getNumTC()%></td>
                            <td><%=clases.get(j).getLecturerName()%></td>
                            <td><%=clases.get(j).getDate()%></td>
                            <td><%=clases.get(j).getShift()%></td>
                            <td><%=clases.get(j).getRoom()%></td>
                            <td>120</td>
                            <td><%=clases.get(j).getNumOfStudent()%></td>
                            <%if (clases.get(j).getNumOfStudent() >= 120) {%>
                            <td><input type="checkbox" disabled="true" name="check" value="<%=clases.get(j).getClassName()%>"></td>
                                <%} else {%>
                            <td><input type="checkbox" name="check" value="<%=clases.get(j).getClassName()%>"></td>
                                <%}%>
                        </tr>
                        <%}%>
                    </table>
                    <input type="submit" value="Đăng ký">
                </form>
                <br>
                <form action="#" method="post" id="formequest">
                    <u>Yêu cầu mở lớp:</u>
                    <table id="tablerequest">
                        <tr>
                            <td>Mã Lớp</td>
                            <td>
                                <select name="sClassId">
                                    <option>SE002</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Tên Lớp</td>
                            <td>
                                <select name="sClassName">
                                    <option>Lập trình hướng đối tượng.</option>
                                </select>
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <input type="submit" value="Gửi yêu cầu">

                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>

</html>
