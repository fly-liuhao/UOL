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
 * Servlet implementation class DisplayLabMemberServlet
 */
@WebServlet("/DisplayLabMemberServlet")
public class DisplayLabMemberServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayLabMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LabMemberService labMemberService = new LabMemberServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        List<LabMember> labMemberList = labMemberService.selectLabMember(map);
        request.setAttribute("labMemberList", labMemberList);

        String pageTag = EncodingUtil.changeEncoding(request.getParameter("pageTag"));
        if (pageTag.equals("select")) {
            SchoolService schoolService = new SchoolServiceImpl();
            List<School> schoolList = schoolService.selectAllSchool();
            request.setAttribute("schoolList", schoolList);
            request.getRequestDispatcher("member/selectMember.jsp").forward(request, response);
        }
        if (pageTag.equals("modify")) {
            request.getRequestDispatcher("member/modifyMember.jsp").forward(request, response);
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
