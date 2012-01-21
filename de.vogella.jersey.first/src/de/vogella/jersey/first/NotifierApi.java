package de.vogella.jersey.first;

import java.io.File;
import java.io.StringWriter;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import de.micromata.opengis.kml.v_2_2_0.Kml;

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
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey City Camp HTML!" + "</body></h1>" + "</html> ";
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
    final Kml kml = new Kml();
    kml.createAndSetPlacemark().withName("London, UK").withDescription("Description").withOpen(Boolean.TRUE)
        .createAndSetPoint().addToCoordinates(-0.126236, 51.500152);

    StringWriter stringWriter = new StringWriter();
    kml.marshal(stringWriter);
    String string = stringWriter.toString();

    return string;
  }
}
