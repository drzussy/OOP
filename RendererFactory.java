

/**
 * A factory that maps
 */

public class RendererFactory {
    RendererFactory(){}
    public Renderer buildRenderer(String type, int size) {
        Renderer renderer;
        if (type.equals("void")) {
            return new VoidRenderer();
        } else {
            return new ConsoleRenderer(size);
        }
    }
}
