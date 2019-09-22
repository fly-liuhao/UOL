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

import com.ychs.uol.model.OpenCourse;
import com.ychs.uol.model.School;
import com.ychs.uol.service.OpenCourseService;
import com.ychs.uol.service.OpenCourseServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class DisplayOpenCourseServlet
 */
@WebServlet("/DisplayOpenCourseServlet")
public class DisplayOpenCourseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOpenCourseServlet() {
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

        Map<String, Object> map = new HashMap<String, Object>();
        List<OpenCourse> openCourseList = openCourseService.selectOpenCourse(map);
        request.setAttribute("openCourseList", openCourseList);

        // 查询到的所有学校信息
        SchoolService schoolService = new SchoolServiceImpl();
        List<School> schoolList = schoolService.selectAllSchool();
        request.setAttribute("schoolList", schoolList);

        request.getRequestDispatcher("publicclass/selectClass.jsp").forward(request, response);
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
