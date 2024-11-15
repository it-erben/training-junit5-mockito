# Parameterized Tests nutzen

In dieser Übung lernen Sie, wie Parameterized Tests in JUnit 5 mit verschiedenen Quellen verwendet werden. Sie schreiben Tests für die Methoden der Klasse `StringTools` und nutzen dabei `@ValueSource`, `@CsvSource`, `@MethodSource` und `@CsvFileSource`.

## Aufgabe 1: `@ValueSource`

1. **Ziel**: Erstellen Sie einen Parameterized Test, um die Methode `isPalindrome` zu testen. Hinweis: Ein Palindrom ist eine Zeichenkette, die gleich bleibt, wenn sie umgekehrt wird – wobei Groß- und Kleinschreibung ignoriert werden.
2. **Vorgehen**:
    - Nutzen Sie `@ValueSource`, um eine Reihe von Palindrom-Strings zu übergeben, die alle als `true` bewertet werden sollten.
    - Beispiele für Palindrome: 
      - Hannah, 
      - neben
      - Otto
      - Regallager
      - Reittier
3. **Schreiben Sie den Test**:
    - Erstellen Sie eine Methode `testIsPalindrome` in der Testklasse `StringToolsTest`.
    - Verwenden Sie die Annotation `@ValueSource(strings = { ... })` mit mindestens fünf Beispielwerten, die Palindrome sind.

## Aufgabe 2: `@CsvSource`

1. **Ziel**: Erstellen Sie einen Parameterized Test, um die Methode `countVowels` zu testen. Sie soll die Anzahl an Vokalen in einem String zurückgeben.
2. **Vorgehen**:
    - Nutzen Sie `@CsvSource`, um eine Reihe von Eingaben und erwarteten Ausgaben anzugeben.

3. **Schreiben Sie den Test**:
    - Erstellen Sie eine Methode `testCountVowels` in der Testklasse `StringToolsTest`.
    - Verwenden Sie die Annotation `@CsvSource({ ... })` mit Eingaben und den erwarteten Ergebnissen.

## Aufgabe 3: `@MethodSource`

1. **Ziel**: Erstellen Sie einen Parameterized Test, um die Methode `reverse` zu testen.
2. **Vorgehen**:
    - Verwenden Sie `@MethodSource`, um eine Methode zu definieren, die Testdaten bereitstellt.
    - Die Methode sollte eine Liste von Eingaben und erwarteten Ausgaben zurückgeben.

3. **Schreiben Sie den Test**:
    - Erstellen Sie eine Methode `testReverse` in der Testklasse `StringToolsTest`.
    - Definieren Sie eine Methode `reverseTestCases`, die `Stream<Arguments>` zurückgibt, mit Eingaben und den erwarteten Ergebnissen.

## Aufgabe 4: `@CsvFileSource`

1. **Ziel**: Erstellen Sie einen Parameterized Test, um die Methode `toTitleCase` zu testen.
2. **Vorbereitung**:
    - Erstellen Sie eine CSV-Datei namens `title_cases.csv` in Ihrem Projektverzeichnis `src/test/resources`.
    - Fügen Sie folgende Zeilen hinzu:

      ```
      input,expected
      "hello world","Hello World"
      "java programming","Java Programming"
      "parameterized tests","Parameterized Tests"
      "unit testing","Unit Testing"
      ```

3. **Schreiben Sie den Test**:
    - Erstellen Sie eine Methode `testToTitleCase` in der Testklasse `StringToolsTest`.
    - Verwenden Sie `@CsvFileSource(resources = "/title_cases.csv", numLinesToSkip = 1)`, um die Daten aus der Datei zu laden.
