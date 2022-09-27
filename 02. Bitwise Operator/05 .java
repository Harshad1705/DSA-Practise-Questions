class Question_02 {
    public static void main(String[] args) {
        int a = 1;
        int b = 2 ;

        if((a--)>0 && (++b)>2){
            System.out.println("Inside IF");
        }else{
            System.out.println("Inside ELSE");
        }

        System.out.println(a + "  " + b);
    }
}
