package com.puban.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadUtil extends HttpServlet
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final String UPLOAD_DIR = "C:\\Users\\yy\\Desktop\\test\\";
	
	private static final String TMP_DIR = "C:\\Users\\yy\\Desktop\\test";
	
	private static final String ENCODING = "UTF-8";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
		if(ServletFileUpload.isMultipartContent(req))
		{
			
			req.setCharacterEncoding(ENCODING);
			DiskFileItemFactory factory = new DiskFileItemFactory();
			File repository = new File(TMP_DIR);
			factory.setRepository(repository);
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setHeaderEncoding(ENCODING);
			upload.setSizeMax(-1);
			upload.setProgressListener(new MyProgressListener(req, resp));
			try
			{
				List<FileItem> items = upload.parseRequest(req);
				for(FileItem file : items)
				{
					if(!file.isFormField())
					{
						if(file.getName() != null && file.getSize() != 0)
						{
							String name = file.getName();
							String newFile = UPLOAD_DIR + getNewName(name);
							file.write(new File(newFile));
							System.out.println("File:" + file.getName() + " is upload to "
									+ newFile);
							
						}
					}
				}
			} catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}

	private static String getNewName(String fileName)
	{
		int index = fileName.lastIndexOf(".");
		return fileName.substring(0, index) + "_"
				+ System.currentTimeMillis() 
				+ fileName.substring(index);
	}
	
}
