package com.puban.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.ProgressListener;
public class MyProgressListener implements ProgressListener 
{
	private HttpServletResponse resp;
	private HttpServletRequest req;
	
	public MyProgressListener(HttpServletRequest req, HttpServletResponse resp)
	{
		this.req = req;
		this.resp = resp;
	}
	public void update(long pBytesRead, long pContentLength, int pItems) 
	{
		//System.out.println("We are currently reading item " + pItems);
		if (pContentLength == -1) 
		{
		} else 
		{
			double f = (double)pBytesRead/pContentLength;
			int i = (int)(f*100);

			req.getSession().setAttribute("status", i);
	        
       }
   }
	
}
