<%-- 
    Document   : jspXemQuiDinh
    Created on : Apr 23, 2011, 4:35:04 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Qui Định.</title>
        <style media="all" type="text/css">
            table{
                border: 3px solid #ff092d;
                margin-left: 25%;
                margin-top: 100px;
                padding: .2cm;
                width: 50%;
                background-color: #E0FFFF;
            }
            table th{
                border: 2px solid #153E7E;
                background: #488AC7;
                height: 38px;
            }
            table td{
                border: 1px solid #d53E7E;
                background: #98AFC7;
                height: 25px;
            }
            table option{
                width: 40px;
            }

            #button-update{
                margin-left: 45%;
                margin-top: 25px;
                border: 2px solid #83021C;
                text-transform: uppercase;
                width: 125px;
                height: 45px;
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
                <table>
                <tr align="center">
                    <th>Mục</th><th>Giá Trị</th>
                </tr>
                <tr>
                    <td>Tuổi SV Tối Thiểu</td>
                    <td align="center">15</td>
                </tr>
                <tr>
                    <td>Tuổi SV Tối Đa</td>
                    <td align="center">27</td>
                </tr>
                <tr>
                    <td>Tuổi GV Tối Thiểu</td>
                    <td align="center">30</td>
                </tr>
                <tr>
                    <td>Tuổi GV Tối Đa</td>
                    <td align="center">65</td>
                </tr>
                <tr>
                    <td>Số TC tối thiểu/HK/SV</td>
                    <td align="center">15</td>
                </tr>
                <tr>
                    <td>Số TC tối đa/HK/SV</td>
                    <td align="center">25</td>
                </tr>
                <tr>
                    <td>Học Vị Tối Thiều GV</td>
                    <td align="center">Cao Học</td>
                </tr>
                <tr>
                    <td>Số SV Tối Thiểu/Lớp</td>
                    <td align="center">35</td>
                </tr>
                <tr>
                    <td>Số SV Tối Đa/Lớp</td>
                    <td align="center">125</td>
                </tr>
                <tr>
                    <td>Số Điểm HT Môn học</td>
                    <td align="center">5.0</td>
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
