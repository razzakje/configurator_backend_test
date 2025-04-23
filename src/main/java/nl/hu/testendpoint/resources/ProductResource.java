package nl.hu.testendpoint.resources;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import nl.hu.testendpoint.domain.Component;
import nl.hu.testendpoint.services.ProductService;

import java.util.List;

@Path("/components")
public class ProductResource {

    private final ProductService productService = new ProductService();

    @POST
    @Path("/preview")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<Component> getComponentsByIds(List<Integer> productIDs) {
        return productService.getComponentsByIds(productIDs);
    }
}
