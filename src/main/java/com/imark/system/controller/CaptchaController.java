package com.imark.system.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.imark.common.util.IUtil;
import com.imark.common.vo.JsonMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;


/**
 * 类名: CaptchaController
 * 包名: com.imark.system.controller
 * 描述: 生成图形验证码,用于注册页面
 * 创建人: ycwu3
 * 创建时间: 2017/10/9 19:48
 **/
@Controller
@RequestMapping("/captcha")
public class CaptchaController {
    @Autowired
    private Producer captchaProducer = null;

    /**
     * 方法名称: 获取图形验证码
     * 参数:
     * 描述信息: TODO
     * 创建人: ycwu3
     * 创建时间: 2017/10/9 21:16
     **/
    @RequestMapping(value = "/getKaptchaImage")
    public ModelAndView getKaptchaImage(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String code = (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        System.out.println("验证码: " + code);

        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");

        String capText = captchaProducer.createText();
        session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);

        BufferedImage bi = captchaProducer.createImage(capText);
        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        try {
            out.flush();
        } finally {
            out.close();
        }
        return null;
    }



    /***
     * 操作日志列表
     * @param request
     * @return
     */
    @RequestMapping("/validate")
    @ResponseBody
    public Object validate(String vcode,HttpSession session){
        Object  existCode=session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        if(existCode!=null&&vcode.equals(existCode+"")){
            return new JsonMsg(true,"验证通过");
        }else{
            return new JsonMsg(false,"验证不通过");
        }
    }

}
