package com.training.persistance.clusters;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

class BatchSaveOperation {

    @SuppressWarnings("SqlNoDataSourceInspection")
    private static final String QUERY = "UPDATE TRACK SET CLUSTER = ? WHERE REMOTE_ID = ?";
    private PreparedStatement preparedStatement;

    BatchSaveOperation(Connection connection) throws SQLException {
        preparedStatement = connection.prepareStatement(QUERY);
    }

    void withItem(String remoteId, int clusterId) throws SQLException {
        preparedStatement.setInt(1, clusterId);
        preparedStatement.setString(2, remoteId);
        preparedStatement.addBatch();
    }

    void execute() throws SQLException {
        preparedStatement.executeBatch();
    }
}
