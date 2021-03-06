package com.buraktuysuz.springboottraining;

import com.buraktuysuz.springboottraining.entity.Category;
import com.buraktuysuz.springboottraining.entity.Product;
import com.buraktuysuz.springboottraining.service.entitySevice.CategoryEntitySevice;
import com.buraktuysuz.springboottraining.service.entitySevice.ProductEntityService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringBootTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootTrainingApplication.class, args);
//		ConfigurableApplicationContext applicationContext = SpringApplication.run(SpringBootTrainingApplication.class, args);
//		CategoryEntitySevice categoryEntitySevice = applicationContext.getBean(CategoryEntitySevice.class);
//		ProductEntityService productEntityService=applicationContext.getBean(ProductEntityService.class);
//		getPhoneCategory(categoryEntitySevice);
//		CreateFitnessAndSporCat(categoryEntitySevice);
	}

	private static void CreateFitnessAndSporCat(CategoryEntitySevice categoryEntitySevice) {
		Category spor=new Category();
		spor.setName("Spor");
		spor.setDepth(1L);

		spor=categoryEntitySevice.save(spor);

		Category fitness=new Category();
		fitness.setDepth(2L);
		fitness.setName("Fitness");
		fitness.setUpperCategory(spor);

		fitness=categoryEntitySevice.save(fitness);


//		getAllProduct(productEntityService);

		List<Category> categories=getAllCategory(categoryEntitySevice);
		for(Category cat:categories){
			System.out.println(cat);
		}
	}

	private static Category getPhoneCategory(CategoryEntitySevice service) {
		return service.findById(2L);
	}
	private static List<Category> getAllCategory(CategoryEntitySevice service) {
		return service.findAll();
	}

	private static List<Product> getAllProduct(ProductEntityService service) {
		return service.findAll();
	}

}
