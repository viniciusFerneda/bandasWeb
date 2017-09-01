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

import br.com.vinicius.banda.dto.BandaDTO;
import br.com.vinicius.banda.service.BandaService;

@Path("bandas")
public class BandaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<BandaDTO> listarBandas() {
		BandaService bandaService = new BandaService();
		try {
			return bandaService.listarBandas();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public BandaDTO getBanda(@PathParam("codigo") int codigo) {
		BandaService bandaService = new BandaService();
		try {
			return bandaService.buscarBandaPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new BandaDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(BandaDTO banda) {
		BandaService bandaService = new BandaService();
		try {
			bandaService.inserir(banda.toBanda());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(BandaDTO banda) {
		BandaService bandaService = new BandaService();
		try {
			bandaService.alterar(banda.toBanda());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		BandaService bandaService = new BandaService();
		try {
			bandaService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
