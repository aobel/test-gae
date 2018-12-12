package com.test.dao;

import com.googlecode.objectify.ObjectifyService;
import com.test.data.LibroBean;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Alejandro Aranda
 */
public class TestBeanDAO {

    private static final Logger LOGGER = Logger.getLogger(TestBeanDAO.class.getName());

    /**
     * @return list of test beans
     */
    public List<LibroBean> list() {
        LOGGER.info("Retrieving list of beans");
        return ObjectifyService.ofy().load().type(LibroBean.class).list();
    }

    /**
     * @param id
     * @return test bean with given id
     */
    public LibroBean get(Long id) {
        LOGGER.info("Retrieving bean " + id);
        return ObjectifyService.ofy().load().type(LibroBean.class).id(id).now();
    }

    /**
     * Saves given bean
     * @param bean
     */
    public void save(LibroBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("null test object");
        }
        LOGGER.info("Saving bean " + bean.getId());
        ObjectifyService.ofy().save().entity(bean).now();
    }

    /**
     * Deletes given bean
     * @param bean
     */
    public void delete(LibroBean bean) {
        if (bean == null) {
            throw new IllegalArgumentException("null test object");
        }
        LOGGER.info("Deleting bean " + bean.getId());
        ObjectifyService.ofy().delete().entity(bean);
    }
    /**
     * Deletes given bean
     * @param bean
     */
    public List<LibroBean> buscar(String text) {
        LOGGER.info("Retrieving list of beans");
      //Pasar codigo a DAO
    	LOGGER.info("Entra en Buscar");
    	List<LibroBean> resultado = ObjectifyService.ofy().load().type(LibroBean.class).list();
    	List<LibroBean> selecionados = new ArrayList<LibroBean>();
    	LOGGER.info(text);
    	for (LibroBean element : resultado) {
    		LOGGER.info(element.toSearch());
    		if (element.toSearch().contains(text)) {
    			selecionados.add(element);
    		}
    	}
        return selecionados;
    }
    
}
