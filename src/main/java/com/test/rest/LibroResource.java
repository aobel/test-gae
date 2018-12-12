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

@Path("/test")
@Produces("application/json;charset=utf-8")
@Api(value = "test", description = "Test service")
public class LibroResource {
	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");
    private LibroBeanDAO testBeanDAO;

    public LibroResource() {
        this.testBeanDAO = new LibroBeanDAO();
    }

    @GET
    @ApiOperation("list test objects")
    public Response list() {
        return Response.ok(this.testBeanDAO.list()).build();
    }

    @GET
    @Path("/{id}")
    @ApiOperation("get test object")
    public Response get(@PathParam("id") Long id) {
        LibroBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
        	LOGGER.info("NO GET BEAN NULL");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(bean).build();
    }
    
    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save test object")
    public Response save(LibroBean bean) {
        this.testBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete book object")
    public Response delete(@ApiParam("test ID") @PathParam("id") Long id) {
        LibroBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.testBeanDAO.delete(bean);
        return Response.ok().build();
    }
    
  
    @GET
    @Path("/search/{text}")
    @ApiOperation("list test objects")
    public Response get(@PathParam("text") String text) {
    	return Response.ok(this.testBeanDAO.buscar(text)).build();
    }
    
}
