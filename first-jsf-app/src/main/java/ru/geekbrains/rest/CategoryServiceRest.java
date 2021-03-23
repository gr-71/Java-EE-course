package ru.geekbrains.rest;

import ru.geekbrains.service.CategoryRepr;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Local
@Path("/v1/category")
public interface CategoryServiceRest {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insert(CategoryRepr category);

}
