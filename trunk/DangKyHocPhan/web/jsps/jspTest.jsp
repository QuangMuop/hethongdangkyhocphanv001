<%-- 
    Document   : jspTest
    Created on : 04-05-2011, 23:30:35
    Author     : ngloc_it
--%>

<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Test</title>
        <%
            request.setCharacterEncoding("UTF-8");
           
        %>
    </head>
    <body>
        <h4>Tìm kiếm một giảng viên theo tên:</h4>
        <form action="../justfortest?action=search" method="post">
            Họ và tên giảng viên: <input type="text" name="txtName"/>
            <input type="submit" value="Run"/>
        </form>
        <br/><br/><br/>
        <form action="../justfortest?action=insert" method="post">
            <h4>Thêm 1 giảng viên vào databse:</h4>
            <table>
                <tr>
                    <td>Mã GV</td>
                    <td><input type="text" name="txtId"></td>
                </tr>
                <tr>
                    <td>Họ và tên</td>
                    <td><input type="text" name="txtFullName"></td>
                </tr>
                <tr>
                    <td>Ngày Sinh</td>
                    <td>
                        <%int i = 0;%>
                        <select name="sDay">
                            <%for(i = 0; i < 31; i++){%>
                                <option><%=(i+1)%></option><%
                            }%>
                        </select>
                        <select name="sMonth">
                            <%for(i = 0; i < 12; i++){%>
                                <option><%=(i+1)%></option><%
                            }%>
                        </select>
                        <select name="sYear">
                            <%for(i = 0; i < 50; i++){%>
                                <option><%=(i+1950)%></option><%
                            }%>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type="text" name="txtEmail"></td>
                </tr>
                <tr>
                    <td>Điện Thoại</td>
                    <td><input type="text" name="txtPhone"></td>
                </tr>
                <tr>
                    <td>Địa chỉ</td>
                    <td><input type="text" name="txtAddress"></td>
                </tr>
                <tr>
                    <td>Học Hàm</td>
                    <td>
                        <select name="sHocHam">
                            <option>null</option>
                            <option>GS</option>
                            <option>PGS</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Học Vị</td>
                    <td>
                        <select name="sHocVi">
                            <option>null</option>
                            <option>Tiến Sĩ</option>
                            <option>Thạc Sĩ</option>
                            <option>Cao Học</option>
                        </select>
                    </td>
                </tr>
            </table>
            <input type="submit" value="Thêm">
        </form>
    </body>
</html>
