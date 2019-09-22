package com.ychs.uol.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ychs.uol.model.Credit;
import com.ychs.uol.service.CreditService;
import com.ychs.uol.service.CreditServiceImpl;
import com.ychs.uol.util.EncodingUtil;

/**
 * Servlet implementation class AddCreditServlet
 */
@WebServlet("/AddCreditServlet")
public class AddCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    CreditService creditService = new CreditServiceImpl();
	    
	    String stuName = EncodingUtil.changeEncoding(request.getParameter("stuName"));
	    String stuId = EncodingUtil.changeEncoding(request.getParameter("stuId"));
	    String score = EncodingUtil.changeEncoding(request.getParameter("score"));
	    String remark = EncodingUtil.changeEncoding(request.getParameter("remark"));
	    
	    Credit credit = new Credit(stuName, stuId, score, remark);
	    int result = creditService.addCredit(credit);
	    if(result != 0) {
	        response.sendRedirect("success.jsp");
	    } else {
	        response.sendRedirect("fail.jsp");
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
