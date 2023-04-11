package com.example.app.CarServiceApplication.services;

import com.example.app.CarServiceApplication.data.Database;
import com.example.app.CarServiceApplication.data.Owner;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private Database database = new Database();

    public List<Owner> findAll() {
        return database.getOwnerArrayList();
    }

    public Owner findById(long id) {
        for (int i = 0; i < database.getOwnerArrayList().size(); i++) {
            if (database.getOwnerArrayList().get(i).getId() == (id)) {
                return database.getOwnerArrayList().get(i);
            }
        }
        return null;
    }

    public void save(Owner owner) {
        database.setownerArrayList(owner);
    }

//    public void deleteAll() {
//        database.getOwnerArrayList().clear();
//    }

    public void deleteByID(long id) {
        database.getOwnerArrayList().remove(findById(id));
    }

    public void update(long id, Owner owner) {
        Owner toUpdateOwner = findById(id);
        toUpdateOwner.setId(owner.getId());
        toUpdateOwner.setName(owner.getName());

    }
}
