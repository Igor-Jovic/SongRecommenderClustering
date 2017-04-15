package com.training.persistance.clusters;


import com.training.clustering.Cluster;
import com.training.persistance.DBConnectionPool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class ClusterRepository {

    public void saveClusters(List<Cluster> clusters) {
        try (Connection conn = DBConnectionPool.getConnection()) {
            BatchSaveOperation batchSaveOperation = new BatchSaveOperation(conn);
            for (Cluster cluster : clusters) addCluster(cluster, batchSaveOperation);
            batchSaveOperation.execute();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addCluster(Cluster cluster, BatchSaveOperation saveOperation) throws SQLException {
        int clusterId = cluster.getClusterId();
        for (String remoteId : cluster.getItems()) {
            saveOperation.withItem(remoteId, clusterId);
        }
    }
}
