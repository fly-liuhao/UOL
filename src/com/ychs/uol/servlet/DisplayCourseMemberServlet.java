package com.ychs.uol.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.CourseMember;
import com.ychs.uol.service.CourseMemberService;
import com.ychs.uol.service.CourseMemberServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class DisplayCourseMemberServlet
 */
@WebServlet("/DisplayCourseMemberServlet")
public class DisplayCourseMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCourseMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       CourseMemberService courseMemberService = new CourseMemberServiceImpl();
	        Map<String, Object> map = new HashMap<String, Object>();
	        List<CourseMember> courseMemberList = courseMemberService.selectCourseMember(map);
	        request.setAttribute("courseMemberList", courseMemberList);
	        request.getRequestDispatcher("publicclass/selectPerson.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
