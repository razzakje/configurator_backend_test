package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.GPU;
import nl.hu.testendpoint.services.GPUService;

import java.util.List;

@Path("/gpu")
public class GPUResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<GPU> getAllGPUs() {

        return GPUService.getAllGPUs();
    }
}
