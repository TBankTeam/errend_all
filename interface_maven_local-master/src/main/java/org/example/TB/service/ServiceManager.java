package org.example.TB.service;

import java.lang.Exception;
import java.lang.String;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.example.TB.config.SystemConfig;
import org.fisco.bcos.sdk.client.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Data
@Slf4j
public class ServiceManager {
  @Autowired
  private SystemConfig config;

  @Autowired
  private Client client;

  List<String> hexPrivateKeyList;

  @PostConstruct
  public void init() {
    hexPrivateKeyList = Arrays.asList(this.config.getHexPrivateKey().split(","));
  }

  /**
   * @notice: must use @Qualifier("userDataStorageService") with @Autowired to get this Bean
   */
  @Bean("userDataStorageService")
  public Map<String, userDataStorageService> inituserDataStorageServiceManager() throws Exception {
    Map<String, userDataStorageService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	userDataStorageService userDataStorageService = new userDataStorageService();
    	userDataStorageService.setAddress(this.config.getContract().getUserDataStorageAddress());
    	userDataStorageService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	userDataStorageService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, userDataStorageService);
    }
    log.info("++++++++userDataStorageService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("TimeCoinService") with @Autowired to get this Bean
   */
  @Bean("TimeCoinService")
  public Map<String, TimeCoinService> initTimeCoinServiceManager() throws Exception {
    Map<String, TimeCoinService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	TimeCoinService timeCoinService = new TimeCoinService();
    	timeCoinService.setAddress(this.config.getContract().getTimeCoinAddress());
    	timeCoinService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	timeCoinService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, timeCoinService);
    }
    log.info("++++++++TimeCoinService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("TableService") with @Autowired to get this Bean
   */
  @Bean("TableService")
  public Map<String, TableService> initTableServiceManager() throws Exception {
    Map<String, TableService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	TableService tableService = new TableService();
    	tableService.setAddress(this.config.getContract().getTableAddress());
    	tableService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	tableService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, tableService);
    }
    log.info("++++++++TableService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("P2PTimeService") with @Autowired to get this Bean
   */
  @Bean("P2PTimeService")
  public Map<String, P2PTimeService> initP2PTimeServiceManager() throws Exception {
    Map<String, P2PTimeService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	P2PTimeService p2PTimeService = new P2PTimeService();
    	p2PTimeService.setAddress(this.config.getContract().getP2PTimeAddress());
    	p2PTimeService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	p2PTimeService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, p2PTimeService);
    }
    log.info("++++++++P2PTimeService map:{}", serviceMap);
    return serviceMap;
  }

  /**
   * @notice: must use @Qualifier("P2PTableService") with @Autowired to get this Bean
   */
  @Bean("P2PTableService")
  public Map<String, P2PTableService> initP2PTableServiceManager() throws Exception {
    Map<String, P2PTableService> serviceMap = new ConcurrentHashMap<>(this.hexPrivateKeyList.size());
    for (int i = 0; i < this.hexPrivateKeyList.size(); i++) {
    	String privateKey = this.hexPrivateKeyList.get(i);
    	if (privateKey.startsWith("0x") || privateKey.startsWith("0X")) {
    		privateKey = privateKey.substring(2);
    	}
    	if (privateKey.isEmpty()) {
    		continue;
    	}
    	org.fisco.bcos.sdk.crypto.CryptoSuite cryptoSuite = new org.fisco.bcos.sdk.crypto.CryptoSuite(this.client.getCryptoType());
    	org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair cryptoKeyPair = cryptoSuite.createKeyPair(privateKey);
    	String userAddress = cryptoKeyPair.getAddress();
    	log.info("++++++++hexPrivateKeyList[{}]:{},userAddress:{}", i, privateKey, userAddress);
    	P2PTableService p2PTableService = new P2PTableService();
    	p2PTableService.setAddress(this.config.getContract().getP2PTableAddress());
    	p2PTableService.setClient(this.client);
    	org.fisco.bcos.sdk.transaction.manager.AssembleTransactionProcessor txProcessor = 
    		org.fisco.bcos.sdk.transaction.manager.TransactionProcessorFactory.createAssembleTransactionProcessor(this.client, cryptoKeyPair);
    	p2PTableService.setTxProcessor(txProcessor);
    	serviceMap.put(userAddress, p2PTableService);
    }
    log.info("++++++++P2PTableService map:{}", serviceMap);
    return serviceMap;
  }
}
