public class Pair {

        private final int capacity ;
        private final int perPerson ;

        public Pair(int capacity,int perPerson) {
            this.capacity = capacity;
            this.perPerson = perPerson;
        }

        public int getPerPerson() {
            return perPerson;
        }
        public int getCapacity() {
            return capacity;
        }

}
