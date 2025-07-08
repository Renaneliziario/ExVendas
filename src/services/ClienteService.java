package services;

import dao.IClienteDAO;
import domain.Cliente;


public class ClienteService implements IClienteService {
	
	private IClienteDAO clienteDAO;
	
	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;		
	}

	@Override
	public void salvar(Cliente cliente) {
		clienteDAO.salvar(cliente);
	}
	
	@Override
	public Cliente buscarPorCpf (Long cpf) {
		return clienteDAO.buscarPorCpf(cpf);
	}
}
    
