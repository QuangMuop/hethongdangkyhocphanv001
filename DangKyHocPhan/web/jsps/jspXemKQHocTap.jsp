<%@page import="system.dto.*;"%>
<%@page import="java.util.ArrayList" %>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%
ArrayList<clsDetailResult> result=(ArrayList<clsDetailResult>) session.getAttribute("result");
clsStudent student =(clsStudent) session.getAttribute("student");
ArrayList<clsStudyResult> sr=(ArrayList<clsStudyResult>) session.getAttribute("year");
int n=sr.size();
int m=result.size();
int i,j;
int numTC=0;
float SumMark=0;
float Average=0;
for(j=0;j<m;j++){
    numTC+=result.get(j).getNumTC();
    SumMark+=(result.get(j).getNumTC()*result.get(j).getMark());
    Average=(float)Math.round(SumMark*100/numTC)/100;
}
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Xem kết quả học tập</title>
        <style media="all" type="text/css">

                #form-formstudent{
                margin-left: 20px;
                margin-top: 50px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;                                
                width: 1000px;
                }
                #form-formstudent table{
                width: 100%;
                padding-left: 5px;
                padding-right: 5px;
                }
                #formdetail table{
                width: 100%;
                    padding-left: 10px;
                        padding-right: 10px;
                        
                }
                #formdetail table th{
                background-color:#00ff00;
                height: 30px;
                border-color: black;
                }

                #formdetail table td{
                text-align: center;
                background-color:#686;
                }


                #form-result{
                margin-left: 20px;
                margin-bottom: 20px;
                padding-top: 20px;
                padding-bottom: 20px;
                padding-right: 10px;
                padding-left: 10px;                
                border: 3px solid #7F38EC;
                width: 500px;
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
                <br><h3>Thông tin về kết quả học tập của sinh viên:</h3><br>
                <form action="" name="formstudent"  id="formstudent">
                    <table>
                        <tr>
                            <td width="200px">MSSV: </td>
                            <td width="100px"><%=student.getCode()%></td>
                            <td width="200px">Họ và tên: </td>
                            <td><%=student.getFullname()%></td>
                        </tr>
                        <tr>
                            <td width="200px">Số tín chỉ đã tích lũy: </td>
                            <td width="100px"><%=numTC%></td>
                            <td width="200px">Điểm trung bình:</td>
                            <td><%=Average%></td>
                          </tr>
                         <tr>
                             <td width="50px">Năm học:  </td>
                            <td>
                                <select style="width:90px" name="year" id="year" onchange="reloadResult()">
                                     <option value="All">Tất cả</option>
                                  <% for(i=0;i<n;i++){%>
                                  <option value="<%=sr.get(i).getYear()%>"><%=sr.get(i).getYear()%></option>
                                  <%}%>
                                 </select>
                            </td>
                            <td width="50px">Học kỳ:</td>
                            <td>
                                <select style="width:70px" name="semester" onchange="reloadResult()">
                                   <option value="0">Tất cả</option>
                                   <option value="1">1</option>
                                   <option value="2">2</option>
                                 </select>
                            </td>
                         </tr>
                       
                    </table>
		</form>
                <hr/><hr/>
		<form id="formdetail" name="formdetail">
                 <u>Chi tiết</u>
                    <table id="detail" name="detail" border="2" bordercolor="yellow" >
                        <tr>
                            <th align="center" width="100px">Năm học</th><th align="center" width="70px">Học kỳ</th><th align="center" width="100px">Mã môn</th><th align="center" width="300px">Tên môn học</th><th align="center" width="70px">Số TC</th><th align="center" width="80px">Điểm</th><th align="center" width="100px">Nhân hệ số</th>
                        </tr>
                             <%
                                numTC=0;
                                SumMark=0;
                                Average=0;
                                for(j=0;j<m;j++){%>
				<tr>
                                    <td><%=result.get(j).getYear()%></td><td><%=result.get(j).getSemester()%></td><td><%=result.get(j).getSubCode()%></td><td><%=result.get(j).getSubName()%></td><td><%=result.get(j).getNumTC()%></td><td><%=result.get(j).getMark()%></td><td><%=result.get(j).getNumTC()*result.get(j).getMark()%></td>
				</tr>
				<%
                                numTC+=result.get(j).getNumTC();
                                SumMark+=(result.get(j).getNumTC()*result.get(j).getMark());
                                Average=(float)Math.round(SumMark*100/numTC)/100;
                                }%>
                            <tr>
                                <td align="center">
                                    <h1>Tổng kết</h1>
                                </td>
                                <td ></td>
                                <td></td>
                                <td align="center"><h1>Trung bình: <%= Average %></h1></td>
                                <td align="center"><h1><%=numTC%></h1></td>
                                <td></td>
                                <td align="center"><h1><%=SumMark%></h1></td>
                            </tr>
			</table>
			<br/>
                </form>
                <form action="../DownloadFile?action=studentresult&mssv=<%=student.getCode()%>" method="post" id="frmexport">
                    <a href="../DownloadFile?action=studentresult&mssv=<%=student.getCode()%>"> Tải file</a>
                </form>
                
            </div><!--End Contents-->

            <div id="footer"><!--Footer-->
                 <%@include file="jspFooter.jsp" %>
            </div><!--End footer-->
        </div>
        <!--End Wrapper-->
    </body>
    <script  type = "text/javascript" >
        function createRequestObject(){
            var req;
            if(window.XMLHttpRequest){
                //For Firefox, Safari, Opera
                req = new XMLHttpRequest();
            }
            else if(window.ActiveXObject){
                //For IE 5+
                req = new ActiveXObject("Microsoft.XMLHTTP");
            }
            else{
                //Error for an old browser
                alert('Your browser is not IE 5 or higher, or Firefox or Safari or Opera');
            }
            return req;
        }

        //Make the XMLHttpRequest Object
        var http = createRequestObject();
        function reloadResult(){
            if(http){
                var year=document.formstudent.year.value;
                var semester=document.formstudent.semester.value;
                http.open("GET","../servStudyResult?first="+false+"&year="+year+"&semester="+semester,true);
                http.onreadystatechange = handleResponse;
                http.send(null);
            }
        }

        function handleResponse(){
            if(http.readyState == 4 && http.status == 200){
                var detail=document.getElementById("detail");
                detail.innerHTML=http.responseText;
            }
        }
    </script>
</html>
