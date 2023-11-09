## Kafka Topics
- Data in Kafka topics is deleted after one week by default (also called the default message retention period), and this value is configurable.
- The offset is an integer value that Kafka adds to each message as it is written into a partition. Each message in a given partition has a unique offset.
- Unlike database tables, Kafka topics are not query-able. Instead, we have to create Kafka producers to send data to the topic and Kafka consumers to read the data from the topic in order.
- Kafka topics are immutable: once data is written to a partition, it cannot be changed

---

## Kafka Offsets
- Apache Kafka offsets represent the position of a message within a Kafka Partition
- If a topic has more than one partition, Kafka guarantees the order of messages within a partition, but there is no ordering of messages across partitions.
- Even though we know that messages in Kafka topics are deleted over time (as seen above), the offsets are not re-used. They continually are incremented in a never-ending sequence.

---

## Kafka Producers
- Applications that send data into topics are known as Kafka producers.
- Applications typically integrate a Kafka client library to write to Apache Kafka.
  
![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/42a22923-0295-44ef-9326-f997df96409b)

---

## Message Keys
- Each event message contains an optional key and a value.
- In case the key `(key=null)` is not specified by the producer, messages are distributed evenly across partitions in a topic. This means messages are sent in a `round-robin fashion` (partition p0 then p1 then p2, etc... then back to p0 and so on...).
- **If a key is sent (key != null), then all messages that share the same key will always be sent and stored in the same Kafka partition.**
- A key can be anything to identify a message - a string, numeric value, binary value, etc.
- Kafka message keys are commonly used when there is a need for message ordering for all messages sharing the same field. For example, in the scenario of tracking trucks in a fleet, we want data from trucks to be in order at the individual truck level. In that case, we can choose the key to be truck_id. In the example shown below, the data from the truck with id truck_id_123 will always go to partition p0.

![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/02e8ff66-fccc-4158-aa32-7b25fdc57844)

---

## Kafka Message Anatomy
- Kafka messages are created by the producer. A Kafka message consists of the following elements:
![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/168405a5-dd36-43a1-b668-bf10d54423e5)

    `Key`: Key is optional in the Kafka message and it can be null. A key may be a string, number, or any object and then the key is serialized into binary format.

    `Value`: The value represents the content of the message and can also be null. The value format is arbitrary and is then also serialized into binary format.

   `Compression Type`: Kafka messages may be compressed. The compression type can be specified as part of the message. Options are none, gzip, lz4, snappy, and zstd

    `Headers`: There can be a list of optional Kafka message headers in the form of key-value pairs. It is common to add headers to specify metadata about the message, especially for tracing.

    `Partition + Offset`: Once a message is sent into a Kafka topic, it receives a partition number and an offset id. The combination of topic+partition+offset uniquely identifies the message

    `Timestamp`: A timestamp is added either by the user or the system in the message.

---

## Kafka Message Serializers
- Kafka brokers expect byte arrays as keys and values of messages.
- The process of transforming the producer's programmatic representation of the object to binary is called** message serialization**.

---

## Kafka Message Key Hashing
- A Kafka partitioner is a code logic that takes a record and determines to which partition to send it into.

  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/96e84a34-5ec8-4042-acd4-c842d99956e8)

- Key Hashing is the process of determining the mapping of a key to a partition.
- In the default Kafka partitioner, the keys are hashed using the `murmur2 algorithm`, with the formula below for the curious:

  ```java
  targetPartition = Math.abs(Utils.murmur2(keyBytes)) % (numPartitions - 1)
  ```
- It is possible to override the default partitioner via the producer property partitioner.class, although it is not advisable unless you know what you are doing. 
  
---

## Kafka Consumers
- Applications that pull event data from one or more Kafka topics are known as Kafka Consumers.
- Applications integrate a Kafka client library to read from Apache Kafka.
- A consumer always reads data from a lower offset to a higher offset and cannot read data backwards (due to how Apache Kafka and clients are implemented).
- If the consumer consumes data from more than one partition, the message order is not guaranteed across multiple partitions because they are consumed simultaneously, but the message read order is still guaranteed within each individual partition.
- By default, Kafka consumers will only consume data that was produced after it first connected to Kafka. Which means that to read historical data in Kafka, one must specify it as an input to the command, as we will see in the practice section.

---

## Kafka Message Deserializers
- Data being consumed must be deserialized in the same format it was serialized in.
- Messages sent to a Kafka topic that do not respect the agreed-upon serialization format are called `poison pills`. They are not fun to deal with.

---

