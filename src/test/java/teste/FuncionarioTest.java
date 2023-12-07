package teste;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.google.gson.Gson;

import model.Funcionario;
import repository.FuncionarioRepository;

public class FuncionarioTest {
	
	private FuncionarioRepository funcionarioRepository = new FuncionarioRepository();
	private Gson gson = new Gson();
	
	@Test
	public void cadastrar() {
		Funcionario novo = new Funcionario();
		novo.setNome("Funcionário 1");
		novo.setCargo("Desenvolvedor");
		novo.setIdade("35 anos");
		novo.setDataAdmissao(new Date());
		int id = this.funcionarioRepository.cadastrar(novo);
		System.out.println(String.format("ID registrado: %d", id));
		Assert.assertTrue(id > 0);
	}
	
	@Test
	public void atualizar() {
		Funcionario novo = new Funcionario();
		novo.setId(1);
		novo.setNome("Funcionário 1");
		novo.setCargo("Desenvolvedor");
		novo.setIdade("18 anos");
		novo.setDataAdmissao(new Date());
		Funcionario atualizado = this.funcionarioRepository.atualizarFuncionario(novo);
		System.out.println(this.gson.toJson(atualizado));
		Assert.assertTrue(atualizado != null);
	}
	
	@Test
	public void listar() {
		this.cadastrar();
		List<Funcionario> lista = this.funcionarioRepository.listar();		
		System.out.println(this.gson.toJson(lista));
	}
	
	@Test
	public void consultar() {
		this.cadastrar();
		Funcionario funcionario = this.funcionarioRepository.consultar(1);		
		System.out.println(this.gson.toJson(funcionario));
		Assert.assertTrue(funcionario != null);
	}
	
	@Test
	public void remover() throws Exception {
		this.cadastrar();
		Funcionario funcionario = new Funcionario();
		funcionario.setId(1);
		this.funcionarioRepository.removerFuncionario(funcionario);	
	}

}
