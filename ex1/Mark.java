

public enum Mark {
        BLANK, X, O;


        @Override
        public String toString(){
            /*
            This function receives an enum object of type Mark and returns it as a string.
            If mark is BLANK, null is returned.
             */
            return switch (this) {
                case X -> "X";
                case O -> "O";
                default -> null;
            };
        }
}