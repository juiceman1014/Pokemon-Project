import java.util.HashSet;
public class Character implements Comparable<Character>{

    private String dataLine;
    private String abilities;
    private double against_bug;
    private double against_dark;
    private double against_dragon;
    private double against_electric;
    private double against_fairy;
    private double against_fight;
    private double against_fire;
    private double against_flying;
    private double against_ghost;
    private double against_grass;
    private double against_ground;
    private double against_ice;
    private double against_normal;
    private double against_poison;
    private double against_psychic;
    private double against_rock;
    private double against_steel;
    private double against_water;
    private int attack;
    private int base_egg_steps;
    private int base_happiness;
    private int base_total;
    private int capture_rate;
    private String classification;
    private int defense;
    private int experience_growth;
    private double height_m;
    private int hp;
    private String japanese_name;
    private String name;
    private double percentage_male;
    private int pokedex_number;
    private int sp_attack;
    private int sp_defense;
    private int speed;
    private String type1;
    private String type2;
    private double weight_kg;
    private int generation;
    private int is_legendary;

    public Character(String dataLine){

        this.dataLine = dataLine;

        String[] section = dataLine.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

        this.abilities = section[0].isEmpty() ? "N/A" : section[0];
        this.against_bug = section[1].isEmpty() ? 0.0 : Double.parseDouble(section[1]);
        this.against_dark = section[2].isEmpty() ? 0.0 : Double.parseDouble(section[2]);
        this.against_dragon = section[3].isEmpty() ? 0.0 : Double.parseDouble(section[3]);
        this.against_electric = section[4].isEmpty() ? 0.0 : Double.parseDouble(section[4]);
        this.against_fairy = section[5].isEmpty() ? 0.0 : Double.parseDouble(section[5]);
        this.against_fight = section[6].isEmpty() ? 0.0 : Double.parseDouble(section[6]);
        this.against_fire = section[7].isEmpty() ? 0.0 : Double.parseDouble(section[7]);
        this.against_flying = section[8].isEmpty() ? 0.0 : Double.parseDouble(section[8]);
        this.against_ghost = section[9].isEmpty() ? 0.0 : Double.parseDouble(section[9]);
        this.against_grass = section[10].isEmpty() ? 0.0 : Double.parseDouble(section[10]);
        this.against_ground = section[11].isEmpty() ? 0.0 : Double.parseDouble(section[11]);
        this.against_ice = section[12].isEmpty() ? 0.0 : Double.parseDouble(section[12]);
        this.against_normal = section[13].isEmpty() ? 0.0 : Double.parseDouble(section[13]);
        this.against_poison = section[14].isEmpty() ? 0.0 : Double.parseDouble(section[14]);
        this.against_psychic = section[15].isEmpty() ? 0.0 : Double.parseDouble(section[15]);
        this.against_rock = section[16].isEmpty() ? 0.0 : Double.parseDouble(section[16]);
        this.against_steel = section[17].isEmpty() ? 0.0 : Double.parseDouble(section[17]);
        this.against_water = section[18].isEmpty() ? 0.0 : Double.parseDouble(section[18]);
        this.attack = section[19].isEmpty() ? 0 : Integer.parseInt(section[19]);
        this.base_egg_steps = section[20].isEmpty() ? 0 : Integer.parseInt(section[20]);
        this.base_happiness = section[21].isEmpty() ? 0 : Integer.parseInt(section[21]);
        this.base_total = section[22].isEmpty() ? 0 : Integer.parseInt(section[22]);
        this.capture_rate = section[23].isEmpty() ? 0 :
                Integer.parseInt(section[23].replaceAll("[^\\d]", ""));
        this.classification = section[24].isEmpty() ? "N/A" : section[24];
        this.defense = section[25].isEmpty() ? 0 : Integer.parseInt(section[25]);
        this.experience_growth = section[26].isEmpty() ? 0 : Integer.parseInt(section[26]);
        this.height_m = section[27].isEmpty() ? 0.0 : Double.parseDouble(section[27]);
        this.hp = section[28].isEmpty() ? 0 : Integer.parseInt(section[28]);
        this.japanese_name = section[29].isEmpty() ? "N/A" : section[29];
        this.name = section[30].isEmpty() ? "N/A" : section[30];
        this.percentage_male = section[31].isEmpty() ? 0.0 : Double.parseDouble(section[31]);
        this.pokedex_number = section[32].isEmpty() ? 0 : Integer.parseInt(section[32]);
        this.sp_attack = section[33].isEmpty() ? 0 : Integer.parseInt(section[33]);
        this.sp_defense = section[34].isEmpty() ? 0 : Integer.parseInt(section[34]);
        this.speed = section[35].isEmpty() ? 0 : Integer.parseInt(section[35]);
        this.type1 = section[36].isEmpty() ? "N/A" : section[36];
        this.type2 = section[37].isEmpty() ? "N/A" : section[37];
        this.weight_kg = section[38].isEmpty() ? 0.0 : Double.parseDouble(section[38]);
        this.generation = section[39].isEmpty() ? 0 : Integer.parseInt(section[39]);
        this.is_legendary = section[40].isEmpty() ? 0 : Integer.parseInt(section[40]);
    }

    public String getName(){
        return this.name;
    }

    public int getHP(){
        return this.hp;
    }

    public int getLegendary(){
        return this.is_legendary;
    }

    public int getCaptureRate(){
        return this.capture_rate;
    }

    @Override
    public boolean equals(Object x){
        Character that = (Character)x;
        return this.name.equals(that.name) &&
                this.japanese_name.equals(that.japanese_name) &&
                this.abilities.equals(that.abilities);
    }

    @Override
    public int hashCode() {
        return this.name.length() + this.japanese_name.length() + this.abilities.length() + this.hp;
    }

    public int compareTo(Character that){
        if(this.name.compareTo(that.name) > 0){
            return 1;
        }else if(this.name.compareTo(that.name) < 0){
            return -1;
        }else if(this.japanese_name.compareTo(that.japanese_name) > 0){
            return 1;
        }else if(this.japanese_name.compareTo(that.japanese_name) < 0){
            return -1;
        }else if(this.pokedex_number > that.pokedex_number){
            return 1;
        }else if(this.pokedex_number < that.pokedex_number){
            return -1;
        }else{
            return 0;
        }
    }

    public String getDataLine(){
        return this.dataLine;
    }

}
