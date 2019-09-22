package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ychs.uol.service.UserService;
import com.ychs.uol.service.UserServiceImpl;
import com.ychs.uol.util.EncodingUtil;
import com.ychs.uol.util.MyMD5Util;
import com.ychs.uol.util.NetworkUtil;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        UserService userService = new UserServiceImpl();
        // 用户操作状态
        String status = EncodingUtil.changeEncoding(request.getParameter("status"));
        // 用户登陆
        if (status.equals("login")) {
            // 获取用户名以及密码
            String userName = EncodingUtil.changeEncoding(request.getParameter("username"));
            String userPwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));

            // 从cookie中获得保存的用户密码，用于校验是否在自己设备登陆
            String cookiePwd = "";// 记录自己设备cookie中的用户密码信息
            Cookie[] cookies = request.getCookies();
            if (cookies != null && cookies.length > 0) {
                for (Cookie c : cookies) {
                    if (c.getName().equals("userpwd")) {
                        cookiePwd = c.getValue();
                        break;
                    }
                }
            }

            if (!userPwd.equals(cookiePwd)) {
                // 非从cookies获取密码时将密码转化为加密状态
                userPwd = MyMD5Util.getEncryptedPwd(userPwd);
            }

            // 登陆验证
            boolean result = userService.checkUser(userName, userPwd);
            if (result) {
                String isRemember = EncodingUtil.changeEncoding(request.getParameter("isRemember"));
                // 记住密码
                if (isRemember.equals("true")) {
                    // 创建两个cookie，分别用于存放用户名以及密码
                    Cookie cookie1 = new Cookie("username", userName);
                    Cookie cookie2 = new Cookie("userpwd", userPwd);

                    // 指定Cookie绑定的路径，注意：这里指定的路径要求必须添加上项目名称request.getcontextpath()
//                    cookie1.setPath(request.getContextPath() + "/username");
//                    cookie2.setPath(request.getContextPath() + "/userpwd");

                    // 设置Cookie有效期，参数为一个整型值，单位为秒
                    // 该值大于0，表示将Cookie存放到客户端的硬盘
                    // 该值小于0，与不设置效果相同，会将Cookie存放到浏览器缓存中
                    // 该值等于0，表示Cookie一生成，马上失效
                    cookie1.setMaxAge(60 * 60 * 24 * 10);// 设置Cookie有效期为10天
                    cookie2.setMaxAge(30 * 1);// 设置Cookie有效期为1小时
                    // 向响应中添加Cookie
                    response.addCookie(cookie1);
                    response.addCookie(cookie2);
                }

                HttpSession session = request.getSession();// 获取Sesson
                session.setAttribute("username", userName);
                response.sendRedirect("main.jsp");// 重定向页面
            } else {
                response.sendRedirect("login.jsp");// 重定向页面
            }
        }

        // 用户退出
        if (status.equals("exit")) {
            HttpSession session = request.getSession();// 获取Sesson
            // 从但当前sesson中取出userName属性
            session.removeAttribute("userName");

            response.sendRedirect("login.jsp");// 重定向页面
        }

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}
