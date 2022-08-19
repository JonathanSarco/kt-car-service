# KarService

## Overview
- When a Car is having some inconveniences within the system, it needs to go to a repair shop to fix that problem.
- Before going to the repair shop, the car should generate a notification saying what the problem is. 
- The notification will be shown on the car board and pushed to the cloud where it will be stored.
- When the car’s owner decides to go to the garage (or repair shop), this shop will receive all the telemetry based on the plaque number on the car, 
where it can work on the problem and communicate with the customer about what the real problem is.

### Workflow

- Telemetry of a Car: When a car is having some issues within their system, the telemetry of it will send a notification to the user (via the car board) where he can analyze it and take action from that.
- At the same time, that information has to be pushed to a cloud database (?) where it has to be available for all the clients/services belonging to the brand of the car.
- Database will generate events (pushed to a stream, Kafka or Akka) where can be accessed via APIs. These APIs can be consumed for clients who have access to it (for example a repair shop for the car).



