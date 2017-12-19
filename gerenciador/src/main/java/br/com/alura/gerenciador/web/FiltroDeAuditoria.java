package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter("/*")
public class FiltroDeAuditoria implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		String usuario = "<deslogado>";
		/*
		if(cookie != null) {
			usuario = cookie.getValue();
			cookie.setMaxAge(10*60);
			res.addCookie(cookie);
		}*/
		
		HttpSession session = req.getSession();
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuario.logado");
		
		if(usuarioLogado != null) {
			usuario = usuarioLogado.getEmail();
		}
		
		System.out.println("Usuário " + usuario +" acessando a URI " + req.getRequestURI());
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
