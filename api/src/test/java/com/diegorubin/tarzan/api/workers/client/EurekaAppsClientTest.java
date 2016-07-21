package com.diegorubin.tarzan.api.workers.client;

import com.diegorubin.tarzan.api.workers.domain.Application;
import com.diegorubin.tarzan.api.workers.gateways.client.EurekaAppsClient;
import feign.Feign;
import feign.jaxb.JAXBContextFactory;
import feign.jaxb.JAXBDecoder;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.cloud.netflix.feign.support.SpringMvcContract;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * Eureka Apps Client Test
 *
 * @author diegorubin
 */
@RunWith(MockitoJUnitRunner.class)
public class EurekaAppsClientTest {

  @Rule
  public final MockWebServer server = new MockWebServer();

  @Test
  public void shouldGetWorkersFromEureka() {
    server.enqueue(new MockResponse().setResponseCode(200).setBody(getBody()));
    EurekaAppsClient client = getEurekaAppsClient();

    Application application = client.get().getApplications().get(0);

    Assert.assertEquals(application.getName(), "WORKER");
  }

  private EurekaAppsClient getEurekaAppsClient() {
    JAXBContextFactory jaxbFactory = new JAXBContextFactory.Builder()
        .withMarshallerJAXBEncoding("UTF-8")
        .build();

    return Feign.builder().contract(new SpringMvcContract())
        .decoder(new JAXBDecoder(jaxbFactory))
        .target(EurekaAppsClient.class, "http://localhost:" + server.getPort());
  }

  private String getBody() {
    ClassLoader classLoader = getClass().getClassLoader();
    File file = new File(classLoader.getResource("eureka/apps.xml").getFile());
    StringBuilder body = new StringBuilder();

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        body.append(line).append("\n");
      }
      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
    }

    return body.toString();
  }
}
