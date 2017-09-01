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

import br.com.vinicius.banda.dto.MusicaDTO;
import br.com.vinicius.banda.service.MusicaService;

@Path("musicas")
public class MusicaController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public List<MusicaDTO> listarMusicas() {
		MusicaService musicaService = new MusicaService();
		try {
			return musicaService.listarMusicas();
		} catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<>();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{codigo}/")
	public MusicaDTO getMusica(@PathParam("codigo") int codigo) {
		MusicaService musicaService = new MusicaService();
		try {
			return musicaService.buscarMusicaPorCodigo(codigo);
		} catch (SQLException e) {
			e.printStackTrace();
			return new MusicaDTO();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response inserir(MusicaDTO musica) {
		MusicaService musicaService = new MusicaService();
		try {
			musicaService.inserir(musica.toMusica());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response alterar(MusicaDTO musica) {
		MusicaService musicaService = new MusicaService();
		try {
			musicaService.alterar(musica.toMusica());
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DELETE
	@Path("{codigo}/")
	public Response excluir(@PathParam("codigo") int codigo) {
		MusicaService musicaService = new MusicaService();
		try {
			musicaService.excluir(codigo);
			return Response.status(Response.Status.OK).build();
		} catch (SQLException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
