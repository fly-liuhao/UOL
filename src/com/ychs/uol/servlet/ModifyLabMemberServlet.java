package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.LabMember;
import com.ychs.uol.service.LabMemberService;
import com.ychs.uol.service.LabMemberServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class ModifyLabMemberServlet
 */
@WebServlet("/ModifyLabMemberServlet")
public class ModifyLabMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyLabMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LabMemberService labMemberService = new LabMemberServiceImpl();
	    String studentName = EncodingUtil.changeEncoding(request.getParameter("studentName"));
        String studentId = EncodingUtil.changeEncoding(request.getParameter("studentId"));
        String sex = EncodingUtil.changeEncoding(request.getParameter("sex"));
        String grade = EncodingUtil.changeEncoding(request.getParameter("grade"));
        String birthPlace = EncodingUtil.changeEncoding(request.getParameter("nation"));
        String phoneNumber = EncodingUtil.changeEncoding(request.getParameter("mobile"));
        String email = EncodingUtil.changeEncoding(request.getParameter("email"));
        String school = EncodingUtil.changeEncoding(request.getParameter("school"));
        String department = EncodingUtil.changeEncoding(request.getParameter("department"));
        String major = EncodingUtil.changeEncoding(request.getParameter("major"));
        String schoolJob = EncodingUtil.changeEncoding(request.getParameter("job"));
        String joinDate = EncodingUtil.changeEncoding(request.getParameter("joinDate"));
        String certificate = EncodingUtil.changeEncoding(request.getParameter("card"));
        String status = EncodingUtil.changeEncoding(request.getParameter("state"));
        String labJob = EncodingUtil.changeEncoding(request.getParameter("role"));
        String trainning = EncodingUtil.changeEncoding(request.getParameter("trainning"));
        String skill = EncodingUtil.changeEncoding(request.getParameter("intrest"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
        LabMember member = new LabMember(studentName, studentId, sex, grade, birthPlace, phoneNumber, email, school,
                department, major, schoolJob, joinDate, certificate, status, labJob, trainning, skill, remark);
	    
        int result = labMemberService.modifyLabMember(member);
        if(result != 0) {
            response.sendRedirect("DisplayLabMemberServlet?pageTag=modify");
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
