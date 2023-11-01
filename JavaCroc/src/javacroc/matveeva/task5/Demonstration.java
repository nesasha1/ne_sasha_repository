package javacroc.matveeva.task5;

import javacroc.matveeva.task5.devices.Refrigerator;
import javacroc.matveeva.task5.devices.Stove;
import javacroc.matveeva.task5.devices.Microwave;

import java.util.ArrayList;
import java.util.List;

public class Demonstration {
    static public List<DeviceGeneral> deviceList = new ArrayList<>();

    public static void main(String[] args) {
        printCharacteristics(deviceList);
    }

    static {

        Refrigerator liebherrA = new Refrigerator();
        liebherrA.setName("Двухкамерный холодильник Liebherr CNef 5735-21");
        liebherrA.setPrice(150_000);
        liebherrA.setDescription("Двухкамерный холодильник с системой NoFrost");
        liebherrA.setHeight(201);
        liebherrA.setWidth(70);
        liebherrA.setDepth(66.5);
        liebherrA.setColor("Серебристый");
        liebherrA.setStatus("Нет в наличии");

        deviceList.add(liebherrA);

    }

    public static void printCharacteristics(List<DeviceGeneral> devices) {

        for (DeviceGeneral device : devices) {
            System.out.println(device.getCharacteristics());
        }

    }
}


