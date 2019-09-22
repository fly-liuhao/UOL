package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.Major;
import com.ychs.uol.service.MajorService;
import com.ychs.uol.service.MajorServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class AddMajorServlet
 */
@WebServlet("/AddMajorServlet")
public class AddMajorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMajorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MajorService majorService = new MajorServiceImpl();

        String majorName = EncodingUtil.changeEncoding(request.getParameter("majorName"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
        String deptId = EncodingUtil.changeEncoding(request.getParameter("dept"));
        String schoolId = EncodingUtil.changeEncoding(request.getParameter("school"));

        Major major = new Major(majorName, remark, deptId, schoolId);
        int result = majorService.addMajor(major);
        if (result != 0) {
            response.sendRedirect("success.jsp");// 重定向页面
        } else {
            response.sendRedirect("fail.jsp");// 重定向页面
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
