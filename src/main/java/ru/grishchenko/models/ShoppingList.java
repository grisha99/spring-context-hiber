package ru.grishchenko.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shoppinglist")
public class ShoppingList {

    @EmbeddedId
    private ShoppingListKey id;

    @Column(name = "cost")
    private double oldCost;

    @Column(name = "count")
    private int count;


}

