/**
 * 
 */
package br.com.renan.services;

import br.com.renan.domain.Cliente;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author renan
 *
 */
public interface IClienteService {

	Boolean cadastrar(Cliente cliente) throws TipoChaveNaoEncontradaException;

	Cliente buscarPorCPF(Long cpf);

	void excluir(Long cpf);

	void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
