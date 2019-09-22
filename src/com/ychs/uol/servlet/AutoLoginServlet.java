package com.ychs.uol.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.ychs.uol.service.UserService;
import com.ychs.uol.service.UserServiceImpl;
import com.ychs.uol.util.EncodingUtil;
import com.ychs.uol.util.MyMD5Util;

/**
 * Servlet implementation class AutoLoginServlet
 */
@WebServlet("/AutoLoginServlet")
public class AutoLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        
        UserService userService = new UserServiceImpl();
        // 获取用户名以及密码
        String userName = EncodingUtil.changeEncoding(request.getParameter("username"));
        String userPwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));
        
        // 注意：此处因为是从cookie中直接获取的userPwd（已经加密过），所以不需要再次进行加密
        
        // 登陆验证
        boolean result = userService.checkUser(userName, userPwd);     
        if(result) {
            // 定义session
            HttpSession session = request.getSession();// 获取Sesson
            session.setAttribute("userName", userName);
            response.sendRedirect("main.jsp");// 重定向页面
        }else {
            response.sendRedirect("login.jsp");// 重定向页面
        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
