pragma solidity ^0.6.10;
// SPDX-License-Identifier: MIT

contract userDataStorage {

    // 个体结构体，包含个体在区块链上的地址、姓名、现实世界中的身份、分数、索引和删除标志
    struct Individual {
        address individualAddress;  // 区块链上的个体地址
        string name;  // 个体姓名
        string realid;  // 现实世界中的个体身份
        uint score;  // 分数
        uint index;  // 个体索引
        bool isDeleted; // 删除标志
    }

    // 个体地址到个体结构体的映射
    mapping(address => Individual) public individuals;

    // 存储所有个体地址的动态数组
    address[] public individualAddresses;

    // 判断个体是否已退出
    function IsExitAddress(address _enterAddress)
      public 
      view
      returns(bool isExited)
    {
      if(individualAddresses.length == 0) return false;
      return (individualAddresses[individuals[_enterAddress].index] == _enterAddress);
    }

    // 添加新的个体
    function AddIndividual(
      address _entAddress,
      string memory _name,
      string memory _realid)
      public
      returns(uint index)
    {
      require(!IsExitAddress(_entAddress), "Individual already exists");

 // 输出调试信息
  for (uint i = 0; i < individualAddresses.length; i++) {
      if (individualAddresses[i] == _entAddress) {
          revert("Debug: Address already in the array");
      }
  }

      individualAddresses.push(_entAddress);
      individuals[_entAddress].individualAddress = _entAddress;
      individuals[_entAddress].name = _name;
      individuals[_entAddress].realid = _realid;
      individuals[_entAddress].index = individualAddresses.length - 1;
      individuals[_entAddress].isDeleted = false;
      return individualAddresses.length - 1;
    }

    // 更新个体信息
    function UpdateIndividual(address _entAddress, string memory key, string memory value1, uint value2)
      public
      returns(bool success)
    {
      require(IsExitAddress(_entAddress) == true, "Individual is not exited");
      if(keccak256(abi.encodePacked(key)) == keccak256(abi.encodePacked("name"))) {
          individuals[_entAddress].name = value1;
          return true;
      }
      if(keccak256(abi.encodePacked(key)) == keccak256(abi.encodePacked("realid"))) {
          individuals[_entAddress].realid = value1;
          return true;
      }
      if(keccak256(abi.encodePacked(key)) == keccak256(abi.encodePacked("score"))) {
        individuals[_entAddress].score = value2;
        return true;
      }
      return false;
    }

    // 删除个体
    function DeleteIndividual(address _entAddress) public returns (bool isSuccess) {
      if(!IsExitAddress(_entAddress)) return false;
      individuals[_entAddress].isDeleted = true;
      return true;
    }

    // 根据地址查找个体信息
    function GetIndividual(address _entAddress)
      public
      view
      returns(string memory name, string memory realid, uint score, uint index)
    {
      require(IsExitAddress(_entAddress) == true, "Individual is not exited");
      return(
        individuals[_entAddress].name,
        individuals[_entAddress].realid,
        individuals[_entAddress].score,
        individuals[_entAddress].index);
    }

    // 根据索引查找个体信息
    function GetIndividualByIndex(uint index)
      public
      view
      returns(address entAddress, string memory name, string memory realid)
    {
      require(index < 0 || index >= individualAddresses.length, "Index is out of range");
      return(
        individualAddresses[index],
        individuals[individualAddresses[index]].name,
        individuals[individualAddresses[index]].realid);
    }

    // 返回个体数量
    function GetIndividualCount() public view returns(uint count) {
      return individualAddresses.length;
    }

    // 检查个体是否已被删除
    function IsDeleted(address _entAddress) public view returns(bool isDeleted) {
      require(IsExitAddress(_entAddress) == true, "Individual is not exited");
      return individuals[_entAddress].isDeleted;
    }
}
