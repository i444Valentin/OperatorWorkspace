package com.atc.services;

import com.atc.entity.AbonentsEntity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbonentServiceTest {
    @Test
    void tryFindAbonents(){
        AbonentService abonentService = new AbonentService();
        List<AbonentsEntity> testList = abonentService.findByInitials("","Иванов","");
        for(AbonentsEntity test : testList){
            System.out.println(test.getId());
            System.out.println(test.getИмя());
            System.out.println(test.getФамилия());
            System.out.println(test.getОтчество());
            System.out.println(test.getДатарождения());
            System.out.println(test.isПол());
            System.out.println("_________________________________________");
        }
        assertNotNull(testList);
    }

}