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


//@WebFilter("/PhoneNumberFilter")
public class PhoneNumberFilter extends HttpFilter implements Filter {
   
    public PhoneNumberFilter() {
      
    }

	public void destroy() {
		
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		System.out.println("entered phonenumber filter");
		chain.doFilter(request, response);
		System.out.println("exited phonenumber filter");
	}

// Test More CHanges
	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
