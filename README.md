Google Cloud Messaging Server
-----------------------------

GCMPlayeServer is a small example server using Google Cloud Messageing. It allows devices to register themselves to
receive messages from the server.

It is written in Java and uses Play! framework.

Usage
-----------------------------
You will need to have [Play! framework](http://www.playframework.com/) instelled to run the server.
Before starting the server you must update API_KEY in GCMFactory with the value of your server API key.  You can generate this key
for your project in your Google Cloud Dashboard (more info [here](http://developer.android.com/google/gcm/gs.html)).

This app can be deployed to Heroku.

### Server pages
http://localhost:9000/devices - list of all registered devices

http://localhost:9000/send - form allowing you to send message to all registered devices

http://localhost:9000/register - send POST request to this address from your app to register device (see below).

### App

Send a POST request to the http://localhost:9000/register to register device. You need to include following parameters
deviceId - unique device id

registrationId - registration id that you received when the app registered with Google Cloud Messaging service.

When server sends message to application data will be contained in "message" param by default.



