
package com.example.app.CarServiceApplication.services;

import com.example.app.CarServiceApplication.data.Database;
import com.example.app.CarServiceApplication.data.Part;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartService {
    private Database database = new Database();

    public List<Part> findAll() {
        return database.getBookArrayList();
    }

    public Part findById(Long id) {
        for (int i = 0; i < database.getBookArrayList().size(); i++) {
            if (database.getBookArrayList().get(i).getId() == (id)) {
                return database.getBookArrayList().get(i);
            }
        }
        return null;
    }

    public void save(Part book) {
        database.setBookArrayList(book);
    }

//    public void deleteAll() {
//        database.getBookArrayList().clear();
//    }

    public void delete(Long id) {
        database.getBookArrayList().remove(findById(id));
    }

    public void update(Long id, Part book) {
        Part toUpdateBook = findById(id);
        toUpdateBook.setId(book.getId());
        toUpdateBook.setTitle(book.getTitle());
        toUpdateBook.setYear(book.getYear());
    }
}
