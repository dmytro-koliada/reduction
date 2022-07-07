package test.shorterUrl.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.shorterUrl.model.ShorterUrlEntity;

@Repository
public interface ShorterUrlDao extends JpaRepository<ShorterUrlEntity, String> {
    ShorterUrlEntity getByShortUrl(String shortUrl);
}
