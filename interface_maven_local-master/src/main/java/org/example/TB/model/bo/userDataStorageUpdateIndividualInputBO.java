package org.example.TB.model.bo;

import java.lang.Object;
import java.lang.String;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userDataStorageUpdateIndividualInputBO {
  private String _entAddress;

  private String key;

  private String value1;

  private BigInteger value2;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_entAddress);
    args.add(key);
    args.add(value1);
    args.add(value2);
    return args;
  }
}
