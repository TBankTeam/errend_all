package org.example.TB.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.TB.model.bo.userDataStorageAddIndividualInputBO;
import org.example.TB.model.bo.userDataStorageDeleteIndividualInputBO;
import org.example.TB.model.bo.userDataStorageGetIndividualByIndexInputBO;
import org.example.TB.model.bo.userDataStorageGetIndividualInputBO;
import org.example.TB.model.bo.userDataStorageIndividualAddressesInputBO;
import org.example.TB.model.bo.userDataStorageIndividualsInputBO;
import org.example.TB.model.bo.userDataStorageIsDeletedInputBO;
import org.example.TB.model.bo.userDataStorageIsExitAddressInputBO;
import org.example.TB.model.bo.userDataStorageUpdateIndividualInputBO;
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
public class userDataStorageService {
  public static final String ABI = org.example.TB.utils.IOUtil.readResourceAsString("abi/userDataStorage.abi");

  public static final String BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/ecc/userDataStorage.bin");

  //public static final String SM_BINARY = org.example.TB.utils.IOUtil.readResourceAsString("bin/sm/userDataStorage.bin");

  @Value("${system.contract.userDataStorageAddress}")
  private String address;

  @Autowired
  private Client client;

  AssembleTransactionProcessor txProcessor;

  @PostConstruct
  public void init() throws Exception {
    this.txProcessor = TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, this.client.getCryptoSuite().getCryptoKeyPair());
  }

  public TransactionResponse AddIndividual(userDataStorageAddIndividualInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "AddIndividual", input.toArgs());
  }

  public CallResponse IsExitAddress(userDataStorageIsExitAddressInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "IsExitAddress", input.toArgs());
  }

  public CallResponse GetIndividual(userDataStorageGetIndividualInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "GetIndividual", input.toArgs());
  }

  public CallResponse IsDeleted(userDataStorageIsDeletedInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "IsDeleted", input.toArgs());
  }

  public CallResponse individuals(userDataStorageIndividualsInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "individuals", input.toArgs());
  }

  public CallResponse individualAddresses(userDataStorageIndividualAddressesInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "individualAddresses", input.toArgs());
  }

  public CallResponse GetIndividualByIndex(userDataStorageGetIndividualByIndexInputBO input) throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "GetIndividualByIndex", input.toArgs());
  }

  public CallResponse GetIndividualCount() throws Exception {
    return this.txProcessor.sendCall(this.client.getCryptoSuite().getCryptoKeyPair().getAddress(), this.address, ABI, "GetIndividualCount", Arrays.asList());
  }

  public TransactionResponse DeleteIndividual(userDataStorageDeleteIndividualInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "DeleteIndividual", input.toArgs());
  }

  public TransactionResponse UpdateIndividual(userDataStorageUpdateIndividualInputBO input) throws Exception {
    return this.txProcessor.sendTransactionAndGetResponse(this.address, ABI, "UpdateIndividual", input.toArgs());
  }
}
