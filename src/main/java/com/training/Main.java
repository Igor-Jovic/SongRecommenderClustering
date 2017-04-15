package com.training;

import com.training.clustering.Cluster;
import com.training.clustering.KMeansTrainer;
import com.training.persistance.clusters.ClusterRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        int numberOfClusters = 100;
        List<Cluster> clusters = new KMeansTrainer("src/main/resources/AllSongs.csv", numberOfClusters)
                .trainModelWithRandomMeansFrom("src/main/resources/AllSongsWithGenres.csv")
                .getClusters();

        ClusterRepository clusterRepository = new ClusterRepository();
        clusterRepository.saveClusters(clusters);
    }
}
