package util;

import config.RmiClientConfig;
import dao.SingerService;
import entity.Singer;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

//@Ignore
@ContextConfiguration(classes = RmiClientConfig.class)
@RunWith(SpringRunner.class)
public class RmiTests {
	private Logger logger = LoggerFactory.getLogger(RmiTests.class);

	@Autowired
	private SingerService singerService;

	@Test
	public void testRmiAll() {
		logger.info("testRmiAll");
		List<Singer> singers = singerService.findAll();
		assertEquals(14, singers.size());
		listSingers(singers);
	}

	@Test
	public void testRmiJohn() {
		logger.info("testRmiJohn");
		List<Singer> singers = singerService.findByFirstName("John");
		assertEquals(2, singers.size());
		listSingers(singers);
	}

	private void listSingers(List<Singer> singers){
		singers.forEach(s -> logger.info(s.toString()));
	}
}
