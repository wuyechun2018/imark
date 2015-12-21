package org.apache.jsp.WEB_002dINF.views.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class demo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/views/easyui.jsp");
  }

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_set_var_value_nobody;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_set_var_value_nobody = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_set_var_value_nobody.release();
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
      response.setContentType("text/html; charset=UTF-8");
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
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("\r\n");
      if (_jspx_meth_c_set_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<LINK href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/favicon.ico\" type=\"image/x-icon\" rel=\"icon\">                        \r\n");
      out.write("<LINK href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/favicon.ico\" type=\"image/x-icon\" rel=\"shortcut icon\">\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/styles/base.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/themes/default/easyui.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/themes/icon.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/icons/icon-all.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("var ctx = \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\";\r\n");
      out.write("\r\n");
      out.write("var docWidth=0;\r\n");
      out.write("var docHeight=0;\r\n");
      out.write("\r\n");
      out.write("if(document.documentElement.clientWidth == 0){\r\n");
      out.write("\tif(document.body){\r\n");
      out.write("\t\tdocWidth=document.body.clientWidth;\r\n");
      out.write("\t}\r\n");
      out.write("}else{\r\n");
      out.write("\tdocWidth=document.documentElement.clientWidth;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("if(document.documentElement.clientWidth == 0){\r\n");
      out.write("\tif(document.body){\r\n");
      out.write("\t\tdocHeight=document.body.clientHeight;\r\n");
      out.write("\t}\r\n");
      out.write("}else{\r\n");
      out.write("\tdocHeight= document.documentElement.clientHeight;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/jquery.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/jquery.easyui.min.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/jquery-easyui-1.4.3/jquery.easyui.iplugin.js\"></script>\r\n");
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/js/dateformat.js\"></script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
      out.write('\r');
      out.write('\n');
      out.write("\r\n");
      out.write("<title>IMark</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#grid').datagrid({  \r\n");
      out.write("\t\turl:ctx+'/resources/data/datagrid_data.json',\r\n");
      out.write("\t\tmethod:'get',\r\n");
      out.write("\t\ttitle:\"用户管理\",\r\n");
      out.write("\t\theight: 340,\r\n");
      out.write("        //width: function () { return document.body.clientWidth * 0.8 -50},\r\n");
      out.write("\t\tfit:false,\r\n");
      out.write("\t\tfitColumns:true,\r\n");
      out.write("\t\tstriped: true,//奇偶行是否区分\r\n");
      out.write("\t\tsingleSelect:true,\r\n");
      out.write("\t\tpageSize: 10,\r\n");
      out.write("        pageList: [10,20,30],\r\n");
      out.write("\t\tpagination: true,  \r\n");
      out.write("\t\trownumbers: true,  \r\n");
      out.write("\t\tcolumns:[[\r\n");
      out.write("\t\t          {field:'itemid',title: '来Item ID',align: 'center',width: 100},\r\n");
      out.write("\t\t          {field:'productid',title: 'productid',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'listprice',title: 'listprice',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'attr1',title: 'attr1',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'status',title: 'status',align: 'center',width: 100}\r\n");
      out.write("\t\t]],\r\n");
      out.write("\t\ttoolbar:[{\r\n");
      out.write("\t\t\t\t\t\ttext : '增加',\r\n");
      out.write("\t\t\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}, '-',{\r\n");
      out.write("\t\t\t\t\t\ttext : '删除',\r\n");
      out.write("\t\t\t\t\t\ticonCls : 'icon-remove',\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t},'-', {\r\n");
      out.write("\t\t\t\t\t\ttext : '修改',\r\n");
      out.write("\t\t\t\t\t\ticonCls : 'icon-edit',\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}, '-',{\r\n");
      out.write("\t\t\t\t\t\ttext : '查询',\r\n");
      out.write("\t\t\t\t\t\ticonCls : 'icon-search',\r\n");
      out.write("\t\t\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t} ]\r\n");
      out.write("\t\t\t\r\n");
      out.write("\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("\t\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write(" <div class=\"easyui-layout\"  fit=\"false\">\r\n");
      out.write("        <!-------------------------------搜索框----------------------------------->\r\n");
      out.write("        <fieldset>\r\n");
      out.write("            <legend>信息查询</legend>\r\n");
      out.write("            <form id=\"ffSearch\" method=\"post\">\r\n");
      out.write("\t\t        <div style=\"margin-bottom:5px\">\r\n");
      out.write("                    <label for=\"txtSystemType_ID\">系统编号：</label>\r\n");
      out.write("                    <input class=\"easyui-combobox\" type=\"text\" ID=\"txtSystemType_ID\" name=\"txtSystemType_ID\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtLoginName\">登录名称：</label>\r\n");
      out.write("                    <input type=\"text\" ID=\"txtLoginName\" name=\"txtLoginName\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtFullName\">真实名称：</label>\r\n");
      out.write("                    <input type=\"text\" ID=\"txtFullName\" name=\"txtFullName\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtNote\">日志描述：</label>\r\n");
      out.write("                    <input type=\"text\" ID=\"txtNote\" name=\"txtNote\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("                </div>\r\n");
      out.write("\t\t        <div>\r\n");
      out.write("                    <label for=\"txtIPAddress\"> I P 地 址：</label>\r\n");
      out.write("                    <input type=\"text\" ID=\"txtIPAddress\" name=\"txtIPAddress\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtMacAddress\">Mac地址：</label>\r\n");
      out.write("                    <input type=\"text\" ID=\"txtMacAddress\" name=\"txtMacAddress\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtLastUpdated\">开始时间：</label>\r\n");
      out.write("                    <input class=\"easyui-datebox\" type=\"text\" ID=\"txtLastUpdated\" name=\"txtLastUpdated\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <label for=\"txtLastUpdated2\">结束时间：</label>\r\n");
      out.write("                    <input class=\"easyui-datebox\" type=\"text\" ID=\"txtLastUpdated2\" name=\"txtLastUpdated2\" style=\"width:100px\"  />&nbsp;&nbsp;&nbsp;\r\n");
      out.write("\r\n");
      out.write("                    <a href=\"#\" class=\"easyui-linkbutton\" iconcls=\"icon-search\" id=\"btnSearch\">查询</a>\r\n");
      out.write("                </div>\r\n");
      out.write("            </form>\r\n");
      out.write("        </fieldset>\r\n");
      out.write("                \r\n");
      out.write("        <!-------------------------------详细信息展示表格----------------------------------->\r\n");
      out.write("        <table id=\"grid\"   >\r\n");
      out.write("            \r\n");
      out.write("        </table>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
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

  private boolean _jspx_meth_c_set_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:set
    org.apache.taglibs.standard.tag.rt.core.SetTag _jspx_th_c_set_0 = (org.apache.taglibs.standard.tag.rt.core.SetTag) _jspx_tagPool_c_set_var_value_nobody.get(org.apache.taglibs.standard.tag.rt.core.SetTag.class);
    _jspx_th_c_set_0.setPageContext(_jspx_page_context);
    _jspx_th_c_set_0.setParent(null);
    _jspx_th_c_set_0.setVar("ctx");
    _jspx_th_c_set_0.setValue((java.lang.Object) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${pageContext.request.contextPath}", java.lang.Object.class, (PageContext)_jspx_page_context, null));
    int _jspx_eval_c_set_0 = _jspx_th_c_set_0.doStartTag();
    if (_jspx_th_c_set_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
      return true;
    }
    _jspx_tagPool_c_set_var_value_nobody.reuse(_jspx_th_c_set_0);
    return false;
  }
}
