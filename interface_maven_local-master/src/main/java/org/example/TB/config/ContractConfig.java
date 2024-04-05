package org.example.TB.config;

import java.lang.String;
import lombok.Data;

@Data
public class ContractConfig {
  private String timeCoinAddress;

  private String p2PTimeAddress;

  private String tableAddress;

  private String p2PTableAddress;

  private String userDataStorageAddress;
}
