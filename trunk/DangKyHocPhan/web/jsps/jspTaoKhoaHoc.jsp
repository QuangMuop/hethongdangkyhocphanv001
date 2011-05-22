<%--
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>

<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<Integer> pro=(ArrayList<Integer>) session.getAttribute("pro");
ArrayList<clsCourse> course=(ArrayList<clsCourse>) session.getAttribute("course");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo khóa học</title>
        <style media="all" type="text/css">
            #frmInfo{
                margin-left: 20px;
                margin-top: 10px;
                width: 350px;
                padding-top: 20px;
                padding-bottom: 10px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
            }
             #tablelistcourse{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                border-bottom:  2px solid;
                border-top:  2px solid;
            }

            #tablelistcourse th{
                height: 22px;
                background-color: #F9B7FF;
                border-left: 1px solid;
                border-right: 1px solid;
                border-bottom:  1px solid;
                border-top:  1px solid;
            }
            #tablelistcourse td{
                background-color: #b1B700;
                padding: 2 5 2 5;
                text-align: center;
            }
        </style>
        </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u>Thêm một khóa học mới:</u><br/>
                <form id="frmInfo" action="../servCourse?action=createcomplete" method="post" name="frmInfo">
                    <u>Thông tin lớp học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Khóa học học</td>
                            <td>
                                <select name="courseID" id="courseID" style="width:100px">
                                     <%for(int i=1;i<11;i++){%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Năm bắt đầu</td>
                            <td>
                                <select name="yearIn" id="yearIn" style="width:100px">
                                    <%for(int i=2006;i<2021;i++){%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Năm kết thúc</td>
                            <td>
                                <select name="yearOut" id="yearOut" style="width:100px">
                                    <%for(int i=2010;i<2025;i++){%>
                                    <option value="<%=i%>"><%=i%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                         <tr>
                            <td>Chương trình đào tạo: </td>
                            <td>
                                <select name="ProCode" id="ProCode" style="width:100px">
                                <%for(int i=0;i<pro.size();i++){%>
                                <option value="<%=pro.get(i)%>"><%=pro.get(i)%></option>
                                <%}%>
                                </select>
                            </td>
                        </tr>
                     </table>
                    <br/>
                    <input type="button" value="Tạo khóa học" onclick="insertCourse()">
		</form>
                <br><hr><hr>
               	<u>Danh sách các khóa học hiện có.</u>
		<table id="tablelistcourse">
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
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
     <script  type = "text/javascript" >
         function insertCourse(){
         var yearin = document.frmInfo.yearIn.value;
         var yearout = document.frmInfo.yearOut.value;
         if(yearout-yearin<4){
           alert("Năm kết thúc phải sau năm bắt đầu ít nhất 4 năm")
          }
          else{
           document.forms["frmInfo"].submit();
          }
  }
       </script>
</html>
