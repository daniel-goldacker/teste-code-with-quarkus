package org.acme.controller;

import org.acme.service.MyUtilService;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/util")
public class MyUtilController {
 
    @Inject
    MyUtilService myUtilService;

    @GET
    @Path("/validate/prime/{number}")
    public Response verifyPrimeNuber(@PathParam("number") int number){
        try {
            return Response.ok(myUtilService.isPrimeNumber(number)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @GET
    @Path("/count/{text}")
    public Response verifyTextSize(@PathParam("text") String text){
        try {
            return Response.ok(myUtilService.countCharacters(text)).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }



}
