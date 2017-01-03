package Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Jekaterina on 02.01.2017.
 */
public class PresetMaps {

    public static Set<Integer> getAvailableWidths(){
        return presets.keySet();
    }

    public static Pipe[][] getPreset(int width){
        ArrayList<Pipe[][]> list = presets.get(width);

        int randomList = ThreadLocalRandom.current().nextInt(0, list.size());

        Pipe[][] result = list.get(randomList);
        for (Pipe[] pipeRow : result) {
            for (Pipe item : pipeRow) {
                if(item == null)
                    continue;

                int randomRotations = ThreadLocalRandom.current().nextInt(0, 4);
                for(int i = 0; i < randomRotations; i++){
                    item.rotateClockwise();                 //kõik torud roteeritakse suvaliselt
                }
            }
        }

        return result;
    }

    //Torustiku loomine - kõik torude otsad on omavahel seotud
    //Integer on võti ja ArrayList on väärtused
    private static HashMap<Integer, ArrayList<Pipe[][]>> presets = new HashMap<Integer, ArrayList<Pipe[][]>>(){{
        put(3, new ArrayList<Pipe[][]>(){{
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
        }});
        put(5, new ArrayList<Pipe[][]>(){{
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(false, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
        }});
        put(7, new ArrayList<Pipe[][]>(){{
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(true, false, false, true), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, false, false, true), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, false, true), new Pipe(false, true, true, false), new Pipe(true, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
        }});
        put(9, new ArrayList<Pipe[][]>(){{
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(false, true, true, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, false, true, true), new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
        }});
        put(11, new ArrayList<Pipe[][]>(){{
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, false, false, true), new Pipe(false, true, true, false), new Pipe(false, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, false, false), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(false, true, true, false), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
            add(new Pipe[][]{
                    {new Pipe(false, true, false, false), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(false, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(false, true, true, false), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, false, false, true), new Pipe(true, false, true, false), null},
                    {null, new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, false, true, false), new Pipe(true, true, true, false), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(false, true, true, true), new Pipe(false, true, true, true), new Pipe(false, false, true, true), null},
                    {null, new Pipe(false, true, true, false), new Pipe(true, true, false, true), new Pipe(false, false, true, true), new Pipe(true, true, false, false), new Pipe(true, true, false, true), new Pipe(true, true, true, true), new Pipe(false, false, true, true), new Pipe(true, true, true, false), new Pipe(true, true, true, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, true, true), new Pipe(true, true, false, true), new Pipe(true, true, false, true), new Pipe(true, false, true, true), new Pipe(true, true, true, false), new Pipe(false, true, false, true), new Pipe(true, false, true, true), null},
                    {null, new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, true, false, true), new Pipe(false, true, false, true), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(true, true, false, false), new Pipe(false, true, false, true), new Pipe(true, false, false, true), new Pipe(false, false, false, true)}
            });
        }});
    }};
}
