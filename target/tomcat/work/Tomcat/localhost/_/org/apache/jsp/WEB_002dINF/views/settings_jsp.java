/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2017-04-19 21:58:31 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class settings_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("/WEB-INF/views/common/navigation.jspf", Long.valueOf(1492630596408L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jspf", Long.valueOf(1492446522784L));
    _jspx_dependants.put("/WEB-INF/views/common/header.jspf", Long.valueOf(1492452487684L));
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("\t<title>Contact Manager</title>\r\n");
      out.write("\t\r\n");
      out.write("\t<!-- <link href=\"webjars/bootstrap/3.3.7-1/css/bootstrap.css\" rel=\"stylesheet\"> -->\r\n");
      out.write("\t<link  rel=\"stylesheet\"\r\n");
      out.write("\t\thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/webjars/bootstrap/3.3.7-1/css/bootstrap.css\"/>\r\n");
      out.write("\t\r\n");
      out.write("\t<link type=\"text/css\"\r\n");
      out.write("\t\trel=\"stylesheet\"\r\n");
      out.write("\t  \thref=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/css/style.css\" />\r\n");
      out.write("\t  \t\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write("  <nav class=\"navbar navbar-inverse navbar-static-top-left\"> <!-- Edit bootstrap.css, navbar-inverse: width 70% -->\r\n");
      out.write("  \t<div class=\"container-fluid\"> \r\n");
      out.write("      <div class=\"navbar-header\">\r\n");
      out.write("        <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar3\">\r\n");
      out.write("          <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("          <span class=\"icon-bar\"></span>\r\n");
      out.write("          <span class=\"icon-bar\"></span>\r\n");
      out.write("          <span class=\"icon-bar\"></span>\r\n");
      out.write("        </button>\r\n");
      out.write("        <a class=\"navbar-brand\" href=\"http://www.croz.net\"><img src=\"http://croz.net/wp-content/themes/croz-theme/images/header-logo.svg\" alt=\"CROZ d.o.o.\">\r\n");
      out.write("        </a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <div id=\"navbar3\" class=\"navbar-collapse collapse\">\r\n");
      out.write("        <ul class=\"nav navbar-nav navbar-right\">\r\n");
      out.write("          <li class=\"active\"><a href=\"/welcome\">Home</a></li>\r\n");
      out.write("          <li><a href=\"/contact/about\">About</a></li>\r\n");
      out.write("          <li><a href=\"/contact/list\">Contacts</a></li>\r\n");
      out.write("          <li class=\"dropdown\">\r\n");
      out.write("            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" role=\"button\" aria-expanded=\"false\">Menu <span class=\"caret\"></span></a>\r\n");
      out.write("            <ul class=\"dropdown-menu\" role=\"menu\">\r\n");
      out.write("              <li><a href=\"/contact/addContactForm\">Add Contact</a></li>\r\n");
      out.write("              <li><a href=\"/contact/settings\">Settings</a></li>\r\n");
      out.write("              <li class=\"divider\"></li>\r\n");
      out.write("              <li class=\"dropdown-header\">End Session</li>\r\n");
      out.write("              <li><a href=\"/logout\">Logout</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("          </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </div>\r\n");
      out.write("      <!--/.nav-collapse -->\r\n");
      out.write("    <!--/.container-fluid -->\r\n");
      out.write("    </div>\r\n");
      out.write("  </nav>\r\n");
      out.write("\r\n");
      out.write("\t<br>\r\n");
      out.write("\t\r\n");
      out.write("\t<div id=\"wrapper\">\r\n");
      out.write("\t\t<div id=\"header\">\r\n");
      out.write("\t\t\t<h2>CM - Contact Manager v0.5 Alpha</h2>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\t<div id=\"container\">\r\n");
      out.write("\t\t<div id=\"content\">\r\n");
      out.write("\t\t\t<h3>SETTINGS - UNDER CONSTRUCTION</h3> \r\n");
      out.write("\t\t\t<br>\r\n");
      out.write("\t\t\t<h4>ToDo List:</h4>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>Validation</li>\r\n");
      out.write("\t\t\t\t<li>Full Javadoc implementation</li>\r\n");
      out.write("\t\t\t\t<li>User access levels regulation</li>\r\n");
      out.write("\t\t\t\t<li>Update/Delete links into buttons</li>\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t<br><br><br><br>\r\n");
      out.write("\t\t\t<div id=\"headersmall\">\r\n");
      out.write("\t\t\t\t<h4><label>Change Log:</label></h4>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t\t<br>\t\r\n");
      out.write("\r\n");
      out.write("\t\t\t<label>19.04.</label>\r\n");
      out.write("\t\t\t<ul>\r\n");
      out.write("\t\t\t\t<li>Removed annotations autogenerated ID from entity SEX but left BIGSERIAL definition in SQL</li>\r\n");
      out.write("\t\t\t\t<li>CRUD with Contact-Sex relation works 100%. <a href=\"https://www.javainterviewpoint.com/spring-mvc-radiobutton-radiobuttons-example/\">Radiobuttons</a> implementation planned.</li>\r\n");
      out.write("\t\t\t\t<li>About and Settings pages refreshed.. quite a waste of time.</li>\r\n");
      out.write("\t\t\t\t<li>Implemented ADDRESS entity. Functional 99% - update address adds new address entry, instead of updating the original one. Try out cascade options.</li>\r\n");
      out.write("\t\t\t\t<li>Implemented all entities.Listing works, add form only loads, saving not implemented. Updating? Don't even wanna know..\r\n");
      out.write("\t\t\t</ul>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/webjars/jquery/3.2.0/jquery.min.js\"></script> \r\n");
      out.write("\t<script src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null, false));
      out.write("/resources/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js\"></script>\r\n");
      out.write("\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
