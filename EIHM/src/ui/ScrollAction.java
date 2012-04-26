
package ui;

import java.awt.Adjustable;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;


class ScrollAction implements AdjustmentListener {

    public ScrollAction() {
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent ae) {
        Adjustable source = ae.getAdjustable();
    }
    
}
