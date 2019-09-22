package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.School;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class AddSchoolServlet
 */
@WebServlet("/AddSchoolServlet")
public class AddSchoolServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSchoolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    SchoolService schoolService = new SchoolServiceImpl();
	    String schoolname = EncodingUtil.changeEncoding(request.getParameter("schoolname"));
	    String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
	    School school = new School(schoolname, remark);
	    int result = schoolService.addSchool(school);
        if (result != 0) {
            response.sendRedirect("success.jsp");// 重定向
        } else {
            response.sendRedirect("fail.jsp");// 重定向
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
