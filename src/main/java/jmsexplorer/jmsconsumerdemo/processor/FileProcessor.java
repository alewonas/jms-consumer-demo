package jmsexplorer.jmsconsumerdemo.processor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * FileProcessor is a Camel Processor responsible for processing messages received from an Apache ActiveMQ queue.
 * It extracts information from a JSON message and sets a custom header containing a file name based on the message content.
 */
public class FileProcessor implements Processor {

    /**
     * Processes the incoming message from the ActiveMQ queue.
     *
     * @param exchange The Camel Exchange object containing the message to be processed.
     * @throws Exception If an error occurs during message processing.
     */
    @Override
    public void process(Exchange exchange) throws Exception {
        // Extract the JSON content from the message body.
        String jsonString = exchange.getIn().getBody(String.class);
        // Parse the JSON to retrieve a specific field, "firstName."
        String fileName = parseJson(jsonString);
        // Set a custom header "fileName" for the processed message.
        // The header will be used to determine the name of the file where the message is saved.
        exchange.getIn().setHeader("fileName", "User" + fileName + ".txt");
    }

    /**
     * Parses a JSON string to extract a specific field, "firstName."
     *
     * @param json The JSON string to be parsed.
     * @return The value of the "firstName" field as a String, or null if parsing fails.
     */
    private String parseJson(String json) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            // Read the JSON string into a JSON tree structure.
            JsonNode rootNode = objectMapper.readTree(json);
            // Extract the "firstName" field from the JSON.
            JsonNode fileNameNode = rootNode.get("firstName");
            return fileNameNode.asText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}