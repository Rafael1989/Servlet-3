package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Logout implements Tarefa{
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie cookie = new Cookies(req.getCookies()).getUsuarioLogado();
		
		if(cookie != null) {
			cookie.setMaxAge(0);
			resp.addCookie(cookie);
		}
		HttpSession session = req.getSession();
		
		session.removeAttribute("usuarioLogado");
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/logout.html");
		dispatcher.forward(req, resp);
		//resp.sendRedirect("logout.html"); redirecionamento feito do lado do client 302
		PrintWriter writer = resp.getWriter();
		writer.println("<html><body>Logout efetuado</body></html>");
	}
*/
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("usuarioLogado");
		
		return "/WEB-INF/paginas/logout.html";
	}

}
