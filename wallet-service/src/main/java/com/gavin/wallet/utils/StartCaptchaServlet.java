package com.turing.wallet.utils;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;


/**
 * Created by zhaozhenhua on 2018/6/26.
 */
public class StartCaptchaServlet extends HttpServlet {

    protected static final org.slf4j.Logger logger = LoggerFactory.getLogger(StartCaptchaServlet.class);

    private static StartCaptchaServlet startCaptchaServlet;

    private static Integer errorNum = 0;

    /**
     * 滑动验证码初始化
     * gtServerStatus和success字段是表示api1接口的状态，1表示正常，0表示异常，这两个字段的含义是对应的。
     * gtServerStatus字段是api1接口存入到session中，api2接口会从session取出这个值并进行后续判断，1就走正常二次验证逻辑，0就走宕机模式逻辑。
     * success字段是api1接口返回给前端的值，控制前端的表现形式，1就展现正常页面，0就展示宕机页面。
     *
     * @param userId
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static String captch1(String userId, HttpServletRequest request,
                                 HttpServletResponse response) throws ServletException, IOException {

        //获取参数
//        JSONObject GeetestJson = ConfigUtils.getJsonByKey("sys_conf_geetest_config");
        JSONObject GeetestJson = null;

        GeetestLib gtSdk = new GeetestLib(GeetestJson.getString("geetest_id"), GeetestJson.getString("geetest_key"),
                true);
        String resStr = "{}";

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", userId); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", request.getRemoteAddr()); //传输用户请求验证时所携带的IP


        //进行验证预处理
        int gtServerStatus = gtSdk.preProcess(param);
        //将服务器状态设置到session中
        request.getSession().setAttribute(gtSdk.gtServerStatusSessionKey, gtServerStatus);
        //将userid设置到session中
        request.getSession().setAttribute("userid", userId);

        if (gtServerStatus != 1) {
            errorNum = errorNum + 1;
            logger.error("geet error gtServerStatus:{} 验证码接口错误，当前错误次数:{}，请及时更换验证类型", gtServerStatus, errorNum);
        } else {
            errorNum = 0;
        }

        resStr = gtSdk.getResponseStr();
        return resStr;

    }

    private static void addParams(HashMap<String, String> param, HttpServletRequest request) {
        String customer_url = request.getHeader("referer");
        String customer_ua = request.getHeader("user-agent");
//        String ip_address = AbnormalUtil.getIp();
        String ip_address = null;
        if (ip_address != null) {
            param.put("ip_address", ip_address);
        }
        param.put("customer_url", customer_url);
        param.put("customer_ua", customer_ua);
    }

    /**
     * 滑动验证码二次校验
     *
     * @param geetest_challenge
     * @param geetest_validate
     * @param geetest_seccode
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public static boolean checkCaptchaCode(String geetest_challenge, String geetest_validate, String geetest_seccode, HttpServletRequest request,
                                           HttpServletResponse response) throws ServletException, IOException {


//        JSONObject GeetestJson = ConfigUtils.getJsonByKey("sys_conf_geetest_config");
        JSONObject GeetestJson = null;

        GeetestLib gtSdk = new GeetestLib(GeetestJson.getString("geetest_id"), GeetestJson.getString("geetest_key"),
                true);

        String challenge = geetest_challenge; //request.getParameter(GeetestLib.fn_geetest_challenge);
        String validate = geetest_validate; //request.getParameter(GeetestLib.fn_geetest_validate);
        String seccode = geetest_seccode; //request.getParameter(GeetestLib.fn_geetest_seccode);

        logger.info("challenge:{},validate:{},seccode:{},gt_server_status_code:{}", challenge, validate, seccode);

        //从session中获取gt-server状态
        Object gt_server_status_code = request.getSession().getAttribute(gtSdk.gtServerStatusSessionKey);
        logger.info("gt server status code {}", gt_server_status_code);
        //从session中获取userid
        String userid = (String) request.getSession().getAttribute("userid");

        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("user_id", userid); //网站用户id
        param.put("client_type", "web"); //web:电脑上的浏览器；h5:手机上的浏览器，包括移动应用内完全内置的web_view；native：通过原生SDK植入APP应用的方式
        param.put("ip_address", request.getRemoteAddr()); //传输用户请求验证时所携带的IP

        try {
            // 影响太大，新增功能 先保证出错也不能影响原有版本功能
            // 运行稳定可以移除 try catch
            addParams(param, request);
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        int gtResult = 0;

        //gt-server正常，向gt-server进行二次验证,强制校验
        gtResult = gtSdk.enhencedValidateRequest(challenge, validate, seccode, param);
        logger.info("1:gtResult:{}", gtResult);

        if (gtResult == 1) {
            return true;
        } else {
            // 验证失败
            return false;
        }
    }
}
