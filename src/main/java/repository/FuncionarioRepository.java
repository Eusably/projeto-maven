package repository;

import java.util.List;

import javax.ejb.Stateless;

import model.Funcionario;
import repository.base.AbstractCrudRepository;

@Stateless
public class FuncionarioRepository extends AbstractCrudRepository<Funcionario>{
	
	public List<Funcionario> listar() {
		return super.pesquisarTodos();
	}

	public Funcionario consultar(int id) {
		return super.consultar(id);
	}

	public int cadastrar(Funcionario novo) {
		super.inserir(novo);
		return novo.getId();
	}

	public Funcionario atualizarFuncionario(Funcionario funcionario) {	
		super.atualizar(funcionario);
		return funcionario;
	}
	
	public void removerFuncionario(Funcionario funcionario) {
		super.remover(funcionario);
	}
}
