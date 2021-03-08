/*
 * Course:     SE 2811
 * Term:       Winter 2020-21
 * Assignment: Lab 5: Decorators
 * Author: Dr. Yoder and Nigel Nelson
 * Date: 1/25/21
 */
package networks;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ToggleButton;
import java.util.HashMap;
import java.util.Map;

/**
 * The controller for the main window.
 *
 * Also manages the networks.
 */
public class SimpleCanvasController {
    @FXML
    private Canvas canvas;

    private Map<String, Network> displayable_networks = new HashMap<>();
    private static final int NUM_ALEX_LAYERS = 5;
    private static final int NUM_INCEPTION_LAYERS = 4;
    private static final int NUM_UNUSUAL_LAYERS = 6;


    @FXML
    private void showNetwork(ActionEvent actionEvent) {
        ToggleButton source = (ToggleButton)actionEvent.getSource();
        String id = source.getId();
        System.out.println("id = " + id);
        // Clear Canvas: https://stackoverflow.com/q/27203671/1048186
        GraphicsContext context = canvas.getGraphicsContext2D();
        System.out.println("canvas.getWidth() = " + canvas.getWidth());
        System.out.println("canvas.getHeight() = " + canvas.getHeight());
        context.setLineWidth(3);
        context.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        if(!displayable_networks.containsKey(id)) {
            System.out.println("Warning: Unknown network id:"+id);
        } else {
            System.out.println("DEBUG: Drawing network: "+id);
            Network network = displayable_networks.get(id);

            network.drawLayer(canvas);
        }
    }

    @FXML
    private void initialize() {
        displayable_networks.put("alexLike", createAlexNet());
        displayable_networks.put("inceptionLike", createInception());
        displayable_networks.put("unusualLike", createUnusualNetwork());
    }

    /**
     * As client code, use the decorator classes to construct the inception-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private Network createInception() {
        double increment = (canvas.getWidth()/(NUM_INCEPTION_LAYERS+1));
        Network identityNetwork = new Network();
        identityNetwork.createLayer(3, canvas, increment);
        Network expandedNetwork1 = new ConvolutionalLayer(identityNetwork);
        expandedNetwork1.createLayer(3, canvas, increment*2);
        Network expandedNetwork2 = new ConvolutionalLayer(expandedNetwork1);
        expandedNetwork2.createLayer(3, canvas, increment*3);
        Network expandedNetwork3 = new ConvolutionalLayer(expandedNetwork2);
        expandedNetwork3.createLayer(3, canvas, increment*4);
        return expandedNetwork3;
    }

    /**
     * As client code, use the decorator classes to construct the AlexNet-like network,
     * as described in the lab.
     * @return network The network created.
     */
    private Network createAlexNet() {
        double increment = canvas.getWidth()/(NUM_ALEX_LAYERS+1);
        Network identityNetwork = new Network();
        identityNetwork.createLayer(4, canvas, increment);
        Network expandedNetwork1 = new ConvolutionalLayer(identityNetwork);
        expandedNetwork1.createLayer(4, canvas, increment*2);
        Network expandedNetwork2 = new ConvolutionalLayer(expandedNetwork1);
        expandedNetwork2.createLayer(4, canvas, increment*3);
        Network expandedNetwork3 = new FullyConnectedLayer(expandedNetwork2);
        expandedNetwork3.createLayer(4, canvas, increment*4);
        Network expandedNetwork4 = new FullyConnectedLayer(expandedNetwork3);
        expandedNetwork4.createLayer(3, canvas,increment*5);
        return expandedNetwork4;
    }

    private Network createUnusualNetwork(){
        double increment = (canvas.getWidth()/(NUM_UNUSUAL_LAYERS+1));
        Network identityNetwork = new Network();
        identityNetwork.createLayer(6, canvas, increment);
        Network expandedNetwork1 = new ConvolutionalLayer(identityNetwork);
        expandedNetwork1.createLayer(6, canvas, increment*2);
        Network expandedNetwork2 = new FullyConnectedLayer(expandedNetwork1);
        expandedNetwork2.createLayer(7, canvas, increment*3);
        Network expandedNetwork3 = new FullyConnectedLayer(expandedNetwork2);
        expandedNetwork3.createLayer(1, canvas, increment*4);
        Network expandedNetwork4 = new FullyConnectedLayer(expandedNetwork3);
        expandedNetwork4.createLayer(3, canvas,increment*5);
        Network expandedNetwork5 = new ConvolutionalLayer(expandedNetwork4);
        expandedNetwork5.createLayer(3, canvas, increment*6);
        return expandedNetwork5;
    }
}
