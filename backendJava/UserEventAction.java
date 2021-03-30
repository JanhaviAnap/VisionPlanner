//package backendJava;

import java.sql.*;
import java.util.Vector;
import java.time.*;

public class UserEventAction {
    public static boolean addEvent(int uniqueid,String eventname,String eventdesc,String eventstart, String eventend) {
        boolean status = false;
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into eventlist values (?,?,?,?,?);");
            ps.setInt(1, uniqueid);
            ps.setString(2, eventname);
            ps.setString(3, eventdesc);
            ps.setString(4, eventstart);
            ps.setString(5, eventend);
            if(ps.executeUpdate()>0){
                status = true;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return status;
    }

    public static Vector<String> viewEventFromYearForSelf(int uniqueid,int year) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend,eventname,eventdesc from eventlist where year(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setInt(1, year);
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend")+" "+rs.getString("eventname")+" "+rs.getString("eventdesc"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewEventFromYearMonthForSelf(int uniqueid,int year,int month) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend,eventname,eventdesc from eventlist where year(eventstart)=? and month(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setInt(1, year);
            ps.setInt(2, month);
            ps.setInt(3, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend")+" "+rs.getString("eventname")+" "+rs.getString("eventdesc"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewEventFromYearMonthDateForSelf(int uniqueid,int year,int month, int date) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend,eventname,eventdesc from eventlist where date(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setString(1, year+"-"+month+"-"+date);
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend")+" "+rs.getString("eventname")+" "+rs.getString("eventdesc"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewTasksForTodayForSelf(int uniqueid){
        Vector<String> schedule = new Vector<String>();
        try{
            LocalDate currentdate = LocalDate.now();
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventname,eventdesc,eventstart,eventend from eventlist where date(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setString(1,currentdate.toString());
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add("\nevent name: "+rs.getString("eventname")+"\nEvent description: "+rs.getString("eventdesc")+"\nEvent timings"+rs.getString("eventstart")+"  "+rs.getString("eventend"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewEventFromYear(int uniqueid,int year) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend from eventlist where year(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setInt(1, year);
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewEventFromYearMonth(int uniqueid,int year,int month) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend from eventlist where year(eventstart)=? and month(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setInt(1, year);
            ps.setInt(2, month);
            ps.setInt(3, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewEventFromYearMonthDate(int uniqueid,int year,int month, int date) {
        Vector<String> schedule = new Vector<String>();
        try{
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventstart,eventend from eventlist where date(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setString(1, year+"-"+month+"-"+date);
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add(rs.getString("eventstart")+"  "+rs.getString("eventend"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }

    public static Vector<String> viewTasksForToday(int uniqueid){
        Vector<String> schedule = new Vector<String>();
        try{
            LocalDate currentdate = LocalDate.now();
            Connection conn = UserAction.getConnection();
            PreparedStatement ps = conn.prepareStatement("select eventname,eventdesc,eventstart,eventend from eventlist where date(eventstart)=? and uniqueid=? order by eventstart;");
            ps.setString(1,currentdate.toString());
            ps.setInt(2, uniqueid);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                schedule.add("\nevent name: "+rs.getString("eventname")+"\nEvent description: "+rs.getString("eventdesc")+"\nEvent timings"+rs.getString("eventstart")+"  "+rs.getString("eventend"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return schedule;
    }
}
