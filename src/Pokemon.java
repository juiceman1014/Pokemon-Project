import java.util.HashSet;
import java.util.TreeSet;

public class Pokemon {
    public static HashSet<Character> getHitPointList(int maxHP, HashSet<Character> baseSet){
        HashSet<Character> hitPointList = new HashSet<Character>();
        for(Character pokemon : baseSet){
            if(pokemon.getHP() >= 0 && pokemon.getHP() <= maxHP){
                hitPointList.add(pokemon);
            }
        }
        return hitPointList;
    }

    public static int getIsLegendaryCount(HashSet<Character> baseSet){
        int legendaryCount = 0;
        for(Character pokemon : baseSet){
            if(pokemon.getLegendary() == 1){
                legendaryCount++;
            }
        }
        return legendaryCount;
    }

    public static TreeSet<Character> getCharacterByFirstLetter(char firstLetter, HashSet<Character> baseSet){
        TreeSet<Character> pokeTreeSet = new TreeSet<Character>();

        for(Character pokemon : baseSet){
            char pokeFirstLetter = java.lang.Character.toUpperCase(pokemon.getName().charAt(0));
            char userFirstLetter = java.lang.Character.toUpperCase(firstLetter);
            if(pokeFirstLetter == userFirstLetter){
                pokeTreeSet.add(pokemon);
            }
        }
        return pokeTreeSet;
    }

    public static void main(String[] args) {

        CsvReader c1 = new CsvReader();
        System.out.println("\nFile is read successfully: " +
                c1.readFile("/Users/justintran/F23-CS49J/Pokemon-Project/src"));

        HashSet<Character> pokeSet = c1.getCharacterSet();
        System.out.println("\nOriginal data lines: ");
        for(Character pokemon : pokeSet){
            System.out.println(pokemon.getDataLine());
        }

        System.out.println("\nName/Hit Points/Legendary Status: ");
        for(Character pokemon : pokeSet){
            if(pokemon.getLegendary() == 1) {
                System.out.println("Name: " + pokemon.getName() + ", Hit Points: " + pokemon.getHP() +
                        ", Legendary: true");
            }else{
                System.out.println("Name: " + pokemon.getName() + ", Hit Points: " + pokemon.getHP() +
                        ", Legendary: false");
            }
        }

        HashSet<Character> hitPointList = getHitPointList(60, pokeSet);
        System.out.println("\nHitpoint List (Max 60 HP): ");
        for(Character pokemon : hitPointList){
            System.out.println(pokemon.getName() + ": " + pokemon.getHP());
        }

        System.out.println("\nThere's a total of " + getIsLegendaryCount(pokeSet) + " legendary pokemon:");
        for(Character pokemon : pokeSet){
            if(pokemon.getLegendary() == 1){
                System.out.println(pokemon.getName() + " is legendary!");
            }
        }

        System.out.println("\nAll characters starting with C: ");
        TreeSet<Character> pokeTreeSet = getCharacterByFirstLetter('C', pokeSet);
        for(Character pokemon : pokeTreeSet){
            System.out.println("Name: " + pokemon.getName());
        }

    }
}