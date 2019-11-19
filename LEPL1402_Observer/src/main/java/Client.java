public class Client extends Observer {
    protected String news;

    protected int zone;

    public Client(int zone){
        this.zone = zone;
        this.news = "";
    }

    @Override
    public void update(Object o) {
        Pair<String, Integer> pair = (Pair)o;
        if(pair.getZone()==this.zone){
            news=pair.getAlert();
            zone=pair.getZone();
        }
    }

    @Override
    public int getZone() {
        return zone;
    }

    @Override
    public String getNews() {
        return news;
    }
}