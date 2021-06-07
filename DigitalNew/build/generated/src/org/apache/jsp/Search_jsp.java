package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dal.PostDAO;
import model.Post;
import java.util.ArrayList;

public final class Search_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
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
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/home.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/search.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\n");
      out.write("            <div class=\"content\">\n");
      out.write("                <div class=\"main\">\n");
      out.write("                    ");
ArrayList<Post> listPost = null;
                        if (request.getAttribute("sResult") != null) {
                            listPost = (ArrayList<Post>) request.getAttribute("sResult");
                            for (Post i : listPost) {
                    
      out.write("\n");
      out.write("                    <div class=\"sResult\">\n");
      out.write("                        <div class=\"sText\" style=\"font-weight: bold\">\n");
      out.write("                            <p>");
      out.print(i.getIdPost());
      out.write('|');
      out.print(i.getTitlePost());
      out.write("</p>\n");
      out.write("                        </div>\n");
      out.write("                        <div>\n");
      out.write("                            <img class=\"img-post\" src=\"img/");
      out.print(i.getImgPost());
      out.write("\">\n");
      out.write("                        </div>\n");
      out.write("                        <div id=\"time\">\n");
      out.write("                            By Le Anh Son | 31-07-2000\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 }
                        }
                    
      out.write("\n");
      out.write("                    <div>\n");
      out.write("\n");
      out.write("                        <nav class=\"\">\n");
      out.write("                            <ul class=\"pagination\">\n");
      out.write("                                ");

                                    if (request.getAttribute("index") != null && request.getAttribute("maxPage") != null) {
                                        int index = (Integer) request.getAttribute("index");
                                        int maxPage = (Integer) request.getAttribute("maxPage");
                                        for (int i = 1; i <= maxPage; i++) {
                                
      out.write("\n");
      out.write("                                <a class=\"page-link\" href=\"SearchServlet?index=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a>\n");
      out.write("                                ");
 }
                                    }
      out.write("\n");
      out.write("\n");
      out.write("                            </ul>\n");
      out.write("                        </nav>\n");
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Right.jsp", out, false);
      out.write("\n");
      out.write("            </div>\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
