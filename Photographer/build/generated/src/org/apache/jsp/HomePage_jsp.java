package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Contact;
import model.Image;
import dal.ImageDAO;
import model.Gallery;
import java.util.ArrayList;

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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta charset=\"UTF-8\">\r\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <title>HomePage</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Header.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/HomePage.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/Right.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/gallery.css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/modal.css\"/>\r\n");
      out.write("    </head>\r\n");
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"main\">\r\n");
      out.write("                <!--top-->\r\n");
      out.write("                ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Header.jsp", out, false);
      out.write("\r\n");
      out.write("                <!--Body-->\r\n");
      out.write("                <div class=\"body-page\">\r\n");
      out.write("                    <div class=\"body-1\">\r\n");
      out.write("                        <div class=\"intro-product\">\r\n");
      out.write("                            ");

                                if (request.getAttribute("top1Img") != null) {
                                    Image i = (Image) request.getAttribute("top1Img");
                            
      out.write("\r\n");
      out.write("                            <img id=\"myImg\" src=\"img/");
      out.print(i.getUrl());
      out.write("\" alt=\"Lorem ipsum dolor sit amet\">\r\n");
      out.write("                            <p style=\"font-style: italic;\">Lorem ipsum dolor sit amet</p>\r\n");
      out.write("                            <div id=\"myModal\" class=\"modal\">\r\n");
      out.write("                                <span class=\"close\">X</span>\r\n");
      out.write("                                <img class=\"modal-content\" id=\"img01\">\r\n");
      out.write("                                <div id=\"caption\"></div>\r\n");
      out.write("                            </div>\r\n");
      out.write("                            ");
}
      out.write("\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "Right.jsp", out, false);
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <!--List Gallery-->\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"body-2\">\r\n");
      out.write("\r\n");
      out.write("                        ");

                            int pageSize = 0;
                            if (request.getAttribute("gaList") != null & request.getAttribute("psize") != null) {
                                ArrayList<Gallery> gaList = (ArrayList<Gallery>) request.getAttribute("gaList");
                                pageSize = (Integer) request.getAttribute("psize");
                                ImageDAO id = new ImageDAO();

                                for (int i = 0; i < 2; i++) {
                        
      out.write("\r\n");
      out.write("                        <div class=\"view-gallery\">\r\n");
      out.write("                            <img src=\"img/");
      out.print(id.getTop1UrlImageByGalleryId(gaList.get(i).getGalleryId()));
      out.write("\" alt=\"\">\r\n");
      out.write("                            <div class=\"descript-galery\">\r\n");
      out.write("                                <h2><a href=\"\">View ");
      out.print(gaList.get(i).getTitleGallery());
      out.write("</a></h2>\r\n");
      out.write("                                <p>\r\n");
      out.write("                                    ");
      out.print(gaList.get(i).getDescriptionGallery());
      out.write("\r\n");
      out.write("                                </p>\r\n");
      out.write("                            </div>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        ");
i++;
                                }
                            }
                        
      out.write("\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"pag\">\r\n");
      out.write("                        <ul class=\"pagination\">\r\n");
      out.write("                            ");

                                if (pageSize != 0) {
                                    for (int i = 1; i <= pageSize; i++) {
                            
      out.write("\r\n");
      out.write("                            <li class=\"page-item\"><a class=\"page-link\" href=\"HomePageServlet?index=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i);
      out.write("</a></li> \r\n");
      out.write("                                ");
                                 }
                                    }
                                
      out.write("\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
                        if (request.getAttribute("contact") != null) {
                            Contact ct = (Contact) request.getAttribute("contact");
                    
      out.write("\r\n");
      out.write("                    <div class=\"about-script\">\r\n");
      out.write("                        <h1>About Me</h1>\r\n");
      out.write("                        <div>\r\n");
      out.write("                            <p>");
      out.print(ct.getAboutContact());
      out.write("</p>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!--Footer-->\r\n");
      out.write("                <div class=\"footer\">\r\n");
      out.write("                    <div class=\"link-number\">\r\n");
      out.write("                        <a href=\"\">Created with SimpleSite</a>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">8</span>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">3</span>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">1</span>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">9</span>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">9</span>\r\n");
      out.write("                        <span class=\"footer-page-counter-item\">7</span>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("    <script src=\"js/modal.js\"></script>\r\n");
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
