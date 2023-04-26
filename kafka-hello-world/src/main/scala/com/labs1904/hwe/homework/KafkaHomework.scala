package com.labs1904.hwe.homework

import java.time.Duration
import java.util.{Arrays, Properties, UUID}
import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerConfig, ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.common.serialization.StringDeserializer
import com.labs1904.hwe.util.Constants._
import org.slf4j.LoggerFactory

object KafkaHomework {
  private val logger = LoggerFactory.getLogger(getClass)

  /**
   * Your task is to try to understand this code and run the consumer successfully. Follow each step below for completion.
   * Implement all the todos below
   */

    //TODO: If these are given in class, change them so that you can run a test. If not, don't worry about this step
  val Topic: String = "change-me"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    //TODO: Write in a comment what these lines are doing. What are the properties necessary to instantiate a consumer? -DONE
    //capturing Kafka cluster metadata
    //Instantiate a consumer with key of String and Value of String
    val properties = getProperties(BOOTSTRAP_SERVER)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](properties)


    //TODO: What does this line mean? Write your answer in a comment below
    //why need to convert the Topic to a List? my question
    //subscribe ro consumer topic
    consumer.subscribe(Arrays.asList(Topic))

    while (true) {
      // TODO: Change this to be every 5 seconds -DONE
      val duration: Duration = Duration.ofMillis(5000)

      //TODO: Look up the ConsumerRecords class below, in your own words what is the class designed to do? -DONE
      //the class retrieves and removes the element at the head of the Consumer list of the there is an element of the Consumer with the given duration, else to return 'Null'.
      // The retrieved data is written to message with the Key as String and the Value as String
      val records: ConsumerRecords[String, String] = consumer.poll(duration)

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        //TODO: Describe why we need the .value() at the end of record -DONE
        //to accept any type of record value?
        val message = record.value()

        //TODO: If you were given the values for the bootstrap servers in class, run the app with the green play button and make sure it runs successfully. You should see message(s) printing out to the screen
        logger.info(s"Message Received: $message")
      })
    }
  }

  def getProperties(bootstrapServer: String): Properties = {
    // Set Properties to be used for Kafka Consumer
    val properties = new Properties
    properties.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServer)
    properties.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer].getName)
    properties.setProperty(ConsumerConfig.GROUP_ID_CONFIG, UUID.randomUUID().toString)

    properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    properties
  }

}
