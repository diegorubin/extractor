package com.diegorubin.monitor;

import com.diegorubin.monitor.gateways.TwitterGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.diegorubin"})
@SpringBootApplication
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
