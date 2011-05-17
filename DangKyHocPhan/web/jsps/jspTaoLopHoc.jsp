<%-- 
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    ArrayList<String> lecturerNames = null;
    ArrayList<String> subjectInfo = null;
    ArrayList<String> classExisted = null;
    String err = "";
    int numL = 0, numS = 0, numC = 0, i = 0, count = 0;
    try{
       lecturerNames = (ArrayList<String>)session.getAttribute("lecturernames");
       subjectInfo = (ArrayList<String>) session.getAttribute("subjectinfo");
       classExisted = (ArrayList<String>) session.getAttribute("classexisted");
    }catch(Exception ex){
        err = ex.toString();
    }

    if(lecturerNames != null)
        numL = lecturerNames.size();

    if(subjectInfo != null)
        numS = subjectInfo.size();

    if(classExisted != null)
        numC = classExisted.size();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo lớp học</title>
        <style media="all" type="text/css">
            #form-info{
                margin-left: 20px;
                margin-top: 20px;
                width: 350px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;
                background-color: #92C7C7;
                border: 3px solid #7F38EC;
            }
            #select-long{
                width: 150px;
            }
            #table-list-class{
                margin-left: 20px;
                margin-top: 20px;
                margin-bottom: 120px;
                width: 650px;
                border-left: 2px solid;
                border-right: 2px solid;
            }

            #table-list-class th{
                height: 32px;
                font-weight: bold;
                background-color: #F9B7FF;
            }
            #table-list-class td{
                background-color: #b1B700;
                padding: 2 5 2 5;
            }
        </style>
        <script  type = "text/javascript" >

         function InsertNewClass(){
              
            var ClassId = document.frmInfo.txtClassId.value;
            var tclt = document.frmInfo.txtSoTCLT.value;                      
            var tcth = document.frmInfo.txtSoTCTH.value;
            var Room = document.frmInfo.txtRoom.value;
            var SLSV = document.frmInfo.txtSLSV.value;
            
  

    
            if(ClassId.length==0 || tclt.length==0 || tcth.length==0 ||
                Room.length==0 || SLSV.length == 0){
                alert("Vui Lòng nhập đầy đủ thông tin trược khi submit");
            }else
                //alert("FFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFF");
                document.forms["frmInfo"].submit();
        
    }
         
       </script>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u>Cần bổ sung cơ chế kiểm tra lịch giảng viên, lịch phòng trống</u><br/><br/>
                <form id="form-info" action="../CreateNewClass?function=registry" method="post" name="frmInfo">
                    <u>Phần cung cấp thông tin về lớp học sẽ tạo.</u><br/><br/>
                    <table id="table-info">
                        <tr>
                            <td>Mã lớp</td>
                            <td>
                                <input type="text" name="txtClassId">
                            </td>
                        </tr>
                        <tr>
                            <td>Tên Môn học</td>
                            <td>
                                <select name="sClassName" id="select-long">
                                    <%for(i = 0; i < numS; i++){%>
                                    <option><%=subjectInfo.get(count++)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giảng viên</td>
                            <td>
                                <select name="sLecturerName">
                                    <%for(i = 0; i < numL; i++){%>
                                    <option><%=lecturerNames.get(i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Số tín chỉ LT</td>
                            <td>
                                <input type="text" name="txtSoTCLT" width="250px">
                            </td>
                        </tr>
                        <tr>
                            <td>Số tín chỉ TH</td>
                            <td>
                                <input type="text" name="txtSoTCTH" width="250px">
                            </td>
                        </tr>
                        <tr>
                            <td>Số lượng SV</td>
                            <td>
                                <input type="text" name="txtSLSV" width="250px">
                            </td>
                        </tr>
                        <tr>
                            <td>Thứ</td>
                            <td>                                
                                <select name="sDay">
                                    <%for(i = 2; i <= 7; i++){%>
                                        <option><%=i%></option>
                                    <%}%>
                                </select>                                
                            </td>
                        </tr>
                        <tr>
                            <td>Ca học</td>
                            <td>
                                <select name="sTime">
                                    <option>Sáng</option>
                                    <option>Chiều</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Phòng học</td>
                            <td>
                                <input type="text" name="txtRoom">
                            </td>
                        </tr>
                    </table>
                    <br/><br/>
                    <!--<input type="submit" value="Kiểm tra" width="120px">-->
                    <input type="button" value="Thêm" onclick="InsertNewClass()">
		</form>

		<br/><br/>
		<u>Phần này liệt kê các lớp hiện có.</u><br/><br/>
		<table id="table-list-class">
                    <%i=0;%>
                    <tr>
                        <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>
                    </tr>
                    <%while(i<numC){%>
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001"><%=classExisted.get(i++)%></a></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                        <td><%=classExisted.get(i++)%></td>
                    </tr>
                    <%}%>
                    <!--
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                    -->
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
