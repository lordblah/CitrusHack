package example;
/*assumed that your localhost is connected to the internet and
capable enough to send an email.
Same time make sure all the jar files from Java Email API package
and JAF package ara available in CLASSPATH
*/


//HTML email to contact

        import 	java.io.*;
        import 	java.util.*;
        import	javax.servlet.*;
        import	javax.servlet.http.*;
        import	javax.mail.*;
        import	javax.mail.internet.*;
        import 	javax.activation.*;


public class SendEmail extends HttpServlet{
  public void doGet(HttpServletRequest request,
                    HttpServletresponse response)
          throws ServletException, IOException
  {
  //Email of emmergency contact,add variable containing data
  String to = "jhernandez86@student.rcc.edu"; //email for testing, change asap

  //senders email
  String from  = "helharatheband@gmail.com";//email for testing, change asap

  //place we're sending from
  String host = "localhost";

  //Retriving system properties
  Properties properties = System.getProperties();

  //email server
  properties.setProperty("mail.smtp.host", host);

  //retrive default Session object
  Session session = Session.getInstance(properties);

  //responsive type
  response.setContentType("text/html");
  PrintWriter out = response.getWriter();

  try{
    //default MimeMessage object
    MimeMessage message = new MimeMessage(session);

    //set From: header field of the header.
    message.setFrom(new InternetAddress(from));

    //Set To: header field of the header
    message.addRecipent(Message.RecipentType.TO,
            new InternetAddress(to));

    //Set Subject: header field
    message.setSubject("Important Message!");

    //actual HTML message
    message.setContent("<h1>Listen empathise and don’t judge</h1><p>" +
            "The web browsing activity of your family member show signs of " +
            "falling back into a relapse of depression. Please take time out" +
            " of your day to listen to them actively, empathise and don't judge.</p>","text/html");

    // Send message
    Transport.send(message);

  }catch (MessagingException mex) {
    mex.printStackTrace();
  }
}

} 
