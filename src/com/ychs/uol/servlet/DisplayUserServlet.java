package com.ychs.uol.servlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

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
 * Servlet implementation class DisplayUserServlet
 */
@WebServlet("/DisplayUserServlet")
public class DisplayUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 定义一个userSerice的接口
        UserService userService = new UserServiceImpl();

        // 接收查询出的每页用户对象
        List<User> userList = userService.selectAllUser();
        // 定义分页显示每一页的记录个数
        int pageSize = 5;
        // 从前端获取的页码
        int currPage = Integer.parseInt(EncodingUtil.changeEncoding(request.getParameter("currPage")));
        // 得到user表总记录个数
        int recordNum = userService.getUserRecordNum();
        // 得到总页数
        int pageNum = recordNum / pageSize;
        if (recordNum % pageSize != 0) {
            pageNum++;
        }
        // 限制页数溢出
        if (currPage < 1) {
            currPage = 1;
        }
        if (currPage > pageNum) {
            currPage = pageNum;
        }

        // 查询制定页码的用户
        userList = userService.selectUserPage(currPage, pageSize);

        /** Servlet向JSP网页传递数据的一种方式 */

        // 将集合保存到request，在网页上显示数据
        request.setAttribute("userList", userList);
        // 提交当前页码
        request.setAttribute("currPage", currPage);
        // 提交总记录个数
        request.setAttribute("recordNum", recordNum);
        // 提交总页数
        request.setAttribute("pageNum", pageNum);

        String pageTag = EncodingUtil.changeEncoding(request.getParameter("pageTag"));
        if (pageTag.equals("modify")) {
            // 跳转到指定网页，采用的是 转发方式(forward)
            request.getRequestDispatcher("user/modifyUser.jsp").forward(request, response);
        }
        if (pageTag.equals("delete")) {
            request.getRequestDispatcher("user/deleteUser.jsp").forward(request, response);
        }
        if (pageTag.equals("ban")) {
            request.getRequestDispatcher("user/disableUser.jsp").forward(request, response);
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
