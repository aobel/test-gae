package com.test.rest;

import com.test.dao.LibroBeanDAO;
import com.test.data.LibroBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.util.List;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/libro")
@Produces("application/json;charset=utf-8")
@Api(value = "libro", description = "Servicio Libro")
public class LibroResource {
	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");
    private LibroBeanDAO libroBeanDAO;

    public LibroResource() {
        this.libroBeanDAO = new LibroBeanDAO();
    }

    @GET
    @ApiOperation("Listar Libros")
    public Response list() {
        return Response.ok(this.libroBeanDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("Obtener Libro")
    public Response get(@PathParam("id") Long id) {
        LibroBean bean = this.libroBeanDAO.get(id);
        if (bean == null) {
        	LOGGER.info("NO GET BEAN NULL");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }
    
    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("Guardar Libro")
    public Response save(LibroBean bean) {
        this.libroBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("Eliminar Libro")
    public Response delete(@ApiParam("test ID") @PathParam("id") Long id) {
        LibroBean bean = this.libroBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.libroBeanDAO.delete(bean);
        return Response.ok().build();
    }
    
  
    @GET
    @Path("/search/{text}")
    @ApiOperation("Buscar Libros")
    public Response get(@PathParam("text") String text) {
    	return Response.ok(this.libroBeanDAO.buscar(text)).build();
    }
    
}
