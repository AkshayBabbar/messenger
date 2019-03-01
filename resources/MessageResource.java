/*
*   @author:    Akshay Babbar
*   @Version:   1.0
*   @Purpose:
* */
package org.akshay.messenger.resources;

import org.akshay.messenger.model.Message;
import org.akshay.messenger.service.MessageService;


import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/messages")
public class MessageResource {

    MessageService messageService = new MessageService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getMessages(){
        return messageService.getAllMessage();
    }

    @GET
    @Path("/{messageId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMesesage(@PathParam("messageId") long Id){
//        messageService.getMessage()
    return messageService.getMessage(Id);
    }

}
