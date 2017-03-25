package com.vine.blog.domain.common;


import com.vine.blog.domain.entity.catalog.Category;
import com.vine.blog.domain.entity.catalog.Partition;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    private Partition partition;

    private List<Category> categories = new ArrayList<>();

    public Partition getPartition() {
        return partition;
    }

    public void setPartition(Partition partition) {
        this.partition = partition;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }
}
