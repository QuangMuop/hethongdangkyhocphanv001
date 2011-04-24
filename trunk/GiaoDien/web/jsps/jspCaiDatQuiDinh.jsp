<%-- 
    Document   : jspCaiDatQuiDinh
    Created on : Apr 23, 2011, 4:32:16 PM
    Author     : ngloc_it
--%>
<%@include file="jspmenu.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Trang Cài Đặt Qui Định.</title>
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
        <h1>BẠN ĐANG Ở TRANG CÀI ĐẶT QUI ĐINH!</h1><br/>
        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>

        <form action="" method="post">
            <table>
                <tr align="center">
                    <th>Mục</th><th>Giá Trị hiện tại</th><th>Giá Trị Mới</th>
                </tr>
                <tr>
                    <td>Tuổi SV Tối Thiểu</td>
                    <td align="center">15</td>
                    <td align="center">
                        <select name="sTuoiSVToiThieu">
                            <option>14</option>
                            <option>15</option>
                            <option>16</option>
                            <option>17</option>
                            <option>18</option>
                            <option>19</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tuổi SV Tối Đa</td>
                    <td align="center">27</td>
                    <td align="center">
                        <select name="sTuoiSVToiDa">
                                <option>24</option>
                                <option>25</option>
                                <option>26</option>
                                <option>27</option>
                                <option>28</option>
                                <option>29</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tuổi GV Tối Thiểu</td>
                    <td align="center">30</td>
                    <td align="center">
                        <select name="sTuoiGVToiThieu">
                            <option>28</option>
                            <option>29</option>
                            <option>30</option>
                            <option>31</option>
                            <option>32</option>
                            <option>33</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Tuổi GV Tối Đa</td>
                    <td align="center">65</td>
                    <td align="center">
                        <select name="sTuoiGVToiDa">
                            <option>62</option>
                            <option>63</option>
                                <option>64</option>
                                <option>65</option>
                                <option>66</option>
                                <option>67</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Số TC tối thiểu/HK/SV</td>
                    <td align="center">15</td>
                    <td align="center">
                        <select name="sTCToiThieu">
                            <option>14</option>
                            <option>15</option>
                            <option>16</option>
                            <option>17</option>
                            <option>18</option>
                            <option>19</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Số TC tối đa/HK/SV</td>
                    <td align="center">25</td>
                    <td align="center">
                        <select name="sTCToiDa">
                            <option>24</option>
                            <option>25</option>
                            <option>26</option>
                            <option>27</option>
                            <option>28</option>
                            <option>29</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Học Vị Tối Thiều GV</td>
                    <td align="center">Cao Học</td>
                    <td align="center">
                        <select name="sHVToiThieu">
                            <option>Cao Học</option>
                            <option>Thạc Sĩ</option>
                            <option>Tiến Sĩ</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Số SV Tối Thiểu/Lớp</td>
                    <td align="center">35</td>
                    <td align="center">
                        <select name="sSVToiThieuLop">
                            <option>30</option>
                            <option>22</option>
                            <option>24</option>
                            <option>25</option>
                            <option>26</option>
                            <option>28</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Số SV Tối Đa/Lớp</td>
                    <td align="center">125</td>
                    <td align="center">
                        <select name="sTCToiDa">
                            <option>100</option>
                            <option>120</option>
                            <option>125</option>
                            <option>130</option>
                            <option>135</option>
                            <option>140</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Số Điểm HT Môn học</td>
                    <td align="center">5.0</td>
                    <td align="center">
                        <select name="sDiem">
                            <option>4.5</option>
                            <option>5.0</option>
                            <option>5.5</option>
                        </select>
                    </td>
                </tr>
            </table>
            <input id="button-update" type="submit" name="btnChange" value="Update">
        </form>

        <br/><br/><br/><br/><br/><br/><br/><br/>
    </body>
</html>
