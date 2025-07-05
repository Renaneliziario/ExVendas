package test.dao;

import domain.Cliente;
import dao.IClienteDAO;
import java.util.HashMap;
import java.util.Map;

/**
 * Mock do ClienteDAO para testes unitários.
 * Simula persistência em memória sem dependências externas.
 */
public class ClienteDaoMock implements IClienteDAO {
    
    private Map<Long, Cliente> clientes = new HashMap<>();
    
    @Override
    public void salvar(Cliente cliente) {
        // Mock implementation - armazena em Map para simular persistência
        clientes.put(cliente.getCpf(), cliente);
        System.out.println("Mock: Cliente salvo - " + cliente.getNome());
    }

    @Override
    public Cliente buscarPorCpf(Long cpf) {
        // Mock implementation - busca no Map
        return clientes.get(cpf);
    }
    
    /**
     * Método auxiliar para testes - limpa todos os dados
     */
    public void limparDados() {
        clientes.clear();
    }
    
    /**
     * Método auxiliar para testes - retorna quantidade de clientes
     */
    public int getQuantidadeClientes() {
        return clientes.size();
    }
}
