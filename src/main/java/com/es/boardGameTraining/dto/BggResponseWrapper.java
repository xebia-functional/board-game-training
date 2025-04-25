package com.es.boardGameTraining.dto;

import java.util.List;

public class BggResponseWrapper {
    private List<ResponseBGGAPI> items;

    public List<ResponseBGGAPI> getItems() {
        return items;
    }

    public void setItems(List<ResponseBGGAPI> items) {
        this.items = items;
    }
}
