package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import model.Post;

public final class Right_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>Document</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/right.css\" type=\"text/css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"right\">\r\n");
      out.write("            <div class=\"newst\">\r\n");
      out.write("                <div class=\"titleNews\">\r\n");
      out.write("                    <span>Digital News</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");


                    if (request.getAttribute("digitalPost") != null) {
                        Post p = (Post) request.getAttribute("digitalPost");
                
      out.write("\r\n");
      out.write("                <div class=\"contentNews\">\r\n");
      out.write("                    ");
      out.print(p.getShortDesPost());
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    }
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"newst\">\r\n");
      out.write("                <div class=\"titleNews\">\r\n");
      out.write("                    Search\r\n");
      out.write("                </div>\r\n");
      out.write("                <form action=\"\" method=\"POST\">\r\n");
      out.write("                    <input class=\"searchBox\" type=\"text\" name=\"searchText\" size=\"15\" required>\r\n");
      out.write("                    <input class=\"searchButton\" type=\"submit\" name=\"btnGo\" value=\"Go\">\r\n");
      out.write("                </form>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"newest\">\r\n");
      out.write("                <div>\r\n");
      out.write("                    <span>Last Article</span> <br/>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");

                    if (request.getAttribute("top5LastAr") != null) {
                        ArrayList<Post> listPost = (ArrayList<Post>) request.getAttribute("top5LastAr");
                        for (Post i : listPost) {
                
      out.write("\r\n");
      out.write("                <div class=\"lastArticles\">\r\n");
      out.write("                    <a href=\"HomeServlet?id=");
      out.print(i.getIdPost());
      out.write('"');
      out.write('>');
      out.print(i.getTitlePost());
      out.write("</a>\r\n");
      out.write("                </div>\r\n");
      out.write("                ");
}
                    }
                
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
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
