
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Cliente;
import service.ClienteService;

/**
 * Servlet implementation class CrudClientesServlet
 */
public class CrudClientesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrudClientesServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("idCliente"));
		String nome = request.getParameter("nomeCliente");
		String fone = request.getParameter("foneCliente");
		Cliente cliente = new Cliente(id, nome, fone);
		String oQueFazer = request.getParameter("oQueFazer");
		ClienteService service = new ClienteService();
		switch (oQueFazer) {
		case "Cadastrar":
			service.criar(cliente);
			PrintWriter out = response.getWriter();
			out.println("<h1>"+"Operação realizada com sucesso"+"seu id gerado foi: "+request.getParameter("idCliente")+"</h1>");
			
			break;
		case "Consultar":
			cliente = service.carregar(cliente.getId());
			PrintWriter out1 = response.getWriter();
			out1.println("<h1>"+"Operação realizada com sucesso"+"seu id gerado foi: "+request.getParameter("idCliente")+request.getParameter("nomeCliente")+request.getParameter("foneCliente")+"</h1>"+"<input type=button value = voltar a href=clientes.html>");
			break;
			
		case "Remover":
			//service.excluir(cliente);
			//break;
		case "Atualizar":
			service.atualizar(cliente);
			PrintWriter out2 = response.getWriter();
			out2.println("<h1>"+"Os dados foram atualizados com sucesso"+"seu id gerado foi: "+request.getParameter("idCliente")+request.getParameter("nomeCliente")+request.getParameter("foneCliente")+"</h1>"+"<input type=button value = voltar a href=clientes.html>");
			break;
		}
		PrintWriter out = response.getWriter();
		out.println("<h1>"+"Operação realizada com sucesso"+"</h1>"+"<input type=button value = voltar a href=clientes.html>");
		
	}
}
