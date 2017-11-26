package edu.sjsu.whiteboard.shapes;

import edu.sjsu.whiteboard.models.DLineModel;
import edu.sjsu.whiteboard.models.DShapeModel;

import java.awt.*;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Created by danil on 11/11/17.
 */
public class DLine extends DShape{

    public DLine(){}

    @Override
    public void setPointerToDShapeModel(DShapeModel pointerToDShapeModel) {
    	if(pointerToDShapeModel instanceof DLineModel)
    	{
    		super.setPointerToDShapeModel((DLineModel)pointerToDShapeModel); // call to set dShapeModel in parent class
    	}
    }

    public DShapeModel getDShapeModel() {
        return super.getDShapeModel();// call to get dShapeModel in parent class
    }

    @Override
    public void modelChanged(DShapeModel pointerToDShapeModel) {
        System.out.println("redraw line");
        getCanvasReferencel().repaint();
    }

    @Override
    public void setKnobs(){
        // TODO: Change from 4 knobs to 2 knobs
        //each time model changes, need a new ArrayList...
        //otherwise, it will keep adding points...
        knobPoints = new ArrayList<>();
        knobs =  new ArrayList<>();
        Point knobPoint1 = ((DLineModel)(super.getDShapeModel())).getP1();
        Point knobPoint2 = ((DLineModel)(super.getDShapeModel())).getP2();
        knobPoints.add(knobPoint1);
        knobPoints.add(knobPoint2);
        knobs.add(new Knob(knobPoint1));
        knobs.add(new Knob(knobPoint2));
    }


    @Override
    public void draw(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        //get two points from model
        Point point1 = ((DLineModel)(super.getDShapeModel())).getP1();
        Point point2 = ((DLineModel)(super.getDShapeModel())).getP2();
        g2.setColor(super.getDShapeModel().getColor()); 
        g2.drawLine(point1.x, point1.y, point2.x, point2.y);      
        super.drawKnobs(g2);
    }


}
