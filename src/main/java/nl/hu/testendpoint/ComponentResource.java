package nl.hu.testendpoint;

import jakarta.json.Json;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObjectBuilder;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import nl.hu.testendpoint.domain.Component;
import nl.hu.testendpoint.domain.Configurator;

@Path("/components")
public class ComponentResource {

    @GET
    @Produces("application/json")
    public String components() {
        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Component component : Configurator.getConfigurator().getAllComponents()) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("id", component.getId());
            job.add("type", component.getType());
            job.add("name", component.getName());
            job.add("price", component.getPrice());
            jab.add(job);
        }

        return jab.build().toString();
    }
}
