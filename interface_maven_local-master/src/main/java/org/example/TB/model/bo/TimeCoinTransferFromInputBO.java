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
public class TimeCoinTransferFromInputBO {
  private String _from;

  private String _to;

  private BigInteger _value;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_from);
    args.add(_to);
    args.add(_value);
    return args;
  }
}
