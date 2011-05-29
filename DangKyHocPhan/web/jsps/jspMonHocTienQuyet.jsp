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
ArrayList<clsDetailSubject> list=(ArrayList<clsDetailSubject>) session.getAttribute("list");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Môn học tiên quyết</title>
        <style media="all" type="text/css">
            #subjectlist{
                margin-left: 10px;
                margin-top: 20px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                text-align: center;
            }
            #subjectlist th{
                height: 22px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #subjectlist td{
                background-color: #b1B700;
                padding: 2 5 2 5;
            }
            #formsearch{
                margin-top: 10px;
                margin-left: 20px;
                padding: 5 10 5 10;
                background-color: #f29de3;
                width: 280px;
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

                <h3>Chi tiết các môn học tiên quyết :</h3>
                <form id="sublist">
                  <table id="subjectlist" name="subjectlist">
                    <tr>
                        <th>Môn học</th><th>Môn học tiên quyết</th>
                    </tr>
                   <%for(int i=0;i<list.size();i++){ %>
                         <%if(i==0){%>
                         <tr>
                             <td><b><%=list.get(i).getSubName()%></b></td>
                              <td><%=list.get(i).getPreSubName()%></td>
                         </tr>
                          <%}else{
                             if(list.get(i).getSubName().equalsIgnoreCase(list.get(i-1).getSubName())){%>
                             <tr>
                                <td></td>
                                <td><%=list.get(i).getPreSubName()%></td>
                             </tr>
                             <%}else{%>
                              <tr>
                                  <td><b><%=list.get(i).getSubName()%></b></td>
                                  <td><%=list.get(i).getPreSubName()%></td>
                              </tr>
                              <%}%>
                          <%}%>
                     <%}%>
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
