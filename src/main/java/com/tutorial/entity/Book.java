package com.tutorial.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

@Getter
@Setter
@DynamoDbBean
@NoArgsConstructor
public class Book {

    private String id;
    private String title;
    private String author;
    private String isbn;

    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }
}
