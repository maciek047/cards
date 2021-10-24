package com.kodilla.cards.controller;

import com.kodilla.cards.controller.response.GetCardsResponse;
import com.kodilla.cards.dto.CardDto;
import com.kodilla.cards.service.CardsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Slf4j
@RefreshScope
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CardsController {

    @Value("${application.allow-get-accounts}")
    private boolean allowGetCards;

    private final CardsService cardsService;

    @GetMapping("/cards")
    public GetCardsResponse fetchCards (@RequestParam("customerId") Long customerId){
        log.info("Get cards for customerId: {}", customerId);
        if(!allowGetCards) {
            log.info("Getting accounts is disabled");
            throw new ResponseStatusException(HttpStatus.SERVICE_UNAVAILABLE, "Getting accounts is disabled");
        }
        List<CardDto> cards = cardsService.fetchCardsByCustomerId(customerId);
        return GetCardsResponse.of(cards);
    }

}
