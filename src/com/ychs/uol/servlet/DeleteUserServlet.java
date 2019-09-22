package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.service.UserService;
import com.ychs.uol.service.UserServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class DeleteUserServlet
 */
@WebServlet("/DeleteUserServlet")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserService userService = new UserServiceImpl();
		String userId = EncodingUtil.changeEncoding(request.getParameter("userId"));
		String currPage = EncodingUtil.changeEncoding(request.getParameter("currPage"));
		
		int result = userService.deleteUser(userId);
		if(result != 0) {
		    response.sendRedirect("DisplayUserServlet?pageTag=delete&currPage="+currPage);
		} else {
            response.sendRedirect("fail.jsp");
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
