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

import br.com.vinicius.banda.dto.PaisDTO;
import br.com.vinicius.banda.service.PaisService;

@Path("/paises")
public class PaisController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<PaisDTO> listarPaises() {
		PaisService paisService = new PaisService();
		try {
			return paisService.listarPaises();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public PaisDTO getPais(@PathParam("codigo") int codigo) {
		PaisService paisService = new PaisService();
		try {
			return paisService.buscarPaisPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new PaisDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(PaisDTO pais) {
		PaisService paisService = new PaisService();
		try {
			paisService.inserir(pais.toPais());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(PaisDTO pais) {
		PaisService paisService = new PaisService();
		try {
			paisService.alterar(pais.toPais());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		PaisService paisService = new PaisService();
		try {
			paisService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
