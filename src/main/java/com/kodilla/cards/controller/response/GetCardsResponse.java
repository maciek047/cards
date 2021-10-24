package com.kodilla.cards.controller.response;

import com.kodilla.cards.dto.CardDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
public class GetCardsResponse {
    private List<CardDto> cards;
}
