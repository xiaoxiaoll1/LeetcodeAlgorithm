package proxy;

public class KingsFactory implements Usb{
    @Override
    public float sell(float price) {
        return price;
    }

    @Override
    public boolean ifSell() {
        return false;
    }

    @Override
    public void print(String name) {
        System.out.println(name);
    }
}
