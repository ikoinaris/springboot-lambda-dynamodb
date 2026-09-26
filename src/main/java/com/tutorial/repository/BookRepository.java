package com.tutorial.repository;

import com.tutorial.entity.Book;
import org.springframework.stereotype.Repository;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbTable;
import software.amazon.awssdk.enhanced.dynamodb.Key;
import software.amazon.awssdk.enhanced.dynamodb.TableSchema;

import java.util.List;

@Repository
public class BookRepository {

    private final DynamoDbTable<Book> bookTable;

    public BookRepository(DynamoDbEnhancedClient enhancedClient) {
        this.bookTable = enhancedClient.table("Books", TableSchema.fromBean(Book.class));
    }

    public void save(Book book) {
        bookTable.putItem(book);
    }

    public Book findById(String id) {
        return bookTable.getItem(Key.builder().partitionValue(id).build());}

    public List<Book> findAll() {
        return bookTable.scan().items().stream().toList();
    }

    public void deleteById(String id) {
        bookTable.deleteItem(Key.builder().partitionValue(id).build());
    }
}
