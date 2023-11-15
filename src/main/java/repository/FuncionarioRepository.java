package repository;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;

import model.Funcionario;

@Stateful
public class FuncionarioRepository {
	
	private static List<Funcionario> listaFuncionarios = new ArrayList<>();

	public List<Funcionario> listar() {
		return listaFuncionarios;
	}

	public Funcionario consultar(int id) {
		for(Funcionario funcionario: listaFuncionarios) {
			if(funcionario.getId().intValue() == id) {
				return funcionario;
			}
		}
		return null;
	}

	public int cadastrar(Funcionario novo) {
		int maxId = listaFuncionarios.size() + 1;
		novo.setId(maxId);
		listaFuncionarios.add(novo);
		return novo.getId();
	}

	public Funcionario atualizar(Funcionario funcionario) {	
		listaFuncionarios.add(funcionario);		
		return funcionario;
	}
	
	public void remover(Funcionario funcionario) throws Exception {
		Funcionario atual = this.consultar(funcionario.getId());
		if(atual == null)
			throw new Exception("Funcionário não encontrado");
		
		listaFuncionarios.remove(atual);
	}
}
