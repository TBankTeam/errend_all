package org.example.TB.model.bo;

import java.lang.Boolean;
import java.lang.Object;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class P2PTimeVolunteer_finishOrderInputBO {
  private Boolean finished;

  public List<Object> toArgs() {
    List args = new ArrayList();
    args.add(finished);
    return args;
  }
}
