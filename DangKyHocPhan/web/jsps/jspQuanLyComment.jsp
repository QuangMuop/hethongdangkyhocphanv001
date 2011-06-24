<%@page import="system.dto.clsComment"%>
<%@page import="system.dto.clsProgram"%>
<%@page import="system.dto.clsCourse"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsComment> comment=(ArrayList<clsComment>) session.getAttribute("comment");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quản lý comment</title>
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
                <br><h3>Danh sách các comment chưa giải quyết:</h3><br>
                <hr/><hr/><br>
                <form id="formdetail" name="formdetail">
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th>STT</th><th>Người gửi</th><th >Nội dung</th><th>Xem</th><th>Xóa</th>
                        </tr>
                        <%for(int i=0;i<comment.size();i++){%>
                        <tr>
                            <td><%=i+1%></td>
                            <td><%=comment.get(i).getAuthor()%></td>
                            <%
                             if(comment.get(i).getContent().length()>50){%>
                            <td><%=comment.get(i).getContent().substring(0, 50) %>....</td>
                            <%}else {%>
                            <td><%=comment.get(i).getContent()%></td>
                            <%}%>
                            <td><a href="../servCommentManager?action=detail&Id=<%=comment.get(i).getId()%>">Xem</a> </td>
                            <td><a href="../servCommentManager?action=delete&Id=<%=comment.get(i).getId()%>">Xóa</a> </td>
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
