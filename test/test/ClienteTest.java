package test;

import org.junit.Assert;
import org.junit.Test;

import dao.IClienteDAO;
import domain.Cliente;
import services.ClienteService;
import services.IClienteService;
import test.dao.ClienteDaoMock;

public class ClienteTest {
	
	private IClienteService clienteService;	
	
	public ClienteTest () {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Test
	public void pesquisarCliente () {
		Cliente cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Renan");
		cliente.setCidade("Guarulhos");
		cliente.setEstado("São Paulo");
		cliente.setEnd("End");
		cliente.setNumero(245); // <-- corrigido aqui
		cliente.setTel(11999995555L);
		
		clienteService.salvar(cliente);
		
		Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());
		
		Assert.assertNotNull(clienteConsultado);
		
	}
}