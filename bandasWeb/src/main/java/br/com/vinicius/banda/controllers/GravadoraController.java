package br.com.vinicius.banda.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

import br.com.vinicius.banda.dto.GravadoraDTO;
import br.com.vinicius.banda.service.GravadoraService;

@Path("gravadoras")
public class GravadoraController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<GravadoraDTO> listarGravadoras() {
		GravadoraService gravadoraService = new GravadoraService();
		try {
			return gravadoraService.listarGravadoras();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public GravadoraDTO getMusica(@PathParam("codigo") int codigo) {
		GravadoraService gravadoraService = new GravadoraService();
		try {
			return gravadoraService.buscarGravadoraPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new GravadoraDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(GravadoraDTO musica) {
		GravadoraService gravadoraService = new GravadoraService();
		try {
			gravadoraService.inserir(musica.toGravadora());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(GravadoraDTO musica) {
		GravadoraService gravadoraService = new GravadoraService();
		try {
			gravadoraService.alterar(musica.toGravadora());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		GravadoraService gravadoraService = new GravadoraService();
		try {
			gravadoraService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
