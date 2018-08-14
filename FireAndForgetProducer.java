
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.apache.log4j.BasicConfigurator;

public class FireAndForgetProducer {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        String topicName = "ApplicationTest";
        String key = "Key1";
        String value = "Masuknih dari fire and forget";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092,localhost:9093");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);
        producer.send(record);
        producer.close();

        System.out.println("SimpleProducer Completed.");
    }
}
