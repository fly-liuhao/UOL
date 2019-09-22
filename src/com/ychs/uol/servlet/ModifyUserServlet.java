package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.User;
import com.ychs.uol.service.UserService;
import com.ychs.uol.service.UserServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class ModifyUserServlet
 */
@WebServlet("/ModifyUserServlet")
public class ModifyUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyUserServlet() {
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

        String userId = EncodingUtil.changeEncoding(request.getParameter("userId"));
        String username = EncodingUtil.changeEncoding(request.getParameter("username"));
        String userpwd = EncodingUtil.changeEncoding(request.getParameter("userpwd"));
        String realname = EncodingUtil.changeEncoding(request.getParameter("realname"));
        String sex = EncodingUtil.changeEncoding(request.getParameter("sex"));
        String job = EncodingUtil.changeEncoding(request.getParameter("job"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
        String status = EncodingUtil.changeEncoding(request.getParameter("status"));

        User user = new User(userId, username, userpwd, realname, sex, job, remark, status);
        int result = userService.modifyUser(user);
        if (result != 0) {
            // 从前端获取的页码
            int currPage = Integer.parseInt(EncodingUtil.changeEncoding(request.getParameter("currPage")));
            response.sendRedirect("DisplayUserServlet?pageTag=modify&currPage="+currPage);
        } else {
            response.sendRedirect("fail.jsp");
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
