package org.example.TB.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.TB.model.bo.P2PTableCreateInputBO;
import org.example.TB.model.bo.P2PTableInsertInputBO;
import org.example.TB.model.bo.P2PTableSelectInputBO;
import org.example.TB.model.bo.P2PTableSetTableNameInputBO;
import org.example.TB.model.bo.P2PTableUpdateInputBO;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor;
import org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory;
import org.fisco.bcos.sdk.transaction.model.dto.CallResponse;
import org.fisco.bcos.sdk.transaction.model.dto.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@Data
public class P2PTableService {
  public static final String ABI = org.example.TB.utils.IOUtil.readResourceAsString("abi/P2PTable.abi");

  public static final String BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/ecc/P2PTable.bin");

  //public static final String SM_BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/sm/P2PTable.bin");

  @Value("${system.contract.p2PTableAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public CallResponse select(P2PTableSelectInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "select", input.toArgs());
  }

  public TransactionResponse update(P2PTableUpdateInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "update", input.toArgs());
  }

  public TransactionResponse insert(P2PTableInsertInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "insert", input.toArgs());
  }

  public TransactionResponse setTableName(P2PTableSetTableNameInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "setTableName", input.toArgs());
  }

  public CallResponse table_name() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "table_name", Arrays.asList());
  }

  public TransactionResponse create(P2PTableCreateInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "create", input.toArgs());
  }
}
