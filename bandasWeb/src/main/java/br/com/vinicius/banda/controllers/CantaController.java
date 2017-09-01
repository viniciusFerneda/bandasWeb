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

import br.com.vinicius.banda.dto.CantaDTO;
import br.com.vinicius.banda.service.CantaService;

@Path("cantas")
public class CantaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<CantaDTO> listarCantas() {
		CantaService cantaService = new CantaService();
		try {
			return cantaService.listarCantas();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public CantaDTO getCanta(@PathParam("codigo") int codigo) {
		CantaService cantaService = new CantaService();
		try {
			return cantaService.buscarCantaPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new CantaDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(CantaDTO canta) {
		CantaService cantaService = new CantaService();
		try {
			cantaService.inserir(canta.toCanta());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(CantaDTO canta) {
		CantaService cantaService = new CantaService();
		try {
			cantaService.alterar(canta.toCanta());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		CantaService cantaService = new CantaService();
		try {
			cantaService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
