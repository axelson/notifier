package org.hicapacity.notifier.server;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Jason Axelson
 *
 */
@Path("/helloworld")
public class HelloWorldResource {
  @GET
  @Produces("text/plain")
  public String getClichedMessage() {
    return "Hello World CityCamp";
  }
}
