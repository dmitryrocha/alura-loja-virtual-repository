package alura.java8;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// Considerando a lista abaixo execute as seguintes operações usando as features do Java 8+
// não utilize: for/while/if

//1 . imprima todos os itens da lista no console
//2 . imprima os números distintos em ordem crescente
//3 . imprima os números impares  e distintos em ordem decrescente
//4. imprima a soma dos números ignorando os 3 primeiros
//5. imprima cada número da lista multiplicado por 2
//6. imprima de forma agrupada os números pares e impares ( ambos os grupos apenas números distintos)
//7. imprima o maior número da lista, se não houver lance uma java.util.NoSuchElementException
//8. imprima apenas os 3 primeiros números da lista
//9. imprima a média dos números da lista, se não for possível calcular a média imprima Double.NaN
//10. imprima a quantidade de elementos da lista, a soma de seus elementos, a média e o valor máximo
//11. imprima a data de hoje, somando a quantidade de dias indicadas por cada elemento distinto da lista em ordem crescente

public class Exercicios {
    public static LocalDate hoje = LocalDate.now();
    public static void main(String[] args) {
        questao01();
        questao02();
        questao03();
        questao04();
        questao05();
        questao06();
        questao07();
        questao08();
        questao09();
        questao10();
        questao11();

    }

    public static void questao01() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 1:");
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
    public static void questao02() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 2:");
        Collections.sort(numbers);
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
    public static void questao03() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 3:");
        List q3List = numbers.stream().sorted(Comparator.reverseOrder()).filter(num -> num % 2 != 0).distinct().collect(Collectors.toList());
        q3List.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
    public static void questao04() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 4:");
        int sum = numbers.stream().skip(3).reduce(0, Integer::sum);
        System.out.println("A soma é "+ sum);
    }
    public static void questao05() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 5:");
        numbers = numbers.stream().map(e -> e*2).collect(Collectors.toList());
        numbers.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }

    public static void questao06() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 6:");
        Map<Boolean, List<Integer>> separados = numbers.stream().distinct().collect(Collectors.groupingBy(x -> x % 2 == 0));
        List<Integer> pares = separados.get(true);
        List<Integer> impares = separados.get(false);
        System.out.print("Pares: ");
        pares.forEach(num -> System.out.print(num + " "));
        System.out.print("\nÍmpares: ");
        impares.forEach(num -> System.out.print(num + " "));
        System.out.println();
    }
    public static void questao07() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        int vMax = numbers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException:: new);
        System.out.println("Questão 7:");
        System.out.println("O maior número da lista é: " + vMax);

    }
    public static void questao08() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        Stream<Integer> numbersRange = numbers.stream().skip(0).limit(3);
        System.out.println("Questão 8:");
        numbersRange.forEach(num -> System.out.print(num + " "));
        System.out.println("");
    }
    public static void questao09() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 9:");
        double media = numbers.stream().mapToDouble(v -> v).average().orElse(Double.NaN);
        System.out.println("A média dos números da lista é: " + media);
    }
    public static void questao10() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        int vMax = numbers.stream().mapToInt(v -> v).max().orElseThrow(NoSuchElementException:: new);
        int soma = numbers.stream().reduce(0, Integer::sum);
        double media = numbers.stream().mapToDouble(v -> v).average().orElse(0.0);
        System.out.println("Questão 10:");
        System.out.println("Quantidade de elementos da lista: "+ numbers.size());
        System.out.println("A soma de seus elementos: " + soma);
        System.out.println("A média dos valores na lista é: " + media);
        System.out.println("Valor máximo: " + vMax);
    }
    public static void questao11() {
        List<Integer> numbers = Arrays.asList(1, 5, 8, 7, 4, 1, 6, 3, 2, 1, 8, 5, 7, 4);
        System.out.println("Questão 11:");
        numbers = numbers.stream().distinct().sorted().collect(Collectors.toList());
        numbers.forEach(num -> System.out.println("Data de hoje + " + num.toString() + " é " + hoje.plusDays(num.longValue())+" "));
    }
}
