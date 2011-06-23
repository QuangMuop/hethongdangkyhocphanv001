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
ArrayList<clsClass> reg=(ArrayList<clsClass>) session.getAttribute("reg");
clsStudent student =(clsStudent) session.getAttribute("student");
int n=reg.size();
int j=0;
int numtc=0;
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
                background-color:#5F676D;
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
            <div id="content"><!--Main Contents--><br>
                <h3 align="center">ĐĂNG KÝ HỌC PHẦN</h3>
                <p align="right"><b>Khoa : Kỹ Thuật Phần Mềm</b></p>
                <hr/><hr/>
                <b>MSSV: <%=student.getCode()%> </b><br>
                <b>Họ Tên: <%=student.getFullname()%></b><br>
                <u>Đăng ký học phần: học kỳ 2 năm học 2010-2011</u><br>
                <form id="complete" name="complete" action="../servRegistration?reg=complete" method="post">
                <table id="tablelistclass">
                    <tr>
                        <th>STT</th><th>Thứ</th><th>Lớp</th><th>Môn học</th><th>Giảng viên</th><th>Ca</th><th>Phòng</th><th>Số TC</th>
                    </tr>
                     <%
                    for(j=0;j<n;j++){%>
                     <tr>
                         <td><%=j+1%></td>
                         <td><%=reg.get(j).getDate()%></td>
                         <td><%=reg.get(j).getClassName()%></td>
                         <td><%=reg.get(j).getSubName()%></td>
                         <td><%=reg.get(j).getLecturerName()%></td>
                         <td><%=reg.get(j).getShift()%></td>
                         <td><%=reg.get(j).getRoom()%></td>
                         <td><%=reg.get(j).getNumTC()%></td>
                      </tr>

                    <%
                    numtc+=reg.get(j).getNumTC();
                    }%>
                    <tr>
                        <td><b>Tổng số tín chỉ</b></td><td></td><td></td><td></td><td></td><td></td><td></td><td><b><%=numtc%></b></td>
                    </tr>
                </table>
                 </form>
                 <form id="frmreset" name="frmreset" method="post" action="../servRegistration?reg=reset">
                     <table>
                         <tr>
                             <td><input type="button" onclick="completereg()" value="Hoàn tất đăng ký"></td>
                             <td><input type="button" onclick="reseet()" value="Đăng ký lại"></td>
                         </tr>
                     </table>
                 </form>
              <br>
              </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function reseet(){
             document.forms["frmreset"].submit();
        }
        function completereg(){
            document.forms["complete"].submit();
        }
       </script>
 </html>
