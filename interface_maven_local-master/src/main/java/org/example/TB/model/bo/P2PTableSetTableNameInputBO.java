package org.example.TB.model.bo;

import java.lang.Object;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P2PTableSetTableNameInputBO {
  private String _tableName;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_tableName);
    return args;
  }
}
