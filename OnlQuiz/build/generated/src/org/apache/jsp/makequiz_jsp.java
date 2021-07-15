package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class makequiz_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\" />\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\r\n");
      out.write("        <title>Make Quiz</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/makequiz.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("            <div class=\"body\">\r\n");
      out.write("                <form action=\"MakeQuizServlet\" method=\"post\">\r\n");
      out.write("                    <div class=\"ques-bg\">\r\n");
      out.write("                        <div class=\"question qes\">\r\n");
      out.write("                            <span>Question: </span>\r\n");
      out.write("                            <textarea id=\"ques\" cols=\"60\" rows=\"10\">The name of capital of Viet Nam At 1975</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"question qes\">\r\n");
      out.write("                            <span>Option 1: </span>\r\n");
      out.write("                            <textarea  cols=\"60\" rows=\"5\">Sai Gon</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"question qes\">\r\n");
      out.write("                            <span>Option 2: </span>\r\n");
      out.write("                            <textarea  cols=\"60\" rows=\"5\">Viet Nam</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"question qes\">\r\n");
      out.write("                            <span>Option 3: </span>\r\n");
      out.write("                            <textarea  cols=\"60\" rows=\"5\">Ha Noi</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"question qes\">\r\n");
      out.write("                            <span>Option 4: </span>\r\n");
      out.write("                            <textarea  cols=\"60\" rows=\"5\">TP Ho Chi Minh</textarea>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"ans-bg\">\r\n");
      out.write("                        <div class=\"asw\">\r\n");
      out.write("                            <span>Answer(s):</span>\r\n");
      out.write("                            <ul class=\"list-answ\">\r\n");
      out.write("                                <li><input type=\"checkbox\"><span>Option 1</span></li>\r\n");
      out.write("                                <li><input type=\"checkbox\"><span>Option 2</span></li>\r\n");
      out.write("                                <li><input type=\"checkbox\"><span>Option 3</span></li>\r\n");
      out.write("                                <li><input type=\"checkbox\"><span>Option 4</span></li>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <input type=\"submit\" id=\"save-btn\" value=\"Save\">\r\n");
      out.write("                    </div\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script src=\"js/makequiz.js\">\r\n");
      out.write("        </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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
