package items;

public class Food extends Item{

    public Food(){
        super();
    }

    @Override
    public void Use() {
        if(this.Quantity == 0){
            System.out.println("You don't have any food");
        }
        else{
            System.out.println("You take the time to eat with your crew");
            this.Quantity--;
        }
    }
}
