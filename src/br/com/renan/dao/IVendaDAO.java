/**
 * 
 */
package br.com.renan.dao;

import br.com.renan.dao.generic.IGenericDAO;
import br.com.renan.domain.Venda;
import br.com.renan.exceptions.TipoChaveNaoEncontradaException;

/**
 * @author renan
 *
 */
public interface IVendaDAO extends IGenericDAO<Venda, String> {

	public void finalizarVenda(Venda venda) throws TipoChaveNaoEncontradaException;
}
