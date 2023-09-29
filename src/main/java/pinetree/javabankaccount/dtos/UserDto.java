package pinetree.javabankaccount.dtos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import pinetree.javabankaccount.domain.model.Account;
import pinetree.javabankaccount.domain.model.Card;
import pinetree.javabankaccount.domain.model.Feature;
import pinetree.javabankaccount.domain.model.News;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class UserDto {
    private UUID id;

    private String name;

    private Account account;

    private Card card;

    private List<Feature> features;

    private List<News> news;
}
