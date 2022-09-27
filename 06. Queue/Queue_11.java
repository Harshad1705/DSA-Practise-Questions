

// circular tour

public class Queue_11 {

    static class petrolPump{
        int petrol;
        int distance;

        petrolPump(int x,int y){
            this.petrol =x;
            this.distance = y;
        }
    }

    static int tour(petrolPump[] p,int N){

        // Time complexity = O(n)
        // Space complexity = O(1)

        int deficit = 0;
        int balance = 0;
        int start = 0;

        for(int i = 0;i<N;i++){
            balance = balance + (p[i].petrol - p[i].distance);
            if(balance<0){
                deficit = deficit + balance;
                balance = 0;
                start = i+1;
            }
        }

        if((deficit + balance) >= 0){
            return start;
        }else{
            return -1;
        }
    }
    
    public static void main(String[] args) {
        int N=4;
        int petrol[] = {4,6,7,4};
        int distance[] = {6,5,3,5};

        petrolPump[] p = new petrolPump[N];
        for(int i=0;i<N;i++){
            petrolPump pump = new petrolPump(petrol[i], distance[i]);
            p[i] = pump;
        }


        System.out.println( tour(p,N));


    }
}
