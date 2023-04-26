package com.labs1904.hwe.consumers

import com.labs1904.hwe.producers.SimpleProducer.Topic
import com.labs1904.hwe.util.Constants._
import com.labs1904.hwe.util.Util
import net.liftweb.json.DefaultFormats
import org.apache.kafka.clients.consumer.{ConsumerRecord, ConsumerRecords, KafkaConsumer}
import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}
import org.slf4j.LoggerFactory

import java.time.Duration
import java.util.Arrays

object HweConsumer {
  private val logger = LoggerFactory.getLogger(getClass)

  val consumerTopic: String = "question-1"
  val producerTopic: String = "question-1-output"

  implicit val formats: DefaultFormats.type = DefaultFormats

  def main(args: Array[String]): Unit = {

    // Create the KafkaConsumer
    val consumerProperties = Util.getConsumerProperties(BOOTSTRAP_SERVER)
    val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](consumerProperties)

    // Create the KafkaProducer
    val producerProperties = Util.getProperties(BOOTSTRAP_SERVER)
    val producer = new KafkaProducer[String, String](producerProperties)

    // Subscribe to the topic
    consumer.subscribe(Arrays.asList(consumerTopic))

    while ( {
      true
    }) {
      // poll for new data
      val duration: Duration = Duration.ofMillis(100)
      val records: ConsumerRecords[String, String] = consumer.poll(duration)

      case class RawUser(id: Int, userName: String, name: String, email: String, dob: String)
      case class EnrichedUser(id: Int, userName: String, name: String, email: String, dob: String,
                        numberAsWord: String ,hweDeveloper: String)

      records.forEach((record: ConsumerRecord[String, String]) => {
        // Retrieve the message from each record
        val message = record.value()
        logger.info(s"Message Received: $message")
        // TODO: Add business logic here!
        println(s"Test message $message")
        val messageSplit = message.split("\t")
        val id = messageSplit(0)
        var userName = messageSplit(1)
        var name = messageSplit(2)
        var email = messageSplit(3)
        var dob = messageSplit(4)
        val rawUser = RawUser(id.toInt, userName, name, email, dob)
        logger.info(rawUser.toString)
        val enrichedUser = EnrichedUser(id.toInt, userName, name, email, dob, Util.mapNumberToWord(id.toInt), "Sudhagar Subramaniam")
        val asString = enrichedUser.id + "," + userName + " ," + name + " ," + email + " ," +dob + " ," + Util.mapNumberToWord(id.toInt) + " ," +  "Sudhagar Subramaniam"
        val myRecord = new ProducerRecord[String, String](producerTopic, asString)
        producer.send(myRecord)
      })
    }
  }
}