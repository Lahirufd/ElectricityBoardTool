package electricityboardtool2;

class Account {
    private int id;
    private String name;
    private String address;
    private SinglyLinkedList<Double> billHistory;

    public Account(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.billHistory = new SinglyLinkedList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SinglyLinkedList<Double> getBillHistory() {
        return billHistory;
    }

    public void addBill(double amount) {
        billHistory.add(amount);
    }
    
    public void addPaidAmount(double amount) {
        billHistory.add(-amount);
    }

    @Override
    public String toString() {
        return "Account ID: " + id + ", Name: " + name + ", Address: " + address;
    }
}

