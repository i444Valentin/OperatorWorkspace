package com.atc.mapping;

import com.atc.entity.TariffsEntity;
import com.atc.tableviews.TableViewTariff;

import java.util.List;

public class TariffsMapper extends AbstractMapper{
    private List<TariffsEntity> entityList;
    private List list;

    public TariffsMapper(List<TariffsEntity> entityList, List list) {
        this.entityList = entityList;
        this.list = list;
    }
    @Override
    public List map() {
        for (TariffsEntity entity : entityList) {
            TableViewTariff tableViewTariff = new TableViewTariff(entity.getНазваниеТарифа(),entity.getЦена(),entity.getКоличествоМинут());
            list.add(tableViewTariff);

        }
        return list;
    }
}
