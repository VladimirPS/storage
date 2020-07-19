package ru.pecherskiy.storage;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.pecherskiy.storage.model.Product;
import ru.pecherskiy.storage.repository.ProductRepository;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ContextConfiguration(classes = ProductConfig.class)
class StorageApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createSimpleProduct(){
		Product p = new Product();
		p.setName("Name 1");

		Product saved = productRepository.save(p);
		assertThat(saved.getId()).isNotNull();
	}

}
