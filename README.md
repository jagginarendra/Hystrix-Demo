# Hystrix-Demo
Demo project for Hystrix.

To see mbeans details, we can use jconsole. To pass below dependencies are required to publish data.

compile group: 'com.netflix.hystrix', name: 'hystrix-servo-metrics-publisher', version: '1.5.12' compile group: 'com.netflix.servo', name: 'servo-core', version: '0.12.28'

We can also use alternate way also i.e https://micrometer.io/docs (Meter registry) to publish data to New Relic/Watch Dog or other dimensional metrics supporter. It is added from Spring boot 2.0.0 but later added 1.5.X also as legacy-suuport
