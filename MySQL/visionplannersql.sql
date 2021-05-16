create database visionplanner;
use visionplanner;
create table userdata (
	uniqueid int, 
    username varchar(20), 
    userpassword varchar(20), 
    useremail varchar(30)
);
insert into userdata values(5,"Nishant","nishant","nishant@gmail.com");
select * from userdata;
select username,userpassword from userdata where username = "Jatin" and userpassword = "jatin";
select uniqueid from userdata where uniqueid=4;

select uniqueid from userdata where useremail="nishant@gmail.com";
select * from userdata where useremail="nishant@gmail.com";
select * from userdata where uniqueid=552266;

create table eventlist (
	uniqueid int, 
	eventname varchar(120),
    eventdesc varchar(400),
	eventstart datetime,
    eventend datetime,
    inviteby varchar(30)
);
select * from eventlist;
select eventstart,eventend from eventlist
where year(eventstart)=2021 and uniqueid=552266
order by eventstart
;
select eventstart,eventend from eventlist
where year(eventstart)=2021 and month(eventstart)=02 and month(eventstart)>month(now())-1 and uniqueid=552266;
select distinct * from eventlist where uniqueid=552266 and (date(eventstart)="2021-05-08" or date(eventend)="2021-05-08");
select eventstart,eventend from eventlist
where date(eventstart)="2021-02-11" and uniqueid=552266
;

select now();
insert into eventlist values (552266,"today","this is today","2021-03-11 00:00:00","2021-03-11 23:59:59","alex@gmail.com");
drop table eventlist;
select eventname,eventdesc,eventstart,eventend,inviteby from eventlist where date(eventstart)="2021-05-08 00:00:00" and uniqueid=552266 order by eventstart;
select date("2021-05-08 00:00:00");
create table moodlist(
	uniqueid int,
    mooddate date not null,
    mood varchar(20),
    color varchar(7),
    daydesc varchar(400)
);
select * from moodlist;
insert into moodlist values(1212592114,"2021-05-16","humorous","#FFFF00","nm");
drop table moodlist;
update moodlist set mood="happy",color="#F9A7B0",daydesc="something did happen" where uniqueid=552266;
select mooddate,mood,daydesc from moodlist  where year(mooddate)=2021 and uniqueid=552266 order by mooddate;

select * from moodlist;
delete from moodlist where uniqueid = 0;
truncate table moodlist;

create table quotes(
	quote varchar(500),
    qtype varchar(500)
);
drop table quotes;
select distinct * from quotes;
select quote from quotes where qtype="calm" order by rand() limit 1;
insert into quotes values("It Feels Good To Be Lost In The Right Direction","calm");
Select * from quotes where quote="It Feels Good To Be Lost In The Right Direction" and qtype="calm";
truncate table quotes;
delete from moodlist where uniqueid=545298006;
select * from userdata;
select distinct * from eventlist;
select * from moodlist;
select * from quotes;
insert into moodlist value(234918803,"2021-05-13","calm","#7FFFD4","work");