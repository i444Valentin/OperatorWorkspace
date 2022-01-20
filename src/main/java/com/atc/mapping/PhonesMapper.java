package com.atc.mapping;

import com.atc.entity.PhonesEntity;
import com.atc.tableviews.TableViewPhone;

import java.util.List;

public class PhonesMapper extends AbstractMapper {
    private List<PhonesEntity> entityList;
    private List list;

    public PhonesMapper(List<PhonesEntity> entityList, List list) {
        this.entityList = entityList;
        this.list = list;
    }

    public List map() {
        for (PhonesEntity entity : entityList) {
            String abonentFirstName = entity.getАбонентыByIdАбонент().getИмя();
            String abonentLastName = entity.getАбонентыByIdАбонент().getФамилия();
            String abonentPatronymic = entity.getАбонентыByIdАбонент().getОтчество();

            String abonentInitials = abonentFirstName.trim() + " " + abonentLastName.trim() + " " + abonentPatronymic.trim();
            boolean mountType = entity.getУстановкиByНомер().isТипУстановки();
            String mountTypeString;
            if(mountType){
                mountTypeString = "спаренный";
            }else{
                mountTypeString = "неспаренный";
            }

            TableViewPhone tableViewPhone = new TableViewPhone(entity.getНомер(),
                    abonentInitials,
                    entity.getТипыТелефоновByIdТипТелефона().getТипТелефона(),
                    entity.getТарифыByТариф().getНазваниеТарифа(),
                    entity.getЛьгота(),
                    entity.getАбонентыByIdАбонент().getId(),
                    entity.getУстановкиByНомер().getДатаУстановки().toString(),
                    mountTypeString
                    );
            list.add(tableViewPhone);
        }
        return list;
    }
}
