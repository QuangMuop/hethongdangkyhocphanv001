<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsSubject> sub=(ArrayList<clsSubject>) session.getAttribute("sub");
String subname=(String) session.getAttribute("subname");
String subcode=(String) session.getAttribute("subcode");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo mới môn học</title>
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
                <br>
                <h3>Chọn môn học tiên quyết cho môn học <%=subname%> vừa tạo :</h3>
                Nếu môn học không có môn học tiên quyết có thể bỏ qua bước này
                <form id="sublist" action="../servSubject?action=presub" method="post">
                   <input type="hidden" value="<%=subcode%>" name="subcode" id="subcode">
                  <table id="subjectlist" name="subjectlist">
                    <tr>
                        <th>STT</th><th>Mã môn</th><th>Môn học</th><th>Chọn</th>
                    </tr>
                    <%for(int i=0;i<sub.size();i++){%>
                    <tr>
                        <td><%=i+1%></td><td><%=sub.get(i).getSubCode()%></td><td><%=sub.get(i).getSubName()%></td>
                        <td><input type="checkbox" name="check" value="<%=sub.get(i).getSubCode()%>"></td>

                    </tr>
                    <%}%>
                </table>
                <input type="submit" value="Hoàn tất">
                </form>
                </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
   </html>
