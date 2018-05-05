package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class guestBook_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"utf-8\">\n");
      out.write("  <title>Guest Book</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"css/styles.css\" />\n");
      out.write("  <script type=\"text/javascript\">\n");
      out.write("    const showComments = function(comments) {\n");
      out.write("      let table = document.getElementById('commentsTable');\n");
      out.write("      let insertedRow;\n");
      out.write("      comments.forEach(function(element) {\n");
      out.write("        insertedRow = table.insertRow();\n");
      out.write("        insertedRow.insertCell().innerText = element.date;\n");
      out.write("        insertedRow.insertCell().innerText = element.name;\n");
      out.write("        insertedRow.insertCell().innerText = element.comment;\n");
      out.write("      });\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    const getComments = function() {\n");
      out.write("      let req = new XMLHttpRequest();\n");
      out.write("      req.onreadystatechange = function() {\n");
      out.write("        let commentsStore = JSON.parse(this.responseText).reverse();\n");
      out.write("        showComments(commentsStore);\n");
      out.write("      };\n");
      out.write("      req.open(\"GET\", \"/loadComments\");\n");
      out.write("      req.send();\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    const parsekeyVal = function(text) {\n");
      out.write("      return text.split(\";\").reduce((parsedKeyVals, ele) => {\n");
      out.write("        let keyValPairs = ele.trim().split('=');\n");
      out.write("        parsedKeyVals[keyValPairs[0]] = keyValPairs[1];\n");
      out.write("        return parsedKeyVals;\n");
      out.write("      }, {});\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    const hideCommentsSection = function() {\n");
      out.write("      let commentSection = document.getElementById(\"guestBookForm\");\n");
      out.write("      commentSection.innerText = \"\";\n");
      out.write("      commentSection.style.visibility = \"hidden\";\n");
      out.write("    };\n");
      out.write("\n");
      out.write("    const showCookiesIfUser = function() {\n");
      out.write("      let cookies = parsekeyVal(document.cookie);\n");
      out.write("      if (! +cookies.sessionId && !+cookies.logInStatus)\n");
      out.write("       hideCommentsSection();\n");
      out.write("    }\n");
      out.write("\n");
      out.write("    const actionOnPageLoad = function(){\n");
      out.write("      // getComments();\n");
      out.write("      // showCookiesIfUser();\n");
      out.write("    }\n");
      out.write("  </script>\n");
      out.write("</head>\n");
      out.write("\n");
      out.write("<body onload=\"actionOnPageLoad()\">\n");
      out.write("  <div>\n");
      out.write("    <h1 id=\"flowerHeading\"><a href=\"index.jsp\"> << </a> Guest Book</h1>\n");
      out.write("  </div>\n");
      out.write("  <form id=\"guestBookForm\" action=\"commentAccepted\" method=\"post\">\n");
      out.write("    <h2 style=\"font-family:san-sarif\">Leave A comment</h2>\n");
      out.write("    Your Name<input type=\"text\" name=\"name\" required/> <br /><br /> Comment\n");
      out.write("    <textarea name=\"comment\" style=\"height:40px\" required></textarea><br />\n");
      out.write("    <button>submit</button>\n");
      out.write("  </form>\n");
      out.write("  <table id=\"commentsTable\">\n");
      out.write("  </table>\n");
      out.write("</body>\n");
      out.write("\n");
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
