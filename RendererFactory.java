import javax.swing.*;

/**
 * A factory that maps
 */
public class RendererFactory {
    RendererFactory(){}
    public Renderer buildRenderer(String type, int size){
        Renderer renderer;
        switch(type){
            case "void":
                renderer = new VoidRenderer();
            default:
                renderer = new ConsoleRenderer(size);

        }
        return renderer;
    }
}
