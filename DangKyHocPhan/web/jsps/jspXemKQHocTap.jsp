<%-- 
    Document   : jspXemKQHocTap
    Created on : Apr 23, 2011, 4:34:04 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem kết quả học tập</title>
        <style media="all" type="text/css">

                #form-student{
                margin-left: 20px;
                margin-top: 50px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;                                
                width: 650px;
                }
                #form-detail{
                margin-top: 10px;
                margin-left: 20px;
                margin-bottom: 120px;
                padding-left: 20px;
                padding-right: 20px;
                width: 650px;
                background-color: #9E7BFF;
                }

                #form-detail table{
                width: 100%;
                padding-left: 5px;
                padding-right: 5px;
                }
                #form-detail table th{
                background-color: #7F38EC;
                height: 30px;
                }

                #form-detail table td{
                background-color: #ffe2ff
                }


                #form-result{
                margin-left: 200px;
                margin-bottom: 20px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;                
                border: 3px solid #7F38EC;
                width: 300px;
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
                <form id="form-student">
                    <table>
                        <tr><td>MSSV: </td><td>07520210</td> <td width="120px"></td>  <td>Tổng số TC đã ĐK: </td><td>100</td></tr>
                        <tr><td>Họ Và Tên: </td><td>NgVLộc</td> <td width="120px"></td>   <td>Số TC đã hoàn thành: </td><td>100</td></tr>
                        <tr><td>Khoa: </td><td>CNPM02</td>  <td width="120px"></td>   <td>ĐTB: </td><td>5.55</td></tr>
                    </table>
		</form>
                
		<form id="form-detail">
			<u>Chi tiết</u>
			<table>
				<tr>
					<th>STT</th><th>Mã MH</th><th>Tên MH</th><th>Số TC</th><th>Điểm GK</th><th>Điểm Cuối kỳ</th><th>TB</th>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
				<tr>
					<td>001</td><td>SE001</td><td>Lập Trình Hướng Đối Tượng</td><td>4</td><td>9.0</td><td>9.0</td><td>9.0</td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="Xuất File">
		</form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
