package nl.hu.testendpoint.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.CPU;
import nl.hu.testendpoint.services.CPUService;

import java.util.ArrayList;
import java.util.List;

@Path("/cpu")
public class CPUResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<CPU> getAllCpus() {

        return CPUService.getAllCPU();
    }
}