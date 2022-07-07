package test.shorterUrl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ShorterUrlEntity {

    @Id
    private String fullUrl;
    private String shortUrl;

    public String getFullUrl() {
        return fullUrl;
    }

    public ShorterUrlEntity() {
    }

    public void setFullUrl(String fullUrl) {
        this.fullUrl = fullUrl;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ShorterUrlEntity that = (ShorterUrlEntity) o;
        return Objects.equals(fullUrl, that.fullUrl)
                && Objects.equals(shortUrl, that.shortUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullUrl, shortUrl);
    }

    @Override
    public String toString() {
        return "shorterUrl{"
                + "fullUrl='" + fullUrl + '\''
                + ", shortUrl='" + shortUrl + '\'' + '}';
    }
}
