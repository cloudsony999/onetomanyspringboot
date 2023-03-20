package edu.tutorial.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.tutorial.entity.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	@Query("SELECT t FROM Tutorial t")
	List<Tutorial> findAll();

	@Query("SELECT t FROM Tutorial t WHERE t.published=?1")
	List<Tutorial> findByPublished(boolean isPublished);

	@Query("SELECT t FROM Tutorial t WHERE t.title LIKE %?1%")
	List<Tutorial> findByTitle(String title);

	@Query("SELECT t FROM Tutorial t WHERE t.createdAt BETWEEN ?1 AND ?2")
	List<Tutorial> findByDateBetween(Date start, Date end);

	@Query("SELECT t FROM Tutorial t WHERE t.level>=?1")
	List<Tutorial> findByLevelGreaterThanEqual(int level);

}
