package org.example.TB.model.bo;

import java.lang.Boolean;
import java.lang.Object;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P2PTimeReviewTaskInputBO {
  private Boolean passOrNot;

  private BigInteger auditOpinion;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(passOrNot);
    args.add(auditOpinion);
    return args;
  }
}
