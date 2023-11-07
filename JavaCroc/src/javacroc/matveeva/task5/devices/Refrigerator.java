package javacroc.matveeva.task5.devices;

import javacroc.matveeva.task5.DeviceGeneral;

public class Refrigerator extends DeviceGeneral {

    // дополнительные поля для холодильников
    public int compartmentCount;
    public String freezerPresence;

    public int getCompartmentCount() {
        return compartmentCount;
    }
    public void setCompartmentCount(int compartmentCount) {
        this.compartmentCount = compartmentCount;
    }

    public String getFreezerPresence() {
        return freezerPresence;
    }
    public void setFreezerPresence(String freezerPresence) {
        this.freezerPresence = freezerPresence;
    }



}



