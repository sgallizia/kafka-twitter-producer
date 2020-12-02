# kafka-twitter-producer
This Spring Boot project is an example of Kafka producer. It reads sample tweets from Twitter API and publishes them on a topic. For an example of consumer please visit [this project](https://github.com/sgallizia/kafka-twitter-consumer).
## Quickstart
You must have Kafka installed. You can install it following [this](https://github.com/wurstmeister/kafka-docker)

Create a Twitter Developer Account.

Create a topic with Kafka:


```
.\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092
```

Change the property app.kafka.topic in application.yml with the right topic.

Create a twitter4j.properties file under src/main/resources:

```
oauth.accessTokenSecret: <your Twitter access token secret>
oauth.consumerSecret: <your Twitter consumer secret>
oauth.consumerKey: <your Twitter consumer key>
oauth.accessToken: <your Twitter access token>
debug: true
```

Start the Spring Boot Application.