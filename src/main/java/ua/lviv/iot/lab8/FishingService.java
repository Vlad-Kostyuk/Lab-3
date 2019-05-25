package ua.lviv.iot.lab8;

import javax.enterprise.context.SessionScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/fishing")
@SessionScoped
public class FishingService {
//@Produces(MediaType.APPLICATION_JSON)
    @GET
    @Produces({ MediaType.TEXT_PLAIN })
    public String getShop() {
        // public FishingShopDb getShop(@PathParam("id") Integer id) {
       // return new FishingShopDb(100, "сітка", 1, "металеві прути", null, 12, "black", null, null);
        return "TEST";

    }
}
