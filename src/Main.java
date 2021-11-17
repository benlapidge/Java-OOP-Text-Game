class Main {
    public static void main(String[] args) {
        //Below used from EX1
        ResponseImp response = new ResponseImp(true,"Message 1");
        System.out.println("getStatus() returned: " + response.getStatus());
        System.out.println("getMessage() returned: " + response.getMessage());

        //Below used from EX2
        ItemLine line = new ItemLine("coin",2);
        System.out.println("line.getName() returned " + line.getName());
        System.out.println("line.getQuantity() returned " + line.getQuantity());
    }
}