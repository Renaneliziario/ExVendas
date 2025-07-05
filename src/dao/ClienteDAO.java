package dao;

import domain.Cliente;
import java.util.HashMap;
import java.util.Map;

public class ClienteDAO implements IClienteDAO {

	private Map<Long, Cliente> clientes = new HashMap<>();

	@Override
	public void salvar(Cliente cliente) {
		clientes.put(cliente.getCpf(), cliente);
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		return clientes.get(cpf);
	}

}
