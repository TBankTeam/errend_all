package org.example.TB.raw;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.sdk.abi.FunctionEncoder;
import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.Bool;
import org.fisco.bcos.sdk.abi.datatypes.Event;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.Utf8String;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple2;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@SuppressWarnings("unchecked")
public class P2PTime extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b506040516200115838038062001158833981810160405260808110156200003757600080fd5b8101908080519060200190929190805160405193929190846401000000008211156200006257600080fd5b838201915060208201858111156200007957600080fd5b82518660018202830111640100000000821117156200009757600080fd5b8083526020830192505050908051906020019080838360005b83811015620000cd578082015181840152602081019050620000b0565b50505050905090810190601f168015620000fb5780820380516001836020036101000a031916815260200191505b5060405260200180519060200190929190805160405193929190846401000000008211156200012957600080fd5b838201915060208201858111156200014057600080fd5b82518660018202830111640100000000821117156200015e57600080fd5b8083526020830192505050908051906020019080838360005b838110156200019457808201518184015260208101905062000177565b50505050905090810190601f168015620001c25780820380516001836020036101000a031916815260200191505b50604052505050836000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260049080519060200190620002629291906200028d565b50816005819055508060069080519060200190620002829291906200028d565b50505050506200033c565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620002d057805160ff191683800117855562000301565b8280016001018555821562000301579182015b8281111562000300578251825591602001919060010190620002e3565b5b50905062000310919062000314565b5090565b6200033991905b80821115620003355760008160009055506001016200031b565b5090565b90565b610e0c806200034c6000396000f3fe608060405234801561001057600080fd5b50600436106100f55760003560e01c80637e74884011610097578063a035b1fe11610066578063a035b1fe14610372578063c19d93fb14610390578063dafba584146103ae578063ffb1c285146103de576100f5565b80637e748840146102f65780638da5cb5b146103145780639698c3f81461035e5780639fe8a3df14610368576100f5565b806329dcb0cf116100d357806329dcb0cf146101885780634a79d50c146101a657806371457b81146102295780637284e41614610273576100f5565b806305c2e9f1146100fa578063075d4782146101445780632918fe781461014e575b600080fd5b610102610418565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61014c61043e565b005b6101866004803603604081101561016457600080fd5b8101908080351515906020019092919080359060200190929190505050610601565b005b610190610769565b6040518082815260200191505060405180910390f35b6101ae61076f565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156101ee5780820151818401526020810190506101d3565b50505050905090810190601f16801561021b5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b61023161080d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b61027b610833565b6040518080602001828103825283818151815260200191508051906020019080838360005b838110156102bb5780820151818401526020810190506102a0565b50505050905090810190601f1680156102e85780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b6102fe6108d1565b6040518082815260200191505060405180910390f35b61031c6108d7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6103666108fd565b005b6103706109e0565b005b61037a610b63565b6040518082815260200191505060405180910390f35b610398610b69565b6040518082815260200191505060405180910390f35b6103dc600480360360208110156103c457600080fd5b81019080803515159060200190929190505050610b6f565b005b610416600480360360408110156103f457600080fd5b8101908080359060200190929190803515159060200190929190505050610c11565b005b600260009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161461049857600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166323b872dd33306005546040518463ffffffff1660e01b8152600401808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018281526020019350505050602060405180830381600087803b15801561057657600080fd5b505af115801561058a573d6000803e3d6000fd5b505050506040513d60208110156105a057600080fd5b81019080805190602001909291905050506105ba57600080fd5b6000600754146105c957600080fd5b600160078190555060007f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a2565b60016007541461061057600080fd5b8090508115610626576002600781905550610737565b60036007819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b30600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005546040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b1580156106fa57600080fd5b505af115801561070e573d6000803e3d6000fd5b505050506040513d602081101561072457600080fd5b8101908080519060200190929190505050505b60017f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a25050565b60095481565b60048054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108055780601f106107da57610100808354040283529160200191610805565b820191906000526020600020905b8154815290600101906020018083116107e857829003601f168201915b505050505081565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60068054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108c95780601f1061089e576101008083540402835291602001916108c9565b820191906000526020600020905b8154815290600101906020018083116108ac57829003601f168201915b505050505081565b60085481565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b60026007541461090c57600080fd5b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141561096757600080fd5b33600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550600460078190555060027f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a2565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610a3a57600080fd5b600360075410610a4957600080fd5b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632ccb1b30600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005546040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015610b1557600080fd5b505af1158015610b29573d6000803e3d6000fd5b505050506040513d6020811015610b3f57600080fd5b8101908080519060200190929190505050610b5957600080fd5b6008600781905550565b60055481565b60075481565b600460075414610b7e57600080fd5b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610bd857600080fd5b600560078190555060047f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a250565b600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614610c6b57600080fd5b600560075414610c7a57600080fd5b81600b819055508015610d9c5760066007819055506000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ff","ffffffffffffffffffffffffffffffffffffff16632ccb1b30600160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005546040518363ffffffff1660e01b8152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200182815260200192505050602060405180830381600087803b158015610d5b57600080fd5b505af1158015610d6f573d6000803e3d6000fd5b505050506040513d6020811015610d8557600080fd5b810190808051906020019092919050505050610da4565b600780819055505b60057f1574fcf0f1caf8105cc347b04f4c1b4e85e21a6495eb72d54bef9b144f1a72d960405160405180910390a2505056fea2646970667358221220026d908c7c1f882fbfc22f429e89f443ead69c5181d97bbda02b5ec33cd4251664736f6c634300060a0033"};

    public static final String BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {};

    public static final String SM_BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_timeCoin\",\"type\":\"address\"},{\"internalType\":\"string\",\"name\":\"_title\",\"type\":\"string\"},{\"internalType\":\"uint256\",\"name\":\"_price\",\"type\":\"uint256\"},{\"internalType\":\"string\",\"name\":\"_description\",\"type\":\"string\"}],\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":true,\"internalType\":\"uint256\",\"name\":\"t\",\"type\":\"uint256\"}],\"name\":\"Transaction_msg\",\"type\":\"event\"},{\"inputs\":[],\"name\":\"applyAsVolunteer\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"uint256\",\"name\":\"score\",\"type\":\"uint256\"},{\"internalType\":\"bool\",\"name\":\"finished\",\"type\":\"bool\"}],\"name\":\"assess_volunteer\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"auditopinion\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"candidate_volunteer\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"deadline\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"description\",\"outputs\":[{\"internalType\":\"string\",\"name\":\"\",\"type\":\"string\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"interrupt_sell\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"owner\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"price\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"publish\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"bool\",\"name\":\"passOrNot\",\"type\":\"bool\"},{\"internalType\":\"uint256\",\"name\":\"auditOpinion\",\"type\":\"uint256\"}],\"name\":\"reviewTask\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"state\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"title\",\"outputs\":[{\"internalType\":\"string\",\"name\":\"\",\"type\":\"string\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"volunteer\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"bool\",\"name\":\"finished\",\"type\":\"bool\"}],\"name\":\"volunteer_finishOrder\",\"outputs\":[],\"stateMutability\":\"nonpayable\",\"type\":\"function\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_APPLYASVOLUNTEER = "applyAsVolunteer";

    public static final String FUNC_ASSESS_VOLUNTEER = "assess_volunteer";

    public static final String FUNC_AUDITOPINION = "auditopinion";

    public static final String FUNC_CANDIDATE_VOLUNTEER = "candidate_volunteer";

    public static final String FUNC_DEADLINE = "deadline";

    public static final String FUNC_DESCRIPTION = "description";

    public static final String FUNC_INTERRUPT_SELL = "interrupt_sell";

    public static final String FUNC_OWNER = "owner";

    public static final String FUNC_PRICE = "price";

    public static final String FUNC_PUBLISH = "publish";

    public static final String FUNC_REVIEWTASK = "reviewTask";

    public static final String FUNC_STATE = "state";

    public static final String FUNC_TITLE = "title";

    public static final String FUNC_VOLUNTEER = "volunteer";

    public static final String FUNC_VOLUNTEER_FINISHORDER = "volunteer_finishOrder";

    public static final Event TRANSACTION_MSG_EVENT = new Event("Transaction_msg", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>(true) {}));
    ;

    protected P2PTime(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public List<Transaction_msgEventResponse> getTransaction_msgEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TRANSACTION_MSG_EVENT, transactionReceipt);
        ArrayList<Transaction_msgEventResponse> responses = new ArrayList<Transaction_msgEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            Transaction_msgEventResponse typedResponse = new Transaction_msgEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.t = (BigInteger) eventValues.getIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void subscribeTransaction_msgEvent(String fromBlock, String toBlock, List<String> otherTopics, EventCallback callback) {
        String topic0 = eventEncoder.encode(TRANSACTION_MSG_EVENT);
        subscribeEvent(ABI,BINARY,topic0,fromBlock,toBlock,otherTopics,callback);
    }

    public void subscribeTransaction_msgEvent(EventCallback callback) {
        String topic0 = eventEncoder.encode(TRANSACTION_MSG_EVENT);
        subscribeEvent(ABI,BINARY,topic0,callback);
    }

    public TransactionReceipt applyAsVolunteer() {
        final Function function = new Function(
                FUNC_APPLYASVOLUNTEER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] applyAsVolunteer(TransactionCallback callback) {
        final Function function = new Function(
                FUNC_APPLYASVOLUNTEER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForApplyAsVolunteer() {
        final Function function = new Function(
                FUNC_APPLYASVOLUNTEER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public TransactionReceipt assess_volunteer(BigInteger score, Boolean finished) {
        final Function function = new Function(
                FUNC_ASSESS_VOLUNTEER, 
                Arrays.<Type>asList(new Uint256(score),
                new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] assess_volunteer(BigInteger score, Boolean finished, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_ASSESS_VOLUNTEER, 
                Arrays.<Type>asList(new Uint256(score),
                new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForAssess_volunteer(BigInteger score, Boolean finished) {
        final Function function = new Function(
                FUNC_ASSESS_VOLUNTEER, 
                Arrays.<Type>asList(new Uint256(score),
                new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<BigInteger, Boolean> getAssess_volunteerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ASSESS_VOLUNTEER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<BigInteger, Boolean>(

                (BigInteger) results.get(0).getValue(), 
                (Boolean) results.get(1).getValue()
                );
    }

    public BigInteger auditopinion() throws ContractException {
        final Function function = new Function(FUNC_AUDITOPINION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public String candidate_volunteer() throws ContractException {
        final Function function = new Function(FUNC_CANDIDATE_VOLUNTEER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public BigInteger deadline() throws ContractException {
        final Function function = new Function(FUNC_DEADLINE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public String description() throws ContractException {
        final Function function = new Function(FUNC_DESCRIPTION, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public TransactionReceipt interrupt_sell() {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] interrupt_sell(TransactionCallback callback) {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForInterrupt_sell() {
        final Function function = new Function(
                FUNC_INTERRUPT_SELL, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public String owner() throws ContractException {
        final Function function = new Function(FUNC_OWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public BigInteger price() throws ContractException {
        final Function function = new Function(FUNC_PRICE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public TransactionReceipt publish() {
        final Function function = new Function(
                FUNC_PUBLISH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] publish(TransactionCallback callback) {
        final Function function = new Function(
                FUNC_PUBLISH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForPublish() {
        final Function function = new Function(
                FUNC_PUBLISH, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public TransactionReceipt reviewTask(Boolean passOrNot, BigInteger auditOpinion) {
        final Function function = new Function(
                FUNC_REVIEWTASK, 
                Arrays.<Type>asList(new Bool(passOrNot),
                new Uint256(auditOpinion)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] reviewTask(Boolean passOrNot, BigInteger auditOpinion, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_REVIEWTASK, 
                Arrays.<Type>asList(new Bool(passOrNot),
                new Uint256(auditOpinion)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForReviewTask(Boolean passOrNot, BigInteger auditOpinion) {
        final Function function = new Function(
                FUNC_REVIEWTASK, 
                Arrays.<Type>asList(new Bool(passOrNot),
                new Uint256(auditOpinion)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple2<Boolean, BigInteger> getReviewTaskInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REVIEWTASK, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple2<Boolean, BigInteger>(

                (Boolean) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public BigInteger state() throws ContractException {
        final Function function = new Function(FUNC_STATE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public String title() throws ContractException {
        final Function function = new Function(FUNC_TITLE, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public String volunteer() throws ContractException {
        final Function function = new Function(FUNC_VOLUNTEER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public TransactionReceipt volunteer_finishOrder(Boolean finished) {
        final Function function = new Function(
                FUNC_VOLUNTEER_FINISHORDER, 
                Arrays.<Type>asList(new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] volunteer_finishOrder(Boolean finished, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_VOLUNTEER_FINISHORDER, 
                Arrays.<Type>asList(new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForVolunteer_finishOrder(Boolean finished) {
        final Function function = new Function(
                FUNC_VOLUNTEER_FINISHORDER, 
                Arrays.<Type>asList(new Bool(finished)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<Boolean> getVolunteer_finishOrderInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_VOLUNTEER_FINISHORDER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public static P2PTime load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new P2PTime(contractAddress, client, credential);
    }

    public static P2PTime deploy(Client client, CryptoKeyPair credential, String _timeCoin, String _title, BigInteger _price, String _description) throws ContractException {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new Address(_timeCoin),
                new Utf8String(_title),
                new Uint256(_price),
                new Utf8String(_description)));
        return deploy(P2PTime.class, client, credential, getBinary(client.getCryptoSuite()), encodedConstructor);
    }

    public static class Transaction_msgEventResponse {
        public TransactionReceipt.Logs log;

        public BigInteger t;
    }
}
