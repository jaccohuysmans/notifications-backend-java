#Notifications-backend-java

This contains the Java backend version that is needed by both a [mobile client](https://github.com/jaccohuysmans/notifications-android) as well as a [management client](https://github.com/jaccohuysmans/notifications-management).
This backend is part of the Notifications project. Read more about that [HERE](https://github.com/jaccohuysmans/notifications--main/blob/master/README.md)


###Notes
- The application makes use of the [Play web application framework](https://www.playframework.com/) (In order to locally run your server you either need to install SBT or Activator).
- Notifications are made persistent using ElasticSearch. The application expects a server to be available at the url defined in the application.properties
- There are two endpoints defined in the routes file. One for adding a notification and one for retrieving a list of stored notifications. Both endpoints are publicly accessible, no form of authentication is implemented.


