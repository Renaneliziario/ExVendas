package services;

import domain.Cliente;

public interface IClienteService {
    
    void salvar(Cliente cliente);
    Cliente buscarPorCpf(Long cpf);
}