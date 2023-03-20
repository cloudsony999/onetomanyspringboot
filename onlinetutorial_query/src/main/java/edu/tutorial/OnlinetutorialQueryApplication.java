package edu.tutorial;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.repository.TutorialRepository;

@SpringBootApplication
public class OnlinetutorialQueryApplication implements CommandLineRunner {
	@Autowired
	private TutorialRepository tutorialRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlinetutorialQueryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Tutorial t1 = Tutorial.builder().title("java").description("core java").level(2).published(true)
				.createdAt(new Date()).build();

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2021");
		Tutorial t2 = Tutorial.builder().title("java").description("advanced java").level(3).published(false)
				.createdAt(date1).build();
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse("31/12/2022");
		Tutorial t3 = Tutorial.builder().title("java").description("android java").level(2).published(true)
				.createdAt(date2).build();
		Tutorial t4 = Tutorial.builder().title("python").description("core python").level(1).published(true)
				.createdAt(new Date()).build();
		Tutorial t5 = Tutorial.builder().title("python").description("Data Science").level(3).published(false)
				.createdAt(new Date()).build();
		Tutorial t6 = Tutorial.builder().title("python").description("Machine Learning").level(2).published(true)
				.createdAt(new Date()).build();

		tutorialRepository.save(t1);
		tutorialRepository.save(t2);
		tutorialRepository.save(t3);
		tutorialRepository.save(t4);
		tutorialRepository.save(t5);
		tutorialRepository.save(t6);
		System.out.println("------------------saved all-----------------------");

	}

}
