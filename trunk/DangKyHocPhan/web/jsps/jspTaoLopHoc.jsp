<%-- 
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.clsClass"%>
<%@page import="system.dto.clsSubject"%>
<%@page import="system.dto.clsLecturer"%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList<clsClass> classlist = (ArrayList<clsClass>) session.getAttribute("clases");
    ArrayList<clsLecturer> leclist = (ArrayList<clsLecturer>) session.getAttribute("leclist");
    ArrayList<clsSubject> sublist = (ArrayList<clsSubject>) session.getAttribute("sublist");
    int i, j = 0;
    int n = leclist.size();
    int m = sublist.size();
    int l = classlist.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo lớp học</title>
        <style media="all" type="text/css">
            #frmInfo{
                margin-left: 20px;
                margin-top: 10px;
                width: 350px;
                padding-top: 20px;
                padding-bottom: 10px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #474C52;
                border: 3px solid #7F38EC;
            }
            #ClassName{
                width: 200px;
            }
            #LecturerName{
                width: 200px;
            }
            #txtClassId{
                width: 200px;
            }
            #tablelistclass{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom: 20px;
                width: 740px;
                border-left: 2px solid;
                border-right: 2px solid;
                border-bottom:  2px solid;
                border-top:  2px solid;
            }

            #tablelistclass th{
                height: 22px;
                background-color: #F9B7FF;
                border-left: 1px solid;
                border-right: 1px solid;
                border-bottom:  1px solid;
                border-top:  1px solid;
            }
            #tablelistclass td{
                background-color: #5F676D;
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
                <u>Mở một lớp học mới trong học kỳ  hiện tại:</u><br/>
                <form id="frmInfo" action="../servClassView?action=createcomplete" method="post" name="frmInfo">
                    <u>Thông tin lớp học.</u><br/>
                    <table id="tableinfo">
                        <tr>
                            <td>Lớp học(*):</td>
                            <td>
                                <input type="text" name="txtClassId" id="txtClassId">
                            </td>
                        </tr>
                        <tr>
                            <td>Môn học:</td>
                            <td>
                                <select name="ClassName" id="ClassName" onchange="getClassName()">
                                    <%for (i = 0; i < m; i++) {%>
                                    <option value="<%=sublist.get(i).getSubCode()%>"><%=sublist.get(i).getSubName()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giảng viên:</td>
                            <td>
                                <select name="LecturerName" id="LecturerName">
                                    <%for (j = 0; j < n; j++) {%>
                                    <option value="<%=leclist.get(j).getLecturerCode()%>"><%=leclist.get(j).getFullname()%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Thứ:</td>
                            <td>                                
                                <select name="Day">
                                    <%for (i = 2; i <= 7; i++) {%>
                                    <option value="<%=i%>"> Thứ <%=i%></option>
                                    <%}%>
                                </select>                                
                            </td>
                        </tr>
                        <tr>
                            <td>Ca học:</td>
                            <td>
                                <select name="sTime">
                                    <option value="1">Sáng</option>
                                    <option value="2">Chiều</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Phòng học(*):</td>
                            <td>
                                <input type="text" name="txtRoom" id="txtRoom">
                            </td>
                        </tr>
                    </table>
                    <br/>
                    <input type="button" value="Tạo lớp học" onclick="insertClass()">
                </form>
                <br>  <hr><hr>
               	<u>Danh sách các lớp hiện có.</u>
                <table id="tablelistclass">
                    <tr>
                        <th>STT</th><th>Mã lớp</th><th>Môn học</th><th>Giảng Viên</th><th>Số TC</th><th>Ngày</th><th>Phòng</th><th>Ca</th>
                    </tr>
                    <%for (i = 0; i < l; i++) {%>
                    <tr>
                        <td><%=i + 1%></td>
                        <td><%=classlist.get(i).getClassName()%></td>
                        <td><%=classlist.get(i).getSubName()%></td>
                        <td><%=classlist.get(i).getLecturerName()%></td>
                        <td><%=classlist.get(i).getNumTC()%></td>
                        <td><%=classlist.get(i).getDate()%></td>
                        <td><%=classlist.get(i).getRoom()%></td>
                        <td><%=classlist.get(i).getShift()%></td>
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
        function getClassName(){
            var classname = document.frmInfo.ClassName.value;
            document.frmInfo.txtClassId.value=classname;

        }
        function insertClass(){
            var classname = document.frmInfo.txtClassId.value;
            var room = document.frmInfo.txtRoom.value;
            if(classname.length==0){
                alert("Bạn chưa nhập lớp học");
            }
            else if(room.length==0){
                alert("Bạn chưa nhập phòng học");
            }
            else{
                document.forms["frmInfo"].submit();
            }
        }
    </script>
</html>
