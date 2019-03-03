package org.akshay.messenger.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/injectDemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

    @GET
    @Path("annotations")
    public String getParamUsingAnnotations(@MatrixParam("param") String matrixParam,
                                           @HeaderParam("CustomerHeadParam") String CustomerHeadParam,
                                           @CookieParam("Cookie") String cookie) {

        return "Matrix Param " + matrixParam + "CustomerHead Parameter is " + CustomerHeadParam  + "Cookie: " + cookie;
    }

}
