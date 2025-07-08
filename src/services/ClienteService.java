package services;

import dao.IClienteDAO;
import domain.Cliente;


public class ClienteService implements IClienteService {
	
	private IClienteDAO clienteDao;
	
	public ClienteService(IClienteDAO clienteDAO) {
		this.clienteDao = clienteDAO;		
	}

	@Override
	public Boolean salvar(Cliente cliente) {
		return clienteDao.salvar(cliente);
	}
	
	@Override
	public Cliente buscarPorCpf (Long cpf) {
		return clienteDao.buscarPorCpf(cpf);
	}

	@Override
	public void excluir(Long cpf) {
		//clienteDAO.excluir(cpf);
	}
}
    
