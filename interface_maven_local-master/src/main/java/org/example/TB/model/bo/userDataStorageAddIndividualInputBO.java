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
public class userDataStorageAddIndividualInputBO {
  private String _entAddress;

  private String _name;

  private String _realid;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_entAddress);
    args.add(_name);
    args.add(_realid);
    return args;
  }
}
