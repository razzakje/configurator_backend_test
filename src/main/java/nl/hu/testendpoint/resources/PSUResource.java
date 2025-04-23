package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.PSU;
import nl.hu.testendpoint.services.PSUService;

import java.util.List;

@Path("/psu")
public class PSUResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PSU> getAllPSUs() {
        return PSUService.getAllPSUs();
    }
}
