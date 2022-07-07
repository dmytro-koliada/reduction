package test.shorterUrl.controller;

import org.springframework.web.bind.annotation.*;
import test.shorterUrl.dto.RequestDto;
import test.shorterUrl.dto.ResponseDto;
import test.shorterUrl.mapper.Mapper;
import test.shorterUrl.service.ShorterUrlService;

@RestController
@RequestMapping
public class ShorterController {
    private final ShorterUrlService service;
    private final Mapper mapper;

    public ShorterController(ShorterUrlService service, Mapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("/")
    public ResponseDto getUrl(@RequestBody RequestDto request) {
        return mapper.toShortUrlDto(service.getShortUrl(mapper.toModel(request)));
    }

    @GetMapping("/{url}")
    public ResponseDto postFullUrl(@PathVariable String url) {
        return mapper.toLongUrlDto(service.getFullUrl(url));
    }
}
