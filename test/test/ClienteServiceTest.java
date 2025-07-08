package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.IClienteDAO;
import domain.Cliente;
import services.ClienteService;
import services.IClienteService;
import test.dao.ClienteDaoMock;

public class ClienteServiceTest {
	
	private IClienteService clienteService;	
	
	private Cliente cliente;
	
	public ClienteServiceTest () {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}
	
	@Before
	public void init() {		
		cliente = new Cliente();
		cliente.setCpf(12312312312L);
		cliente.setNome("Renan");
		cliente.setCidade("Guarulhos");
		cliente.setEstado("São Paulo");
		cliente.setEnd("End");
		cliente.setNumero(245); // <-- corrigido aqui
		cliente.setTel(11999995555L);
		clienteService.salvar(cliente);		
	}	
	
	@Test
	public void pesquisarCliente () {		
		Cliente clienteConsultado = clienteService.buscarPorCpf(cliente.getCpf());		
		Assert.assertNotNull(clienteConsultado);		
	}	
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteService.salvar(cliente);		
		Assert.assertTrue(retorno);		
	}	
	
	@Test
	public void excluirCliente() {
		clienteService.excluir(cliente.getCpf());		
	}
}