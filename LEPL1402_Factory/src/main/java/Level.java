import javax.swing.plaf.synth.SynthTextAreaUI;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Level extends AbstractLevel{
    public Level(String input){
        String[] arr=input.split("\n");
        components= new LevelComponent[arr.length][];
        for(int i=0;i<arr.length;i++) {
            LevelComponent[] levelComponents = new LevelComponent[arr[i].length()];
            for (int j = 0; j < levelComponents.length; j++) {
                levelComponents[j]=getElement(arr[i].charAt(j));
            }
            components[i]=levelComponents;
        }
    }

    public static LevelComponent getElement(char  c){
        switch (c){
            case 'D':
                Door door=new Door();
                return door;
            case 'K':
                Key key=new Key();
                return key;
            case '#':
                Wall wall=new Wall();
                return wall;
            case '-':
                Floor floor=new Floor();
                return floor;
            default:
                throw new IllegalArgumentException("NO!");
        }
    }
    @Override
    public String toString() {
        String string="";
        for(int i=0;i<components.length;i++){
            for(int j=0;j<components[0].length;j++){
                string+=components[i][j].draw();
            }
            if(i != components.length-1){
                string+="\n";
            }

        }
        return string;
    }

    @Override
    LevelComponent[][] getComponents() {
        return components;
    }

    @Override
    int getSize() {
        return components.length*components[0].length;
    }

    public static void main(String[] args) {
        String mamene = "#-K\n-D-\n#-K";
        Level level = new Level(mamene);
        System.out.println(level.getSize());
        System.out.println(level.toString());
        System.out.println(Arrays.deepToString(level.getComponents()));
    }
}