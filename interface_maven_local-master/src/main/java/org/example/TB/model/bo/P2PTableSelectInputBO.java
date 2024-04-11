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
public class P2PTableSelectInputBO {
  private String key;

  private String value;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(key);
    args.add(value);
    return args;
  }
}
