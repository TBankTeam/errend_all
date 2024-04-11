package org.example.TB.raw;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.fisco.bcos.sdk.abi.FunctionReturnDecoder;
import org.fisco.bcos.sdk.abi.TypeReference;
import org.fisco.bcos.sdk.abi.datatypes.Address;
import org.fisco.bcos.sdk.abi.datatypes.Bool;
import org.fisco.bcos.sdk.abi.datatypes.Function;
import org.fisco.bcos.sdk.abi.datatypes.Type;
import org.fisco.bcos.sdk.abi.datatypes.Utf8String;
import org.fisco.bcos.sdk.abi.datatypes.generated.Uint256;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple1;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple3;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple4;
import org.fisco.bcos.sdk.abi.datatypes.generated.tuples.generated.Tuple6;
import org.fisco.bcos.sdk.client.Client;
import org.fisco.bcos.sdk.contract.Contract;
import org.fisco.bcos.sdk.crypto.CryptoSuite;
import org.fisco.bcos.sdk.crypto.keypair.CryptoKeyPair;
import org.fisco.bcos.sdk.model.CryptoType;
import org.fisco.bcos.sdk.model.TransactionReceipt;
import org.fisco.bcos.sdk.model.callback.TransactionCallback;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;

@SuppressWarnings("unchecked")
public class UserDataStorage extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50611b96806100206000396000f3fe608060405234801561001057600080fd5b506004361061009e5760003560e01c8063ae2c69da11610066578063ae2c69da14610521578063b4b390491461057d578063b967993114610703578063cd68248a1461075f578063d7d3380e146107bb5761009e565b80632224e849146100a357806347bb554414610111578063568e6536146102485780637a7a2ccf1461038e578063944a2cc0146103ac575b600080fd5b6100cf600480360360208110156100b957600080fd5b810190808035906020019092919050505061094f565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6101536004803603602081101561012757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061098b565b604051808060200180602001858152602001848152602001838103835287818151815260200191508051906020019080838360005b838110156101a3578082015181840152602081019050610188565b50505050905090810190601f1680156101d05780820380516001836020036101000a031916815260200191505b50838103825286818151815260200191508051906020019080838360005b838110156102095780820151818401526020810190506101ee565b50505050905090810190601f1680156102365780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b6102746004803603602081101561025e57600080fd5b8101908080359060200190929190505050610c60565b604051808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020018060200180602001838103835285818151815260200191508051906020019080838360005b838110156102ea5780820151818401526020810190506102cf565b50505050905090810190601f1680156103175780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610350578082015181840152602081019050610335565b50505050905090810190601f16801561037d5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b610396610f58565b6040518082815260200191505060405180910390f35b6103ee600480360360208110156103c257600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610f65565b604051808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018060200186815260200185815260200184151515158152602001838103835288818151815260200191508051906020019080838360005b8381101561047a57808201518184015260208101905061045f565b50505050905090810190601f1680156104a75780820380516001836020036101000a031916815260200191505b50838103825287818151815260200191508051906020019080838360005b838110156104e05780820151818401526020810190506104c5565b50505050905090810190601f16801561050d5780820380516001836020036101000a031916815260200191505b509850505050505050505060405180910390f35b6105636004803603602081101561053757600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506110fe565b604051808215151515815260200191505060405180910390f35b6106ed6004803603606081101561059357600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001906401000000008111156105d057600080fd5b8201836020820111156105e257600080fd5b8035906020019184600183028401116401000000008311171561060457600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192908035906020019064010000000081111561066757600080fd5b82018360208201111561067957600080fd5b8035906020019184600183028401116401000000008311171561069b57600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f8201169050808301925050505050505091929192905050506111d8565b6040518082815260200191505060405180910390f35b6107456004803603602081101561071957600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061157a565b604051808215151515815260200191505060405180910390f35b6107a16004803603602081101561077557600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506115f6565b604051808215151515815260200191505060405180910390f35b610935600480360360808110156107d157600080fd5b81019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291908035906020019064010000000081111561080e57600080fd5b82018360208201111561082057600080fd5b8035906020019184600183028401116401000000008311171561084257600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001906401000000008111156108a557600080fd5b8201836020820111156108b757600080fd5b803590602001918460018302840111640100000000831117156108d957600080fd5b91908080601f016020809104026020016040519081016040528093929190818152602001838380828437600081840152601f19601f820116905080830192505050505050509192919290803590602001909291905050506116bd565b604051808215151515815260200191505060405180910390f35b6001818154811061095c57fe5b906000526020600020016000915054906101000a900473ffffffffffffffffffffffffffffffffffffffff1681565b6060806000806001151561099e866115f6565b151514610a13576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f496e646976696475616c206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b6000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001016000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002016000808873ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600301546000808973ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060040154838054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610bae5780601f10610b8357610100808354040283529160200191610bae565b820191906000526020600020905b815481529060010190602001808311610b9157829003601f168201915b50505050509350828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c4a5780601f10610c1f57610100808354040283529160200191610c4a565b820191906000526020600020905b815481529060010190602001808311610c2d57829003601f168201915b5050505050925093509350935093509193509193565b60006060806000841080610c7957506001805490508410155b610ceb576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260158152602001807f496e646578206973206f7574206f662072616e6765000000000000000000000081525060200191505060405180910390fd5b60018481548110610cf857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660008060018781548110610d3357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060010160008060018881548110610dab57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600201818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610ea85780601f10610e7d57610100808354040283529160200191610ea8565b820191906000526020600020905b815481529060010190602001808311610e8b57829003601f168201915b50505050509150808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610f445780601f10610f1957610100808354040283529160200191610f44565b820191906000526020600020905b815481529060010190602001808311610f2757829003601f168201915b505050505090509250925092509193909250565b6000600180549050905090565b60006020528060005260406000206000915090508060000160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690806001018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116","156101000203166002900480156110375780601f1061100c57610100808354040283529160200191611037565b820191906000526020600020905b81548152906001019060200180831161101a57829003601f168201915b505050505090806002018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156110d55780601f106110aa576101008083540402835291602001916110d5565b820191906000526020600020905b8154815290600101906020018083116110b857829003601f168201915b5050505050908060030154908060040154908060050160009054906101000a900460ff16905086565b60006001151561110d836115f6565b151514611182576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f496e646976696475616c206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b6000808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060050160009054906101000a900460ff169050919050565b60006111e3846115f6565b15611256576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f496e646976696475616c20616c7265616479206578697374730000000000000081525060200191505060405180910390fd5b60008090505b600180549050811015611332578473ffffffffffffffffffffffffffffffffffffffff166001828154811061128d57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161415611325576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526023815260200180611b3e6023913960400191505060405180910390fd5b808060010191505061125c565b506001849080600181540180825580915050600190039060005260206000200160009091909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550836000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060000160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550826000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600101908051906020019061146b929190611a98565b50816000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060020190805190602001906114c1929190611a98565b5060018080549050036000808673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206004018190555060008060008673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060050160006101000a81548160ff021916908315150217905550600180805490500390509392505050565b6000611585826115f6565b61159257600090506115f1565b60016000808473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060050160006101000a81548160ff021916908315150217905550600190505b919050565b600080600180549050141561160e57600090506116b8565b8173ffffffffffffffffffffffffffffffffffffffff1660016000808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001908152602001600020600401548154811061167357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff161490505b919050565b6000600115156116cc866115f6565b151514611741576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f496e646976696475616c206973206e6f7420657869746564000000000000000081525060200191505060405180910390fd5b60405160200180807f6e616d6500000000000000000000000000000000000000000000000000000000815250600401905060405160208183030381529060405280519060200120846040516020018082805190602001908083835b602083106117bf578051825260208201915060208101905060208303925061179c565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405160208183030381529060405280519060200120141561185f57826000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206001019080519060200190611855929190611a98565b5060019050611a90565b60405160200180807f7265616c69640000000000000000000000000000000000000000000000000000815250600601905060405160208183030381529060405280519060200120846040516020018082805190602001908083835b602083106118dd57805182526020820191506020810190506020830392506118ba565b6001836020036101000a03801982511681845116808217855250505050505090500191505060405160208183030381529060405280519060200120141561197d57826000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206002019080519060200190611973929190611a98565b5060019050611a90565b60405160200180807f73636f7265000000000000000000000000000000000000000000000000000000815250600501905060405160208183030381529060405280519060200120846040516020018082805190602001908083835b602083106119fb57805182526020820191506020810190506020830392506119d8565b6001836020036101000a038019825116818451168082178552505050505050905001915050604051602081830303815290604052805190602001201415611a8b57816000808773ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019081526020016000206003018190555060019050611a90565b600090505b949350505050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10611ad957805160ff1916838001178555611b07565b82800160010185558215611b07579182015b82811115611b06578251825591602001919060010190611aeb565b5b509050611b149190611b18565b5090565b611b3a91905b80821115611b36576000816000905550600101611b1e565b5090565b9056fe44656275673a204164647265737320616c726561647920696e20746865206172726179a2646970667358221220283d17334c8a7cd43b52612b62ac8fb0848d6764ccd28d4bd75bb0caeab0d73c64736f6c634300060a0033"};

    public static final String BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", BINARY_ARRAY);

    public static final String[] SM_BINARY_ARRAY = {};

    public static final String SM_BINARY = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", SM_BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_entAddress\",\"type\":\"address\"},{\"internalType\":\"string\",\"name\":\"_name\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"_realid\",\"type\":\"string\"}],\"name\":\"AddIndividual\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"index\",\"type\":\"uint256\"}],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"DeleteIndividual\",\"outputs\":[{\"internalType\":\"bool\",\"name\":\"isSuccess\",\"type\":\"bool\"}],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"GetIndividual\",\"outputs\":[{\"internalType\":\"string\",\"name\":\"name\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"realid\",\"type\":\"string\"},{\"internalType\":\"uint256\",\"name\":\"score\",\"type\":\"uint256\"},{\"internalType\":\"uint256\",\"name\":\"index\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"uint256\",\"name\":\"index\",\"type\":\"uint256\"}],\"name\":\"GetIndividualByIndex\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"entAddress\",\"type\":\"address\"},{\"internalType\":\"string\",\"name\":\"name\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"realid\",\"type\":\"string\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"name\":\"GetIndividualCount\",\"outputs\":[{\"internalType\":\"uint256\",\"name\":\"count\",\"type\":\"uint256\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_entAddress\",\"type\":\"address\"}],\"name\":\"IsDeleted\",\"outputs\":[{\"internalType\":\"bool\",\"name\":\"isDeleted\",\"type\":\"bool\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_enterAddress\",\"type\":\"address\"}],\"name\":\"IsExitAddress\",\"outputs\":[{\"internalType\":\"bool\",\"name\":\"isExited\",\"type\":\"bool\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"_entAddress\",\"type\":\"address\"},{\"internalType\":\"string\",\"name\":\"key\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"value1\",\"type\":\"string\"},{\"internalType\":\"uint256\",\"name\":\"value2\",\"type\":\"uint256\"}],\"name\":\"UpdateIndividual\",\"outputs\":[{\"internalType\":\"bool\",\"name\":\"success\",\"type\":\"bool\"}],\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"uint256\",\"name\":\"\",\"type\":\"uint256\"}],\"name\":\"individualAddresses\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[{\"internalType\":\"address\",\"name\":\"\",\"type\":\"address\"}],\"name\":\"individuals\",\"outputs\":[{\"internalType\":\"address\",\"name\":\"individualAddress\",\"type\":\"address\"},{\"internalType\":\"string\",\"name\":\"name\",\"type\":\"string\"},{\"internalType\":\"string\",\"name\":\"realid\",\"type\":\"string\"},{\"internalType\":\"uint256\",\"name\":\"score\",\"type\":\"uint256\"},{\"internalType\":\"uint256\",\"name\":\"index\",\"type\":\"uint256\"},{\"internalType\":\"bool\",\"name\":\"isDeleted\",\"type\":\"bool\"}],\"stateMutability\":\"view\",\"type\":\"function\"}]"};

    public static final String ABI = org.fisco.bcos.sdk.utils.StringUtils.joinAll("", ABI_ARRAY);

    public static final String FUNC_ADDINDIVIDUAL = "AddIndividual";

    public static final String FUNC_DELETEINDIVIDUAL = "DeleteIndividual";

    public static final String FUNC_GETINDIVIDUAL = "GetIndividual";

    public static final String FUNC_GETINDIVIDUALBYINDEX = "GetIndividualByIndex";

    public static final String FUNC_GETINDIVIDUALCOUNT = "GetIndividualCount";

    public static final String FUNC_ISDELETED = "IsDeleted";

    public static final String FUNC_ISEXITADDRESS = "IsExitAddress";

    public static final String FUNC_UPDATEINDIVIDUAL = "UpdateIndividual";

    public static final String FUNC_INDIVIDUALADDRESSES = "individualAddresses";

    public static final String FUNC_INDIVIDUALS = "individuals";

    protected UserDataStorage(String contractAddress, Client client, CryptoKeyPair credential) {
        super(getBinary(client.getCryptoSuite()), contractAddress, client, credential);
    }

    public static String getBinary(CryptoSuite cryptoSuite) {
        return (cryptoSuite.getCryptoTypeConfig() == CryptoType.ECDSA_TYPE ? BINARY : SM_BINARY);
    }

    public TransactionReceipt AddIndividual(String _entAddress, String _name, String _realid) {
        final Function function = new Function(
                FUNC_ADDINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] AddIndividual(String _entAddress, String _name, String _realid, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_ADDINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForAddIndividual(String _entAddress, String _name, String _realid) {
        final Function function = new Function(
                FUNC_ADDINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(_name),
                new Utf8String(_realid)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple3<String, String, String> getAddIndividualInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ADDINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple3<String, String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getAddIndividualOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_ADDINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public TransactionReceipt DeleteIndividual(String _entAddress) {
        final Function function = new Function(
                FUNC_DELETEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] DeleteIndividual(String _entAddress, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_DELETEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForDeleteIndividual(String _entAddress) {
        final Function function = new Function(
                FUNC_DELETEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple1<String> getDeleteIndividualInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DELETEINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<Boolean> getDeleteIndividualOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_DELETEINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public Tuple4<String, String, BigInteger, BigInteger> GetIndividual(String _entAddress) throws ContractException {
        final Function function = new Function(FUNC_GETINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple4<String, String, BigInteger, BigInteger>(
                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue());
    }

    public Tuple3<String, String, String> GetIndividualByIndex(BigInteger index) throws ContractException {
        final Function function = new Function(FUNC_GETINDIVIDUALBYINDEX, 
                Arrays.<Type>asList(new Uint256(index)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple3<String, String, String>(
                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue());
    }

    public BigInteger GetIndividualCount() throws ContractException {
        final Function function = new Function(FUNC_GETINDIVIDUALCOUNT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeCallWithSingleValueReturn(function, BigInteger.class);
    }

    public Boolean IsDeleted(String _entAddress) throws ContractException {
        final Function function = new Function(FUNC_ISDELETED, 
                Arrays.<Type>asList(new Address(_entAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallWithSingleValueReturn(function, Boolean.class);
    }

    public Boolean IsExitAddress(String _enterAddress) throws ContractException {
        final Function function = new Function(FUNC_ISEXITADDRESS, 
                Arrays.<Type>asList(new Address(_enterAddress)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeCallWithSingleValueReturn(function, Boolean.class);
    }

    public TransactionReceipt UpdateIndividual(String _entAddress, String key, String value1, BigInteger value2) {
        final Function function = new Function(
                FUNC_UPDATEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value1),
                new Uint256(value2)),
                Collections.<TypeReference<?>>emptyList());
        return executeTransaction(function);
    }

    public byte[] UpdateIndividual(String _entAddress, String key, String value1, BigInteger value2, TransactionCallback callback) {
        final Function function = new Function(
                FUNC_UPDATEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value1),
                new Uint256(value2)),
                Collections.<TypeReference<?>>emptyList());
        return asyncExecuteTransaction(function, callback);
    }

    public String getSignedTransactionForUpdateIndividual(String _entAddress, String key, String value1, BigInteger value2) {
        final Function function = new Function(
                FUNC_UPDATEINDIVIDUAL, 
                Arrays.<Type>asList(new Address(_entAddress),
                new Utf8String(key),
                new Utf8String(value1),
                new Uint256(value2)),
                Collections.<TypeReference<?>>emptyList());
        return createSignedTransaction(function);
    }

    public Tuple4<String, String, String, BigInteger> getUpdateIndividualInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_UPDATEINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple4<String, String, String, BigInteger>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue()
                );
    }

    public Tuple1<Boolean> getUpdateIndividualOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_UPDATEINDIVIDUAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public String individualAddresses(BigInteger param0) throws ContractException {
        final Function function = new Function(FUNC_INDIVIDUALADDRESSES, 
                Arrays.<Type>asList(new Uint256(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeCallWithSingleValueReturn(function, String.class);
    }

    public Tuple6<String, String, String, BigInteger, BigInteger, Boolean> individuals(String param0) throws ContractException {
        final Function function = new Function(FUNC_INDIVIDUALS, 
                Arrays.<Type>asList(new Address(param0)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Bool>() {}));
        List<Type> results = executeCallWithMultipleValueReturn(function);
        return new Tuple6<String, String, String, BigInteger, BigInteger, Boolean>(
                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (String) results.get(2).getValue(), 
                (BigInteger) results.get(3).getValue(), 
                (BigInteger) results.get(4).getValue(), 
                (Boolean) results.get(5).getValue());
    }

    public static UserDataStorage load(String contractAddress, Client client, CryptoKeyPair credential) {
        return new UserDataStorage(contractAddress, client, credential);
    }

    public static UserDataStorage deploy(Client client, CryptoKeyPair credential) throws ContractException {
        return deploy(UserDataStorage.class, client, credential, getBinary(client.getCryptoSuite()), "");
    }
}
