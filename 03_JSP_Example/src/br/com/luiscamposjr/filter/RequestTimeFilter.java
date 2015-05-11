package br.com.luiscamposjr.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/list-contatos.jsp")
public class RequestTimeFilter implements Filter {

    public RequestTimeFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		
		System.out.println("Tempo de execução: " + (tempoFinal - tempoInicial));
		
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
