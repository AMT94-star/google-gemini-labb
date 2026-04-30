package se.amt.googlegeminilabb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.amt.googlegeminilabb.model.GeminiModel;

public interface GeminiRepository extends JpaRepository<GeminiModel, Long> {
}
