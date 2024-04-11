import "./TimeCoin.sol";
pragma solidity ^0.6.10;
// SPDX-License-Identifier: MIT

contract P2PTime {
    TimeCoin timeCoin;
    address public owner;
    address public candidate_volunteer;
    address public volunteer;
    string public title;
    uint256 public price;
    string public description;
    uint256 public state;
    uint256 public auditopinion;
    uint public deadline;
    uint owner_score;
    uint volunteer_score;


    event Transaction_msg(uint256 indexed t);

    constructor(
                address _timeCoin,
                string memory _title,
                uint256 _price,
                string memory _description) public {
        timeCoin = TimeCoin(_timeCoin);
        owner = msg.sender;
        title = _title;
        price = _price;
        description = _description;
        //deadline = block.timestamp + 7 days;
    }

 
	//发布
    function publish() public {
        require(msg.sender == owner);
        require(timeCoin.transferFrom(msg.sender, address(this), price));
        require(state == 0);
        state = 1;//已发布、待审核
        emit Transaction_msg(0); // send the msg to web3 if the function run to this point, which mean the function execute successfully
    }
    

    
    //审核
    function reviewTask(bool passOrNot,uint256 auditOpinion) public {
    require(state == 1);
    auditOpinion = auditOpinion;
    if(passOrNot) {
            state = 2;//通过
        }else{
            state = 3;//未通过
            timeCoin.transferTo(owner, price);
        }
    emit Transaction_msg(1);
	}

	//接单
    function applyAsVolunteer() public {
    require(state == 2);//已通过
     require(msg.sender != owner);
    volunteer = msg.sender;
    state = 4;//getorder接单成功
    emit Transaction_msg(2);
	}
	
	//完成订单
	function volunteer_finishOrder(bool finished) public {
    require(state == 4);
    require(msg.sender == volunteer);
    state = 5;
    emit Transaction_msg(4);
	}

	//需求者确认后评价
    function assess_volunteer(uint score, bool finished) public {
        require(msg.sender == owner);
        require(state == 5);
        volunteer_score = score;
        if(finished) {
            state = 6;
             timeCoin.transferTo(volunteer, price);
        }else{
            state = 7;
        }

        emit Transaction_msg(5);
    }

        //取消交易
    function interrupt_sell() public {
        require(msg.sender == owner);
        require(state < 3);
        require(timeCoin.transferTo(owner, price));
        state = 8;
    }

    

}
