package test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dao.IClienteDAO;
import domain.Cliente;
import test.dao.ClienteDaoMock;

public class ClienteDAOTest {
	
	private IClienteDAO clienteDAO;
	
	private Cliente cliente;
	
	public ClienteDAOTest() {
		clienteDAO = new ClienteDaoMock();
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
		clienteDAO.salvar(cliente);	
	}	
	
	@Test
	public void pesquisarCliente () {			
		Cliente clienteConsultado = clienteDAO.buscarPorCpf(cliente.getCpf());		
		Assert.assertNotNull(clienteConsultado);		
	}
	
	@Test
	public void salvarCliente() {
		Boolean retorno = clienteDAO.salvar(cliente);		
		Assert.assertTrue(retorno);		
	}	
	
	@Test
	public void excluirCliente() {
		clienteDAO.excluir(cliente.getCpf());		
	}

}
