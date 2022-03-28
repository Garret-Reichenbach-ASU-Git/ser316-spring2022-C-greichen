public class Stuffing {
    public enum StuffingType {
        BASE,
        DOWN,
        FOAM
    }

    StuffingType polyStuffingType;
    int price;

    public Stuffing (StuffingType interiorStuffingType) {

        switch (interiorStuffingType) {
            case BASE:
                this.polyStuffingType = StuffingType.BASE;
                this.price = 30;
                break;
            case DOWN:
                this.polyStuffingType = StuffingType.DOWN;
                this.price = 40;
                break;
            case FOAM:
                this.polyStuffingType = StuffingType.FOAM;
                this.price = 50;
                break;
        }
    }
}
