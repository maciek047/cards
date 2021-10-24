package com.kodilla.cards.mapper;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.dto.CardDto;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardsMapper {
    public CardDto mapToCardDto(Card card) {
        return new CardDto(
                card.getId(),
                card.getCardNumber(),
                card.getCurrency(),
                card.getAvailableFunds());
    }
    public List<CardDto> mapToCardDtoList(List<Card> cards) {
        return cards.stream()
                .map(card -> mapToCardDto(card))
                .collect(Collectors.toList());
    }
}
