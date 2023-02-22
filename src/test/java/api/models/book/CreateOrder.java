package api.models.book;

import lombok.Data;

@Data
public class CreateOrder {
    int bookId;
    String customerName;

}
