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
public class TimeCoinCtorBO {
  private BigInteger _initialSupply;

  private String tokenName;

  private String tokenSymbol;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_initialSupply);
    args.add(tokenName);
    args.add(tokenSymbol);
    return args;
  }
}
