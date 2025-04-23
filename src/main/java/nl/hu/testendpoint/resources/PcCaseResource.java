package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.PcCase;
import nl.hu.testendpoint.services.PcCaseService;

import java.util.List;

@Path("/pccase")
public class PcCaseResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<PcCase> getAllPcCases() {
        return PcCaseService.getAllPcCases();
    }
}
