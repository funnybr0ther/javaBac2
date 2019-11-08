import java.util.List;
import java.awt.Color;

import java.util.Comparator;
import java.util.List;

public class Sorter {


    /*
     * Should sort the list and order the Flower by color, in this specific order : red, blue, green
     */
    public static void sortFlowerByColor(List<Flower> list){
        list.sort(new Comparator<Flower>() {
            @Override
            public int compare(Flower flower, Flower t1) {
                if (flower.getPetalColor().getRed()==t1.getPetalColor().getRed()){
                    if (flower.getPetalColor().getBlue()==t1.getPetalColor().getBlue()){
                        if (flower.getPetalColor().getGreen()==t1.getPetalColor().getGreen()){
                            return flower.compareTo(t1);
                        }
                        return flower.getPetalColor().getGreen()-t1.getPetalColor().getGreen();
                    }
                    return flower.getPetalColor().getBlue()-t1.getPetalColor().getBlue();
                }
                return flower.getPetalColor().getRed()-t1.getPetalColor().getRed();
                }
        });
    }
    /*
     * Should sort the Plant by name only
     */
    public static void sortPlantByName(List<Plant> list){
        list.sort(new Comparator<Plant>() {
            @Override
            public int compare(Plant plant, Plant t1) {
                return plant.getName().compareTo(t1.getName());
            }
        });
    }

    /*
     * Should sort the list and order the Tree by height
     */
    public static void sortTreeByHeight(List<Tree> list){
        list.sort(new Comparator<Tree>() {
            @Override
            public int compare(Tree tree, Tree t1) {
                return tree.getHeight()-t1.getHeight();
            }
        });
    }
}
