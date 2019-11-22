/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica01;


import java.awt.Color;
import java.util.Iterator;
import java.util.Random;
import org.graphstream.algorithm.generator.Generator;
import org.graphstream.algorithm.generator.RandomGenerator;
import org.graphstream.graph.Graph;
import org.graphstream.graph.Node;
import org.graphstream.graph.implementations.SingleGraph;

public class VisGraph {

	public void showWindow(){		
		
		    Graph graph = new SingleGraph("Random");
		    Generator gen = new RandomGenerator(2);//Grado promedio de vertices
		    gen.addSink(graph);
		    gen.begin();
		    for(int i=0; i<100; i++)
		    	gen.nextEvents();
		    gen.end();
                    graph.addAttribute("ui.stylesheet", "node {shape: box;fill-color: blue, green, red;text-mode:normal;text-background-mode: plain; fill-mode: dyn-plain;}");

                    for(Node v : graph.getEachNode()){
                        if(v.getDegree() > 0){
                            v.addAttribute("ui.color", Color.GREEN);
                        }else{
                            v.addAttribute("ui.color", getColor());
                        }
                    }
                    
		    graph.display();
	}
	
	public static void main(String [] args){
		VisGraph a = new VisGraph();
		a.showWindow();
	}
        
        public static Color getColor(){
            Random r = new Random();
            double d = r.nextDouble()*13;
            int in = (int)d;
            switch(in){
                case 0: return Color.BLACK;
                case 1: return Color.BLUE;
                case 2: return Color.CYAN;
                case 3: return Color.DARK_GRAY;
                case 4: return Color.GRAY;
                case 5: return Color.MAGENTA;
                case 6: return Color.LIGHT_GRAY;
                case 7: return Color.MAGENTA;
                case 8: return Color.ORANGE;
                case 9: return Color.PINK;
                case 10: return Color.RED;
                case 11: return Color.WHITE;
                case 12: return Color.YELLOW;
                default: return Color.BLUE;
            }
        }
}