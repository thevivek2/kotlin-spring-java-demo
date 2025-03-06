
## Getting started
~~~
java 17.0.11
maven 3.6.3
mvn clean install
mvn clean install -DskipTests=true

Go to target and run this command  !!>>
java -jar demo-0.0.1-SNAPSHOT.jar



2025-03-06T11:36:49.317+05:45 TRACE 18032 --- [demo] [nio-8080-exec-1] com.example.demo.TraceService            : Entering helloWorldFromMemory Continuation at kotlin.reflect.full.KCallables.callSuspendBy(KCallables.kt:74)
2025-03-06T11:36:49.318+05:45 TRACE 18032 --- [demo] [nio-8080-exec-1] com.example.demo.TraceService            : Exiting helloWorldFromMemory Continuation at kotlin.reflect.full.KCallables.callSuspendBy(KCallables.kt:74) Returning MonoOnErrorResume
2025-03-06T11:36:49.342+05:45 TRACE 18032 --- [demo] [nio-8080-exec-1] c.e.demo.example.RequestTrackerFilter    :  **** RequestTrackerFilter *****************
2025-03-06T11:37:07.603+05:45 TRACE 18032 --- [demo] [nio-8080-exec-2] c.e.demo.example.RequestTrackerFilter    :  **** RequestTrackerFilter *****************
2025-03-06T11:37:10.629+05:45 TRACE 18032 --- [demo] [nio-8080-exec-5] c.e.demo.example.RequestTrackerFilter    :  **** RequestTrackerFilter *****************
2025-03-06T11:37:10.629+05:45  INFO 18032 --- [demo] [atcher-worker-1] com.example.demo.example.HelloWorld      : This is executed inside Coroutine context with Dispatcher.IO
2025-03-06T11:37:10.629+05:45  INFO 18032 --- [demo] [atcher-worker-1] com.example.demo.example.HelloWorld      : Do any blocking call - NO PROBLEM
~~~
