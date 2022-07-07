package test.shorterUrl.service.impl;

import org.springframework.stereotype.Service;
import test.shorterUrl.dao.ShorterUrlDao;
import test.shorterUrl.model.ShorterUrlEntity;
import test.shorterUrl.service.ShorterUrlService;

@Service
public class ShorterUrlServiceImpl implements ShorterUrlService {
    private final char[] array =
            "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

    private final ShorterUrlDao shorterURlDao;

    public ShorterUrlServiceImpl(ShorterUrlDao shorterURlDao) {
        this.shorterURlDao = shorterURlDao;
    }


    @Override
    public ShorterUrlEntity getShortUrl(ShorterUrlEntity FullUrl) {
       if(isValidate(FullUrl)) {
           return shorterURlDao.save(toShort(FullUrl));
       }
       throw new RuntimeException("your link is invalid");
    }

    @Override
    public ShorterUrlEntity getFullUrl(String path) {
        return shorterURlDao.getByShortUrl("http://localhost:8080/" + path);
    }

    private boolean isValidate(ShorterUrlEntity url) {
        String cleanUrl = url.getFullUrl().trim();
        String pattern = "^(http:\\/\\/www\\.|https:\\/\\/www\\.|http:\\/\\/|https:\\/\\/)?"
                + "[a-z0-9]+([\\-\\.]{1}[a-z0-9]+)*\\.[a-z]{2,5}(:[0-9]{1,5})?(\\/.*)?$";
        return !cleanUrl.equals("") && cleanUrl.matches(pattern);
    }

    private ShorterUrlEntity toShort(ShorterUrlEntity ShorterUrlEntity) {
        StringBuilder stringBuilder = new StringBuilder();
        while (stringBuilder.length() != 8) {
            stringBuilder.append(array[(int) (array.length - Math.random() * array.length)]);
        }
        ShorterUrlEntity.setShortUrl("http://localhost:8080/" + stringBuilder);
        return ShorterUrlEntity;
}
}
