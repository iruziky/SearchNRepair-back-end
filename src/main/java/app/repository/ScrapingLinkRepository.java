package app.repository;
import app.entity.ScrapingLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScrapingLinkRepository extends JpaRepository<ScrapingLink, Long> {
	boolean existsByUrl(String url);
}

