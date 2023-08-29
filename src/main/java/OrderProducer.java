
import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.serializer.kafka.dto.Order;

public class OrderProducer {

    public static void main(String[]args){
        Properties props = new Properties();
        props.setProperty("bootstrap.servers", "localhost:9092");

        props.setProperty("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.setProperty("value.serializer"," com.serializer.kafka.dto.OrderSerializer");
    

        KafkaProducer<String,Order> producer = new KafkaProducer<>(props);
        Order order = new Order();
        order.setCustomerName("kalinga");
        order.setProduct("console");
        order.setQuantity("1");
        
        ProducerRecord<String,Order>record = new ProducerRecord<>("OrderCSTopic",order.getCustomerName(), order);
        try{
            producer.send(record);
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            producer.close();
        }
    
    
    
    }
    
}
