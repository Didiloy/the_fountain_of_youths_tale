package items;

public class Drug extends Item{

    public Drug(){
        super();
    }


    @Override
    public void Use() {
        System.out.println("Why would you use drug if your not sick?");
    }

    public void heal(){
        this.Quantity--;
    }
}
