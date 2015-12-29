package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class main_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\r\n");
      out.write("<link href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/styles/main.css\" rel=\"stylesheet\" media=\"screen\">\r\n");
      out.write("<title>IMark</title>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("function addTab(params) {\r\n");
      out.write("\tvar iframe = '<iframe src=\"' + params.url + '\" frameborder=\"0\" style=\"border:0;width:100%;height:98%;\"></iframe>';\r\n");
      out.write("\tvar mainTab = $('#mainTabs');\r\n");
      out.write("\tvar opts = {\r\n");
      out.write("\t\ttitle : params.title,\r\n");
      out.write("\t\tclosable : true,\r\n");
      out.write("\t\ticonCls : params.iconCls,\r\n");
      out.write("\t\tcontent : iframe,\r\n");
      out.write("\t\tborder : false,\r\n");
      out.write("\t\tfit : true\r\n");
      out.write("\t};\r\n");
      out.write("\tif (mainTab.tabs('exists', opts.title)) {\r\n");
      out.write("\t\tmainTab.tabs('select', opts.title);\r\n");
      out.write("\t} else {\r\n");
      out.write("\t\tmainTab.tabs('add', opts);\r\n");
      out.write("\t}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t//权限树\r\n");
      out.write("\t$('#permission_tree').tree({      \r\n");
      out.write("      url: \"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/permission.json?date=\"+new Date().getTime(),  \r\n");
      out.write("      method:'get', \r\n");
      out.write("      onClick:function(node){\r\n");
      out.write("    \t  var param=new Object();\r\n");
      out.write("    \t  param.url=ctx+node.attributes.url;\r\n");
      out.write("    \t  param.title=node.text;\r\n");
      out.write("    \t  addTab(param);\r\n");
      out.write("      }\r\n");
      out.write("\t\t      \r\n");
      out.write("\t});   \t  \r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body class=\"welcome_body\">\r\n");
      out.write("\r\n");
      out.write("<div class=\"easyui-layout\" fit=\"true\">\r\n");
      out.write("\t\t<div data-options=\"region:'north'\" style=\"height:50px\">\r\n");
      out.write("\t\t\t<div id=\"topbar\" class=\"top-bar\">\r\n");
      out.write("                <div class=\"top-bar-left\">\r\n");
      out.write("                    <h1 style=\"margin-left: 10px; margin-top: 10px;color: #fff\">\r\n");
      out.write("                    \t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/images/imark.png\" style=\"vertical-align:middle\">\r\n");
      out.write("                    \t<span style=\"vertical-align:middle;\">IMark</span>\r\n");
      out.write("                    </h1>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("                <div class=\"top-bar-right\">\r\n");
      out.write("                  \t<span class=\"top-bar-user\"> <strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${CURRENT_USER.loginAccount}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong>,欢迎您！</span>\r\n");
      out.write("                </div>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("            ");
      out.write("\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'south',split:true\" style=\"height:30px;\" class=\"ibackgroud\">\r\n");
      out.write("\t\t\t<div class=\"south-bottom\">Copyright © 2015 Imark. All Rights Reserved 京ICP备 0001XXX号     建议分辨率:1280*800 |关于我们</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t\r\n");
      out.write("\t\t<div data-options=\"region:'east',split:true,border: true,iconCls: 'icon-standard-date'\" title=\"日历\" style=\"width:210px;\">\r\n");
      out.write("\t\t\t<div id=\"eastLayout\" class=\"easyui-layout\" data-options=\"fit: true\">\r\n");
      out.write("                <div data-options=\"region: 'north', split: false, border: false\" style=\"height: 220px;\">\r\n");
      out.write("                    <div class=\"easyui-calendar\" data-options=\"fit: true, border: false\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div id=\"linkPanel\" data-options=\"region: 'center', border: false, title: '通知', iconCls: 'icon-hamburg-link', tools: [{ iconCls: 'icon-hamburg-refresh', handler: function () { window.link.reload(); } }]\">\r\n");
      out.write("                    <ul class=\"easyui-tree\" data-options=\"url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/tree_data.json',method:'get',animate:true,dnd:true\"></ul>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'west',split:true, border: true,iconCls: 'icon-hamburg-library'\" title=\"导航\" style=\"width:200px;font-family: Microsoft YaHei;\" >\r\n");
      out.write("\t\t\t<div class=\"easyui-accordion\" data-options=\"fit:true,border:false\">\r\n");
      out.write("\t\t\t\t<div title=\"我的年轮\"  style=\"padding:10px;\" >\r\n");
      out.write("\t\t\t\t\t<ul class=\"easyui-tree\" data-options=\"url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/tree_data.json',method:'get',animate:true,dnd:true\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div title=\"权限管理\"  data-options=\"selected:true\" style=\"padding:10px;\">\r\n");
      out.write("\t\t\t\t\t<ul id=\"permission_tree\"></ul>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t<div title=\"系统监控\" style=\"padding:10px\">\r\n");
      out.write("\t\t\t\t\tcontent3\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div data-options=\"region:'center',title:'Main Title',iconCls:'icon-ok'\">\r\n");
      out.write("\t\t\t<div id=\"mainTabs\" class=\"easyui-tabs\" data-options=\"fit:true,border:false,plain:true\">\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div title=\"主页\" data-options=\"href:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/_content.html'\" style=\"padding:10px\"></div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t\t<div title=\"我的轨迹\" style=\"padding:5px\">\r\n");
      out.write("\t\t\t\t\t<table class=\"easyui-datagrid\"\r\n");
      out.write("\t\t\t\t\t\t\tdata-options=\"url:'");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/data/datagrid_data.json',method:'get',singleSelect:true,fit:true,fitColumns:true\">\r\n");
      out.write("\t\t\t\t\t\t<thead>\r\n");
      out.write("\t\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'itemid'\" width=\"80\">Item ID</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'productid'\" width=\"100\">Product ID</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'listprice',align:'right'\" width=\"80\">List Price</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'unitcost',align:'right'\" width=\"80\">Unit Cost</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'attr1'\" width=\"150\">Attribute</th>\r\n");
      out.write("\t\t\t\t\t\t\t\t<th data-options=\"field:'status',align:'center'\" width=\"50\">Status</th>\r\n");
      out.write("\t\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t</thead>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("\t\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</div>\r\n");
      out.write("\r\n");
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
