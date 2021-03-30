//package backendJava;
import java.time.*;
import java.time.format.DateTimeFormatter;
public class Event {
    int uniqueid;
    String eventname;
    String eventdesc;
    String eventstart;
    String eventend;
    public Event(){
        LocalDateTime dateobj = LocalDateTime.now();
        DateTimeFormatter objformat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        uniqueid = 0;
        eventname = "Event Name - Untitled";
        eventdesc = "Event Description";
        eventstart = dateobj.format(objformat);
        eventend = dateobj.format(objformat);
    }

    public int getUniqueId(){
        return uniqueid;
    }
    public void setUniqueId(int uniqueid){
        this.uniqueid = uniqueid;
    }

    public String getEventName(){
        return eventname;
    }
    public void setEventName(String eventname) {
        this.eventname = eventname;
    }

    public String getEventDesc(){
        return eventdesc;
    }
    public void setEventDesc(String eventdesc) {
        this.eventdesc = eventdesc;
    }

    public String getEventStart(){
        return eventstart;
    }
    public void setEventStart(String eventstart) {
        this.eventstart = eventstart;
    }

    public String getEventEnd(){
        return eventend;
    }
    public void setEventEnd(String eventend) {
        this.eventend = eventend;
    }
}
