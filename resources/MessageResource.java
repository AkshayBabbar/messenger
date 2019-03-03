/*
*   @author:    Akshay Babbar
*   @Version:   1.0
*   @Purpose:
* */
package org.akshay.messenger.resources;

import org.akshay.messenger.model.Message;
import org.akshay.messenger.service.MessageService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

    private MessageService messageService = new MessageService();

    @GET
    public List<Message> getMessages(@QueryParam("year") int year,
                                     @QueryParam("start") int start,
                                     @QueryParam("size") int size)

    {
        if (year >= 0) {
            return messageService.getAllMessgesYear(year);
        }
        if (start > 0 && size > 0)
            return messageService.getAllPaginated(start, size);
        return messageService.getAllMessage();
    }

    @GET
    @Path("/{messageId}")
    public Message getMesesage(@PathParam("messageId") long Id) {
//        messageService.getMessage()
        return messageService.getMessage(Id);
    }

    @POST
    public Message addMessage(Message message) {

        return messageService.addMessage(message);

    }

    @PUT
    @Path("/{messageId}")
    public Message pushMessage(@PathParam("messageId") long Id, Message message) {
        message.setId(Id);
        return messageService.updateMessage(message);
    }

    @DELETE
    @Path("/{messageId}")
    public Message deleteMessage(@PathParam("messageId") long id) {
        return messageService.removeMessage(id);
    }


}
