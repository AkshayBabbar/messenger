package org.akshay.messenger.service;


import org.akshay.messenger.database.DatabaseClass;
import org.akshay.messenger.model.Message;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class MessageService {
    private Map<Long, Message> messages = DatabaseClass.getMessages();

    public MessageService() {
        messages.put(1L,new Message(1, "Hello","Akshay"));
        messages.put(2L,new Message(2, "Hello","Akshay"));
    }

    public List<Message> getAllMessage(){
        return new ArrayList<>(messages.values());
    }
    public List<Message> getAllMessgesYear(int year){
        List<Message> messagesForYear = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (Message message :
                messages.values()) {
            cal.setTime(message.getCreated());
            if(cal.get(Calendar.YEAR) == year)
                messagesForYear.add(message);

        }
        return messagesForYear;
    }

    public List<Message> getAllPaginated(int start, int size){
        ArrayList<Message> list = new ArrayList<>(messages.values());
        if(start + size> list.size()) return  new ArrayList<>();
        return list.subList(start, start + size);
    }

    public Message addMessage(Message message){
        message.setId(messages.size() + 1);
        messages.put(message.getId(),message);
        return message;
    }

    public Message getMessage( long id){
        return messages.get(id);
    }

    public Message updateMessage(Message message){
        if(message.getId() <= 0){
            return null;
        }
        messages.put(message.getId(),message);
        return message;
    }

    public Message removeMessage(long id){
        return messages.remove(id);
    }
}
