import java.util.ArrayList;
import java.util.List;

public class MeteoStation extends Observable {

    protected ArrayList<Observer> subscribers = new ArrayList<>();
    protected ArrayList<Pair<String, Integer>> zones = new ArrayList<>();
    private String alert;
    private Integer zone;

    @Override
    public Observer[] getSubscribers() {
        int length = subscribers.size();
        Observer[] observers = new Observer[length];
        int index = 0;
        for (Observer i:subscribers){
            observers[index]=subscribers.get(index);
            index++;
        }
        return observers;

    }

    @Override
    public void broadcast(Pair<String, Integer> pair) {
        for(Observer i:subscribers){
            i.update(pair);
        }
    }

    @Override
    public void addObserver(Observer sub) {
        if(!subscribers.contains(sub)){
            subscribers.add(sub);
        }
    }

    @Override
    public boolean removeObserver(Observer sub) {
        return subscribers.remove(sub);
    }

    @Override
    public void setAlert(String alert, int zone) {
        broadcast(new Pair<String,Integer>(alert,zone));
    }
}
