package io.tidb.bigdata.mapreduce.tidb;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface TiDBWritable {
  /**
   * Reads the fields of the object from the {@link ResultSet}.
   * @param resultSet the {@link ResultSet} to get the fields from.
   */
  void readFields(ResultSet resultSet) throws SQLException;
}
