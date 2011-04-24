package org.apache.jsp.jsps;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class jspXemDSLop_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Danh sách lớp học</title>\n");
      out.write("        <style media=\"all\" type=\"text/css\">\n");
      out.write("            #table-list-class{\n");
      out.write("                margin-left: 10%;\n");
      out.write("                margin-top: 20px;\n");
      out.write("                width: 80%;\n");
      out.write("                border-left: 2px solid;\n");
      out.write("                border-right: 2px solid;\n");
      out.write("            }\n");
      out.write("            #table-list-class th{\n");
      out.write("                height: 32px;\n");
      out.write("                font-weight: bold;\n");
      out.write("                background-color: #F9B7FF;\n");
      out.write("            }\n");
      out.write("            #table-list-class td{\n");
      out.write("                background-color: #b1B700;\n");
      out.write("                padding: 2 5 2 5;\n");
      out.write("            }\n");
      out.write("            #form-action{\n");
      out.write("                margin-left: 10%;\n");
      out.write("                margin-top: 30px;\n");
      out.write("                padding: 0 2 0 2;\n");
      out.write("            }\n");
      out.write("            #form-action table{\n");
      out.write("                width: 225px;\n");
      out.write("            }\n");
      out.write("            #btn-set{\n");
      out.write("                width: 80px;\n");
      out.write("                background-color: #E3E4FA;\n");
      out.write("            }\n");
      out.write("            #form-search{\n");
      out.write("                margin-left: 10%;\n");
      out.write("                padding: 5 10 5 10;\n");
      out.write("                background-color: #f29de3;\n");
      out.write("                width: 320px;\n");
      out.write("            }\n");
      out.write("        </style>>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <h1>BẠN ĐANG Ở TRANG XEM DANH SÁCH LỚP HỌC!</h1><br/>\n");
      out.write("        <h1>Chào mừng đến với hệ thống đăng ký học phần...!</h1>\n");
      out.write("\n");
      out.write("        <br/><br/>\n");
      out.write("\n");
      out.write("        <h3>Phần này cung cấp các chức năng search\n");
      out.write("        ???sao không cho thêm chức năng search vào trang đăng ký môn học và bỏ chức năng này đi nhỉ...\n");
      out.write("        </h3>\n");
      out.write("\n");
      out.write("        <form id = \"form-search\" action=\"\" method=\"post\">\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"checkbox\" name=\"chkSearchByName\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"sName\">\n");
      out.write("                            <option>Lập Trình Hướng Đối Tượng</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"checkbox\" name=\"chkSearchByID\"></td>\n");
      out.write("                    <td>\n");
      out.write("                            <select name=\"sID\">\n");
      out.write("                                <option>SE01</option>\n");
      out.write("                            </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td><input type=\"submit\" value=\"Tìm Kiếm\"></td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td><input type=\"checkbox\" name=\"chkSearchByTeacher\"></td>\n");
      out.write("                    <td>\n");
      out.write("                        <select name=\"sTeacherName\">\n");
      out.write("                            <option>Vũ Thanh Nguyên</option>\n");
      out.write("                        </select>\n");
      out.write("                    </td>\n");
      out.write("                    <td></td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("        </form>\n");
      out.write("        <hr/>\n");
      out.write("        <h3>Phần này là danh sách các lớp học hiện có.</h3>\n");
      out.write("\n");
      out.write("        <table id=\"table-list-class\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Mã</th><th>Tên Lớp</th><th>Giảng Viên</th><th>Số TC LT</th><th>Số TC TH</th><th>Phòng</th><th>Thứ</th><th>Ca</th><th>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>SE001</td><td>PP Mô hình hóa</td><td>Ts. Vũ Thanh Nguyễn</td><td>2</td><td>0</td><td>201</td><td>3</td><td>Sáng</td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
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
