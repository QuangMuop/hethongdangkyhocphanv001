<%@page import="system.dto.ClsNews"%>
<%@page import="system.dto.clsComment"%>
<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
    ArrayList<ClsNews> list = (ArrayList<ClsNews>) session.getAttribute("news");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý tin tức</title>
        <style media="all" type="text/css">

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
                background-color: #5F676D;
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
                <br><h3>Danh sách các thông báo của khoa:</h3><br>
                <hr/><hr/><br>
                <form id="formdetail" name="formdetail">
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th>STT</th><th>Ngày đăng</th><th >Nội dung</th><th>Tình trạng</th><th>Sửa</th><th>Xóa</th>
                        </tr>
                        <%for (int i = 0; i < list.size(); i++) {%>
                        <tr>
                            <td><%=i + 1%></td>
                            <td><%=list.get(i).GetDate()%></td>
                            <td><%=list.get(i).GetContent().substring(0, 50)%>....</td>
                            <%if (list.get(i).GetType() == 0) {%>
                            <td>Đang đăng</td>
                            <%} else {%>
                            <td>Chưa đăng</td>
                            <%}%>
                            <%if (list.get(i).GetType() == 0) {%>
                            <td><a href="../ServNews?action=update&Id=<%=list.get(i).GetId()%>">Gỡ bõ</a> </td>
                            <%} else {%>
                            <td><a href="../ServNews?action=update&Id=<%=list.get(i).GetId()%>">Đăng</a> </td>
                            <%}%>
                            <td><a href="../ServNews?action=delete&Id=<%=list.get(i).GetId()%>">Xóa</a> </td>
                        </tr>
                        <%}%>
                    </table>
                    <br/>
                </form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>
