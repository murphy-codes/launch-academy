/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2020-09-14 21:30:05 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("  <head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("  <title>JSP Donut Orders</title>\n");
      out.write("  </head>\n");
      out.write("  <body>\n");
      out.write("    ");

      Map<String, Integer> donutOrders = new HashMap<String, Integer>();
      donutOrders.put("Jennifer", 10);
      donutOrders.put("Alex", 1);
      donutOrders.put("Carly", 3);
      int totalDonuts = 0;
      List<String> donutNuts = new ArrayList<String>();
      Map<String, String> favDonuts = new HashMap<String, String>();
      favDonuts.put("Alex", "Maple");
      favDonuts.put("Carly", "Glazed");
    
      out.write("\n");
      out.write("\n");
      out.write("    <h2>Donut Orders</h2>\n");
      out.write("    <p>As of: ");
      out.print( new java.util.Date().toLocaleString() );
      out.write("</p>\n");
      out.write("\n");
      out.write("    <ul>\n");
      out.write("    ");
 for(String employee: donutOrders.keySet()) {
      int donutCount = donutOrders.get(employee);
      if (donutCount > 5) { donutCount = 2; }
      totalDonuts+=donutCount;
      
      out.write(" <li>");
      out.print( employee + ": " + donutCount + " donut(sss)" );
      out.write(' ');
 if (favDonuts.containsKey(employee)) { 
      out.write(" (fav donut: ");
      out.print( favDonuts.get(employee) );
      out.write(')');
      out.write(' ');
 } 
      out.write(" </li> ");

    } 
      out.write("\n");
      out.write("    </ul>\n");
      out.write("\n");
      out.write("    <p>Total donuts: ");
      out.print( totalDonuts );
      out.write("</p>\n");
      out.write("\n");
      out.write("    ");
 if (donutNuts.size() != 0) { 
      out.write("\n");
      out.write("      <p>Talk to the following people about not trying to game the donut system (and the perils of sugar crashes!): </p>\n");
      out.write("      <ul>\n");
      out.write("        ");
 for(String employee: donutNuts) {
      out.write("\n");
      out.write("          <li> ");
      out.print( employee );
      out.write(" </li>\n");
      out.write("        ");
} 
      out.write("\n");
      out.write("      </ul>\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("  </body>\n");
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
