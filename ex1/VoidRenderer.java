
/**
 * Empty implementation of Renderer. Doesn't actually render anything to monitor.
 * Use this Renderer subclass to run program between two computer players quickly.
 */
public class VoidRenderer implements Renderer {
    VoidRenderer(){};

    /**
     * does literally nothing
     * @param board
     */
    public void renderBoard(Board board){}

}
