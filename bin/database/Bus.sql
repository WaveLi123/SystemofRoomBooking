create table bus(	
	类型 varchar(23),
	编号 varchar(23),
	座位数 varchar(23),
	线路编号 varchar(23)
)
create table Route(
	编号 varchar(23),
	始发站 varchar(23),
	终点站 varchar(23),
	经站数 varchar(23),
	所需时长 varchar(23)	
)
create table Local(
	编号 varchar(23),
	始发站 varchar(23),
	终点站 varchar(23),
	经站数 varchar(23),
	所需时长 varchar(23),
	路程长度 varchar(23),
	线路编号 varchar(23)
)
create table LongDistance(
	编号 varchar(23),
	始发站 varchar(23),
	终点站 varchar(23),
	经站数 varchar(23),
	所需时长 varchar(23),
	始发时间 varchar(23),
	末发时间 varchar(23)
)

create table Employee(
	编号 varchar(23),
	姓名 varchar(23),
	身份证号 varchar(23),
	年龄 varchar(23),
	薪水 varchar(23),
	所属部门 varchar(23),	
)

create table Manager(
	编号 varchar(23),
	姓名 varchar(23),
	身份证号 varchar(23),
	年龄 varchar(23),
	薪水 varchar(23),
	所属部门 varchar(23),
	工作内容 varchar(23),
	主管部门 varchar(23),
	职责 varchar(23)
)

create table Passenger(
	编号 varchar(23),
	姓名 varchar(23),
	性别 varchar(23),
	年龄 varchar(23),
	备注 varchar(23)
)


