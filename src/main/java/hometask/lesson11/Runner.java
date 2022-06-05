package hometask.lesson11;

/*
Необходимо создать приложение, которое будет в цикле обрабатывать пользовательский ввод и уведомлять пользователся
об внутренних ошибках.
Если пользователь вводит слово exit - программа завершается
Если пользователь вводит get - программа из памяти возвращает и удаляет элемент (строку)
Если пользователь вводит что-то иное - то данная строка сохраняется в память
Задание:
1) Реализовать обработку пользовательского ввода
2) Создать сервис для хранения ввода (массив или коллекция)
3) При превышении 5 элементов - возвращать информацию об ошибке пользователю (бросать исключение)
4) Если память пуста и пользователь хочет получить данные - показывать ошибку (память пуста)
5) Если пользователь забрал данные, то эти данные удаляются из хранилища (FIFO - первым зашел - первым вышел)
*/

import common.ReadersFromCMD;
import hometask.lesson11.exceptions.StorageMemoryEmptyException;
import hometask.lesson11.exceptions.StringStorageFullException;

public class Runner {
    public static void main(String[] args) {
        String str;
        String temp = "";
        ReadersFromCMD fromCMD = new ReadersFromCMD();
        InputStorageService service = new InputStorageService();
        do {
            try {
                str = fromCMD.readStr("Enter some string.");
                temp = service.serviceCore(str);
                System.out.println(temp);
            } catch (StorageMemoryEmptyException | StringStorageFullException e) {
                System.out.println(e.getMessage());
            }
        } while (!temp.equals("program closed"));
    }

}
