package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Post;

public final class HomePage_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Home Page</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/home.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <div class=\"main\">\r\n");
      out.write("                    ");

                        Post p = null;
                        if (request.getAttribute("post") != null) {
                            p = (Post) request.getAttribute("post");
                    
      out.write("\r\n");
      out.write("                    <div class=\"title\">\r\n");
      out.write("                        <p>");
      out.print(p.getTitlePost());
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"image\">\r\n");
      out.write("                        <img src=\"img/");
      out.print(p.getImgPost());
      out.write("\">\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"text\">\r\n");
      out.write("                        <p>");
      out.print(p.getDescriptPost());
      out.write("</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"signature\">\r\n");
      out.write("                        <div class=\"icon1\"></div>\r\n");
      out.write("                        <div class=\"icon2\"></div>\r\n");
      out.write("                        <div>By ");
      out.print( p.getAuthorPost() + " | " + p.formatDate());
      out.write("</div>\r\n");
      out.write("                    </div>  \r\n");
      out.write("                    ");

                        }
                    
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Right.jsp", out, false);
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Footer.jsp", out, false);
      out.write("\r\n");
      out.write("        </div>\r\n");
      out.write("        <script lang=\"javascript\" src=\"js/search.js\"></script>\r\n");
      out.write("    </body>\r\n");
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
