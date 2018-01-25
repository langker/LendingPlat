package me.langker.LendingPlat.Util;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import me.langker.LendingPlat.Controller.ContractController;
import me.langker.LendingPlat.Controller.UserController;
import me.langker.LendingPlat.Entity.User;

@ManagedBean
@SessionScoped
public class URLFilter implements Filter {

	@Inject UserController userController;
	@Inject ContractController conController;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hrequest = (HttpServletRequest)request;
		HttpServletResponseWrapper wrapper = new HttpServletResponseWrapper((HttpServletResponse) response);
		String redirectPath = hrequest.getContextPath() + "/index.xhtml";
		if (hrequest.getSession().getAttribute("userid") !=null ) {
			int loginUserid = (Integer) hrequest.getSession().getAttribute("userid");
			//25 is the lenght of "/LendingPlat/upload_cred
			String credital = hrequest.getRequestURI().substring(25)==null?"":hrequest.getRequestURI().substring(25); 
			
			User loginUser = userController.findUserProfile(loginUserid);
			User visitUser = userController.findByCred(credital);
			
			if (loginUser.getId()==visitUser.getId()
					||loginUser.getIsAdmin()==true
					||conController.isInTheSameContract(loginUser.getId(), visitUser.getId())) { 
				chain.doFilter(request, response);
			} else {
				wrapper.sendRedirect(redirectPath);
	            return;
			}
		} else {
			wrapper.sendRedirect(redirectPath);
            return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
}
