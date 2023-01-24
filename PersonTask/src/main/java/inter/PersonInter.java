package inter;

import models.Person;

public interface PersonInter {
    void add(Person person);
    void update(Person person);
    Person findById(int id);
    void remove(int id);
}
