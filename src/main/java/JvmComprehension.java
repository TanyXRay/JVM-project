public class JvmComprehension { //  Metaspace попадает JvmComprehension уже загруженный с помощью ClassLoader.

    public static void main(String[] args) { // main опеределено место в фрейме стек - памяти
        int i = 1;                        //1 в стеке (Область памяти Stack)хранятся локальные переменные из фреймов: сюда опеределяется примитив. переменная i со значением 1
        Object o = new Object();          //2 объект new Object() попадает в кучу (область памяти heap), а ссылка на объект Object o будет определена в стек
        Integer integer = 2;              //3 объект класса-обертки Integer integer также определится в куче со значением 2
        printAll(o, i, integer);          //4  printAll также как и main будет хранится в стеке фреймов со значениями o, i, integer
        System.out.println("finished");   //7 System.out-статическая функция, хранится в в пуле строковых констант внутри кучи со значением "finished", println - хранится в стеке фреймов и ссылается на "finished"
    }// метод main() завершается на строке 9, поэтому стековая память для метода main() будет уничтожена.
    // Также программа заканчивается в этой строке, следовательно, Java Runtime освобождает всю память и завершает программу.

    private static void printAll(Object o, int i, Integer integer) {
        Integer uselessVar = 700;                       //5 бъект класса-обертки Integer uselessVar также определится в куче со значением 700
        System.out.println(o.toString() + i + integer); //6 System.out-статическая функция, хранится в в пуле строковых констант внутри кучи со значением o.toString(), println - хранится в стеке фреймов ссылаясь на o.toString(), i, integer
    } // Метод printAll завершается на строке 14, поэтому блок стековой памяти для этого метода становится свободным.
    // В куче работает сборщик мусора: освобождает память путем удаления объектов, на которые нет каких-либо ссылок, делая это параллельно с работой программы, производя остановку и очистку
}
