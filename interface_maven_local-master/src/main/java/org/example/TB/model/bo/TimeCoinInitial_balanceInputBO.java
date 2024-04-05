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
public class TimeCoinInitial_balanceInputBO {
  private String user;

  private BigInteger initial_coin;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(user);
    args.add(initial_coin);
    return args;
  }
}
