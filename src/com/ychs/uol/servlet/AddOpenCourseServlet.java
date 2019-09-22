package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.OpenCourse;
import com.ychs.uol.service.OpenCourseService;
import com.ychs.uol.service.OpenCourseServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class AddOpenCourseServlet
 */
@WebServlet("/AddOpenCourseServlet")
public class AddOpenCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddOpenCourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OpenCourseService openCourseService = new OpenCourseServiceImpl();

        String courseDate = EncodingUtil.changeEncoding(request.getParameter("courseDate"));
        String courseName = EncodingUtil.changeEncoding(request.getParameter("courseName"));
        String speakerName = EncodingUtil.changeEncoding(request.getParameter("speakerName"));
        String organizerName = EncodingUtil.changeEncoding(request.getParameter("organizerName"));
        String place = EncodingUtil.changeEncoding(request.getParameter("address"));
        String school = EncodingUtil.changeEncoding(request.getParameter("school"));
        String department = EncodingUtil.changeEncoding(request.getParameter("department"));
        String grade = EncodingUtil.changeEncoding(request.getParameter("grade"));
        String explain = EncodingUtil.changeEncoding(request.getParameter("explain"));
        String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));

        OpenCourse course = new OpenCourse(courseDate, courseName, speakerName, organizerName, place, school,
                department, grade, explain, remark);

        int result = openCourseService.addOpenCourse(course);
        if (result != 0) {
            response.sendRedirect("success.jsp");
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
