package org.akshay.messenger.resources;


import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

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

    @GET
    @Path("context")
    public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders httpHeaders){
        String path  = uriInfo.getAbsolutePath().toString();
        String cookies = httpHeaders.getCookies().toString();
        return "Path : " + path + " Cookies: " + cookies;
    }

}
