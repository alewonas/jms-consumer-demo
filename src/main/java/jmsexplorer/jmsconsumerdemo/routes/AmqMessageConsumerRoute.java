package jmsexplorer.jmsconsumerdemo.routes;

import jmsexplorer.jmsconsumerdemo.processor.FileProcessor;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * AmqMessageConsumerRoute is a Camel route that consumes messages from an Apache ActiveMQ queue
 * and processes them using the FileProcessor class.
 */
@Component
public class AmqMessageConsumerRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception{
        // Define the route to consume messages from the "intake-queue" in ActiveMQ.
        from("activemq:queue:intake-queue")
                // Process each message using the FileProcessor class.
                .process(new FileProcessor())
                // Save the processed message to the "processed-forms" directory with a filename from the message header.
                .to("file:processed-forms/?fileName=${header.fileName}");
    }

}