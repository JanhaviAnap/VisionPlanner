create database visionplanner;
use visionplanner;
create table userdata (uniqueid int, username varchar(20), userpassword varchar(20), useremail varchar(30));
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
    eventend datetime
);
select * from eventlist;
select eventstart,eventend from eventlist
where year(eventstart)=2021 and uniqueid=552266
order by eventstart
;
select eventstart,eventend from eventlist
where year(eventstart)=2021 and month(eventstart)=02 and month(eventstart)>month(now())-1 and uniqueid=552266
;
select eventstart,eventend from eventlist
where date(eventstart)="2021-02-11" and uniqueid=552266
;
select now();
insert into eventlist values (552266,"today","this is today","2021-03-11 00:00:00","2021-03-11 23:59:59");
drop table eventlist;

create table moodlist(
	uniqueid int,
    mooddate date,
    mood varchar(20),
    color varchar(7),
    daydesc varchar(400)
);
select * from moodlist;
insert into moodlist values(552266,"2021-03-005","none","#FFFFFF","nm");
drop table moodlist;
update moodlist set mood="happy",color="#F9A7B0",daydesc="something did happen" where uniqueid=552266;
select mooddate,mood,daydesc from moodlist  where year(mooddate)=2021 and uniqueid=552266 order by mooddate;
