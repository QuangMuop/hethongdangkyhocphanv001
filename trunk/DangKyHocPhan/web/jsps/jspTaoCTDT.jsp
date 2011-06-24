<%@page import="system.dto.clsSubject"%>
<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<Integer> procode = (ArrayList<Integer>) session.getAttribute("procode");
    ArrayList<clsSubject> sub = (ArrayList<clsSubject>) session.getAttribute("sub");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tạo mới một chương trình đào tạo</title>
        <style media="all" type="text/css">

            #pro{
                margin-left: 10px;
                margin-top: 10px;
                margin-bottom:  10px;
                width: 1000px;
            }
            #pro table{
                width: 100%;
                padding-left: 5px;
                padding-right: 5px;
            }
            #formdetail table{
                width: 100%;
                padding-left: 10px;
                padding-right: 10px;
                text-align: center;

            }
            #formdetail table th{
                background-color:#00ff00;
                height: 30px;
                border-color: black;
            }

            #formdetail table td{
                text-align: center;
                background-color: #5F5A59;
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
                <br><h3>Tạo mới một chương trình đào tạo khung của khoa Kỹ Thuật Phần Mềm:</h3>
                <form action="" name="pro"  id="pro">
                    <table>
                        <tr>
                            <td width="150px"><b>Mã chương trình: </b> </td>
                            <td><input type="text" readonly name="maCT" id="maCT" value="<%=procode.size() + 1%>"> </td>
                    </table>
                </form>
                <hr/><hr/>
                <form id="formdetail" name="formdetail" action="../servProManage?action=preview" method="post">
                    <u>Chi tiết</u>
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th>Mã môn học</th><th >Tên môn học</th><th>Học kỳ</th><th>Chọn</th>
                        </tr>
                        <%for (int i = 0; i < sub.size(); i++) {%>
                        <tr>
                            <td><%=sub.get(i).getSubCode()%></td>
                            <td><%=sub.get(i).getSubName()%></td>
                            <td>
                                <select name="<%=sub.get(i).getSubCode()%>"
                                        <%for (int j = 0; j <= 9; j++) {%>
                                        <option value="<%=j%>"><%=j%></option>
                                    <%}%>
                                </select>
                            </td>
                            <td><input type="checkbox" name="check" value="<%=sub.get(i).getSubCode()%>"></td>
                        </tr>
                        <%}%>
                    </table>
                    <br/>
                    <input type="submit" value="Tạo mới">
                </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
