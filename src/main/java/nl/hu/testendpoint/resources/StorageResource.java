package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.Storage;
import nl.hu.testendpoint.services.StorageService;

import java.util.List;

@Path("/storage")
public class StorageResource {

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Storage> getAllStorages() {
        return StorageService.getAllStorages();
    }
}
