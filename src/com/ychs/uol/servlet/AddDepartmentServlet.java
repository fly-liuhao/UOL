package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.Department;
import com.ychs.uol.service.DepartmentService;
import com.ychs.uol.service.DepartmentServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class AddDepartmentServlet
 */
@WebServlet("/AddDepartmentServlet")
public class AddDepartmentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDepartmentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DepartmentService departmentService = new DepartmentServiceImpl();
		
		String departmentName = EncodingUtil.changeEncoding(request.getParameter("departmentName"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
        String schoolId = EncodingUtil.changeEncoding(request.getParameter("schoolId"));

        Department department = new Department(departmentName, remark, schoolId);
        int result = departmentService.addDepartment(department);
        if (result != 0) {
            response.sendRedirect("success.jsp");// 重定向页面
        } else {
            response.sendRedirect("fail.jsp");// 重定向页面
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
