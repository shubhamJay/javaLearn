package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class abeliophyllum_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("    <meta charset=\"utf-8\">\n");
      out.write("    <title>Abeliophyllum</title>\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/styles.css\">\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    <div id=\"headings\">\n");
      out.write("      <h1 id=\"flowerHeading\"><a href=\"index.jsp\"> << </a> Abeliophyllum</h1>\n");
      out.write("    </div>\n");
      out.write("    <div>\n");
      out.write("      <img src=\"img/abeliophyllum.jpg\" id=\"abeliophyllumImage\">\n");
      out.write("    </div>\n");
      out.write("    <p id=\"flowerInfo\">\n");
      out.write("      <b>Abeliophyllum (White Forsythia, or Korean Abelialeaf)</b> is a monotypic genus\n");
      out.write("      of flowering plants in the olive family, Oleaceae. It consists of one species,\n");
      out.write("      <b>Abeliophyllum distichum </b>Nakai, endemic to Korea, where it is endangered in the wild,\n");
      out.write("      occurring at only seven sites.It is related to Forsythia, but differs in having white,\n");
      out.write("      not yellow, flowers.\n");
      out.write("    </p>\n");
      out.write("      <p>\n");
      out.write("\n");
      out.write("      It is a deciduous shrub growing to 1â2 m tall. The leaves are opposite,\n");
      out.write("      simple, 6â10 cm long and 3-4.5 cm wide, pubescent both above and below.The flowers are produced\n");
      out.write("      in early spring before the new leaves appear; they are white and fragrant, about 1 cm long,\n");
      out.write("       with a four-lobed corolla. The fruit is a round, winged samara 2â3 cm diameter.\n");
      out.write("     </p>\n");
      out.write("      It is cultivated as an ornamental plant in Europe and North America.\n");
      out.write("    </p>\n");
      out.write("    <a href=\"pdf/abeliophyllum.pdf\" download>Download as Book</a>\n");
      out.write("  </body>\n");
      out.write("</html>\n");
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
