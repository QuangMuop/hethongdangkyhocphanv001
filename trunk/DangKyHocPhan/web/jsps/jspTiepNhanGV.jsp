<%-- 
    Document   : jspTiepNhanGV
    Created on : Apr 23, 2011, 4:29:54 PM
    Author     : ngloc_it
--%>
<%@page import="java.util.ArrayList"%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%
    int i = 0;
    int n = 0;
    int STT = 1;
    String strErr = "";
    ArrayList<String> listResult = null;
    try{
        listResult = (ArrayList<String>) session.getAttribute("listinfomation");        
        n = listResult.size();
        strErr = "No Error";
     }catch(Exception ex){
        strErr = ex.toString();
     }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiếp nhận giảng viên</title>
        <style media="all" type="text/css">
             #form-add-one{
                    margin-left: 50px;
                    margin-top: 20px;
                    float: left;
                    width: 320px;
                    padding-top: 20px;
                    padding-bottom: 20px;
                    padding-right: 10px;
                    padding-left: 10px;
                    background-color: #92C7C7;
                    border: 3px solid #7F38EC;
                }
                #form-add-one u{
                    background-color: #FFFF00;
                }
                #form-browse{
                    margin-right: 20px;
                    margin-top: 20px;
                    margin-bottom: 120px;
                    float: right;
                    width: 300px;
                    padding-top: 20px;
                    padding-bottom: 20px;
                    padding-right: 10px;
                    padding-left: 10px;
                    background-color: #92C7C7;
                    border: 3px solid #7F38EC;
                }
                #form-browse u{
                    background-color: #FFFF00;
                }
                #form-result{
                    clear: both;
                }
                #form-result table th{
                    height: 15px;
                }
                #form-result table td{
                    margin-left: 5px;
                    margin-right: 5px;
                }
            </style>
            <script  type = "text/javascript" >
         function PreCheckLecturerOne(){
            var MaGV = document.frmAddOne.txtLecturerCode.value;
            var FirstName = document.frmAddOne.txtFirstName.value;
            var LastName = document.frmAddOne.txtLastName.value;
            var Address = document.frmAddOne.txtAddress.value;
            var Phone = document.frmAddOne.txtPhoneNumber.value;
            var Email = document.frmAddOne.txtEmail.value;            

            if((MaGV.length == 0)|| (FirstName.length == 0)|| (LastName.length == 0)
                || (Address.length == 0) || (Phone.length == 0)
                || (Email.length == 0)){
                alert("Vui Lòng nhập đầy đủ thông tin trược khi submit");
            }else
                document.forms["frmAddOne"].submit();
         }

         function PreCheckLecturerFile(){
                var filename = document.frmFile.txtPath.value;
                if(filename.length == 0){
                    alert("Vui Lòng file trược khi submit");
            }else
                document.forms["frmFile"].submit();
         }
       </script>
    </head>
    <body>
        <!--Div Wrapper-->
        <div id="wrapper">
            <div id="mainNav"><!--Main Navigation-->
                <%@include file="jspMainNav.jsp" %>
            </div><!--End Navigation-->
            <div id="content"><!--Main Contents-->
                <form id="form-add-one" name="frmAddOne" action="../RegistryLecturer?function=addone" method="post">
                    <u>Thêm 1 GV vào database.</u><br/><br/>
                    <table id="table-add-one">
                        <tr>
                            <td>Mã GV</td> <td><input type="text" name="txtLecturerCode"></td>
                        </tr>
                        <tr>
                            <td>Họ</td> <td><input type="text" name="txtFirstName"></td>
                        </tr>
                        <tr>
                            <td>Tên</td> <td><input type="text" name="txtLastName"></td>
                        </tr>
                        <tr>
                            <td>Ngày Sinh</td>
                            <td>
                                <select name="sDay">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select>
                                <select name="sMonth">
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                </select>
                                <select name="sYear">
                                    <option>1991</option>
                                    <option>1992</option>
                                    <option>1993</option>
                                    <option>1994</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Giới Tính</td>
                            <td>
                                <select name="sSex">
                                    <option>Nam</option>
                                    <option>Nữ</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Địa chỉ</td> <td><input type="text" name="txtAddress"></td>
                        </tr>
                        <tr>
                            <td>Điện thoại</td> <td><input type="text" name="txtPhoneNumber"></td>
                        </tr>
                        <tr>
                            <td>Email</td> <td><input type="text" name="txtEmail"></td>
                        </tr>
                        <tr>
                            <td>Học Hàm</td>
                            <td>
                                <select name="sHocHam">
                                    <option>Cao Học</option>
                                    <option>Thạc sĩ</option>
                                    <option>Tiến Sĩ</option>
                                    <option>P.Giáo Sư</option>
                                    <option>Khác</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Học Vị</td>
                            <td>
                                <select name="sHocVi">
                                    <option>Cao Học</option>
                                    <option>Thạc sĩ</option>
                                    <option>Tiến Sĩ</option>
                                    <option>P.Giáo Sư</option>
                                    <option>Khác</option>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>CMND</td>
                            <td><input type="text" name="txtCMND"></td>
                        </tr>
                    </table>
                    <input type="button" value="Thêm" onclick="PreCheckLecturerOne()">
                </form>

                <br/><br/>
                <form id="form-browse" name="frmFile" action="../RegistryLecturer?function=addlist"
                      method="post" enctype="multipart/form-data">
                    <u>Thêm Giảng Viên Từ File</u><br/><br/>
                    <table id="table-browse">
                        <tr>
                            <td><input type="file" name="txtPath"></td>
                        </tr>
                        <tr>
                            <td><input type="button" onclick="PreCheckLecturerFile()" value="Thêm"></td><td></td>
                        </tr>
                    </table>
                    <br/><br/><br/>
                </form>

                <form action="" id="form-result">                    
                    <%  if(n>0){
                            i = 0;
                            //n = listResult.size();
                            //1. LecturerCode,   2. FullName,     3. BirthDay, 4. Email, 5. Phone
                            //6. Address,   7. HocHam,  8. Degree,  9.Gender,   10. CMND.
                    %>                           
                            <u>Kết quả:</u>
                            <table>
                                <tr>
                                    <th>Mã GV</th><th>Họ Và Tên</th><th>Địa Chỉ</th><th>Giới Tính</th><th>Ghi Chú</th>
                                </tr>
                            <%while(i<n){%>
                                <tr>
                                    <td><a href="../LecturerDetail?lecturerecode=<%=listResult.get(i)%>"> <%=listResult.get(i++)%></a></td> <!--i = 1-->
                                    <td><%=listResult.get(i++)%></td> <!--i = 2-->
                                    <%i+=3;%> <td> <%=listResult.get(i++)%> </td> <!--i = 6-->
                                    <%i+=2;%><td><%=listResult.get(i++)%></td> <!--i = 9-->
                                    <%i+=1;%><td><%=listResult.get(i++)%></td> <!--i = 11-->
                                </tr>                            
                              <%}%>
                              </table>
                    <%}%>
                     <br/><br/>
                </form>
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
</html>