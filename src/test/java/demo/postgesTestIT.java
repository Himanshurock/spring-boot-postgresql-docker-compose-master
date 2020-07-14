package demo;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.DemoApplication;
import com.example.entity.Item;
import com.example.repository.ItemRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@ContextConfiguration(classes = DemoApplication.class)
@EnableAutoConfiguration
@ComponentScan("com.example")
public class postgesTestIT {
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Test
	public void connnectionTest() {
		
		itemRepository.save(new Item(4, "TestPostgres"));
		Assert.assertNotNull(itemRepository.findById(4));
		
	}
}
