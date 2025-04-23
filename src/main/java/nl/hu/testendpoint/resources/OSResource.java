package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.OS;
import nl.hu.testendpoint.services.OSService;

import java.util.List;

@Path("/os")
public class OSResource {

    private final OSService service = new OSService();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<OS> getAllOSs() {
        return service.getAllOSs();
    }
}
