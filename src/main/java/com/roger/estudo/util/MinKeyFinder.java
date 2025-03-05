package com.roger.estudo.util;

import java.util.Map;
import java.util.Optional;

public class MinKeyFinder {
    public static Double calcularVolume(Map<String, Double> medidas) {
        Optional<Map.Entry<String, Double>> minEntry = medidas.entrySet().stream().min(Map.Entry.comparingByValue()); //comparingByValue()>

        if(minEntry.isEmpty()) {
            throw new IllegalArgumentException("Map is empty");
        }

        // pga a chave do menor valor
        String minKey = minEntry.get().getKey();

        Double minValue = minEntry.get().getValue();

        //dobra o menor valor
        medidas.put(minKey, minValue * 2);

        // Calcula o volume multiplicando os tres valores
        return medidas.values().stream().reduce(1.0, (a, b) -> a * b);



    }

    public static void main(String[] args) {
        Map<String, Double> medidas = Map.of("altura", 1.0, "largura", 4.0, "comprimento", 3.0);


        Double volume = calcularVolume(medidas);


        ;
    }
}

