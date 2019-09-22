package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import com.ychs.uol.model.User;
import com.ychs.uol.service.UserService;
import com.ychs.uol.service.UserServiceImpl;
import com.ychs.uol.util.EncodingUtil;
import com.ychs.uol.util.MyMD5Util;

/**
 * Servlet implementation class AddUserServlet
 */
@WebServlet("/AddUserServlet")
public class AddUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
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

        String username = EncodingUtil.changeEncoding(request.getParameter("username"));
        String userpwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));
        String realname = EncodingUtil.changeEncoding(request.getParameter("realname"));
        String sex = EncodingUtil.changeEncoding(request.getParameter("sex"));
        String job = EncodingUtil.changeEncoding(request.getParameter("job"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));

        User user = new User(username, userpwd, realname, sex, job, remark);
        int result = userService.addUser(user);
        if (result != 0) {
            response.sendRedirect("success.jsp");// 重定向
        } else {
            response.sendRedirect("fail.jsp");// 重定向
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
