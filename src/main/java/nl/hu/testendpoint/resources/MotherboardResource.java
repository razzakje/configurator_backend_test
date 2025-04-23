package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.Motherbord;
import nl.hu.testendpoint.services.MotherbordService;

import java.util.List;

@Path("/motherboard")
public class MotherboardResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Motherbord> getAllMotherbords() {
        return MotherbordService.getAllMotherbords();
    }
}
