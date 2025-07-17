public class Pair {

        private final int capacity ;
        private final int perPerson ;
        private final int turfID ;
        private  final int bookings ;

        public Pair(int capacity, int perPerson, int turfID, int bookings) {
            this.capacity = capacity;
            this.perPerson = perPerson;
            this.turfID = turfID;
            this.bookings = bookings;
        }

    public int getBookings() {
        return bookings;
    }

    public int getTurfID(){
            return turfID;
        }
        public int getPerPerson() {
            return perPerson;
        }
        public int getCapacity() {
            return capacity;
        }

}
