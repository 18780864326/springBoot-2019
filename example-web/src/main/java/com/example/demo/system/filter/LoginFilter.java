package com.example.demo.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginFilter  implements Filter {
		 private static final Logger logger = LoggerFactory.getLogger(LoginFilter.class);
	   //不需要登录就可以访问的路径(白名单)
   private String  servletPath = "/MonitorSystem";
   private String[] includeUrls = new String[]{
		   "/static/js",
		   "/loginSystem.html",
		   "/system",
		   "/static/layui",
		   "/module/monitorInfo",
   		   "/static/plugins",
   		   "/static/images",
   		   "/static/html/conmmon"};
   private String not_login_url = "/system/notLogin";//处理未登录  同步HTTP请求
   private String not_login_ajax_url = "/system/longin_ajaxFilter"; //处理未登录  异步HTTP请求
   private String login_flag = "userName";//登录标识 变量名
   public LoginFilter(){};
   @Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
			throws IOException, ServletException {
		 	HttpServletRequest request = (HttpServletRequest) servletRequest;
	        HttpServletResponse response = (HttpServletResponse) servletResponse;
	        HttpSession session = request.getSession(false);
	        String uri = request.getRequestURI();
//	        System.out.println("filter url:"+uri);
	        boolean needFilter = isNeedFilter(uri);
	        if (!needFilter) { //不需要过滤直接传给下一个过滤器
	            filterChain.doFilter(servletRequest, servletResponse);
	        } else { 
	            // session 登录标识
	          if(session!=null&&session.getAttribute(login_flag) != null){
	                filterChain.doFilter(request, response);
	            }else{
	                String requestType = request.getHeader("X-Requested-With");
	                //判断是否是ajax请求
	                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
	                	request.getRequestDispatcher(not_login_ajax_url).forward(request, response);
	                }else{
	                	request.getRequestDispatcher(not_login_url).forward(request, response);
	                }
	                return;
	            }
	        }
	}

	
	 @Override
	public void destroy() {
	}
	
	 /**
	  *  判断URL是否在白名单中
	  * @param uri
	  * @return
	  */
	 public boolean isNeedFilter(String uri) {
	        for (String includeUrl : includeUrls) {
	            if( uri.startsWith(servletPath+includeUrl)) {
	                return false;
	            }
	        }
	        return true;
	    }

}
