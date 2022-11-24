package items;

public abstract class Item {
    protected int Quantity;

    public Item(){
        Quantity = 0;
    }

    public abstract void Use();

    public void add(int q){
        this.Quantity += q;
    }

    public void add(){
        this.Quantity++;
    }

    public int getQuantity(){
        return Quantity;
    }
}
