package com.example.demo.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter  implements Filter {
	
	   //不需要登录就可以访问的路径(比如:注册登录等)
   private String[] includeUrls = new String[]{"/demo/static/js",
		   "/demo/loginSystem.html",
		   "/demo/system",
		   "/demo/static/layui"};
   private String NO_LOGIN = "您还未登录";
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
	        } else { //需要过滤器
	            // session 登录标识
	          if(session!=null&&session.getAttribute("userName") != null){
//	                 System.out.println("user:"+session.getAttribute("userName"));
	                filterChain.doFilter(request, response);
	            }else{
	                String requestType = request.getHeader("X-Requested-With");
	                //判断是否是ajax请求
	                if(requestType!=null && "XMLHttpRequest".equals(requestType)){
	                    response.getWriter().write(this.NO_LOGIN);
	                }else{
	                    //重定向到登录页(需要在static文件夹下建立此html文件)
	                    response.sendRedirect(request.getContextPath()+"/loginSystem.html");
	                }
	                return;
	            }
	        }
	}

	
	 public boolean isNeedFilter(String uri) {
	        for (String includeUrl : includeUrls) {
	            if( uri.startsWith(includeUrl)) {
	                return false;
	            }
	        }
	        return true;
	    }

}
