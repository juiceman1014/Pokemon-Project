import java.util.HashSet;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

public class CsvReader {
    private HashSet<Character> pokeHashSet;

    public CsvReader(){
        pokeHashSet = new HashSet<Character>();
    }

    public boolean readFile(String fileName){

        File dirf = new File(fileName);
        File pokef = new File(dirf, "pokemon.csv");

        if(dirf.isDirectory() && dirf.exists() && pokef.isFile() && pokef.exists()) {
            try {
                FileReader fr = new FileReader(pokef);
                BufferedReader br = new BufferedReader(fr);

                br.readLine();

                String line;
                boolean done = false;
                while (!done) {
                    line = br.readLine();
                    if (line == null) {
                        done = true;
                    } else {
                        Character c = new Character(line);
                        pokeHashSet.add(c);
                    }
                }
                br.close();
                fr.close();
            } catch (FileNotFoundException x) {
                System.out.println("No such file: " + pokef);
            } catch (IOException x) {
                System.out.println("IO trouble");
            }

            return true;
        }else{
            return false;
        }
    }

    public HashSet<Character> getCharacterSet(){
        return this.pokeHashSet;
    }

}
