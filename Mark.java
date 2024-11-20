public enum Mark {
        BLANK,
        X,
        O;

    String toString(Mark mark){
        /*
        This function receives an enum object of type Mark and returns it as a string.
        If mark is BLANK, null is returned.
         */
        return switch (mark) {
            case X -> "X";
            case O -> "O";
            default -> null;
        };
    }
}