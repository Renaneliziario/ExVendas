/**
 * 
 */
package br.com.renan.services;

import br.com.renan.dao.IProdutoDAO;
import br.com.renan.domain.Produto;
import br.com.renan.services.generic.GenericService;

/**
 * @author renan
 *
 */
public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

	public ProdutoService(IProdutoDAO dao) {
		super(dao);
	}

}
