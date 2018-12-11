package com.test.rest;

import com.test.dao.TestBeanDAO;
import com.test.data.LibroBean;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

import java.util.logging.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/test")
@Produces("application/json;charset=utf-8")
@Api(value = "test", description = "Test service")
public class TestResource {
	private final static Logger LOGGER = Logger.getLogger("bitacora.subnivel.Control");
    private TestBeanDAO testBeanDAO;

    public TestResource() {
        this.testBeanDAO = new TestBeanDAO();
    }

    @GET
    @ApiOperation("list test objects")
    public Response list() {
    	LOGGER.info("Entra en listado");
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
    	LOGGER.info("Entra en GET: "+bean.toString());
        return Response.ok(bean).build();
    }
    
    @POST
    @Consumes("application/json;charset=utf-8")
    @ApiOperation("save test object")
    public Response save(LibroBean bean) {
    	LOGGER.info("Entra en SAVE: "+bean.toString());
        this.testBeanDAO.save(bean);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @ApiOperation("delete book object")
    public Response delete(@ApiParam("test ID") @PathParam("id") Long id) {
    	LOGGER.info("Entra en DELETE");
        LibroBean bean = this.testBeanDAO.get(id);
        if (bean == null) {
        	LOGGER.info("NO DELETE BEAN NULL");
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        this.testBeanDAO.delete(bean);
    	LOGGER.info("DELETE: "+bean.toString());
        return Response.ok().build();
    }
    
    

    
}
