public class Task4 {
    public static void main(String[] args) {
        boolean workCondition=false;
        boolean manuel = false;
        boolean automatic=true;
        int weight=400;
        boolean weightSensor=false;
        boolean stuckSensor=false;
        boolean speed1=false;
        boolean speed2=false;
        boolean speed3=false;
        boolean speed4=false;

        if(manuel==true){
            stuckSensor=false;
            if(weight>1000){
                weightSensor=false;
            }
            weightSensor=true;
            if(weightSensor==true){
                workCondition=true;
            }
        }

        if(automatic==true){
            if(weight==0){
                workCondition=false;
            }else if(weight>1000 || stuckSensor==true){
                workCondition=false;
            }else {
                workCondition=true;
            }
        }

        if(automatic==true){
            if(weight<300){
                speed4=true;
                System.out.println("speed4");
            } else if (weight<500) {
                speed3=true;
                System.out.println("speed3");
            } else if (weight<800) {
                speed2=true;
                System.out.println("speed2");
            } else if (weight<=1000) {
                speed1=true;
                System.out.println("speed1");
            }
        }

        System.out.println(workCondition);

    }
}
