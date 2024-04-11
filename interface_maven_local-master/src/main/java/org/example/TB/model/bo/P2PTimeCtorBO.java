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
public class P2PTimeCtorBO {
  private String _timeCoin;

  private String _title;

  private BigInteger _price;

  private String _description;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(_timeCoin);
    args.add(_title);
    args.add(_price);
    args.add(_description);
    return args;
  }
}
