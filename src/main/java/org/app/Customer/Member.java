import java.util.List;

class Member extends RegisteredCustomer {
    private final double poin_rate = 0.01;

    public Member(int id, List<Integer> bills, String name, String telephoneNumber, int point, boolean active) {
        super(id, bills, name, telephoneNumber, point, active);
    }
}