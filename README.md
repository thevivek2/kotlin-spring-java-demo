
## Getting started
~~~
java 17.0.11
maven 3.6.3
mvn clean install
mvn clean install -DskipTests=true

Go to target and run this command  !!>>
java -jar demo-0.0.1-SNAPSHOT.jar



2025-03-06T14:15:48.678+05:45  INFO 25180 --- [demo] [192.168.150.118] o.s.web.servlet.DispatcherServlet        : Completed initialization in 1 ms
2025-03-06T14:15:51.904+05:45  INFO 25180 --- [demo] [nio-8080-exec-1] com.example.demo.example.HelloWorld      : Lets collect few information from main thread
2025-03-06T14:15:51.912+05:45  INFO 25180 --- [demo] [atcher-worker-1] com.example.demo.example.HelloWorld      :  reqAttribute  org.apache.catalina.connector.RequestFacade@58a8dc8
2025-03-06T14:15:51.912+05:45  INFO 25180 --- [demo] [atcher-worker-1] com.example.demo.example.HelloWorld      : Thanks... https://www.youtube.com/watch?v=hQrFfwT1IMo&t=1514s
https://docs.spring.io/spring-framework/reference/languages/kotlin/coroutines.html
2025-03-06T14:15:51.915+05:45 TRACE 25180 --- [demo] [atcher-worker-1] com.example.demo.TraceService            : Entering externalUrlGet
2025-03-06T14:15:51.917+05:45 TRACE 25180 --- [demo] [atcher-worker-1] c.e.demo.example.ExampleRestClient       : getting from external url with that replies randomly delayed 753ms
2025-03-06T14:15:51.918+05:45 TRACE 25180 --- [demo] [nio-8080-exec-1] c.e.demo.example.RequestTrackerFilter    :  **** Logging Above The Cloud *****************
2025-03-06T14:15:55.532+05:45 TRACE 25180 --- [demo] [atcher-worker-1] com.example.demo.TraceService            : Exiting externalUrlGet  <200 OK OK,200 OK RANDOM DELAY WAS 753,[]>
2025-03-06T14:16:04.889+05:45 TRACE 25180 --- [demo] [nio-8080-exec-4] c.e.demo.example.RequestTrackerFilter    :  **** Logging Above The Cloud *****************

