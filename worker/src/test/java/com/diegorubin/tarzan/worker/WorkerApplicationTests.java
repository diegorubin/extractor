package com.diegorubin.tarzan.worker;

import com.diegorubin.tarzan.worker.configs.TestsConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestsConfiguration.class)
public class WorkerApplicationTests {

	@Test
	public void contextLoads() {
	}

}