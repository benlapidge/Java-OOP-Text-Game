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

        //Below used from EX3
        Entity entity = new Entity('*');
        System.out.println("entity.getCode = " + entity.getCode());
        entity.setItemQuantity("coins", 20);
        entity.setItemQuantity("handbags", 1);
        entity.setItemQuantity("treacle", 2);
        entity.setItemQuantity("stain remover", 1);
        System.out.println(entity.getItemNames());
    }
}