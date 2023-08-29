package com.serializer.kafka.dto;
import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class OrderSerializer implements Serializer<Order>{

    @Override
    public byte[] serialize(String topic, Order order) {
        byte response[]=null;
        ObjectMapper obj = new ObjectMapper();
        try{
            response = obj.writeValueAsString(order).getBytes();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return response;
    }

    

  
    
}
