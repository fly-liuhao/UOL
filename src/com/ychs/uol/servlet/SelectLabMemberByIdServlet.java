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

import com.ychs.uol.model.Department;
import com.ychs.uol.model.LabMember;
import com.ychs.uol.model.Major;
import com.ychs.uol.model.School;
import com.ychs.uol.service.DepartmentService;
import com.ychs.uol.service.DepartmentServiceImpl;
import com.ychs.uol.service.LabMemberService;
import com.ychs.uol.service.LabMemberServiceImpl;
import com.ychs.uol.service.MajorService;
import com.ychs.uol.service.MajorServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class SelectLabMemberByIdServlet
 */
@WebServlet("/SelectLabMemberByIdServlet")
public class SelectLabMemberByIdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectLabMemberByIdServlet() {
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
        String memberId = EncodingUtil.changeEncoding(request.getParameter("memberId"));
        LabMember member = labMemberService.selectLabMemberById(memberId);
        String joinDate = member.getJoinDate();
        member.setJoinDate(joinDate.substring(0, 10));
        request.setAttribute("member", member);

        // 填入默认的下拉列表选择项
        {
            SchoolService schoolService = new SchoolServiceImpl();
            List<School> schoolList = schoolService.selectAllSchool();
            request.setAttribute("schoolList", schoolList);

            DepartmentService departmentService = new DepartmentServiceImpl();
            Map<String, Object> deptmap = new HashMap<String, Object>();
            deptmap.put("schoolId", member.getSchoolId());
            List<Department> deptList = departmentService.selectDepartment(deptmap);
            request.setAttribute("deptList", deptList);

            MajorService majorService = new MajorServiceImpl();
            Map<String, Object> majormap = new HashMap<String, Object>();
            majormap.put("schoolId", member.getSchoolId());
            majormap.put("deptId", member.getDeptId());
            List<Major> majorList = majorService.selectMajor(majormap);
            request.setAttribute("majorList", majorList);
        }

        String pageTag = EncodingUtil.changeEncoding(request.getParameter("pageTag"));
        if (pageTag.equals("display")) {
            request.getRequestDispatcher("member/displayMemberInfo.jsp").forward(request, response);
        }
        if (pageTag.equals("modify")) {
            request.getRequestDispatcher("member/modifyMemberInfo.jsp").forward(request, response);
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
