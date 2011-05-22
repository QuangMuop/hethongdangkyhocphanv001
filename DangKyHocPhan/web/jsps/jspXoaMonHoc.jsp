<%--
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsSubject"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
clsSubject sub=(clsSubject) session.getAttribute("sub");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cập nhật môn học</title>
        <style media="all" type="text/css">

        </style>
        </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u><b>Sửa môn học mới :</b></u><br/>
                <form id="frmInfo" action="../servSubject?action=deletecomplete" method="post" name="frmInfo">
                    <u>Thông tin môn học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Môn học : </td>
                            <td><%=sub.getSubName()%></td>
                        </tr>
                         <tr>
                            <td>Mã môn : </td>
                            <td><%=sub.getSubCode()%></td>
                         </tr>
                          <tr>
                            <td>Số Tín chỉ : </td>
                            <td><%=sub.getNumTC()%></td>
                         </tr>
                          <tr>
                            <td>Số tín chỉ lý thuyết : </td>
                            <td><%=sub.getTCLT()%></td>
                         </tr>
                          <tr>
                            <td>Số tín chỉ thực hành : </td>
                            <td><%=sub.getTCTH()%></td>
                         </tr>
                    </table>
                    <br/>
                    <input type="submit" value="xóa môn học" >
                    <input type="hidden" name="subcode" value="<%=sub.getSubCode()%>">
		</form>
               	</div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
  </html>
