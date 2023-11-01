package javacroc.matveeva.task5.devices;

import javacroc.matveeva.task5.DeviceGeneral;

public class Microwave extends DeviceGeneral {

    // дополнительные поля для микроволновок
    int volume;
    String displayPresence;

    // конструктор микроволновок
    Microwave (
            String name,
            int price,
            String description,
            double height,
            double width,
            double depth,
            int volume,
            String displayPresence,
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
        this.volume = volume;
        this.displayPresence = displayPresence;
        this.color = color;
        this.status = status;
        this.IsRussianManufacturer = IsRussianManufacturer;
        this.manufacturerCountry = manufacturerCountry;
        this.guarantee = guarantee;
        this.importGuarantee = importGuarantee;
    }

    // метод
    public static void getMicrowave(String[] args) {

        Microwave dexp = new Microwave(
                "Микроволновая печь DEXP MS-71",
                4_999,
                "Микроволновая печь DEXP MS-71 обладает всеми необходимыми для такого типа устройств функциями и возможностями, и при этом не усложнена лишними и редко используемыми. Модель мощностью 700 Вт позволяет размораживать, готовить и разогревать пищу. В 20-литровой камере модели установлен поворотный стол из закаленного стекла диаметром 24.5 см. Покрытие из эмалированной стали легко очищается губкой с моющим средством или даже обычной влажной салфеткой. Микроволновая печь DEXP MS-71 управляется посредством таймера на 30 минут и простого поворотного переключателя. Мощность регулируется на 6 уровнях. Дверца прибора открывается с помощью ручки. Выполнен кухонный прибор в черном цвете, и его стильный дизайн можно назвать подходящим практически для любой кухни.",
                25.65,
                45.1,
                35.4,
                20,
                "Нет",
                "Белый",
                "Нет в наличии",
                false,
                "Китай",
                24,
                "Да");

        Microwave hyundai = new Microwave(
                "Микроволновая печь Hyundai HYM-D3032",
                5_599,
                "Микроволновая печь Hyundai HYM-D3032 станет надежной помощницей для быстрого разогрева и размораживания продуктов, а также приготовления различных блюд. Данная модель обладает внутренним объемом 20 литров и несколькими автоматическими программами с простым управлением при помощи поворотного механизма. На кнопочной панели управления имеются таймер для программирования определенного времени и функция блокировки от случайного изменения параметров. В наборе с Hyundai HYM-D3032 поставляются стеклянный поддон и кольцо вращения.",
                26.2,
                45.2,
                33.4,
                20,
                "Да",
                "Черный",
                "В наличии",
                false,
                "Китай",
                24,
                "Да");

        Microwave liebherr = new Microwave(
                "Микроволновая печь Gorenje MO4250TCLI",
                9_999,
                "Микроволновая печь Gorenje MO4250TCLI выполнена в корпусе бежевого цвета и выделяется оформлением в классическом изысканном стиле. Она оборудована несколькими автоматическими программами. Два поворотных механизма позволяют легко установить мощность микроволн из 5 доступных режимов и время воздействия. Данная модель обладает внутренним объемом 20 литров и покрытием на основе эмалированной стали. В комплекте с Gorenje MO4250TCLI предусмотрено стеклянное поворотное блюдо.",
                28.9,
                45.5,
                36.1,
                20,
                "Нет",
                "Бежевый",
                "В наличии",
                false,
                "Китай",
                12,
                "Да");

    }

}
