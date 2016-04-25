package com.puban.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProgressController extends HttpServlet
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		req.setAttribute("data", req.getSession().getAttribute("status"));

		String data = req.getAttribute("data").toString();
		PrintWriter out = resp.getWriter();  
        out.print(data);
        out.flush();
        out.close(); 
	}

}
