package ru.job4j.condition;

public class DummyBot {
//Бот должен принимать строку и возвращать ответ.
//
//Бот наш глупый. Он умеет отвечать только на три Фразы.
//
//Если пришла фраза "Привет, Бот.", бот отвечает: "Привет, умник."
//
//Если пришла фраза "Пока.", бот отвечает: "До скорой встречи."
//
//Если пришла любая другая фраза,  бот отвечает: "Это ставит меня в тупик. Задайте другой вопрос."
//
//Помните, что строки можно сравнивать только через методы equals. Нельзя использовать ==.
    public static String answer(String question) {
        String rsl = "Это ставит меня в тупик. Задайте другой вопрос.";
        if ("Привет, Бот.".equals(question)) {
            rsl = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            rsl = "До скорой встречи.";
        }
        return rsl;
    }
}