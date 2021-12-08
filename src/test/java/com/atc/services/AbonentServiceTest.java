package com.atc.services;

import com.atc.entity.AbonentsEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbonentServiceTest {
    @Test
    void tryFindAbonents(){
        AbonentService abonentService = new AbonentService();
        List<AbonentsEntity> testList = abonentService.findByInitials("4","4","4");
        for(AbonentsEntity test : testList){
            System.out.println(test.getId());
            System.out.println(test.getИмя());
            System.out.println(test.getФамилия());
            System.out.println(test.getОтчество());
            System.out.println(test.getДатарождения());
            System.out.println(test.isПол());
            System.out.println("_________________________________________");
        }
        Integer minCount=0;
        Integer actualCount = testList.size();
        assertNotEquals(minCount,actualCount);
//        System.err.println("Elements in database not found. Try change search criteria or check query to database.");
    }

}