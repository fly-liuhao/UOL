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

import com.ychs.uol.model.Credit;
import com.ychs.uol.service.CreditService;
import com.ychs.uol.service.CreditServiceImpl;

/**
 * Servlet implementation class DisplayCreditServlet
 */
@WebServlet("/DisplayCreditServlet")
public class DisplayCreditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCreditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    CreditService creditService = new CreditServiceImpl();
	    Map<String, Object> map = new HashMap<String, Object>();
	    List<Credit> creditList = creditService.selectCredit(map);
	    
	    request.setAttribute("creditList", creditList);
	    request.getRequestDispatcher("score/selectScore.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
