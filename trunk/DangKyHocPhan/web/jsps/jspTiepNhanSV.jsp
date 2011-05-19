<%-- 
    Document   : jspTiepNhanSV
    Created on : Apr 23, 2011, 4:29:43 PM
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
    String cMax = (String)session.getAttribute("numcourse");
    if(cMax == null)
           cMax = "1";
    int CourseMax = Integer.parseInt(cMax);
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiếp Nhận Sinh Viên</title>
        <style media="all" type="text/css">
            #form-add-one{
                float: left;
                margin-left: 10px;
                margin-top: 20px;
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
                float: right;
                margin-right: 20px;                
                margin-bottom: 120px;
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
                margin-top: 25px;
                margin-bottom: 25px;
                border-left: 2px solid;
                border-right: 2px solid;
            }
            
            #form-result table th{                
                background-color: #E3E4FA;
            }
            #form-result table td{
                padding-left: 5px;
                padding-right: 5px;
            }
        </style>
        <script  type = "text/javascript" >
         function PreCheckStudentOne(){
            var MSSV = document.frmAddOne.txtMSSV.value;
            var FirstName = document.frmAddOne.txtFirstName.value;
            var LastName = document.frmAddOne.txtLastName.value;
            var Address = document.frmAddOne.txtThuongTru.value;
            var Home = document.frmAddOne.txtTamTru.value;
            var Phone = document.frmAddOne.txtPhoneNumber.value;
            var Email = document.frmAddOne.txtEmail.value;
            var CMND = document.frmAddOne.txtCMND.value;

            if((MSSV.length == 0)|| (FirstName.length == 0)|| (LastName.length == 0)
                || (Address.length == 0)|| (Home.length == 0)|| (Phone.length == 0)
                || (Email.length == 0)|| (CMND.length == 0)){
                alert("Vui Lòng nhập đầy đủ thông tin trược khi submit");
            }else
                document.forms["frmAddOne"].submit();
         }

         function PreCheckStudentFile(){
            var filename = document.frmFileS.txtPath.value;
                if(filename.length == 0){
                    alert("Vui Lòng file trược khi submit");
            }else
                document.forms["frmFileS"].submit();
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
                <form id="form-add-one" name="frmAddOne" action="../RegistryStudent?function=addone" method="post">
                    <u>Thêm 1 SV vào database.</u><br/><br/>
                    <table id="table-add-one">
                        <tr>
                            <td>MSSV</td> <td><input type="text" name="txtMSSV"></td>
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
                                    <%for(i = 0; i < 31; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonth">
                                    <%for(i = 0; i < 12; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYear">
                                    <%for(i = 0; i < 50; i++){%>
                                        <option><%=(1980+i)%></option>
                                    <%}%>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>Lớp</td>
                            <td>
                            <select name="sClass">
                                    <%for(i = 1; i <= CourseMax; i++){%>
                                        <option>
                                            CNPM <% if(i<10){%>0<%}%><%=i%>
                                        </option>
                                    <%}%>
                            </select>
                            </td>
                    </tr>
                    <tr>
                            <td>Ngày Nhập học</td>
                            <td>
                                <select name="sDayn">
                                    <%for(i = 0; i < 31; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sMonthn">
                                    <%for(i = 0; i < 12; i++){%>
                                        <option><%=(i+1)%></option>
                                    <%}%>
                                </select>
                                <select name="sYearn">
                                    <%for(i = 0; i < 50; i++){%>
                                        <option><%=(1980+i)%></option>
                                    <%}%>
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
                        <td>Địa chỉ thường trú</td> <td><input type="text" name="txtThuongTru"></td>
                    </tr>
                    <tr>
                        <td>Địa chỉ tạm trú</td> <td><input type="text" name="txtTamTru"></td>
                    </tr>
                    <tr>
                        <td>Điện thoại</td> <td><input type="text" name="txtPhoneNumber"></td>
                    </tr>
                    <tr>
                        <td>Email</td> <td><input type="text" name="txtEmail"></td>
                    </tr>
                    <tr>
                        <td>Khóa</td>
                        <td>
                            <select name="sCourse">
                                <%for(i = 1; i <= CourseMax; i++){%>
                                    <option><%=i%></option>
                                <%}%>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Tình Trạng</td>
                        <td>
                            <select name="sIsStuding">
                                <option>Đang học</option>                                
                                <option>Bị giam bằng</option>                                
                                <option>Bảo lưu</option>                                
                                <option>Khác</option>                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Loại hình đào tạo</td>
                        <td>
                            <select name="sType">
                                <option>Chính Qui</option>                                                                                             
                                <option>Khác</option>                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Bậc Học</td>
                        <td>
                            <select name="sBachoc">
                                <option>Đại học</option>                                
                                <option>Cao đẳng</option>                                
                                <option>Cử nhân</option>                                
                                <option>Đào tạo từ xa</option>                                
                                <option>Khác</option>                                
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>CMND</td>
                        <td><input type="text" name="txtCMND"></td>
                    </tr>
                    <!-- isStuding, CMND,Type, Bachoc-->
                </table>
                <br/>
                <input type="button" value="Thêm" onclick="PreCheckStudentOne()">
            </form>

            <br/><br/>
            <form id="form-browse" action="../RegistryStudent?function=addlist"
                  method="post" name="frmFileS" enctype="multipart/form-data">
                <u>Thêm Sinh Viên Từ File</u><br/><br/>
                <table id="table-browse">
                    <tr>
                        <td><input type="file" name="txtPath"></td>
                    </tr>
                    <tr>
                        <td><input type="button" onclick="PreCheckStudentFile()" value="Thêm"></td><td></td>
                    </tr>
                </table>
            </form>
            
            <br/><br/>


            <form action="#" method="post" id="form-result">
                <h4><a href="../ViewListStudent?search=no&order=FullName">Xem Danh sách SV</a></h4>
                <br/>
                <%if(listResult != null){%>
                <u>Kết quả:</u>
                <table>
                    <tr>
                        <th>STT</th><th>Họ Và Tên</th><th>MSSV</th><th>Lớp</th><th>Email</th><th>Giới Tính</th><th>Ghi Chú</th>
                    </tr>
                    <%
    //CELL 1// FullName//CELL2: MSSV//CELL3: BirthDay//CELL4: Lop - Class//CELL5: Email
    //CELL6: PhoneNumber//CELL7: TamTru/CELL8: ThuongTru
    //CELL: Status: Đang học, đang bảo lưu, đang ...
    //CELL10: CourseNumber//CELL11: Sex//CELL12: ID (CMND)
    //CELL13: Hình thức: Chính qui, tại chức, ...
    //CELL14: Bậc học : đại học, cao đẳng, cử nhân, trung cấp,...
                    i = 0;

                        while(i<n){
                        %>
                        <tr>
                            <td><%=STT++%></td>
                            <td><%=listResult.get(i++)%></td><!-- Họ và tên: Cell 1  i = 1-->
                            <td><a href="../StudentDetail?MSSV=<%=listResult.get(i)%>"><%=listResult.get(i++)%></a></td><!--MaSSV: Cell 2  i = 2-->
                            <%i++;%><td><%=listResult.get(i++)%></td><!--Class: Cell 4  i = 4-->
                            <td><%=listResult.get(i++)%></td><!--Email: Cell 5  i = 5-->
                            <%i+=5;%><td><%=listResult.get(i++)%></td><!--Sex: Cell 11-->
                            <%i+=3;%> <td><%=listResult.get(i++)%></td><!--Ghi Chu: Cell 15  i = 15-->
                        </tr>
                        <%}%>
                    <%}%>
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