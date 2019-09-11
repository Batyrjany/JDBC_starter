<<<<<<< HEAD
public class EnumPractice {

    public static void main(String[] args) {

        Season s1 = Season.SUMMER;
        takeSeasonAction(s1);

        takeSeasonAction(Season.WINTER);


=======


public class EnumPractice {


    public static void main(String[] args) {

        Season s1 = Season.SUMMER ;

        takeSeasonAction( s1 );

        takeSeasonAction( Season.WINTER );
>>>>>>> a03aaf9f3d084c8d12c24018a26ef87b4dabc10c


    }

<<<<<<< HEAD
    static void takeSeasonAction(Season season){

        switch (season){
            case SPRING:
                System.out.println("Nowruz celebration");
                break;

            case FALL:
                System.out.println("Thanksgiving");

            case SUMMER:
                System.out.println("Swimming");
                break;
            case WINTER:
                System.out.println("Swnowboarding");
                break;
                default:
                    System.out.println("Invalid season");
        }

    }
}
=======

    static void takeSeasonAction(Season season){

        switch (season){

            case SPRING:
                System.out.println("CELEBRATE NAWRUZ");
                break;
            case SUMMER:
                System.out.println("GO TO THE BEACH");
                break;
            case FALL:
                System.out.println("CELEBRATE Thanksgiving, Apple Picking");
                break;
            case WINTER:
                System.out.println("Snowboarding , Chirstmas , New Year , Hibernate ");
                break;
                default:
                    System.out.println("NOT A VALID SEASON !!!");

        }






    }


}


>>>>>>> a03aaf9f3d084c8d12c24018a26ef87b4dabc10c
