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
public class P2PTableUpdateInputBO {
  private String p2p_address;

  private String volunteer_address;

  private BigInteger state;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(p2p_address);
    args.add(volunteer_address);
    args.add(state);
    return args;
  }
}