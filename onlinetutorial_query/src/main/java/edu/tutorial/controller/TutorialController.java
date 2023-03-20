package edu.tutorial.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.tutorial.entity.Tutorial;
import edu.tutorial.repository.TutorialRepository;

@RestController
public class TutorialController {

	@Autowired
	private TutorialRepository tutorialRepository;

	@PostMapping("/tutorial")
	public Tutorial saveTutorial(@RequestBody Tutorial tutorial) {
		return tutorialRepository.save(tutorial);
	}

	@GetMapping("/tutorial")
	public List<Tutorial> getAllTutorials() {
		return tutorialRepository.findAll();
	}

	@GetMapping("/tutorialsPublished/{published}")
	public List<Tutorial> getAllTutorialsPublished(@PathVariable boolean published) {
		return tutorialRepository.findByPublished(published);
	}

	@GetMapping("/tutorialsByTitle/{title}")
	public List<Tutorial> getAllTutorialsPublished(@PathVariable String title) {
		return tutorialRepository.findByTitle(title);
	}

	@GetMapping("/tutorialsByDateRange/{start}/{end}")
	public List<Tutorial> getAllTutorialsPublished(
			@PathVariable("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date start,
			@PathVariable("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date end) {
		return tutorialRepository.findByDateBetween(start, end);
	}

}
