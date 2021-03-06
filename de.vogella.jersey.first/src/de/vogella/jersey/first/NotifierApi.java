package de.vogella.jersey.first;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

// POJO, no interface no extends

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/api")
public class NotifierApi {

  // This method is called if TEXT_PLAIN is request
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayPlainTextHello() {
    return "Hello Jersey CityCamp!";
  }

  // This method is called if XML is request
  @GET
  @Produces(MediaType.TEXT_XML)
  public String sayXMLHello() {
    return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }

  // This method is called if HTML is request
  @GET
  @Produces(MediaType.TEXT_HTML)
  public String sayHtmlHello() {
    return "<html> " + "<title>" + "Hello Jersey" + "</title>" + "<body><h1>"
        + "Hello Jersey City Camp HTML!" + "</body></h1>" + "</html> ";
  }

  @Path("/todo")
  @GET
  @Produces(MediaType.TEXT_XML)
  public String testTodo() {
    return "<?xml version=\"1.0\"?>" + "<hello> Testinger Jersey" + "</hello>";
  }

  @Path("/getAllEvents")
  @GET
  @Produces(MediaType.TEXT_XML)
  public String getAllEvents() {
    return DataSource.newSampleData();
  }

  @Path("/setEvent")
  @POST
  @Consumes(MediaType.TEXT_XML)
  @Produces(MediaType.TEXT_XML)
  public String setEvent(String message) {
    System.out.println("in set event");
    System.out.println("Got message: " + message);
    return "<?xml version=\"1.0\"?>" + "<hello> Testinger Jersey" + "</hello>";
  }
}
