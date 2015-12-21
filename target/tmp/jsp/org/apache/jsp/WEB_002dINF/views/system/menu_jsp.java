package org.apache.jsp.WEB_002dINF.views.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t$('#menu_tb').datagrid({  \r\n");
      out.write("\t\turl:ctx+'/resources/data/datagrid_data.json',\r\n");
      out.write("\t\tmethod:'get',\r\n");
      out.write("\t\ttitle:\"菜单管理\",\r\n");
      out.write("\t\tfit:true,\r\n");
      out.write("\t\tfitColumns:true,\r\n");
      out.write("\t\tstriped: true,//奇偶行是否区分\r\n");
      out.write("\t\tsingleSelect:true,\r\n");
      out.write("\t\tpagination: true,  \r\n");
      out.write("\t\trownumbers: true,  \r\n");
      out.write("\t\tcolumns:[[\r\n");
      out.write("\t\t          {field:'itemid',title: '来Item ID',align: 'center',width: 100},\r\n");
      out.write("\t\t          {field:'productid',title: 'productid',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'listprice',title: 'listprice',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'attr1',title: 'attr1',align: 'center',width: 100}, \r\n");
      out.write("\t\t          {field:'status',title: 'status',align: 'center',width: 100}\r\n");
      out.write("\t\t]],\r\n");
      out.write("\t\ttoolbar:$('#c_tb')\r\n");
      out.write("\t\t//,footer:$('#ft')\r\n");
      out.write("\r\n");
      out.write("\t\t})\r\n");
      out.write("\r\n");
      out.write("\t\t$('#menu_tb').datagrid('getPanel').removeClass(\r\n");
      out.write("\t\t\t\t'lines-both lines-no lines-right lines-bottom').addClass(\r\n");
      out.write("\t\t\t\t'lines-both');\r\n");
      out.write("\r\n");
      out.write("\t})\r\n");
      out.write("\t\r\n");
      out.write("\t/**\r\n");
      out.write("\t[\r\n");
      out.write("\t\t     {\r\n");
      out.write("\t\t\t\ttext : '增加',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-add',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, '-',{\r\n");
      out.write("\t\t\t\ttext : '删除',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-remove',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t},'-', {\r\n");
      out.write("\t\t\t\ttext : '修改',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-edit',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t}, '-',{\r\n");
      out.write("\t\t\t\ttext : '查询',\r\n");
      out.write("\t\t\t\ticonCls : 'icon-search',\r\n");
      out.write("\t\t\t\thandler : function() {\r\n");
      out.write("\r\n");
      out.write("\t\t\t\t}\r\n");
      out.write("\t\t\t} ]\r\n");
      out.write("\t\r\n");
      out.write("\t**/\r\n");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("<div class=\"easyui-layout\" style=\"width:700px;height:700px;\" fit=\"true\">\r\n");
      out.write("        <div data-options=\"region:'west',split:true,title:'菜单树'\" style=\"width: 300px; padding: 1px;\">\r\n");
      out.write("            <div>\r\n");
      out.write("              <ul class=\"easyui-tree\" data-options=\"url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/tree_data.json',method:'get',animate:true,dnd:true\"></ul>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div id=\"tb\" data-options=\"region:'center',title:'菜单编辑'\" style=\"padding:5px;height:auto\">                \r\n");
      out.write("            <div style=\"padding:10px 60px 20px 60px\">\r\n");
      out.write("\t\t    <form id=\"ff\" method=\"post\">\r\n");
      out.write("\t\t    \t<table cellpadding=\"5\">\r\n");
      out.write("\t\t    \t\t<tr>\r\n");
      out.write("\t\t    \t\t\t<td>Name:</td>\r\n");
      out.write("\t\t    \t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"name\" data-options=\"required:true\"></input></td>\r\n");
      out.write("\t\t    \t\t</tr>\r\n");
      out.write("\t\t    \t\t<tr>\r\n");
      out.write("\t\t    \t\t\t<td>Email:</td>\r\n");
      out.write("\t\t    \t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"email\" data-options=\"required:true,validType:'email'\"></input></td>\r\n");
      out.write("\t\t    \t\t</tr>\r\n");
      out.write("\t\t    \t\t<tr>\r\n");
      out.write("\t\t    \t\t\t<td>Subject:</td>\r\n");
      out.write("\t\t    \t\t\t<td><input class=\"easyui-textbox\" type=\"text\" name=\"subject\" data-options=\"required:true\"></input></td>\r\n");
      out.write("\t\t    \t\t</tr>\r\n");
      out.write("\t\t    \t\t<tr>\r\n");
      out.write("\t\t    \t\t\t<td>Message:</td>\r\n");
      out.write("\t\t    \t\t\t<td><input class=\"easyui-textbox\" name=\"message\" data-options=\"multiline:true\" style=\"height:60px\"></input></td>\r\n");
      out.write("\t\t    \t\t</tr>\r\n");
      out.write("\t\t    \t\t<tr>\r\n");
      out.write("\t\t    \t\t\t<td>Language:</td>\r\n");
      out.write("\t\t    \t\t\t<td>\r\n");
      out.write("\t\t    \t\t\t\t<select class=\"easyui-combobox\" name=\"language\"><option value=\"ar\">Arabic</option><option value=\"bg\">Bulgarian</option><option value=\"ca\">Catalan</option><option value=\"zh-cht\">Chinese Traditional</option><option value=\"cs\">Czech</option><option value=\"da\">Danish</option><option value=\"nl\">Dutch</option><option value=\"en\" selected=\"selected\">English</option><option value=\"et\">Estonian</option><option value=\"fi\">Finnish</option><option value=\"fr\">French</option><option value=\"de\">German</option><option value=\"el\">Greek</option><option value=\"ht\">Haitian Creole</option><option value=\"he\">Hebrew</option><option value=\"hi\">Hindi</option><option value=\"mww\">Hmong Daw</option><option value=\"hu\">Hungarian</option><option value=\"id\">Indonesian</option><option value=\"it\">Italian</option><option value=\"ja\">Japanese</option><option value=\"ko\">Korean</option><option value=\"lv\">Latvian</option><option value=\"lt\">Lithuanian</option><option value=\"no\">Norwegian</option><option value=\"fa\">Persian</option><option value=\"pl\">Polish</option><option value=\"pt\">Portuguese</option><option value=\"ro\">Romanian</option><option value=\"ru\">Russian</option><option value=\"sk\">Slovak</option><option value=\"sl\">Slovenian</option><option value=\"es\">Spanish</option><option value=\"sv\">Swedish</option><option value=\"th\">Thai</option><option value=\"tr\">Turkish</option><option value=\"uk\">Ukrainian</option><option value=\"vi\">Vietnamese</option></select>\r\n");
      out.write("\t\t    \t\t\t</td>\r\n");
      out.write("\t\t    \t\t</tr>\r\n");
      out.write("\t\t    \t</table>\r\n");
      out.write("\t\t    </form>\r\n");
      out.write("\t    <div style=\"text-align:center;padding:5px\">\r\n");
      out.write("\t    \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"submitForm()\">Submit</a>\r\n");
      out.write("\t    \t<a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" onclick=\"clearForm()\">Clear</a>\r\n");
      out.write("\t    </div>\r\n");
      out.write("\t    </div>\r\n");
      out.write("        </div>\r\n");
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
