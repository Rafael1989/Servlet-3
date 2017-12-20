package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="/fazTudo")
public class FazTudo extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tarefa = request.getParameter("tarefa");
		if(tarefa==null)throw new IllegalArgumentException();
		String nomeDaClasse = "br.com.alura.gerenciador.web." + tarefa;
		try {
			Class type = Class.forName(nomeDaClasse);
			Tarefa instancia = (Tarefa)type.newInstance();
			String pagina = instancia.executa(request, response);
			RequestDispatcher dispatcher = request.getRequestDispatcher(pagina);
			dispatcher.forward(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			throw new ServletException(e);
		}
	}

}
