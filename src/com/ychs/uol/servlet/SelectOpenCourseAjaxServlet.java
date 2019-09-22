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
import com.ychs.uol.model.OpenCourse;
import com.ychs.uol.model.School;
import com.ychs.uol.service.OpenCourseService;
import com.ychs.uol.service.OpenCourseServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class SelectOpenCourseAjaxServlet
 */
@WebServlet("/SelectOpenCourseAjaxServlet")
public class SelectOpenCourseAjaxServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectOpenCourseAjaxServlet() {
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

        String status = EncodingUtil.changeEncoding(request.getParameter("status"));
        if (status.equals("first")) {
            // 查询到的所有学校信息
            SchoolService schoolService = new SchoolServiceImpl();
            List<School> schoolList = schoolService.selectAllSchool();
            request.setAttribute("schoolList", schoolList);

            // 查询所有的公开课记录
            List<OpenCourse> openCourseList = openCourseService.selectOpenCourse(null);

            int pageSize = 3;// 每页记录个数
            int recordNum = openCourseList.size();// 总共查询的记录数

            int pageNum = recordNum / pageSize;// 一共可分几页
            if (recordNum % pageSize != 0) {
                pageNum++;
            }
            request.setAttribute("pageNum", pageNum);
            request.getRequestDispatcher("publicclass/selectClass.jsp").forward(request, response);

        }
        if (status.equals("second")) {
            response.setContentType("text/html;charset=utf-8");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            Map<String, Object> map = new HashMap<String, Object>();
            String startDate = EncodingUtil.changeEncoding(request.getParameter("startDate"));
            if (!startDate.equals("")) {
                map.put("startDate", startDate);
            }
            String endDate = EncodingUtil.changeEncoding(request.getParameter("endDate"));
            if (!endDate.equals("")) {
                map.put("endDate", endDate);
            }
            String courseName = EncodingUtil.changeEncoding(request.getParameter("courseName"));
            if (!courseName.equals("")) {
                map.put("courseName", courseName);
            }
            String schoolId = EncodingUtil.changeEncoding(request.getParameter("school"));
            if (!schoolId.equals("")) {
                map.put("schoolId", schoolId);
            }
            String deptId = EncodingUtil.changeEncoding(request.getParameter("department"));
            if (!deptId.equals("")) {
                map.put("deptId", deptId);
            }
            String grade = EncodingUtil.changeEncoding(request.getParameter("grade"));
            if (!grade.equals("")) {
                map.put("grade", grade);
            }
            // 根据条件查询公开课记录
            List<OpenCourse> openCourseList = openCourseService.selectOpenCourse(map);

            // 根据网页传来的页码进行分页
            int pageSize = 3;// 每页记录个数
            int currPage = Integer.parseInt(EncodingUtil.changeEncoding(request.getParameter("page")));// 获取当前页码
            int brginPage = (currPage - 1) * pageSize;// 分页开始索引
            int endPage = currPage * pageSize;// 分页结束索引
            if (endPage > openCourseList.size()) {// 限制索引使其不超过边际边际
                endPage = openCourseList.size();
            }
            List<OpenCourse> subOpenCourseList = openCourseList.subList(brginPage, endPage);
            // 使用阿里的插件，转为JSON字符串
            String jsonStr = JSON.toJSONString(subOpenCourseList);
            out.print(jsonStr);

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
