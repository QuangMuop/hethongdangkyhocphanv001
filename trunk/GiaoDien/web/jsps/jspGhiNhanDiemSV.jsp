<%-- 
    Document   : jspGhiNhanDiemSV
    Created on : Apr 23, 2011, 4:31:30 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ghi nhận điểm SV</title>
        <style media="all" type="text/css">
            form{
            margin-left: 120px;
            margin-top: 50px;
            margin-bottom: 120px;
            padding-left: 20px;
            padding-top: 20px;
            padding-bottom: 20px;
            width: 450px;
            border: 2px solid #d20019;
            background-color: #f3e3e4;
            }

            form table{
            width: 100%;
            }

            form table th{
            background-color: #02ffff;

            }
            form table tr{
            background-color: #d2ff02;
            height: 20px
            }

            form table select{
            width: 100%
            }


            #btn{
            margin:20px auto;
            background-color: #dd3399;
            }

            #txtinput{
            width: 100%;
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
                    Phần này QLK nhập điểm SV cho từng môn học.<br/>
                    điểm được cung cấp bởi các GV phụ trách môn học trong một file excel.
                </p>

                <br/><br/>

		<form action="#" method="post" name="frm_Input_Score">
			<table>
				<tr>
					<th></th><th>Mã Lớp</th><th>Tên Lớp</th><th></th>
				</tr>
				<tr>
					<td>Chọn Lớp</td>
					<td>
						<select name="sClassId">
							<option>SE001</option>
						</select>
					</td>
					<td>
						<select name="sClassName">
							<option>Lập trình hướng đối tượng</option>
						</select>
					</td>
					<td></td>
				</tr>
				<tr>
					<td></td><td></td><td></td><td></td>
				</tr>
				<tr>
					<td>Chọn File</td><td colspan="2"><input id="txtinput" type="text" name="txtFilePath"></td><td><input type="submit" value="Tìm File"></td>
				</tr>
				<tr>
					<td colspan="4"><input id="btn" type="submit" value="Nhập điểm."></td>
				</tr>
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
