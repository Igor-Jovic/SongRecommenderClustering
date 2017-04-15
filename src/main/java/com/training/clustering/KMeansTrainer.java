package com.training.clustering;

import com.example.SongRecommenderCore;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@SuppressWarnings("unchecked")
public class KMeansTrainer {
    private final String pathToCsv;
    private List<Cluster> clusters;
    private final int numberOfClusters;

    public KMeansTrainer(String pathToCsv, int numberOfClusters) {
        this.pathToCsv = pathToCsv;
        this.numberOfClusters = numberOfClusters;
    }

    public List<Cluster> getClusters() {
        if (clusters == null) {
            throw new IllegalStateException("Training was not performed.");
        }
        return clusters;
    }

    public KMeansTrainer trainModel() {
        Map<String, List<String>> clusteringResult = new SongRecommenderCore().performClustering(numberOfClusters, pathToCsv);
        clusters = clusteringResult.keySet().stream()
                .map(s -> new Cluster(s, clusteringResult.get(s)))
                .collect(Collectors.toList());

        return this;
    }

    public KMeansTrainer trainModelWithRandomMeansFrom(String pathToCandidates) {
        Map<String, List<String>> clusteringResult = new SongRecommenderCore()
                .performClusteringWithCentroidsWithGenres(numberOfClusters, pathToCsv, pathToCandidates);
        clusters = clusteringResult.keySet().stream()
                .map(s -> new Cluster(s, clusteringResult.get(s)))
                .collect(Collectors.toList());

        return this;
    }


}
