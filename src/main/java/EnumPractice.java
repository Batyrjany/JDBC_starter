public class EnumPractice {

    public static void main(String[] args) {

        Season s1 = Season.SUMMER;
        takeSeasonAction(s1);

        takeSeasonAction(Season.WINTER);




    }

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
