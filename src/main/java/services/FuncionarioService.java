package services;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Funcionario;
import repository.FuncionarioRepository;

@Path("/funcionario")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class FuncionarioService {

	@Inject
	private FuncionarioRepository funcionarioRepository;

	@GET
	public Response listar() {
		return Response.ok().entity(this.funcionarioRepository.listar()).build();
	}

	@GET
	@Path("/{id}")
	public Response consultar(@PathParam("id") int id) {
		return Response.ok().entity(this.funcionarioRepository.consultar(id)).build();
	}

	@POST
	public Response cadastrar(Funcionario novo) {
		return Response.ok().entity(this.funcionarioRepository.cadastrar(novo)).build();
	}

	@PUT
	public Response atualizar(Funcionario funcionario) {
		try {
			this.funcionarioRepository.removerFuncionario(funcionario);
			return Response.ok(this.funcionarioRepository.atualizarFuncionario(funcionario)).build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}
	
	@DELETE
	public Response remover(Funcionario funcionario) {
		try {
			this.funcionarioRepository.removerFuncionario(funcionario);
			return Response.ok().build();
		} catch (Exception e) {
			return Response.serverError().entity(e.getMessage()).build();
		}
	}

}
