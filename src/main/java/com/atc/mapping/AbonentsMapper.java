package com.atc.mapping;

import com.atc.entity.AbonentsEntity;
import com.atc.tableviews.TableViewAbonent;

import java.util.List;

public class AbonentsMapper extends AbstractMapper {
    private List<AbonentsEntity> entityList;
    private List list;

    public AbonentsMapper(List<AbonentsEntity> entityList, List list) {
        this.entityList =entityList;
        this.list = list;
    }

     public List map() {
        for (AbonentsEntity abonentsEntity : entityList) {

            String gender;
            if (abonentsEntity.isПол()) {
                gender = "мужской";
            } else {
                gender = "женский";
            }

            String date;
            date = abonentsEntity.getДатарождения().toString();
            TableViewAbonent tableViewAbonent = new TableViewAbonent(
                    abonentsEntity.getId(),
                    abonentsEntity.getИмя(),
                    abonentsEntity.getФамилия(),
                    abonentsEntity.getОтчество(),
                    date,
                    gender);
            list.add(tableViewAbonent);
        }
        return list;
    }


}
