package ua.lviv.iot.lab8;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fishing")
public class FishingService {

    @GET
    @Path("{id}/")
    @Produces(MediaType.APPLICATION_JSON)
    public FishingShopDb getShop(@PathParam("id") Integer id) {
        return new FishingShopDb(100, "сітка", 1, "металеві прути", null, 12, "black", null, null);

    }
}
