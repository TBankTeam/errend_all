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
public class TimeCoinApproveAndCallInputBO {
  private String _spender;

  private BigInteger _value;

  private byte[] _extraData;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_spender);
    args.add(_value);
    args.add(_extraData);
    return args;
  }
}
