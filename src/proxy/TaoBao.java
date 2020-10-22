package proxy;

public class TaoBao implements Usb {

    private KingsFactory kingsFactory = new KingsFactory();

    @Override
    public float sell(float price) {
        System.out.println("有红包");
        float sell = kingsFactory.sell(80f);
        return sell+price;
    }

    @Override
    public boolean ifSell() {
        return false;
    }

    @Override
    public void print(String name) {

    }
}
