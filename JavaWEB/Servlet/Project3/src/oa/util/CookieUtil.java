package oa.util;

import jakarta.servlet.ServletRequestAttributeEvent;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.http.fileupload.RequestContext;


/**
 * 编写的Cookie类，用于生成Cookie、删除单个cookie和删除所有的cookie
 */
public class CookieUtil extends HttpServlet {
    private static HttpServletRequest request;
    private static HttpServletResponse response;




    //有参构造法
    public CookieUtil(HttpServletRequest request,HttpServletResponse response){
        CookieUtil.request = request;
        CookieUtil.response = response;
    }

    public static HttpServletRequest getRequest() {
        return request;
    }

    public static void setRequest(HttpServletRequest request) {
        CookieUtil.request = request;
    }

    public static HttpServletResponse getResponse() {
        return response;
    }

    public static void setResponse(HttpServletResponse response) {
        CookieUtil.response = response;
    }

    /**
     * 创建cookie，需传入所需要的cookiename,cookievalue,path,effectTime
     * @param CookieName
     * @param CookieValue
     * @param path
     * @param EffectTime
     * @return
     */
    public static void CreateCookie(String CookieName, String CookieValue, String path, int EffectTime){

        Cookie cookie = new Cookie(CookieName,CookieValue);
        cookie.setPath(path);
        cookie.setMaxAge(EffectTime);
        response.addCookie(cookie);

    }


    /**
     * 删除指定的cookie：输入Cookie的名字，然后将该cookie删除
     * @param CookieName
     * @return null
     */
    public void DeleteSingleCookie(String CookieName){
        //获取请求的cookies
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie:
             cookies) {
            //如果传入的名字与cookie中的名字有一样的就删除
            if (CookieName.equals(cookie.getName())) {
                //设置cookie的值为空
                cookie.setValue(null);

                //立即删除当前cookie
                cookie.setMaxAge(0);
                cookie.setPath(request.getContextPath());

                //传入新的cookie给响应域，响应域接受并重置cookie（非常重要，一定不能省略）
                response.addCookie(cookie);

                //执行到这里说明已经成功删除，在后台输出删除成功的提示信息
                System.out.println(cookie.getName() + "已经被成功删除");
            }else {
                //执行到这里说明并没有这个name的cookie，在后台输出相应的提示信息
                System.out.println("对不起，并没有名为" + cookie.getName() + "的cookie");
            }

        }

    }


    /**
     * 删除全部的cookie
     * @return
     */
    public static void DeleteAllCookie(){
        //获取Cookie
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie:
             cookies) {
            //逐个删除cookie
            cookie.setValue(null);
            cookie.setMaxAge(0);
            cookie.setPath(request.getContextPath());
            response.addCookie(cookie);
        }

        //提示用户cookie已经删除完成
        System.out.println("已经完全删除cookie！");

    }
}
