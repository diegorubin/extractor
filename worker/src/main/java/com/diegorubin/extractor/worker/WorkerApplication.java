package com.diegorubin.extractor.worker;

import com.diegorubin.extractor.worker.monitor.gateways.TwitterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.diegorubin.extractor"})
public class WorkerApplication implements CommandLineRunner {

  @Autowired
  private TwitterGateway twitterGateway;

  public static void main(String[] args) {
    SpringApplication.run(WorkerApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {
    twitterGateway.listen();
  }

}