## Kafka Consumer Groups & Offsets
- We have seen that consumers can consume data from Kafka topics partitions individually, but for horizontal scalability purposes it is recommended to consume Kafka topics as a group.
- Consumers that are part of the same application and therefore performing the same "logical job" can be grouped together as a Kafka consumer group.
- The benefit of leveraging a Kafka consumer group is that the consumers within the group will coordinate to split the work of reading from different partitions.

  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/9acde3f4-3731-48f7-b6a8-16994c446b4c)

### Kafka Consumer Group ID
- In order for indicating to Kafka consumers that they are part of the same specific group , we must specify the consumer-side setting group.id.
- Kafka Consumers automatically use a `GroupCoordinator` and a `ConsumerCoordinator` to assign consumers to a partition and ensure the load balancing is achieved across all consumers in the same group.

![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/e25a2c77-6b9d-4d65-9fa8-ff416692739d)

![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/257b3f65-0eff-41d0-b50e-c12be139c74c)

- If there are more consumers than the number of partitions of a topic, then some consumers will remain inactive as shown below.
  
![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/afdcd7ec-6511-4f7a-b95e-241c0853ba0d)

### [Kafka Consumer Offsets](https://www.conduktor.io/kafka/kafka-consumer-groups-and-consumer-offsets/#Kafka-Consumer-Offsets-2)
- Kafka brokers use an internal topic named `__consumer_offsets` that keeps track of what messages a given consumer group last successfully processed.
- The process of committing offsets is not done for every message consumed (because this would be inefficient), and instead is a periodic process.

### Why use Consumer Offsets?
- Offsets are critical for many applications. If a Kafka client crashes, a rebalance occurs and the latest committed offset help the remaining Kafka consumers know where to restart reading and processing messages.

### Delivery semantics for consumers
- By default, Java consumers automatically commit offsets (controlled by the enable.auto.commit=true property) every auto.commit.interval.ms (5 seconds by default) when .poll() is called.
- A consumer may opt to commit offsets by itself (enable.auto.commit=false). Depending on when it chooses to commit offsets, there are delivery semantics available to the consumer. The three delivery semantics are explained below.

    At most once:

        Offsets are committed as soon as the message is received.

        If the processing goes wrong, the message will be lost (it won’t be read again).

    At least once (usually preferred):

        Offsets are committed after the message is processed.

        If the processing goes wrong, the message will be read again.

        This can result in duplicate processing of messages. Therefore, it is best practice to make sure data processing is idempotent (i.e. processing the same message twice won't produce any undesirable effects

    Exactly once:

        This can only be achieved for Kafka topic to Kafka topic workflows using the transactions API. The Kafka Streams API simplifies the usage of that API and enables exactly once using the setting processing.guarantee=exactly_once_v2 (exactly_once on Kafka < 2.5)

        For Kafka topic to External System workflows, to effectively achieve exactly once, you must use an idempotent consumer.

In practice, at least once with idempotent processing is the most desirable and widely implemented mechanism for Kafka consumers.

---

## Kafka Brokers
- A single Kafka server is called a Kafka Broker. That Kafka broker is a program that runs on the Java Virtual Machine (Java version 11+) and usually a server that is meant to be a Kafka broker will solely run the necessary program and nothing else.
- `Kafka Cluster` - An ensemble of Kafka brokers working together is called a Kafka cluster.
- A broker in a cluster is identified by a unique numeric ID. In the figure below, the Kafka cluster is made up of three Kafka brokers.

  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/8dd51be4-ea21-4705-b518-fba119d70f54)

- Kafka brokers store data in a directory on the server disk they run on.
- To achieve high throughput and scalability on topics, Kafka topics are partitioned. If there are multiple Kafka brokers in a cluster, then partitions for a given topic will be distributed among the brokers evenly, to achieve load balancing and scalability.

  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/18002142-4d42-4f21-a856-222c6ce67de2)

### How do clients connect to a Kafka Cluster (bootstrap server)?
- A client that wants to send or receive messages from the Kafka cluster may connect to any broker in the cluster.
- Every broker in the cluster has metadata about all the other brokers and will help the client connect to them as well, and therefore any broker in the cluster is also called a bootstrap server.
- The bootstrap server will return metadata to the client that consists of a list of all the brokers in the cluster.
- Then, when required, the client will know which exact broker to connect to to send or receive data, and accurately find which brokers contain the relevant topic-partition.

  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/98847949-f77a-420b-85d5-c5dae0919a7a)

- In practice, it is common for the Kafka client to reference at least two bootstrap servers in its connection URL, in the case one of them not being available, the other one should still respond to the connection request. That means that Kafka clients (and developers / DevOps) do not need to be aware of every single hostname of every single broker in a Kafka cluster, but only to be aware and reference two or three in the connection string for clients.

---  

