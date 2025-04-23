package nl.hu.testendpoint;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import nl.hu.testendpoint.domain.CPU;
import nl.hu.testendpoint.domain.Component;
import nl.hu.testendpoint.domain.Configurator;

import java.util.ArrayList;

@Path("/components")
public class ComponentResource {

    @GET
    @Produces("application/json")
    public String components() {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Component component : Configurator.getComponents().getAllComponents()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", component.getId());
            job.add("type", component.getType());
            job.add("name", component.getName());
            job.add("description", component.getDescription());
            job.add("price", component.getPrice());
            jab.add(job);
        }

        return jab.build().toString();
    }

//    @GET
//    @Path("{type}")
//    @Produces("application/json")
//    public String getSpecificComponent(@PathParam("type") String type) {
//        JsonArrayBuilder jab = Json.createArrayBuilder();
//
//        for (Component component : Configurator.getConfigurator(configuratieID).getAllComponents()) {
//            JsonObjectBuilder job = Json.createObjectBuilder();
//            job.add("id", component.getId());
//            job.add("type", component.getType());
//            job.add("name", component.getName());
//            job.add("price", component.getPrice());
//            jab.add(job);
//        }
//
//        return jab.build().toString();
//    }
    @GET
    @Path("/configurator/{name}")
    @Produces("application/json")
    public String getComponentsByConfiguratie(@PathParam("name") String name) {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Component component : Configurator.getConfigurator(name).getAllComponents()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", component.getId());
            job.add("type", component.getType());
            job.add("name", component.getName());
            job.add("description", component.getDescription());
            job.add("price", component.getPrice());
            jab.add(job);
        }

        return jab.build().toString();
    }

}
