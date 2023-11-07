package javacroc.matveeva.task5.devices;

import javacroc.matveeva.task5.DeviceGeneral;

public class Stove extends DeviceGeneral {

    // дополнительные поля для печей
    int oven;
    int burnersNumber;

    // конструктор печей
    Stove (
            String name,
            int price,
            String description,
            double height,
            double width,
            double depth,
            int oven,
            int burnersNumber,
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
        this.oven = oven;
        this.burnersNumber = burnersNumber;
        this.color = color;
        this.status = status;
        this.IsRussianManufacturer = IsRussianManufacturer;
        this.manufacturerCountry = manufacturerCountry;
        this.guarantee = guarantee;
        this.importGuarantee = importGuarantee;
    }


    // метод получения характеристик
    public static void getStove(String[] args) {

        Stove gefest = new Stove(
                "Газовая плита Gefest GC 531E2WH",
                14_999,
                "Реализована возможность очистки внутренней поверхности паром. Температура во время готовки может достигать 275°С. Встроенный цифровой дисплей отображает все основные параметры. Управление производится при помощи поворотных переключателей и сенсорных кнопок. Плита комплектуется глубоким и плоским противнями, металлической решеткой.",
                85,
                50,
                53,
                42,
                4,
                "Белый",
                "В наличии",
                false,
                "Беларусь",
                24,
                "Да");

        Stove deluxe = new Stove(
                "Электрическая плита De Luxe 5004.16э 017",
                16_499,
                "Электрическая плита De Luxe 5004.16э 017 оформлена в терракотовом цвете. Покрытие из эмалированной стали устойчиво к повреждениям и без труда очищается от загрязнений. Плита оборудована 4 чугунными конфорками диаметром 145/180 мм и духовым шкафом емкостью 43 л. Режим «Гриль» позволяет готовить сочные блюда с поджаристой корочкой. Для равномерного запекания крупных кусков мяса и овощей целиком есть вертел.",
                85,
                50,
                50,
                65,
                2,
                "Оранжевый",
                "Нет в наличии",
                true,
                "Россия",
                12,
                "Нет");

        Stove gorenje = new Stove(
                "Электрическая плита Gorenje GEC5C40WC",
                40_499,
                "Электрическая плита Gorenje GEC5C40WC представлена в белом цвете. Варочная поверхность выполнена из стеклокерамики и оснащена четырьмя конфорками диаметром от 14,5 см до 18 см. Предусмотрена расширенная зона нагрева для использования объемной посуды. Индикаторы остаточного тепла дают возможность доводить пищу до готовности в выключенном состоянии. В нижней части корпуса расположен выдвижной ящик для хранения посуды.",
                85,
                50,
                59.4,
                70,
                4,
                "Белый",
                "В наличии",
                false,
                "Чехия",
                12,
                "Да");
    }

}
