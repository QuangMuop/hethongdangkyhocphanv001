package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspTaoTaiKhoan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/jsps/jspmenu.jsp");
  }

  private org.apache.jasper.runtime.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.apache.jasper.runtime.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <link href=\"../csss/menu.css\" rel=\"stylesheet\" type=\"text/css\" media=\"screen\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <MARQUEE onmouseover=\"this.stop();\" onmouseout=\"this.start();\" HEIGHT=25 BGCOLOR=#C0C6CE BEHAVIOR=scroll SCROLLAMOUNT=\"4\">\n");
      out.write("            Chào mừng đến với hệ thống đăng ký học phần.\n");
      out.write("        </MARQUEE>\n");
      out.write("\n");
      out.write("        <div id=\"logo\">\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <div id = \"menu\">\n");
      out.write("            <ul>\n");
      out.write("                <li><a href=\"jspTrangChu.jsp\"> Trang chủ </a>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspXemDSLop.jsp\">Xem DS Lớp Học</a> </li>\n");
      out.write("                <li><a href=\"jspXemTKB.jsp\">Xem TKB</a></li>\n");
      out.write("                <li><a href=\"#\">Quản Lý Khoa</a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li> <a href=\"jspTiepNhanSV.jsp\">Tiếp Nhận SV</a> </li>\n");
      out.write("                        <li><a href=\"jspTiepNhanGV.jsp\">Tiếp Nhận GV</a> </li>\n");
      out.write("                        <li> <a href=\"jspLapTKB.jsp\">Lập TKB</a> </li>\n");
      out.write("                        <li><a href=\"jspTaoLopHoc.jsp\">Tạo Lớp Học</a> </li>\n");
      out.write("                        <li><a href=\"jspGhiNhanDiemSV.jsp\">Ghi Nhận Điểm SV</a> </li>\n");
      out.write("                        <li><a href=\"jspTaoTaiKhoan.jsp\">Tạo Tài Khoản Mới</a> </li>\n");
      out.write("                        <li> <a href=\"jspCapNhatTaiKhoan.jsp\">Cập Nhật Tài Khoản</a> </li>\n");
      out.write("                        <li><a href=\"jspCaiDatQuiDinh.jsp\">Cài Đặt Qui Định</a> </li>                        \n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"#\">Sinh Viên</a>\n");
      out.write("                <ul>\n");
      out.write("                        <li> <a href=\"jspDangKyMonHoc.jsp\">Đăng Ký Môn Học</a> </li>\n");
      out.write("                        <li><a href=\"jspXemChuongTrinhDaoTao.jsp\">Xem Chương Trình Đào Tạo</a> </li>\n");
      out.write("                        <li><a href=\"jspXemTKB.jsp\">Xem TKB</a> </li>\n");
      out.write("                        <li> <a href=\"jspXemKQHocTap.jsp\">Xem KQ Học Tập</a> </li>\n");
      out.write("                        <li><a href=\"jspCapNhatThongTin.jsp\">Cập Nhật Thông Tin</a> </li>\n");
      out.write("                        <li> <a href=\"jspGuiYeuCau.jsp\">Gửi Yêu Cầu</a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspLogin.jsp\">Login</a></li>\n");
      out.write("                <li><a href=\"#\">Qui định</a>\n");
      out.write("                <ul>\n");
      out.write("                        <li> <a href=\"jspXemQuiDinh.jsp\">Xem Qui Định</a> </li>\n");
      out.write("                        <li><a href=\"jspCaiDatQuiDinh.jsp\">Sửa Qui Định</a> </li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li><a href=\"jspLienHe.jsp\">Liên Hệ</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("        <br/><br/>\n");
      out.write("        <hr/><hr/>        \n");
      out.write("    </body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"\n");
      out.write("   \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Tạo Tài Khoản Mơi.</title>\n");
      out.write("        <style media=\"all\" type=\"text/css\">\n");
      out.write("            #table-info{\n");
      out.write("                margin-left: 240px;\n");
      out.write("                margin-top: 75px;\n");
      out.write("                padding: 22 5 22 5;\n");
      out.write("                width: 350px;\n");
      out.write("                border: 3px solid #503438;\n");
      out.write("                background-color: #737CA1;\n");
      out.write("            }\n");
      out.write("            #table-info tr{\n");
      out.write("            }\n");
      out.write("            #text-label{\n");
      out.write("                color: #F6358A;\n");
      out.write("                font-weight: bold;\n");
      out.write("                border: 1px solid #EBDDE2;\n");
      out.write("            }\n");
      out.write("            #text-input{\n");
      out.write("                width: 200px\n");
      out.write("            }\n");
      out.write("            #btn-submit{\n");
      out.write("                width: 70px;\n");
      out.write("                background-color: #ff4455;\n");
      out.write("            }\n");
      out.write("            #table-list{\n");
      out.write("                margin-left: 175px;\n");
      out.write("                margin-top: 50px;\n");
      out.write("                width: 700px;\n");
      out.write("                padding: 22 5 22 5;\n");
      out.write("                border: 3px solid #503438;\n");
      out.write("                background-color: #737CA1;\n");
      out.write("                color: red;\n");
      out.write("            }\n");
      out.write("            #table-list-header{\n");
      out.write("                background-color: #FDEEF4;\n");
      out.write("                font-weight: bold;\n");
      out.write("                color: blue;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>BẠN ĐANG Ở TRANG CÀI ĐẶT QUI ĐINH!</h1><br/>\n");
      out.write("        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>\n");
      out.write("\n");
      out.write("        <br/><br/>\n");
      out.write("        <hr/><hr/> <h3>Phần thông tin cho tài khoản</h3> <br/>\n");
      out.write("\t\t<form method=\"post\" action=\"#\">\n");
      out.write("\t\t\t<table id=\"table-info\">\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Tên Đăng Nhập</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtUsername\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Mật Khẩu</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtPassword\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Nhập lại Mật khẩu</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtRePassword\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Họ</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtFirstname\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Tên</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtLasttname\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Ngày Sinh</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<select name=\"sDay\">\n");
      out.write("\t\t\t\t\t\t\t<option>1</option>\n");
      out.write("\t\t\t\t\t\t\t<option>2</option>\n");
      out.write("\t\t\t\t\t\t\t<option>3</option>\n");
      out.write("\t\t\t\t\t\t\t<option>4</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<select name=\"sMonth\">\n");
      out.write("\t\t\t\t\t\t\t<option>1</option>\n");
      out.write("\t\t\t\t\t\t\t<option>2</option>\n");
      out.write("\t\t\t\t\t\t\t<option>3</option>\n");
      out.write("\t\t\t\t\t\t\t<option>4</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t\t<select name=\"sYear\">\n");
      out.write("\t\t\t\t\t\t\t<option>1991</option>\n");
      out.write("\t\t\t\t\t\t\t<option>1992</option>\n");
      out.write("\t\t\t\t\t\t\t<option>1993</option>\n");
      out.write("\t\t\t\t\t\t\t<option>1994</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Email</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtEmail\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Số ĐT</td>\n");
      out.write("\t\t\t\t\t<td><input id=\"text-input\" type=\"text\" name=\"txtPhonenumber\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td id=\"text-label\">Quyền truy cập</td>\n");
      out.write("\t\t\t\t\t<td>\n");
      out.write("\t\t\t\t\t\t<select name=\"sRole\">\n");
      out.write("\t\t\t\t\t\t\t<option>Admin</option>\n");
      out.write("\t\t\t\t\t\t\t<option>Normal</option>\n");
      out.write("\t\t\t\t\t\t</select>\n");
      out.write("\t\t\t\t\t</td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t\t<tr>\n");
      out.write("\t\t\t\t\t<td></td>\n");
      out.write("\t\t\t\t\t<td><input id=\"btn-submit\" type=\"submit\" name=\"btnCreate\" value=\"Tạo Mới\"></td>\n");
      out.write("\t\t\t\t</tr>\n");
      out.write("\t\t\t</table>\n");
      out.write("\t\t</form>\n");
      out.write("\n");
      out.write("\t\t<hr/><hr/>\n");
      out.write("\n");
      out.write("\t\t<h3>Phần danh sách các tài khoản đã có</h3> <br/>\n");
      out.write("\t\t<table id = \"table-list\">\n");
      out.write("\t\t\t<tr id = \"table-list-header\">\n");
      out.write("\t\t\t\t<th>Tài khoản</th><th>Mật khẩu</th><th>Quyền</th><th>Ngày tạo</th><th>...</th><th>...</th><th>...</th><th width=\"75px\"></th>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><a href=\"#\">ngloc_it</a></td><td>unknown</td><td>1</td><td>1-1-2001</td><td>...</td><td>...</td><td>...</td>\n");
      out.write("\t\t\t\t<td><form action=\"#\" method=\"post\"><input type=\"submit\" value=\"Delete\"></form></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t\t<tr>\n");
      out.write("\t\t\t\t<td><a href=\"#\">ngloc_it</a></td><td>unknown</td><td>1</td><td>1-1-2001</td><td>...</td><td>...</td><td>...</td>\n");
      out.write("\t\t\t\t<td><form action=\"#\" method=\"post\"><input type=\"submit\" value=\"Delete\"></form></td>\n");
      out.write("\t\t\t</tr>\n");
      out.write("\t\t</table>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
