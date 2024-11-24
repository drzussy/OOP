

/**
 * A factory that maps
 */

/**
 * A factory class that creates different types of renderers based on the given parameters.
 * It provides a method to instantiate either a `VoidRenderer` or a `ConsoleRenderer` based on the type
 * string provided.
 */
public class RendererFactory {
    /**
     * Constructs a new RendererFactory.
     * The constructor initializes a RendererFactory object that can be used to create renderers.
     */
    RendererFactory(){}

    /**
     * Builds and returns a Renderer object based on the specified type and size.
     * If the type is "void", a `VoidRenderer` is returned. Otherwise, a `ConsoleRenderer` is returned
     * with the given size.
     *
     * @param type The type of renderer to create (e.g., "void" or other valid types).
     * @param size The size to be used by the `ConsoleRenderer`. This parameter is ignored if the type is
     *             "void".
     * @return A `Renderer` object corresponding to the given type.
     */
    public Renderer buildRenderer(String type, int size) {
        Renderer renderer;
        if (type.toLowerCase().equals("void")) {
            return new VoidRenderer();
        } else if(type.toLowerCase().equals("console")) {
            return new ConsoleRenderer(size);
        }else{
            return null;
        }
    }
}
