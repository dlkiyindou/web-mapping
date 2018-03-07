package fr.scholanova.group.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App 
{
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

//	@Bean
//	public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
//		return new CommandLineRunner() {
//			public void run(String... args) throws Exception {
//
//				System.out.println("Let's inspect the beans provided by Spring Boot:");
//
//				String[] beanNames = ctx.getBeanDefinitionNames();
//				Arrays.sort(beanNames);
//				for (String beanName : beanNames) {
//					System.out.println(beanName);
//				}
//
//			}
//		};
//	}
}
