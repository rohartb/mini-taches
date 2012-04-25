/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

/**
 *
 * @author bastien
 */
class ScrollAction implements AdjustmentListener {

    public ScrollAction() {
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        Adjustable source = ae.getAdjustable();
    }
    
}
