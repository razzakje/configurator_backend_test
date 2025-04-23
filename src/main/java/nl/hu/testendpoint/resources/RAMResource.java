package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.RAM;
import nl.hu.testendpoint.services.RAMService;

import java.util.List;

@Path("/ram")
public class RAMResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RAM> getAllRAMs() {
        return RAMService.getAllRAMs();
    }
}
