package org.example.TB.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.TB.model.bo.P2PTimeAssess_volunteerInputBO;
import org.example.TB.model.bo.P2PTimeReviewTaskInputBO;
import org.example.TB.model.bo.P2PTimeVolunteer_finishOrderInputBO;
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
public class P2PTimeService {
  public static final String ABI = org.example.TB.utils.IOUtil.readResourceAsString("abi/P2PTime.abi");

  public static final String BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/ecc/P2PTime.bin");

  //public static final String SM_BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/sm/P2PTime.bin");

  @Value("${system.contract.p2PTimeAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public CallResponse owner() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "owner", Arrays.asList());
  }

  public CallResponse description() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "description", Arrays.asList());
  }

  public CallResponse deadline() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "deadline", Arrays.asList());
  }

  public TransactionResponse publish() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "publish", Arrays.asList());
  }

  public CallResponse candidate_volunteer() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "candidate_volunteer", Arrays.asList());
  }

  public CallResponse volunteer() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "volunteer", Arrays.asList());
  }

  public TransactionResponse volunteer_finishOrder(P2PTimeVolunteer_finishOrderInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "volunteer_finishOrder", input.toArgs());
  }

  public CallResponse state() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "state", Arrays.asList());
  }

  public TransactionResponse interrupt_sell() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "interrupt_sell", Arrays.asList());
  }

  public CallResponse title() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "title", Arrays.asList());
  }

  public CallResponse price() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "price", Arrays.asList());
  }

  public CallResponse auditopinion() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "auditopinion", Arrays.asList());
  }

  public TransactionResponse assess_volunteer(P2PTimeAssess_volunteerInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "assess_volunteer", input.toArgs());
  }

  public TransactionResponse applyAsVolunteer() throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "applyAsVolunteer", Arrays.asList());
  }

  public TransactionResponse reviewTask(P2PTimeReviewTaskInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "reviewTask", input.toArgs());
  }
}
