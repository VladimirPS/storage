package ru.pecherskiy.storage.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;
@Data
public class Product {
    @Id
    Long id;
    String name;
    String description;
    Date created;
    Integer place_storage;
    Boolean reserved;


}
