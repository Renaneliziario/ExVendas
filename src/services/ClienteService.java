package services;

import domain.Cliente;
import dao.IClienteDAO;
import dao.ClienteDAO;

public class ClienteService implements IClienteService {
    
    private IClienteDAO clienteDAO;
    
    public ClienteService() {
        this.clienteDAO = new ClienteDAO();
    }
    
    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }
    
    @Override
    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }
    
    @Override
    public Cliente buscarPorCpf(Long cpf) {
        return clienteDAO.buscarPorCpf(cpf);
    }
}
