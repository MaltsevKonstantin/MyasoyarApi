package ru.maltsevkonstantin.myasoyarapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Product;
import ru.maltsevkonstantin.myasoyarapi.models.libraries.Tare;
import ru.maltsevkonstantin.myasoyarapi.services.ProductService;
import ru.maltsevkonstantin.myasoyarapi.services.TaresService;

import java.util.Collections;
import java.util.Date;
import java.util.Random;

import static ru.maltsevkonstantin.myasoyarapi.models.libraries.TareType.*;

@RestController
@RequestMapping("/test")
public class TestController {

    TaresService taresService;
    private final ProductService productService;

    @Autowired
    public TestController(TaresService taresService, ProductService productService) {
        this.taresService = taresService;
        this.productService = productService;
    }

    @GetMapping("/create_boxes/{quantity}")
    public void createTaresType1(@PathVariable int quantity) {
        Random random = new Random();
        int size = taresService.findAll().size();
        float[] boxWeights = {1.5f, 1.6f, 1.7f, 1.8f};
        for (int count = size + 1; count < quantity + size + 1; count++) {
            Tare tare = new Tare();
            tare.setName("Колбасный ящик " + (count));
            tare.setType(BOX);
            Tare.Weight weight = new Tare.Weight();
            weight.setDate(new Date());
            weight.setTare(tare);
            weight.setWeight(boxWeights[random.nextInt(boxWeights.length)]);
            tare.setWeights(Collections.singletonList(weight));
            taresService.save(tare);
        }
    }

    @GetMapping("/create_transports/{quantity}")
    public void createTaresType2(@PathVariable int quantity) {
        Random random = new Random();
        int size = taresService.findAll().size();
        float[] transportWeights = {6.4f, 6.5f, 6.6f, 6.7f, 6.8f};
        for (int count = size + 1; count < quantity + size + 1; count++) {
            Tare tare = new Tare();
            tare.setName("Колбасная тележка " + (count));
            tare.setType(TRANSPORT);
            Tare.Weight weight = new Tare.Weight();
            weight.setDate(new Date());
            weight.setTare(tare);
            weight.setWeight(transportWeights[random.nextInt(transportWeights.length)]);
            tare.setWeights(Collections.singletonList(weight));
            taresService.save(tare);
        }
    }

    @GetMapping("/create_manufactures/{quantity}")
    public void createTaresType3(@PathVariable int quantity) {
        Random random = new Random();
        int size = taresService.findAll().size();
        float[] manufactureWeights = {45.0f, 45.4f, 45.6f, 46.0f, 46.3f, 46.5f, 46.7f, 46.9f, 47.1f, 47.4f, 47.7f, 48.0f};
        for (int count = size + 1; count < quantity + size + 1; count++) {
            Tare tare = new Tare();
            tare.setName("Колбасная рама " + (count));
            tare.setType(MANUFACTURE);
            Tare.Weight weight = new Tare.Weight();
            weight.setDate(new Date());
            weight.setTare(tare);
            weight.setWeight(manufactureWeights[random.nextInt(manufactureWeights.length)]);
            tare.setWeights(Collections.singletonList(weight));
            taresService.save(tare);
        }
    }

