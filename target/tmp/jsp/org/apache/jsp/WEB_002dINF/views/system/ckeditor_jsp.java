package org.apache.jsp.WEB_002dINF.views.system;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ckeditor_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<script type=\"text/javascript\" src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/ckeditor-4.5.6/ckeditor.js\"></script>\r\n");
      out.write("\r\n");
      out.write("<style type=\"text/css\">\r\n");
      out.write(".itable label{\r\n");
      out.write("\tfont-size: 12px;\r\n");
      out.write("\tfont-family: 'Microsoft YaHei';\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".l_td{\r\n");
      out.write("\twidth:5%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".w_td{\r\n");
      out.write("width:40%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itable td input{\r\n");
      out.write("\twidth:89%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itable td label{\r\n");
      out.write("\tfloat:right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".itable td select{\r\n");
      out.write("\twidth:90%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("$(function(){\r\n");
      out.write("\t$('#articleTitle').focus();\r\n");
      out.write("\t\r\n");
      out.write("})\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("function formSumbit(){\r\n");
      out.write("\tvar data = CKEDITOR.instances.editor.getData();\r\n");
      out.write("\t$('#ckForm').submit();\r\n");
      out.write("\t\r\n");
      out.write("\t//设置值\r\n");
      out.write("\t//CKEDITOR.instances.editor.setData(data+\"<h1>hello</h1>\");\r\n");
      out.write("\t\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<title>IMark</title>\r\n");
      out.write("<script type=\"text/javascript\">\r\n");
      out.write("</script>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\t<fieldset class=\"ifieldset\">\r\n");
      out.write("            <legend>文本编辑</legend>\r\n");
      out.write("\t\t \t\t<form id=\"ckForm\" action=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/editor/saveArticle\" method=\"post\">\r\n");
      out.write("\t\t\t\t\t<table style=\"width: 100%\" class=\"itable\">\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"l_td\"><label>文章标题：</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w_td\"><input name=\"articleTitle\" id=\"articleTitle\"/></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"l_td\"><label>类别：</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w_td\">\r\n");
      out.write("\t\t\t\t\t\t\t\t<select name=\"articleType\" id=\"articleType\">\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"1\">个人随想</option> \r\n");
      out.write("\t\t\t\t\t\t\t\t\t<option value=\"2\">网上摘录</option>   \r\n");
      out.write("\t\t\t\t\t\t\t\t</select>\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"l_td\"><label>描述信息：</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w_td\"><input name=\"articleDesc\" /></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"l_td\"><label>关键字：</label></td>\r\n");
      out.write("\t\t\t\t\t\t\t<td class=\"w_td\"><input name=\"keyWord\" /></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"4\"></td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td colspan=\"4\">\t\r\n");
      out.write("\t\t\t\t\t\t\t\t\t<textarea name=\"articleContent\" id=\"editor\" rows=\"10\" cols=\"80\">\r\n");
      out.write("\t\t\t\t               \t\t\t\r\n");
      out.write("\t\t\t\t           \t\t\t </textarea>\r\n");
      out.write("\t\t\t\t           \t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t\t<tr>\r\n");
      out.write("\t\t\t\t\t\t\t<td>\r\n");
      out.write("\t\t\t\t\t\t\t\t<a style=\"float:right;margin-right:10px;\" href=\"javascript:void(0)\"  onclick=\"formSumbit()\" class=\"btn_a_add\">提交</a>\r\n");
      out.write("\t\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t\t</td>\r\n");
      out.write("\t\t\t\t\t\t</tr>\r\n");
      out.write("\t\t\t\t\t</table>\r\n");
      out.write("\t\t        </form>\r\n");
      out.write("\t\t</fieldset>\r\n");
      out.write("\t\t <script>\r\n");
      out.write("              CKEDITOR.replace( 'editor', {\r\n");
      out.write("                    customConfig: '");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ctx}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("/resources/ckeditor-4.5.6/config.js?v='+Math.random()\r\n");
      out.write("               });\r\n");
      out.write("\t\t </script>\r\n");
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
