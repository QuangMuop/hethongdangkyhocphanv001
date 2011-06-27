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
ArrayList<clsSubject> list=(ArrayList<clsSubject>) session.getAttribute("list");
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo môn học tiên quyết</title>
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
                <u><b>Tạo mới môn học tiên quyết :</b></u><br/>
                <form id="frmInfo" action="../servDetailSubject?action=createcomplete" method="post" name="frmInfo">
                    <u>Thông tin môn học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Môn học(*):</td>
                            <td>
                                <select name="sSub" id="sSub">
                                  <%for(int i=0;i<list.size();i++){%>  
                                  <option value="<%=list.get(i).getSubCode()%>"><%=list.get(i).getSubName()%></option>
                                  <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Môn học tiên quyết(*):</td>
                            <td>
                                <select name="sPreSub" id="sPreSub">
                                  <%for(int i=0;i<list.size();i++){%>  
                                  <option value="<%=list.get(i).getSubCode()%>"><%=list.get(i).getSubName()%></option>
                                  <%}%>   
                                </select>
                            </td>
                        </tr>
                        <tr>
                           
                    </table>
                    <br/>
                    <input type="button" value="Tạo môn học" onclick="insertSub()">
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
     
        function insertSub(){
            subname=document.getElementById("sSub").value;
            presub=document.getElementById("sPreSub").value;
            if(subname==presub){
                alert("Môn học và môn học tiên quyết không được giống nhau");
            }else {
                document.forms["frmInfo"].submit();
            }
        }
    </script>
  </html>
