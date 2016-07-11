package com.diegorubin.monitor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WorkerApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(WorkerApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception {

  }
}
