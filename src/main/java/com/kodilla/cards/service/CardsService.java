package com.kodilla.cards.service;

import com.kodilla.cards.domain.Customer;
import com.kodilla.cards.dto.CardDto;
import com.kodilla.cards.mapper.CardsMapper;
import com.kodilla.cards.repository.CardsRepository;
import com.kodilla.cards.repository.CustomersRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CardsService {
    private final CardsRepository cardsRepository;
    private final CustomersRepository customersRepository;
    private final CardsMapper cardsMapper;

    @Transactional
    public List<CardDto> fetchCardsByCustomerId(Long customerId) {
        Customer theCustomer = customersRepository.findCustomerById(customerId);
        return cardsMapper.mapToCardDtoList(
                cardsRepository.findCardsByCustomer(theCustomer));
    }
}
