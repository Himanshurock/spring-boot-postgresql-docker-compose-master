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
//@DataJpaTest
@ContextConfiguration(classes = DemoApplication.class)
@EnableAutoConfiguration
@ComponentScan("com.example")

/*
 * @EntityScan("com.example.entity")
 * 
 * @EnableJpaRepositories
 */
public class postgesTestIT {
	
	@Autowired
	private ItemRepository itemRepository;
	
	//@Autowired
	//TestEntityManager testEntityManager;
	
	/*
	 * @Bean public JpaTransactionManager transactionManager() { return new
	 * JpaTransactionManager(); }
	 */
	
	
	 /** @Bean public EntityManagerFactory entityManagerFactory() { return
	 * EntityManagerFactory(); }
	 */
	
	
	@Test
	public void connnectionTest() {
				itemRepository.save(new Item(4, "D"));
		Assert.assertNotNull(itemRepository.findById(4));
		//Assert.assertNotNull(itemRepository.findOne(5));
		
	}

}