## Kafka Topic Replication
- One of the main reasons for Kafka's popularity, is the resilience it offers in the face of broker failures.
- Kafka is designed with replication as a core feature to withstand these failures while maintaining uptime and data accuracy.
- `Kafka Replication` - Data Replication helps prevent data loss by writing the same data to more than one broker
- The `replication factor` is a topic setting and is specified at topic creation time.
- A replication factor of `1` means no replication. It is mostly used for development purposes and should be avoided in test and production Kafka clusters
- A replication factor of `3` is a commonly used replication factor as it provides the right balance between broker loss and replication overhead.

### What are Kafka Partitions Leader and Replicas?
- For a given topic-partition, one Kafka broker is designated by the cluster to be responsible for sending and receiving data to clients. That broker is known as the leader broker of that topic partition. Any other broker that is storing replicated data for that partition is referred to as a replica.
- Therefore, each partition has one leader and multiple replicas.

### What are In-Sync Replicas (ISR)?
- An ISR is a replica that is up to date with the leader broker for a partition. Any replica that is not up to date with the leader is out of sync.

### Kafka producers acks setting
- Kafka producers only write data to the current leader broker for a partition.
- Kafka producers must also specify a level of acknowledgment acks to specify if the message must be written to a minimum number of replicas before being considered a successful write.
- The default value of acks has changed with Kafka v3.0

      if using Kafka < v3.0, acks=1
      if using Kafka >= v3.0, acks=all

- When `acks=0` producers consider messages as "written successfully" the moment the message was sent `without waiting for the broker to accept it at all`.
  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/7b0a63a1-7102-4201-be8b-a1ba6b5712ca)

- When `acks=1` , producers consider messages as "written successfully" when the message was `acknowledged by only the leader`.
  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/11de9165-7da4-4e86-a72d-75c80b44c323)

- When acks=all, producers consider messages as "written successfully" when the message is accepted by all in-sync replicas (ISR).
  ![image](https://github.com/AbhishekKudal/InterviewQuestions/assets/102067485/9c179262-073a-4950-9707-787c6e10931c)

### Kafka Topic Replication Settings
- `acks=all` and `min.insync.replicas=2` is the most popular option for data durability and availability and allows you to withstand at most the loss of one Kafka broker

### Kafka Consumers Replicas Fetching
- Kafka consumers read by default from the partition leader.
- But since Apache Kafka 2.4, it is possible to configure consumers to read from in-sync replicas instead (usually the closest).
- Reading from the closest in-sync replicas (ISR) may improve the request latency, and also decrease network costs, because in most cloud environments cross-data centers network requests incur charges.

### Preferred leader
- The preferred leader is the designated leader broker for a partition at topic creation time (as opposed to being a replica).
- The process of deciding which broker is a leader at topic creation time is called a preferred leader election.
- When the preferred leader goes down, any partition that is an ISR (in-sync replica) is eligible to become a new leader (but not a preferred leader). Upon recovering the preferred leader broker and having its partition data back in sync, the preferred leader will regain leadership for that partition. 

## Zookeeper with Kafka
- Zookeeper is used to track cluster state, membership, and leadership
- Zookeeper Being Eliminated from Kafka v4.x

Important:

    Kafka 0.x, 1.x & 2.x must use Zookeeper

    Kafka 3.x can work without Zookeeper (KIP-500) but is not production ready yet

    Kafka 4.x will not have Zookeeper

- How do the Kafka brokers and clients keep track of all the Kafka brokers if there is more than one? The Kafka team decided to use Zookeeper for this purpose.

- Zookeeper is used for metadata management in the Kafka world. For example:

    1. Zookeeper keeps track of which brokers are part of the Kafka cluster

    2. Zookeeper is used by Kafka brokers to determine which broker is the leader of a given partition and topic and perform leader elections

    3. Zookeeper stores configurations for topics and permissions

    4. Zookeeper sends notifications to Kafka in case of changes (e.g. new topic, broker dies, broker comes up, delete topics, etc.…)
 
- A Zookeeper cluster is called an ensemble. It is recommended to operate the ensemble with an odd number of servers, e.g., 3, 5, 7, as a strict majority of ensemble members (a quorum) must be working in order for Zookeeper to respond to requests. Zookeeper has a leader to handle writes, the rest of the servers are followers to handle reads.

### Should you use Zookeeper with Kafka clients?
- Zookeeper is also less secure than Kafka, and therefore Zookeeper ports should only be opened to allow traffic from Kafka brokers, and not Kafka clients
- **Therefore, to be a great modern-day Kafka developer, never ever use Zookeeper as a configuration in your Kafka clients, and other programs that connect to Kafka.**
