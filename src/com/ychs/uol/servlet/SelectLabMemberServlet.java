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

import com.ychs.uol.model.LabMember;
import com.ychs.uol.model.School;
import com.ychs.uol.service.LabMemberService;
import com.ychs.uol.service.LabMemberServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class SelectLabMemberServlet
 */
@WebServlet("/SelectLabMemberServlet")
public class SelectLabMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectLabMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    LabMemberService labMemberService = new LabMemberServiceImpl();
	    Map<String, Object> map = new HashMap<String, Object>();
        String memberName = EncodingUtil.changeEncoding(request.getParameter("memberName"));
        if(!memberName.equals("")) {
            map.put("memberName", memberName);
        }  
        String grade = EncodingUtil.changeEncoding(request.getParameter("grade"));
        if(!grade.equals("")) {
            map.put("grade", grade);
        }
        String phoneNumber = EncodingUtil.changeEncoding(request.getParameter("phoneNumber"));
        if(!phoneNumber.equals("")) {
            map.put("phoneNumber", phoneNumber);
        }       
        String schoolid = EncodingUtil.changeEncoding(request.getParameter("school"));
        if(!schoolid.equals("")) {
            map.put("schoolId", schoolid);
        }
        String departmentid = EncodingUtil.changeEncoding(request.getParameter("department"));
        if(!departmentid.equals("")) {
            map.put("departmentId", departmentid);
        }
        String majorid = EncodingUtil.changeEncoding(request.getParameter("major"));
        if(!majorid.equals("")) {
            map.put("majorId", majorid);
        }
        String status = EncodingUtil.changeEncoding(request.getParameter("status"));
        if(!status.equals("")) {
            map.put("status", status);
        }
        String labJob = EncodingUtil.changeEncoding(request.getParameter("labJob"));
        if(!labJob.equals("")) {
            map.put("labJob", labJob);
        }
        String certificate = EncodingUtil.changeEncoding(request.getParameter("certificate"));
        if(!certificate.equals("")) {
            map.put("certificate", certificate);
        }    
	    List<LabMember> labMemberList = labMemberService.selectLabMember(map);
	    
        SchoolService schoolService = new SchoolServiceImpl();
        List<School> schoolList = schoolService.selectAllSchool();
        
        request.setAttribute("schoolList", schoolList);
	    request.setAttribute("labMemberList", labMemberList);
	    request.getRequestDispatcher("member/selectMember.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
