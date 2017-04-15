package com.training.clustering;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class KMeansTrainerTest {

    @Test(expected = IllegalStateException.class)
    public void getClusters_modelNotTrained_illegalState() {
        KMeansTrainer kMeansTrainer = new KMeansTrainer("src/10KSongs.csv", 5);
        kMeansTrainer.getClusters();
    }

    @Test
    public void getClusters_modelTrained_returnsClusters() {
        int numberOfClusters = 5;
        List<Cluster> clusters = new KMeansTrainer("src/10KSongs.csv", numberOfClusters)
                .trainModel()
                .getClusters();

        assertEquals(numberOfClusters, clusters.size());
    }
}