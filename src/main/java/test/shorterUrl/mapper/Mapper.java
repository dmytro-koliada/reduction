package test.shorterUrl.mapper;

import org.springframework.stereotype.Component;
import test.shorterUrl.dto.RequestDto;
import test.shorterUrl.dto.ResponseDto;
import test.shorterUrl.model.ShorterUrlEntity;

@Component
public class Mapper {
    public ResponseDto toShortUrlDto(ShorterUrlEntity shortUrl) {
        ResponseDto responseDto = new ResponseDto();
        responseDto.setShortURL(shortUrl.getShortUrl());
        return responseDto;
    }

    public ShorterUrlEntity toModel(RequestDto requestDto) {
        ShorterUrlEntity longUrl = new ShorterUrlEntity();
        longUrl.setFullUrl(requestDto.getFullURL());
        return longUrl;
    }

    public ResponseDto toLongUrlDto(ShorterUrlEntity fullUrl) {
       ResponseDto responseDto = new ResponseDto();
        responseDto.setShortURL(fullUrl.getFullUrl());
        return responseDto;
    }
}
