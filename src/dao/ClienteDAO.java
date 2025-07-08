package dao;

import domain.Cliente;

public class ClienteDAO implements IClienteDAO {
	
	@Override
	public Boolean salvar (Cliente cliente ) {
		return true;
	}

	@Override
	public Cliente buscarPorCpf(Long cpf) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void excluir(Long cpf) {
		// TODO Auto-generated method stub
		
	}
	
	
}

