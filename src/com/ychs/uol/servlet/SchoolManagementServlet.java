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
import com.ychs.uol.model.Major;
import com.ychs.uol.model.School;
import com.ychs.uol.service.DepartmentService;
import com.ychs.uol.service.DepartmentServiceImpl;
import com.ychs.uol.service.MajorService;
import com.ychs.uol.service.MajorServiceImpl;
import com.ychs.uol.service.SchoolService;
import com.ychs.uol.service.SchoolServiceImpl;
import com.ychs.uol.util.EncodingUtil;

import oracle.net.aso.f;

/**
 * Servlet implementation class SchoolManagementServlet
 */
@WebServlet("/SchoolManagementServlet")
public class SchoolManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SchoolManagementServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        SchoolService schoolService = new SchoolServiceImpl();
        List<School> schoolList = schoolService.selectAllSchool();    
        request.setAttribute("schoolList", schoolList);
        
        String pageTag = EncodingUtil.changeEncoding(request.getParameter("pageTag"));
        if (pageTag.equals("addDepartment")) {
            request.getRequestDispatcher("school/addDepartment.jsp").forward(request, response);
        }
        if (pageTag.equals("addMajor")) {
            request.getRequestDispatcher("school/addMajor.jsp").forward(request, response);
        }
        if (pageTag.equals("addMember")) {
            request.getRequestDispatcher("member/addMember.jsp").forward(request, response);
        }
        if (pageTag.equals("addPublicClass")) {
            request.getRequestDispatcher("publicclass/addPublicClass.jsp").forward(request, response);
        }
        if (pageTag.equals("registPerson")) {
            request.getRequestDispatcher("publicclass/registPerson.jsp").forward(request, response);
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
