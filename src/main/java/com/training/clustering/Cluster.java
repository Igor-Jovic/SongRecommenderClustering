package com.training.clustering;

import java.util.List;

public class Cluster {
    private final int clusterId;
    private final String centroid;
    private final List<String> items;
    private static int nextClusterId;

    public Cluster(String centroid, List<String> items) {
        this.clusterId = nextClusterId++;
        this.centroid = centroid;
        this.items = items;
    }

    public int getClusterId() {
        return clusterId;
    }

    public String getCentroid() {
        return centroid;
    }

    public List<String> getItems() {
        return items;
    }
}
