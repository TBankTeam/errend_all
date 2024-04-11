package org.example.TB.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.TB.model.bo.TimeCoinAllowanceInputBO;
import org.example.TB.model.bo.TimeCoinApproveAndCallInputBO;
import org.example.TB.model.bo.TimeCoinApproveInputBO;
import org.example.TB.model.bo.TimeCoinBalanceOfInputBO;
import org.example.TB.model.bo.TimeCoinBurnFromInputBO;
import org.example.TB.model.bo.TimeCoinBurnInputBO;
import org.example.TB.model.bo.TimeCoinInitial_balanceInputBO;
import org.example.TB.model.bo.TimeCoinTransferFromInputBO;
import org.example.TB.model.bo.TimeCoinTransferToInputBO;
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
public class TimeCoinService {
  public static final String ABI = org.example.TB.utils.IOUtil.readResourceAsString("abi/TimeCoin.abi");

  public static final String BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/ecc/TimeCoin.bin");

  //public static final String SM_BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/sm/TimeCoin.bin");

  @Value("${system.contract.timeCoinAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public CallResponse decimals() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "decimals", Arrays.asList());
  }

  public TransactionResponse burnFrom(TimeCoinBurnFromInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "burnFrom", input.toArgs());
  }

  public CallResponse symbol() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "symbol", Arrays.asList());
  }

  public CallResponse getInitialSupply() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getInitialSupply", Arrays.asList());
  }

  public TransactionResponse transferFrom(TimeCoinTransferFromInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "transferFrom", input.toArgs());
  }

  public CallResponse getAdmin() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "getAdmin", Arrays.asList());
  }

  public TransactionResponse initial_balance(TimeCoinInitial_balanceInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "initial_balance", input.toArgs());
  }

  public CallResponse balanceOf(TimeCoinBalanceOfInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "balanceOf", input.toArgs());
  }

  public CallResponse totalSupply() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "totalSupply", Arrays.asList());
  }

  public TransactionResponse approve(TimeCoinApproveInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "approve", input.toArgs());
  }

  public CallResponse allowance(TimeCoinAllowanceInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "allowance", input.toArgs());
  }

  public TransactionResponse approveAndCall(TimeCoinApproveAndCallInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "approveAndCall", input.toArgs());
  }

  public CallResponse name() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "name", Arrays.asList());
  }

  public TransactionResponse burn(TimeCoinBurnInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "burn", input.toArgs());
  }

  public TransactionResponse transferTo(TimeCoinTransferToInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "transferTo", input.toArgs());
  }
}
