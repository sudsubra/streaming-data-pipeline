# Overview

Kafka has many moving pieces, but also has a ton of helpful resources to learn available online. In this homework, your
challenge is to write answers that make sense to you, and most importantly, **in your own words!**
Two of the best skills you can get from this class are to find answers to your questions using any means possible, and to
reword confusing descriptions in a way that makes sense to you. 

### Tips
* You don't need to write novels, just write enough that you feel like you've fully answered the question
* Use the helpful resources that we post next to the questions as a starting point, but carve your own path by searching on Google, YouTube, books in a library, etc to get answers!
* We're here if you need us. Reach out anytime if you want to ask deeper questions about a topic 
* This file is a markdown file. We don't expect you to do any fancy markdown, but you're welcome to format however you like

### Your Challenge
1. Create a new branch for your answers 
2. Complete all of the questions below by writing your answers under each question
3. Commit your changes and push to your forked repository

## Questions
#### What problem does Kafka help solve? Use a specific use case in your answer 
* Helpful resource: [Confluent Motivations and Use Cases](https://youtu.be/BsojaA1XnpM)

Kafka enables high throughput processing, is distributed and scalable, supports high-performance, is durable, 
and supports a publish-subscribe mechanism. Used for:
* **Messaging** - In comparison to most messaging systems Kafka has better throughput, built-in partitioning, replication, and 
fault-tolerance which makes it a good solution for large scale message processing applications. Example: 
online store that tracks purchases and update the available inventory.
* **Website Activity Tracking** - Publishing site activity to central topics with one topic per activity such as 
page views, searches, login info and etc., which are available realtime and loading into offline data warehousing
systems for offline processing and reporting. Example: 
* **Metrics** - Used for operational monitoring data which involves aggregating statistics from distributed applications
to produce centralized feeds of operational data
* **Log Aggregation** - can be used to collect physical log files off servers and place them in central place for
processing. Log Aggregation is the practice of collecting logs from across the enterprise (applications, databases, 
infrastructure components, etc.) into a single centralized logging platform. 
* **Stream Processing** - Many users of Kafka process data in processing pipelines consisting of multiple stages, where raw input 
data is consumed from Kafka topics and then aggregated, enriched, or otherwise transformed into new topics for further 
consumption or follow-up processing.
* **Event Sourcing** - can be used to log state changes as a time-ordered sequence of records.
* **Commit Log** - can be used as external commit-log for a distributed system, which helps replicate data between
nodes and acts as a re-syncing mechanism for failed nodes to restore their data

#### What is Kafka?
* Helpful resource: [Kafka in 6 minutes](https://youtu.be/Ch5VhJzaoaI) \n
* Kafka is distributed platform from sources and streams to many persistent targets/consumers in realtime. 
Kafka ingest data from multiple producer systems and application and makes the data available to multiple consumer
and application. Kafka 

#### Describe each of the following with an example of how they all fit together: 
 * Topic - method to categorize and store data. It is a specific stream of data. topic is split into partitions 
that enable topic to be distributed across various nodes.
 * Producer - client application that push events to topic
 * Consumer - client applications that read and process the events for Kafka partitions
 * Broker - A kafka serverj
 * Partition - mechanism that distributes data across multiple storage servers. Messages are indexed and stored 
together with a timestamp and ordered by the position of the message with a partition. Partitions are distributed 
across a node cluster and are replicated to multiple servers to ensure that Apache Kafka delivers message streams in a fault-tolerant manner.

#### Describe Kafka Producers and Consumers

#### How are consumers and consumer groups different in Kafka? 
* Helpful resource: [Consumers](https://youtu.be/lAdG16KaHLs)
* Helpful resource: [Confluent Consumer Overview](https://youtu.be/Z9g4jMQwog0)

#### How are Kafka offsets different than partitions? 

#### How is data assigned to a specific partition in Kafka? 

#### Describe immutability - Is data on a Kafka topic immutable? 

#### How is data replicated across brokers in kafka? If you have a replication factor of 3 and 3 brokers, explain how data is spread across brokers
* Helpful resource [Brokers and Replication factors](https://youtu.be/ZOU7PJWZU9w)

#### What was the most fascinating aspect of Kafka to you while learning? 
