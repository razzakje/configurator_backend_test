package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.CpuCooler;
import nl.hu.testendpoint.services.CpuCoolerService;

import java.util.List;

@Path("/cpucooler")
public class CpuCoolerResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public static List<CpuCooler> getAllCpuCoolers() {
        return CpuCoolerService.getAllCpuCoolers();
    }
}
