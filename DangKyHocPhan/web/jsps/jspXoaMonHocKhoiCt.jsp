<%--
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsSubject"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsProgram> pro=(ArrayList<clsProgram>) session.getAttribute("pro");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xóa môn học khỏi chương trình</title>
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
                <u><b>Xóa một môn học khỏi chương trình đào tạo :</b></u><br/>
                <form id="frmInfo" action="../servProManage?action=delete" method="post" name="frmInfo">
                    <u>Thông tin môn học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Mã chương trình:</td>
                            <td><b><%=pro.get(0).getProgramCode()%></b></td>
                        </tr>
                         <tr>
                            <td>Môn học</td>
                            <td>
                                <select name="sub" id="sub">
                                    <%for(int i=0;i<pro.size();i++){%>

                                    <option value="<%=pro.get(i).getSubjectCode()%>"><%=pro.get(i).getSubName()%></option>
                                    <%}%>
                                </select>
                            </td>
                         </tr>
                          </table>
                    <br/>
                    <input type="submit" value="Xóa môn học" >
                    <input type="hidden" name="code" id="code" value="<%=pro.get(0).getProgramCode()%>">
		</form>
               	</div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>

</html>
