package se.init.tdbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.init.tdbi.entity.Question;

@SuppressWarnings("unused")
public interface QuestionRepository extends JpaRepository<Question, Long> {
}
