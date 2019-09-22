package com.ychs.uol.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.ychs.uol.model.Department;
import com.ychs.uol.model.School;
import com.ychs.uol.service.DepartmentService;
import com.ychs.uol.service.DepartmentServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class FindDeptBySchoolServlet
 */
@WebServlet("/FindDeptBySchoolServlet")
public class FindDeptBySchoolServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindDeptBySchoolServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        DepartmentService departmentService = new DepartmentServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        String schoolId = EncodingUtil.changeEncoding(request.getParameter("schoolId"));
        if (!schoolId.equals("")) {
            map.put("schoolId", schoolId);
        }else {
            // 让其查不到
            map.put("schoolId", "xxx");
        }
        List<Department> departmentList = departmentService.selectDepartment(map);
        String jsonStr = JSON.toJSONString(departmentList);
        out.print(jsonStr);
        out.close();
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
