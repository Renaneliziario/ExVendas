package test;

import org.junit.Assert;
import org.junit.Test;

import domain.Cliente;
import services.IClienteService;
import services.ClienteService;
import test.dao.ClienteDaoMock;

public class ClienteTest {

    private IClienteService clienteService = new ClienteService(new ClienteDaoMock());
    
    @Test
    public void pesquisarCliente() {
        // Arrange - Criar cliente com todos os dados
        Cliente cliente = new Cliente("João da Silva", 12345678901L);
        cliente.setTel(11987654321L);
        cliente.setEnd("Rua das Flores");
        cliente.setNumero(123);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");

        // Act - Salvar e buscar
        clienteService.salvar(cliente);
        Cliente clienteConsultado = clienteService.buscarPorCpf(12345678901L);

        // Assert - Verificar todos os campos
        Assert.assertNotNull(clienteConsultado); 
        Assert.assertEquals("João da Silva", clienteConsultado.getNome());
        Assert.assertEquals(Long.valueOf(12345678901L), clienteConsultado.getCpf());
        Assert.assertEquals(Long.valueOf(11987654321L), clienteConsultado.getTel());
        Assert.assertEquals("Rua das Flores", clienteConsultado.getEnd());
        Assert.assertEquals(Integer.valueOf(123), clienteConsultado.getNumero());
        Assert.assertEquals("São Paulo", clienteConsultado.getCidade());
        Assert.assertEquals("SP", clienteConsultado.getEstado()); 
    }
    
    @Test
    public void salvarCliente() {
        // Arrange - Criar cliente
        Cliente cliente = new Cliente("Maria Silva", 98765432100L);
        cliente.setTel(11123456789L);
        cliente.setEnd("Av. Paulista");
        cliente.setNumero(1000);
        cliente.setCidade("São Paulo");
        cliente.setEstado("SP");

        // Act - Salvar
        clienteService.salvar(cliente);
        
        // Assert - Verificar se foi salvo corretamente
        Cliente clienteConsultado = clienteService.buscarPorCpf(98765432100L);
        Assert.assertNotNull(clienteConsultado);
        Assert.assertEquals("Maria Silva", clienteConsultado.getNome());
        Assert.assertEquals("São Paulo", clienteConsultado.getCidade());
        Assert.assertEquals("SP", clienteConsultado.getEstado());
    }
    
    @Test
    public void buscarClienteInexistente() {
        // Act - Buscar cliente que não existe
        Cliente clienteConsultado = clienteService.buscarPorCpf(99999999999L);
        
        // Assert - Deve retornar null
        Assert.assertNull(clienteConsultado);
    }
    
    @Test
    public void salvarMultiplosClientes() {
        // Arrange - Criar múltiplos clientes
        Cliente cliente1 = new Cliente("Pedro Santos", 11111111111L);
        cliente1.setCidade("Rio de Janeiro");
        cliente1.setEstado("RJ");
        
        Cliente cliente2 = new Cliente("Ana Costa", 22222222222L);
        cliente2.setCidade("Belo Horizonte");
        cliente2.setEstado("MG");

        // Act - Salvar ambos
        clienteService.salvar(cliente1);
        clienteService.salvar(cliente2);

        // Assert - Verificar se ambos foram salvos
        Cliente consultado1 = clienteService.buscarPorCpf(11111111111L);
        Cliente consultado2 = clienteService.buscarPorCpf(22222222222L);

        Assert.assertNotNull(consultado1);
        Assert.assertNotNull(consultado2);
        Assert.assertEquals("Pedro Santos", consultado1.getNome());
        Assert.assertEquals("Ana Costa", consultado2.getNome());
        Assert.assertEquals("Rio de Janeiro", consultado1.getCidade());
        Assert.assertEquals("Belo Horizonte", consultado2.getCidade());
    }
}
