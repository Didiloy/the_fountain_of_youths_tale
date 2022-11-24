package items;

public class Tale extends Item{
    public Tale(){
        super();
    }

    @Override
    public void Use() {
        if(this.Quantity > 0){
            System.out.println("Long ago, a war raged among the pirates of the galaxy. " +
                    "This war, which lasted for three generations, was the longest and bloodiest war this galaxy had ever seen. " +
                    "After 32 years of war for power, one pirate and his crew emerged from the pack. " +
                    "It is said that he was invincible in battle, that he had the presence of a god on the battlefield, " +
                    "that he was impervious to poison and above all, that he was merciless to his enemies. " +
                    "He could single-handedly annihilate an entire army, he advanced through the fire as if he was not afraid of death and fought until no enemy was left alive as if he did not know fatigue. " +
                    "After destroying all his enemies, he disappeared without a trace and there was a rumor that he was dead. " +
                    "However, his right hand man fervently denied this rumor, claiming that he could not be dead, because he had drunk from the fountain of youth. " +
                    "No one took him seriously and the pirate was forgotten.");
        }
        else{
            System.out.println("You do not have \"The fountain of youth's tale\"");
        }
    }
}
