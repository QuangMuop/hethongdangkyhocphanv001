<%@page import="system.dto.clsComment"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
clsComment comment=(clsComment) session.getAttribute("comment");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi tiết comment</title>
   </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <br><h3>Chi tiết comment:</h3>
                <form id="formdetail" name="formdetail" action="#" method="post">
                 <table>
                     <tr>
                         <td width="100px">Người gửi:</td><th><%=comment.getAuthor()%></th>
                     </tr>
                     <tr>
                         <td>Email:</td><th><a href="mailto: <%=comment.getEmail()%>"><%=comment.getEmail()%></a></th>
                     </tr>
                     <tr>
                         <td>Ngày gửi:</td><th><%=comment.getDate()%></th>
                     </tr>
                     <tr>
                     <td>MSSV:</td><th><%=comment.getMSSV()%></th>
                    </tr>
                    <tr>
                     <td>Nội dung</td><th><%=comment.getContent()%></th>
                    </tr>
                </table><br>
                <a href="../servCommentManager?action=delete&Id=<%=comment.getId()%>">Xóa comment này</a>
		</form>

            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
  </html>
