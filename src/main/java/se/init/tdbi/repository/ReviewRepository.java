package se.init.tdbi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.init.tdbi.entity.Review;

@SuppressWarnings("unused")
public interface ReviewRepository extends JpaRepository<Review, Long> {
}
