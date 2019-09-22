package com.ychs.uol.servlet;

import java.io.IOException;
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
 * Servlet implementation class AddCourseMemberServlet
 */
@WebServlet("/AddCourseMemberServlet")
public class AddCourseMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCourseMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseMemberService courseMemberService = new CourseMemberServiceImpl();

        String memberId = EncodingUtil.changeEncoding(request.getParameter("memberid"));
        String courseDate = EncodingUtil.changeEncoding(request.getParameter("date"));
        String memberName = EncodingUtil.changeEncoding(request.getParameter("realname"));
        String sex = EncodingUtil.changeEncoding(request.getParameter("sex"));
        String school = EncodingUtil.changeEncoding(request.getParameter("school"));
        String department = EncodingUtil.changeEncoding(request.getParameter("department"));
        String grade = EncodingUtil.changeEncoding(request.getParameter("grade"));
        String phoneNumber = EncodingUtil.changeEncoding(request.getParameter("mobile"));
        String email = EncodingUtil.changeEncoding(request.getParameter("email"));
        
        CourseMember member = new CourseMember(memberId, courseDate, memberName, sex, school, department, grade, phoneNumber, email);
        int  result = courseMemberService.addCourseMember(member);
        
        if(result != 0) {
            response.sendRedirect("DisplayCourseMemberServlet");
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
