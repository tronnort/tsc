package com.tron.web.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class TestService {


    /**
     * 默认key值为传参
     *
     * */

    @Cacheable(cacheNames = "person",key = "#person1.id")
    public Person find(Person person1,String s) {
        Person person = new Person();
        person.setId("001");
        person.setName("tron");
        person.setAge(18);
        return person;
    }

    @Cacheable(cacheNames = "tron",key = "#tron.id")
    public Tron findTron(Tron tron) {
        Tron tron1 = new Tron();
        tron1.setId("002");
        return tron1;
    }

    @CachePut(cacheNames = "tron",key = "#tron.id")
    public Tron updateTron(Tron tron) {
            Tron tron1 = new Tron();
            tron1.setId("002");
            tron1.setGender("man");
            return tron1;
        }


    /**
     * allEntries = true    可以全清缓存
     * */
    @CacheEvict(cacheNames = "tron",key = "#id")
    public void deleteTron(String id) {

    }
}
