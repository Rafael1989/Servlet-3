package br.com.alura.gerenciador.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class NovaEmpresa implements Tarefa{
	
	/*@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String nome = req.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		EmpresaDAO empresaDAO = new EmpresaDAO();
		req.setAttribute("empresa", empresa);
		empresaDAO.adiciona(empresa);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/novaEmpresa.jsp");
		dispatcher.forward(req, resp);
		PrintWriter writer = resp.getWriter();
		System.out.println("Empresa adicionada");
		writer.println("<html><body>Empresa "+ nome +" adicionada!</body></html>");
	}*/

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String nome = request.getParameter("nome");
		Empresa empresa = new Empresa(nome);
		EmpresaDAO empresaDAO = new EmpresaDAO();
		request.setAttribute("empresa", empresa);
		empresaDAO.adiciona(empresa);
		return "/WEB-INF/paginas/novaEmpresa.jsp";
	}

}
