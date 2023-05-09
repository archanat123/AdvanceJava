package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@WebFilter("/UserNameFilter")
public class UserNameFilter extends HttpFilter implements Filter {
       
  
    public UserNameFilter() {
       
    }

	
	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("entered UserNameFilter");
		if(request.getParameter("fullName").isEmpty()) {
				response.getWriter().append("user name is empty || not proceeding");
		return;
		}
		
		chain.doFilter(request, response);
		System.out.println("exited UserNameFilter");
		
	}

	
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
