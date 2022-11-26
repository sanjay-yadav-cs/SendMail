# SendMail

Send Email to Anyone using this library in text format or in html format

# How to Implement

To get a Git project into your build:
> Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```	
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
} 
```

> Step 2. Add the dependency

Add it in your root app.gradle at the end of repositories:

```java	
dependencies {
		...
	implementation 'com.github.sanjay-yadav-cs:SendMail:1.0.0'
		...
}
  ```
  
  
  # How I can send Mail
 
  Simple use cases will look something like this:
  
 ````
 String senderEamail = "sanjayyadav@gmail.com";
String sendePassword = "xyz";
String receiverEamail = "raju@gmail.com";
String messageType = "html";             // (message types "text" or "html")
String subject = "Testing Mail";
String message = "Hello how are you";     // for message type text

// String message = "<html><b>Hello how are you</b></html>";     // for message type html use html code and use inline css for decoraation
 
  
  SendMail mail = new SendMail(contex,senderEamail,sendePassword,receiverEamail,subject,messageType,message);
                mail.execute();
                
 ```  
  
