package electricityboardtool;

class Node<DataType> {
    DataType data;
    Node<DataType> next;

    Node(DataType data) {
        this.data = data;
        this.next = null;
    }
}
