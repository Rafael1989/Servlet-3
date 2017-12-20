package br.com.alura.gerenciador.web;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.Empresa;
import br.com.alura.gerenciador.dao.EmpresaDAO;

public class BuscaEmpresa implements Tarefa{
	
	public BuscaEmpresa() {
		System.out.println("Instaciando uma servlet do tipo BuscaEmpresa: " + this);
	}
	
	/*@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("Inicializando a servlet do tipo BuscaEmpresa: " + this);
	}
	
	@Override
	public void destroy() {
		super.destroy();
		System.out.println("Destruindo a servlet do tipo BuscaEmpresa: "+ this );
	}*/
	
	/*@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String filtro = req.getParameter("filtro");
		
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);
		req.setAttribute("empresas", empresas);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/paginas/buscaEmpresa.jsp");
		dispatcher.forward(req, resp);
		
	}*/

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		String filtro = request.getParameter("filtro");
		EmpresaDAO empresaDAO = new EmpresaDAO();
		Collection<Empresa> empresas = empresaDAO.buscaPorSimilaridade(filtro);
		request.setAttribute("empresas", empresas);
		return "/WEB-INF/paginas/buscaEmpresa.jsp";
	}

}
