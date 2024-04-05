pragma solidity ^0.6.10;
// SPDX-License-Identifier: MIT
interface tokenRecipient {
    function receiveApproval(address _from, uint256 _value, address _token, bytes calldata _extraData) external;
}
contract TimeCoin {

    string public name;//token name
    string public symbol; //token symbol
    uint8 public decimals = 2; // the smallest token unit
    uint256 initial_supply;
    uint256 public totalSupply; // total supply totkens
    address admin; //admin address, can't be modified externally


    mapping(address => uint256) public balanceOf; // storage the balance of all accounts
    mapping(address => mapping(address => uint256)) public allowance; //

    event Transfer(address indexed from, address indexed to, uint256 value);

    modifier onlyAdmin(){
        require(msg.sender == admin);
        _;
    }

    //construct function
    constructor(uint256 _initialSupply, string memory tokenName, string memory tokenSymbol) public  {
        admin = msg.sender;
        initial_supply = _initialSupply * 10 ** uint256(decimals);
        name = tokenName;
        symbol = tokenSymbol;

    }



    function getInitialSupply() public view returns (uint256) {
    return initial_supply;
}

function getAdmin() public view returns (address) {
    return admin;
}

    function initial_balance(address user,uint256 initial_coin) public onlyAdmin {
        balanceOf[user] = initial_coin;
    }

    // token transfer internal function
function _transfer(address _from, address _to, uint256 _value) internal {
    require(_to != address(0), "Address can't be null");
    require(balanceOf[_from] >= _value);
    require(balanceOf[_to] + _value > balanceOf[_to]);

    uint previousBalances = balanceOf[_from] + balanceOf[_to];
    balanceOf[_from] -= _value;
    balanceOf[_to] += _value;
    emit Transfer(_from, _to, _value);

    assert(balanceOf[_from] + balanceOf[_to] == previousBalances);
}

    // token transfer function, call its internal function
function transferTo(address _to, uint256 _value) public returns (bool success) {
    require(_to != address(0), "Address can't be null");
    _transfer(msg.sender, _to, _value);
    return true;
}

    function transferFrom(address _from, address _to, uint256 _value) public returns(bool success){
        _transfer(_from, _to, _value);
        return true;
    }

    function approve(address _spender, uint256 _value) public returns (bool success){
        allowance[msg.sender][_spender] = _value;
        return true;
    }

    function approveAndCall(address _spender, uint256 _value, bytes calldata _extraData) public returns (bool success) {
        tokenRecipient spender = tokenRecipient(_spender);
        if (approve(_spender, _value)) {
            spender.receiveApproval(msg.sender, _value, address(this), _extraData);
            return true;
        }
    }

    function burn(uint256 _value) public returns (bool success) {
        require(balanceOf[msg.sender] >= _value);
        balanceOf[msg.sender] -= _value;
        return true;

    }

    function burnFrom(address _from, uint256 _value) public returns (bool success){
        require(balanceOf[msg.sender] >= _value);
        require(_value <= allowance[_from][msg.sender]);
        balanceOf[_from] -= _value;
        allowance[_from][msg.sender] -= _value;
        return true;
    }


}
