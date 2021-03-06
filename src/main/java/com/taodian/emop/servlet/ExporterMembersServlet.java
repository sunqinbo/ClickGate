package com.taodian.emop.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.taodian.click.ShortUrlService;
import com.taodian.emop.Settings;

public class ExporterMembersServlet extends HttpServlet {

	protected ShortUrlService service = null;
	
	public void init(ServletConfig config){
		service = ShortUrlService.getInstance();		
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    	doPost(request, response);
    }
    
	/**
	 * 导出点击数据。
	 * 
	 * user_id=74,short_key=xx,shop_id=x,num_iid=x, secret=xx
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
    	String url = request.getParameter("url");
    	/*
    	String v = request.getParameter("v");
    	String secret = request.getParameter("sign");
    	String t = request.getParameter("t");

    	String start = request.getParameter("start");
    	String end = request.getParameter("end");
    	*/
    	//m(String field, String value, String secret, String time)
		OutputStream os = response.getOutputStream();// 取得输出流   
		String file = "mty_member.xls";
        response.setHeader("Content-disposition", "attachment; filename=" + file);// 设定输出文件头   
        response.setContentType("application/msexcel");// 定义输出类型 
        service.exportMember(url, os);
        os.flush();

    	//service.e
		//String url = Settings.getString("default_http_index", null);
		/*
    	if(url != null){
			url = response.encodeRedirectURL(url);
			response.sendRedirect(url);	
		} else {
	    	response.setStatus(HttpServletResponse.SC_OK);
			response.setCharacterEncoding("utf8");
			response.setContentType("text/plain");
			
			response.getWriter().print("欢迎使用冒泡短网址系统， version:" + Version.getVersion());
		}
		*/
    	
		
		
		
    }
}
