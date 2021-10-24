package com.kodilla.cards.repository;

import com.kodilla.cards.domain.Card;
import com.kodilla.cards.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CardsRepository extends JpaRepository<Card, Integer> {
    Card findCardByCustomer(Customer customer);
    List<Card> findCardsByCustomer(Customer customer);
    Card save(Card card);
}
