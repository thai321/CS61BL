public class Event {
    private String eventName;
    
    public Event(String eventName) {
        this.eventName = eventName;
    }
    
    public String getEventName() {
        return eventName;
    }
    
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    
    // may need to implement additional methods
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }
        if(this == o) {
            return true;
        }
        if(!(o instanceof Event)) {
            return false;
        }
        Event s = (Event) o;

        return (new String(this.eventName).equals(new String(s.eventName)));
    }
}