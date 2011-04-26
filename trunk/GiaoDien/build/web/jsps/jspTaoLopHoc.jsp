<%-- 
    Document   : jspTaoLopHoc
    Created on : Apr 23, 2011, 4:30:16 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

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
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <u>Cần bổ sung cơ chế kiểm tra lịch giảng viên, lịch phòng trống</u><br/><br/>
		<form id="form-info" action="#" method="post">
			<u>Phần cung cấp thông tin về lớp học sẽ tạo.</u><br/><br/>
			<table id="table-info">
				<tr>
					<td>Mã lớp</td>
					<td>
						<select name="sClassId">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Tên Lớp</td>
					<td>
						<select name="sClassName" id="select-long">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Mã GV</td>
					<td>
						<select name="sTeacherId">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Tên GV</td>
					<td>
						<input type="text" name="txtTeacherName" width="250px">
					</td>
				</tr>
				<tr>
					<td>Số tín chỉ LT</td>
					<td>
						<select name="sLT">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Số tín chỉ TH</td>
					<td>
						<select name="sTH">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Thứ</td>
					<td>
						<select name="sDay">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Ca học</td>
					<td>
						<select name="sTime">
							<option>--------</option>
						</select>
					</td>
				</tr>
				<tr>
					<td>Phòng học</td>
					<td>
						<select name="sRoom">
							<option>--------</option>
						</select>
					</td>
				</tr>
			</table>
			<br/><br/>
			<input type="submit" value="Kiểm tra" width="120px">
			<input type="submit" value="Thêm" width="120px">
		</form>

		<br/><br/>
		<u>Phần này liệt kê các lớp hiện có.</u><br/><br/>
		<table id="table-list-class">
                    <tr>
                        <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>
                    </tr>
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                    <tr>
                        <td><a href="jspChiTietLopHoc.jsp?id=SE001">SE001</a></td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>
                    </tr>
                </table>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
