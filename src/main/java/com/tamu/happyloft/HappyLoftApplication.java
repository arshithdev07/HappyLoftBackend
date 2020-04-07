package com.tamu.happyloft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HappyLoftApplication {

	public static void main(String[] args) {
		SpringApplication.run(HappyLoftApplication.class, args);
	}

//	@Autowired
//	UserRepository userRepository;
//
//	@Autowired
//	ServiceCategoryRepository serviceCategoryRepository;
//
//	@Autowired
//	ServiceStatusRepository serviceStatusRepository;
//
//	@Bean
//	InitializingBean sendDatabase() {
//		return () -> {
//			userRepository.save(new User("Admin", "Admin", "admin@happyloft.com", "Admin!23", null, null, null));
//			userRepository.save(new User("Test", "Admin", "testadmin@happyloft.com", "TestAdmin!23", null, null, null));
//
//			serviceCategoryRepository.save(new ServiceCategory("Plumbing", "Services related to plumbing"));
//			serviceCategoryRepository.save(new ServiceCategory("Pet Services", "Services related to Pets"));
//			serviceCategoryRepository.save(new ServiceCategory("Carpentry", "Services related to Carpentry"));
//			serviceCategoryRepository.save(new ServiceCategory("Cleaning", "Services related to Cleaning"));
//
//			serviceStatusRepository.save(new ServiceStatus("NEW", "Services that are not addressed"));
//			serviceStatusRepository.save(new ServiceStatus("IN PROGRESS", "Services that are being currently addressed"));
//			serviceStatusRepository.save(new ServiceStatus("COMPLETED", "Services that are completed"));
//
//		};
//	}
}

