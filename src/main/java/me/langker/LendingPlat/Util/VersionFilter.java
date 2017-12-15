package me.langker.LendingPlat.Util;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import au.com.flyingkite.mobiledetect.UAgentInfo;

@ManagedBean
@SessionScoped
public class VersionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)arg0;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) arg1);
		UAgentInfo agentInfo = new UAgentInfo(request.getHeader("User-Agent"), null);
		if (agentInfo.detectMobileQuick()) {
			if (request.getRequestURI().contains("mobile")==false) {
				String redirect = request.getContextPath() + "/mobile"+request.getRequestURI().substring(("/"+Util.getProjectname()).length());
				wrapper.sendRedirect(redirect);
			}
		} 
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
