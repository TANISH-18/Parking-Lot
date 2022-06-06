package Model;

public enum ParkingSLotType {



    Car{
        public double getPrice(long duration)
        {
            return duration * 10;

        }
    },
    Bike{
        public double getPrice(long duration)
        {
            return duration * 5;

        }
    },
    Bus {
        public double getPrice(long duration) {
            return duration * 0.20;

        }
    };

    public abstract double getPrice(long duration);
}
