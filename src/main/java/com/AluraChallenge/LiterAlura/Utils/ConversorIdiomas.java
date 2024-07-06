package com.AluraChallenge.LiterAlura.Utils;

import java.util.Map;
import java.util.stream.Collectors;

public class ConversorIdiomas {
    public static final Map<String, String> conversorIdiomas = Map.ofEntries(
            Map.entry("en","Inglés"),
            Map.entry("de", "Alemán"),
            Map.entry("fr", "Francés"),
            Map.entry("it", "Italiano"),
            Map.entry("es", "Español"),
            Map.entry("ru", "Ruso"),
            Map.entry("zh", "Chino"),
            Map.entry("da", "Danes"),
            Map.entry("nl", "Neerlandés"),
            Map.entry("eo", "Esperanto"),
            Map.entry("fi", "Finlandes"),
            Map.entry("la", "Latín"),
            Map.entry("el", "Griego"),
            Map.entry("hu", "Húngaro"),
            Map.entry("pt", "Portugués"),
            Map.entry("sv", "Sueco"),
            Map.entry("jp", "Japonés"),
            Map.entry("pl", "Polaco"),
            Map.entry("he", "Hebreo"),
            Map.entry("af", "Afrikáans"),
            Map.entry("ca", "Catalán"),
            Map.entry("no", "Noruego")

            );

    public static final Map<String, String> conversorIdiomasInverso = conversorIdiomas
            .entrySet()
            .stream()
            .collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));


}