    @GetMapping("/create_products")
    public void createProducts() {
        Product product = new Product();
        product.setName("Азовская целлофан, 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Балык свиной с/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Барская закуска с/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Барский перекус с/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Боярская п/к н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Боярская п/к н/о 450 г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Варшавская п/к н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Варшавская п/к натурин 400г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Домашняя айцел 2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Домашняя натурин произв.");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Классная п/а (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Нежная п/а 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Особая п/а (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Славянская белкозин 0,9 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Славянская белкозин 500г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Славянская н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Славянская натурин 2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Славянская п/а 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Совершенство для пиццы п/а 2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Совершенство п/а 1,3 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Сочная п/а 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ветчина Сочная п/а 500г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Вкусная целлофан 1,2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Вырезка с/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Грудинка свиная с/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Грудинка Традиционная к/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Детская  ГОСТ п/а, 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Докторская белкозин 1 кг СВЕТОФОР (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Докторская ГОСТ ц/о 400г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Докторская Традиционная п/а 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Докторская Традиционная целлофан 1,2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Докторская целлофан ГОСТ 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Домашняя п/к белкозин 0,9 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Донская п/к, н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Елисеевская целлофан 1,2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Закуска Деревенская (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Закуска Охотничья п/а (произв. )");
        productService.save(product);
        product = new Product();
        product.setName("Зельц По-домашнему п/а 1 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Карбонад Люкс к/в (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Княжеская п/к (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаса Ароматная п/а (СВЕТОФОР) (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Гриль п/к (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Домашние (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Карельские п/к, н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Особые п/к н/о  (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Карпачо п/к н/о СВЕТОФОР (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Колбаски Шашлычные п/к н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Краковская ГОСТ п/к н/о 0,4 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Кралька колбаса п/к произв.");
        productService.save(product);
        product = new Product();
        product.setName("Кубанская п/к ц/о 0,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Купеческая п/к н/о 0,6 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Ливерная Закусочная н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Молочная  целлофан ГОСТ 500г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Молочная целлофан ГОСТ 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Муромская целлофан 1,6 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Муромская  целлофан 500г ( произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Нежная целлофан 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Нежная п/а 500 г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Онежская в/к фиброуз 0,7 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Особая п/к белкозин (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Отдельная целлофан ГОСТ 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Отдельная целлофан 500г (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("По-фински в/к фиброуз 0,7 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Рубленая п/к 0,8 кг СВЕТОФОР (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Русская Традиционная п/а (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Русская Традиционная целлофан ГОСТ1,2 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Русская Традиционная цел 500гр. произв.");
        productService.save(product);
        product = new Product();
        product.setName("Русская целлофан ГОСТ 1,8 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Салями Венская в/к фиброуз 0,7 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Салями Итальянская с/в 0,6 кг ( произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Салями Королевская с/в 0,6 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Салями Сибирская в/к фиброуз 0,7 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Ароматные (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Бистро н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Ветчинные н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Говяжьи (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Лакомка н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Нежные н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Сливочные н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Сочные н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Толстячок СЫР айпил  (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сардельки Любительские (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Семейная н/о (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сервелат Австрийский в/к ГОСТ 0,7 кг (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сервелат Ароматный в/к 0,8 кг СВЕТОФОР (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сервелат Елисеевский в/к 0,9 кг белкозин (произв.)");
        productService.save(product);
        product = new Product();
        product.setName("Сервелат Зернистый в/к фиброуз 0.6 кг (произв.)");
        productService.save(product);




/*Сервелат Зернистый п/а произв.
Сервелат Итальянский (произв.)
Сервелат Итальянский СОТЫ (произв.)
Сервелат Классический произв.
Сервелат Коньячный в/к фиброуз 0,6 кг (произв.)
Сервелат Крестьянский 850г п/а (произв.)
Сервелат Московский п/к фиброуз 0,7 кг (произв.)
Сервелат Мускатный в/к фиброуз 0,7 кг (произв.)
Сервелат Мускатный в/к фиброуз 350г (произв.)
Сервелат Охотничий п/к п/а 0,85  кг (произв.)
Сервелат Российский в/к ГОСТ 0,7 кг (произв.)
Сервелат Столичный 0,8 кг СВЕТОФОР (произв.)
Сервелат Столичный в/к п/а 0,85 кг (произв.)
Сервелат Фирменный в/к фиброуз 0,6 кг (произв.)
Сервелат Царский п/к 0,7 кг СВЕТОФОР (произв.)
Сервелат Юбилейный в/к фиброуз 0,6 кг (произв.)
Сервелат Ярославский в/к фиброуз 0,7 кг (произв.)
Сервелатная п/к (произв.)
Сливочная целлофан 1.8 кг (произв.)
Сосиска Большая 32 ножакс (произв.)
Сосиски Баварские с сыром п/а (произв.)
Сосиски Баварские с сыром п/а СВЕТОФОР(произв.)
Сосиски Венские 6 см вискофан копчение( произв.)
Сосиски Венские NDX 19 Москва (произв.)
Сосиски Венские NDX 24 (произв.)
Сосиски Венские вискофан (произв.)
Сосиски Вкусные 6 см, п/а розовый-4 (произв.)
Сосиски Докторские 50г п/а розовый-4 (произв.)
Сосиски Докторские 70г п/а копчение (произв.)
Сосиски Докторские NDX 19 (произв.)
Сосиски Ирландские 50г вискофан копчен (произв.)
Сосиски Ирландские 60г вискофан копчен (произв.)
Сосиски Ирландские 80г вискофан копчен (произв.)
Сосиски Классные 50г вискофан копчение (произв.)
Сосиски Классные 50г п/а копчение (произв.)
Сосиски Классные 60 г вискофан (произв.)
Сосиски Классные 65г 13,5 см вискофан (произв.)
Сосиски Классные 80г 19 см вискофан (произв.)
Сосиски Классные вискофан (произв.)
Сосиски Куриные п/а клише (произв.)
Сосиски Лакомка п/а клише (произв.)
Сосиски Люкс п/а (произв.)
Сосиски Малышок (Москва) (контроль)  п/а (произв.)
Сосиски Малышок ГОСТ п/а 65г (произв.)
Сосиски Малышок ГОСТ п/а клише (произв.)
Сосиски Молочные ГОСТ п/а клише (произв.)
Сосиски Молочные ГОСТ п/а клише 65г (произв.)
Сосиски Молочные п/а 40 г, (Москва) произв.
Сосиски Молочные п/а 50 г, (Москва) произв.
Сосиски Молочные Трад. п/а, 400г Светоф. (произв.)
Сосиски МолочныеТрадиционные айпил 4 кр п(произв.)
Сосиски МолочныеТрадиционные п/а клише (произв.)
Сосиски На завтрак 50 г вискофан (произв.)
Сосиски На завтрак 60 г вискофан (произв.)
Сосиски На завтрак 60 г п/а (произв.)
Сосиски Онежские 50 г, п/а копчение (произв.)
Сосиски Онежские 60 г вискофан (произ.)
Сосиски Онежские вискофан 4 кр п (произв.)
Сосиски Онежские вискофан б/ц (произв.)
Сосиски Премиум п/а копчение (произв.)
Сосиски с сыром п/а копчение СВЕТОФОР (произв.)
Сосиски Сибирские 13см 50г (произв.)
Сосиски Сибирские 70г вискофан копчен (произв.)
Сосиски Сибирские п/а копчение (произв.)
Сосиски Славянские вискофан 4 кр п (произв.)
Сосиски Сливочные п/а копчение СВЕТОФОР (произв.)
Сосиски со сливками 12 см п/а клише (произв.)
Сосиски со сливками 6 см п/а клише (произв.)
Сосиски со сливочным маслом айпил 4 кр п (произв.)
Сосиски Сочные 60 г 12,5 см п/а 4 кр (произв.)
Сосиски Сочные 60 г 13 см вискофан (произв.)
Сосиски Сочные 60 г 13 см п/а (произв.)
Сосиски Сочные вискофан копчение (произв.)
Сосиски Сочные ц/о (произв.)
Сосиски Столовые (произв.)
Сосиски Телячьи 13 см колфан 19  (произв.)
Сосиски Телячьи 19 см колфан 19  (произв.)
Сосиски Телячьи NDX 19 (произв.)
Сосиски ТЕЛЯЧЬИ вискофан произв.
Сосиски Удачные СВЕТОФОР (произв.)
Сосиски Фирменные 50 г вискофан б/ц (произв.)
Сосиски Фирменные 50 г, п/а 4 кр полосы (произв.)
Сосиски Ярославские вискофан 4 кр п (произв.)
Сосиски Ярославские п/а копчение (произв.)
Стейк свиной в маринаде, 500 г произв.
Столовая целлофан ГОСТ 1,8 кг (произв.)
Студень По-деревенски 2,5 кг (произв.)
Студень По-деревенски 800г (произв.)
Студень По-домашнему 600г ( произв.)
Суздальская п/к произв.
Суповой набор  (произв.)
Сытная п/а, 1кг  СВЕТОФОР (произв.)
Таежная п/к, фиброуз, 0,7 кг (произв.)
Таежная п/к, фиброуз, 350 г ( произв.)
Ушки свиные с аджикой к/в (произв.)
Ушки свиные с хреном к/в (произв.)
Ушки свиные с чесночком к/в (произв.)
Фарш Деликатесный 500 г п/а (произв.)
Фарш по-домашнему 1 кг (произв)
Фарш по-домашнему 500 г охл. (произв.)
Фарш по-домашнему, 500 гр, п/а, зам. (произв.)
Фарш Традиционный (Пекарни) 500 г зам п/а (произв)
Фарш Традиционный (пекарня), 1 кг, п/а,зам.произв.
Фирменная п/к п/а (произв.)
Фирменная п/к соты (произв.)
Хлеб Богатырский (произв.)
Хлеб Крестьянский 400г (произв.)
Хлеб Крестьянский произв.
Холодец Застольный 600г ( произв.)
Холодец По-русски СВЕТОФОР (произв.)
Чайная ГОСТ ц/о 400г (произв.)
Чайная целлофан ГОСТ 1,8 кг (произв.)
Чесноковая  н/о (произв.)
Шашлык Кавказский 1 кг, лоток (произв.)
Шашлык Свиной в маринаде лоток 1 кг (произв.)
Шейка Люкс к/в (произв.)
Шейка свиная с/в (произв.)
Шницель Аппетитный 50 г замороженный (произв.)
Шницель Аппетитный 90 г замороженный (произв.)
Шницель Аппетитный 90 г охл. 1,62 кг (произв.)
Шницель Аппетитный 90 г охл. 540 г (произв.)
Шпик для закуски ( произв.)
Шпик по-венгерски (произв.)
Шпик по-домашнему  (произв.)
Шпик соленый с чесноком 400 г СВЕТОФОР (произв.)
Шпикачки Боярские н/о (произв.)
Шпикачки Боярские Сети ВЛ (произв.)
Шпикачки Краснодарские н/о (произв.)
Шпикачки Любимые н/о (произв.)
Шпикачки Москворецкие п/а СВЕТОФОР (произв.)
Шпикачки Русские 500г NDX (произв.)
Шпикачки Русские н/о (произв.)
Щечки свиные (произв.)
Эксп. Докторская Любимая п/а  произв.
Эксп. Докторская любимая целлофан произв.
Эксп. Сардельки Докторские любимые произв.
Элитная п/к 0,7 кг (произв.)
Элитная п/к СОТЫ произв.
Юбилейная п/к, амбер  произв.
Юбилейная п/к, соты (произв.)
Ярославская колбаса п/а 1кг (произв.)*/












    }
}
