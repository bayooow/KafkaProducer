
import java.util.*;
import org.apache.kafka.clients.producer.*;
import org.apache.log4j.BasicConfigurator;

public class SynchronousProducer {

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        String topicName = "ApplicationTest";
        String key = "Key1";
        String value = "Masuk nih dari synchronous";

        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9092");
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        Producer<String, String> producer = new KafkaProducer<>(props);

        ProducerRecord<String, String> record = new ProducerRecord<>(topicName, key, value);

        try {
            RecordMetadata metadata = producer.send(record).get();
            System.out.println("Message is sent to Partition no " + metadata.partition() + " and offset " + metadata.offset());
            System.out.println("SynchronousProducer Completed with success.");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("SynchronousProducer failed with an exception");
        } finally {
            producer.close();
        }

        System.out.println("SimpleProducer Completed.");
    }
}
