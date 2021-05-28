package io.tidb.bigdata.mapreduce.tidb;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.InputSplit;

public class TiDBInputSplit extends InputSplit implements Writable {
  private String startKey;
  private String endKey;
  private String connectorId;
  private String schemaName;
  private String tableName;

  public TiDBInputSplit(){

  }

  public TiDBInputSplit(String startKey, String endKey, String connectorId,
      String schemaName, String tableName) {
    this.startKey = startKey;
    this.endKey = endKey;
    this.connectorId = connectorId;
    this.schemaName = schemaName;
    this.tableName = tableName;
  }

  public String getStartKey() {
    return startKey;
  }

  public String getEndKey() {
    return endKey;
  }

  public String getConnectorId() {
    return connectorId;
  }

  public String getSchemaName() {
    return schemaName;
  }

  public String getTableName() {
    return tableName;
  }

  @Override
  public long getLength() {
    return 0;
  }

  @Override
  public String[] getLocations() {
    return new String[0];
  }

  @Override
  public void write(DataOutput out) throws IOException {
    out.writeUTF(startKey);
    out.writeUTF(endKey);
    out.writeUTF(connectorId);
    out.writeUTF(schemaName);
    out.writeUTF(tableName);
  }

  @Override
  public void readFields(DataInput in) throws IOException {
    this.startKey = in.readUTF();
    this.endKey = in.readUTF();
    this.connectorId = in.readUTF();
    this.schemaName = in.readUTF();
    this.tableName = in.readUTF();
  }

}
