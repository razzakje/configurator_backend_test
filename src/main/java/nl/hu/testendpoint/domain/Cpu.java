package nl.hu.testendpoint.domain;

public class Cpu extends Component {

    public Cpu(String name, double price) {
        super("CPU", name, price);
    }

    public static Cpu getCpu() {
        return new Cpu("Intel Core i9", 200.40);
    }

}
