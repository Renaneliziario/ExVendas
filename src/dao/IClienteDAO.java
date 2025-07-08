package dao;

import domain.Cliente;

public interface IClienteDAO {

	Boolean salvar(Cliente cliente);
	
	Cliente buscarPorCpf(Long cpf);

	void excluir(Long cpf);

}
