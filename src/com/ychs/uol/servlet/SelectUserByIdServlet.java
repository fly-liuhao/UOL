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
 * Servlet implementation class SelectUserByIdServlet
 */
@WebServlet("/SelectUserByIdServlet")
public class SelectUserByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserByIdServlet() {
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
        User user = userService.selectUserById(userId);
        request.setAttribute("user", user);
        
        // 从前端传递过来的页码
        int currPage = Integer.parseInt(EncodingUtil.changeEncoding(request.getParameter("currPage")));
        // 提交当前页码
        request.setAttribute("currPage", currPage);
        request.getRequestDispatcher("user/modifyUserInfo.jsp").forward(request, response);
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
