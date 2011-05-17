<%-- 
    Document   : jspXemChuongTringDaoTao
    Created on : Apr 23, 2011, 4:33:27 PM
    Author     : ngloc_it
--%>
<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsViewProgram> pro=(ArrayList<clsViewProgram>) session.getAttribute("pro");
clsStudent student =(clsStudent) session.getAttribute("student");
int n=pro.size();
int j=0;
int numSub=0;
int numTC=0;
int SumTC=0;
for(j=0;j<n;j++){
    if(pro.get(j).getMark()>=5){
    numSub++;
    numTC+=pro.get(j).getNumTC();
    }
    SumTC+=pro.get(j).getNumTC();
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem chương trình đào tạo</title>
        <style media="all" type="text/css">
            table{
                margin-top: 10px;
                margin-left: 12px;
                margin-bottom: 120px;
                width: 750px;
                }

                table th{
                height: 15px;
                background-color: #00ff00;
                }

                table td{
                text-align: center;
                background-color: #ffe2ff;
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
                <h2 align="center">CHƯƠNG TRÌNH KHUNG</h2><br>
                <b>MSSV: <%=student.getCode()%></b><br>
                <b>Họ Tên: <%=student.getFullname()%></b>
                <p align="right"><b>Khoa: Kỹ thuật phần mềm</b></p>
               	<hr/><hr/>
               <p>
			Tổng số môn đã hoàn thành: <%=numSub%>	<br/>
                        Tổng số tín chỉ đã tích lũy: <%=numTC%><br>
                        Tổng số tín chỉ cần tích lũy: <%=SumTC%><br>
                </p><br>
                <u>Chi tiết chương trình đào tạo:</u>
		<table>
			<tr>
				<th>STT</th><th>Học kỳ</th><th>Mã Môn</th><th>Tên môn</th><th>Số TC</th><th>LT</th><th>TH</th><th>Điểm</th><th>Đạt</th>
			</tr>
                        <%
                        for(j=0; j<n; j++){%>
                            <tr>
                                <td><%=j+1%></td><td><%=pro.get(j).getSemester()%></td><td><%=pro.get(j).getSubCode()%></td><td><%=pro.get(j).getSubName()%></td><td><%=pro.get(j).getNumTC()%></td><td><%=pro.get(j).getNumTCLT()%></td><td><%=pro.get(j).getNumTCTH()%></td>
                                 <%if(pro.get(j).getMark()>0){%>
                                <td><%=pro.get(j).getMark()%></td>
                                <%}else {%>
                                <td></td>
                                 <%}%>
                                <%if(pro.get(j).getMark()>=5){%>
                                <td>x</td>
                                <%}else {%>
                                <td></td>
                                 <%}%>
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
</html>
