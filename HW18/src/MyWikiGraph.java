import java.util.*;

public class MyWikiGraph implements WikiGraph {
    private HashMap<String,String> pages;
    private HashSet<String> titles; 
    
    public MyWikiGraph() {
        pages = new HashMap<String,String>();
        titles = new HashSet<String>();
    }

    public void explore(String title) {
        String next = title;
        while(!pages.containsKey(next)) {
            titles.add(next);
            title = next;
            next = LinkFollower.getFirstLink(next);
            pages.put(title, next);
        }
    }


    public Set<String> getVertices(){
        return titles;
    }

    public String nextTitle(String title) {
        return pages.get(title);

    }
    
    public Set<String> prevTitles(String title) {
        HashSet<String> p = new HashSet<String>();
        for(String a: titles) {
            if(nextTitle(a).equals(title)) {
                p.add(a);
            }
        }
        return p;

    }

    public int distanceToCycle(String title) {
        HashSet<String> visited = new HashSet<String>();
        int count = 0;
        visited.add(title);
        title = nextTitle(title);
        while(title != null && !visited.contains(title)) {
            visited.add(title);
            count++;
            title = nextTitle(title);

        }
        return count;

    }
    
    public static void main(String[] args){
        MyWikiGraph thai = new MyWikiGraph();
        String title = args[0];
        thai.explore("God");
        thai.explore("Computer");
        thai.explore("Physics");
        thai.explore("VietNam");
        thai.explore("Sleep");
        thai.explore("Laptop");
        thai.explore("DNA");
        thai.explore("Thai");
        thai.explore("Games");
        thai.explore("Apple");

        GraphDrawer.writePng(thai,title);

    }

}