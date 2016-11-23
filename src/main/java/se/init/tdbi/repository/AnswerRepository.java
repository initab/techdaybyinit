package se.init.tdbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.init.tdbi.entity.Answer;

@SuppressWarnings("unused")
public interface AnswerRepository extends JpaRepository<Answer, Long> {
    Answer findByReviewId(Long reviewId);
    Answer findByQuestionId(Long reviewId);
}
