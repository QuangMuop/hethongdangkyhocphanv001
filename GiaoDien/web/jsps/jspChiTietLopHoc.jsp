<%-- 
    Document   : jspChiTietLopHoc
    Created on : 26-04-2011, 11:14:32
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiêt lớp học</title>
        <style media="all" type="text/css">
            #form-class-info{
            margin-left: 250px;
            margin-top: 20px;
            width: 350px;
            border: 2px solid;
            background-color: #f3df02;
            }

            #form-class-info table td{
            font-weight: bold
            }

            #form-list-student{
            margin-left: 200px;
            margin-top: 20px;
            margin-bottom: 120px;
            width: 500px;
            border-left: 2px solid;
            border-right: 2px solid;
            background-color: #f3df02;
            }

            #form-list-student table{
            width: 100%
            }

            #form-list-student table th{
            background-color: #ff02ed;
            border: 1px solid;
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
                <p>
            trong trang này: SV có thể xem DS SV, thông tin của lớp học đó.<br/>
            Quản lý khoa được quyền xuất DS SV ra file.
        </p>
        <br/><br/>
		<form id="form-class-info" action="#" method="post">
			<u>Phần cung cấp thông tin về lớp học.</u><br/><br/>
			<table>
				<tr>
					<td>Mã lớp: </td><td>SE001</td>
				</tr>
				<tr>
					<td>Tên Lớp: </td><td>Lập trình hướng đối tượng</td>
				</tr>
				<tr>
					<td>Mã GV: </td><td>GV001</td>
				</tr>
				<tr>
					<td>Tên GV: </td><td>Ts. Nguyễn Văn A</td>
				</tr>
				<tr>
					<td>Số Lượng SV: </td><td>1001</td>
				</tr>
			</table>
			<br/><br/>
		</form>

		<br/><br/>
		<u>Phần này liệt Danh sach SV trong lớp.</u><br/><br/>
		<form name="form_list_student" id="form-list-student" action="#" method="post">
			<table id="table-list-class">
				<tr>
					<th><a href="#">STT</a></th><th><a href="#">MSSV</a></th><th><a href="#">Họ Và Tên</a></th><th><a href="#">Khoa</a></th><th><a href="#">TG ĐK</a></th>
				</tr>
				<tr>
					<td>001</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>
				</tr>
				<tr>
					<td>002</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>
				</tr>
				<tr>
					<td>003</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>
				</tr>
				<tr>
					<td>004</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>
				</tr>
				<tr>
					<td>005</td><td>09520210</td><td>Nguyễn Văn A</td><td>CNPM</td><td>11:20 2-4-2011</td>
				</tr>
			</table>
			<br/>
			<input type="submit" value="   Xuất file   ">
		</form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
