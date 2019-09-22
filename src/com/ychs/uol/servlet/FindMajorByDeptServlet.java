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
import com.ychs.uol.model.Major;
import com.ychs.uol.service.MajorService;
import com.ychs.uol.service.MajorServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class FindMajorByDeptServlet
 */
@WebServlet("/FindMajorByDeptServlet")
public class FindMajorByDeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindMajorByDeptServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        MajorService majorService = new MajorServiceImpl();
        Map<String, Object> map = new HashMap<String, Object>();
        String schoolId = EncodingUtil.changeEncoding(request.getParameter("schoolId"));
        String deptId = EncodingUtil.changeEncoding(request.getParameter("deptId"));
        if (!deptId.equals("")&&!schoolId.equals("")) {
            map.put("schoolId", schoolId);
            map.put("deptId", deptId);
        }else {
            // 让其查不到
            map.put("deptId", "xxx");
        }
        List<Major> majorList = majorService.selectMajor(map);
        String jsonStr = JSON.toJSONString(majorList);
        out.print(jsonStr);
        out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
