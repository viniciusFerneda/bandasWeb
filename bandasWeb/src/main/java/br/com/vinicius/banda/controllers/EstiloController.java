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

import br.com.vinicius.banda.dto.EstiloDTO;
import br.com.vinicius.banda.service.EstiloService;

@Path("estilos")
public class EstiloController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<EstiloDTO> listarEstilos() {
		EstiloService estiloService = new EstiloService();
		try {
			return estiloService.listarEstilos();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public EstiloDTO getEstilo(@PathParam("codigo") int codigo) {
		EstiloService estiloService = new EstiloService();
		try {
			return estiloService.buscarEstiloPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new EstiloDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(EstiloDTO estilo) {
		EstiloService estiloService = new EstiloService();
		try {
			estiloService.inserir(estilo.toEstilo());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(EstiloDTO estilo) {
		EstiloService estiloService = new EstiloService();
		try {
			estiloService.alterar(estilo.toEstilo());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		EstiloService estiloService = new EstiloService();
		try {
			estiloService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
