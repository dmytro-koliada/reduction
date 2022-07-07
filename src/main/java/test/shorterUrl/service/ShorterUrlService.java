package test.shorterUrl.service;

import test.shorterUrl.model.ShorterUrlEntity;

public interface ShorterUrlService {
    ShorterUrlEntity getShortUrl(ShorterUrlEntity ShorterUrlEntity);
    ShorterUrlEntity getFullUrl (String path);
}
