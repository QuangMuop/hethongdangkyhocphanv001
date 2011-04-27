<%-- 
    Document   : jspXemChuongTringDaoTao
    Created on : Apr 23, 2011, 4:33:27 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem chương trình đào tạo</title>
        <style media="all" type="text/css">
            table{
                margin-top: 25px;
                margin-left: 12px;
                margin-bottom: 120px;
                width: 680px;
                }

                table th{
                height: 15px;
                background-color: #ff3fe5;
                }

                table td{
                text-align: center;
                background-color: #79d2ff;
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
               <h2 align="center">CHƯƠNG TRÌNH KHUNG</h2>
        <p>
				MSSV: 07520210 <br/>
				Khoa: Công nghệ phần mềm
		</p>
		<hr/><hr/>

		<a>Xem theo: </a>
		<select>
			<option>Học kỳ</option>
			<option>Loại môn</option>
		</select>
		<br/>
		<p>
			Tổng số môn đã học: 33	<br/>
			Tổng số tín chỉ cần tích lũy: 147	<br/>
			Tổng số tín chỉ đã tích lũy: 100
		</p>

		<table>
			<tr>
				<th>STT</th><th>Học kỳ</th><th>Mã Môn</th><th>Tên môn</th><th>Số TC</th><th>LT</th><th>TH</th><th>Điểm</th><th>Đạt</th>
			</tr>
			<tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
			</tr>
                        <tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
			</tr>
                        <tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
			</tr>
                        <tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
			</tr>
                        <tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
			</tr>
                        <tr>
                            <td>1</td><td>1</td><td>SE001</td><td>Lập trình hướng đối tượng</td><td>4</td><td>3</td><td>1</td><td>32</td><td>x</td>
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
