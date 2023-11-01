package javacroc.matveeva.task5.devices;

import javacroc.matveeva.task5.DeviceGeneral;

public class WashingMachine extends DeviceGeneral {

    // дополнительные поля для стиральных машин
    double maxLoad;
    int drumVolume;

    // конструктор стиральных машин
    WashingMachine (
            String name,
            int price,
            String description,
            double height,
            double width,
            double depth,
            double maxLoad,
            int drumVolume,
            String color,
            String status,
            boolean IsRussianManufacturer,
            String manufacturerCountry,
            int guarantee,
            String importGuarantee) {

        this.name = name;
        this.price = price;
        this.description = description;
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.maxLoad = maxLoad;
        this.drumVolume = drumVolume;
        this.color = color;
        this.status = status;
        this.IsRussianManufacturer = IsRussianManufacturer;
        this.manufacturerCountry = manufacturerCountry;
        this.guarantee = guarantee;
        this.importGuarantee = importGuarantee;
    }

    // метод получения характеристик
    public static void getWashingMachine(String[] args) {

        WashingMachine hotpoint = new WashingMachine(
                "Стиральная машина Hotpoint NSD 6239 S VE RU",
                32_999,
                "Модель Hotpoint NSD 6239 S VE RU оснащена функциями отсрочки запуска, дополнительного полоскания и регулировки скорости отжима в пределах 1200 об/мин. Конфигурацией устройства предусмотрена возможность добавления белья в процессе стирки. Уровень шума во время стирки не превышает 60 дБ, во время отжима - 83 дБ.",
                85,
                59.5,
                42.5,
                6,
                40,
                "Белый",
                "В наличии",
                true,
                "Россия",
                12,
                "Нет");

        WashingMachine  midea = new WashingMachine(
                "Стиральная машина Midea MF100W70/W",
                28_999,
                "Стиральная машина Midea MF100W70/W характеризуется низким уровнем шума во время работы. Это не создает помех отдыху и жизнедеятельности членов семьи. Модель оснащена загрузкой фронтального типа и вмещает белье весом до 7 кг. Это позволяет пользователю очищать в устройстве куртки, комбинезоны, свитера и домашний текстиль. Регулировка скорости отжима удобна для ухода за деликатными тканями. Стиральная машина имеет 15 рабочих программ. Это создает оптимальные условия для очищения одежды из хлопка, шерсти, джинсы.",
                85,
                59.5,
                40,
                7,
                45,
                "Белый",
                "В наличии",
                false,
                "Китай",
                24,
                "Да");

        WashingMachine grundig = new WashingMachine(
                "Стиральная машина Grundig GW5 P57H21 W",
                49_999,
                "Стиральная машина Grundig GW5 P57H21 W - это устройство с классом стирки A и отжима B. Оно функционирует на базе инверторного двигателя. Максимальная допустимая загрузка стиральной машины - 7,5 кг. Модель отжимает простирываемые вещи на скорости 1200 об/мин. Ее можно регулировать с панели управления.",
                84,
                60,
                49.6,
                7.5,
                55,
                "Белый",
                "В наличии",
                true,
                "Россия",
                24,
                "Нет");

    }

}
