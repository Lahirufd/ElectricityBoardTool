package electricityboardtool;

class SinglyLinkedList<AccountType> {
    private Node<AccountType> head;

    public SinglyLinkedList() {
        this.head = null;
    }

    public void add(AccountType data) {
        Node<AccountType> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<AccountType> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean remove(AccountType data) {
        if (head == null) return false;

        if (head.data.equals(data)) {
            head = head.next;
            return true;
        }

        Node<AccountType> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }

        return false;
    }

//    public Node<AccountType> search(AccountType data) {
//        Node<AccountType> current = head;
//        while (current != null) {
//            if (current.data.equals(data)) {
//                return current;
//            }
//            current = current.next;
//        }
//        return null;
//    }

    public void printList() {
        Node<AccountType> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

    public Node<AccountType> returnHead() {
        return head;
    }
}
