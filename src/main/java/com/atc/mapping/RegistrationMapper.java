package com.atc.mapping;

import com.atc.entity.PhonesEntity;
import com.atc.entity.RegistrationEntity;
import com.atc.tableviews.TableViewRegistration;

import java.util.List;

public class RegistrationMapper extends AbstractMapper{

    private List<RegistrationEntity> entityList;
    private List list;

    public RegistrationMapper(List<RegistrationEntity> entityList, List list) {
        this.entityList = entityList;
        this.list = list;
    }

    @Override
    public List map() {
        for (RegistrationEntity entity: entityList){
            String date = String.valueOf(entity.getДатаРегистрации());
            list.add(new TableViewRegistration(entity.getId(),entity.getОператорыByIdОператор().getИмя(),entity.getТелефоныByНомерТелефона().getНомер(),date));
        }

        return list;
    }
}
