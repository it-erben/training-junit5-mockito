# Aufgabenstellung: Test Driven Development (TDD) mit JUnit 5 und Mockito

## Ziel

In dieser Übung entwickeln Sie schrittweise ein Kundenverwaltungssystem.
Der gesamte Entwicklungsprozess erfolgt testgetrieben (Test Driven
Development, TDD). Dies bedeutet, dass Sie vor der Implementierung der
Funktionalität stets zuerst die Tests schreiben.

Das Ziel ist es, ein einfaches System zur Verwaltung von Kontakten zu
entwickeln, das die folgenden Kernfunktionalitäten unterstützt:

- **Kontakte anlegen**
- **Kontakte aktualisieren**
- **Kontakte löschen**

Es ist nicht entscheidend, dass alle Anforderungen vollständig umgesetzt
werden. Wichtig ist, dass Sie den TDD-Ansatz einhalten und Erfahrungen im
iterativen Entwicklungsprozess sammeln.

---

## Systemanforderungen

1. **Kontakte erstellen**

   - Ein Kontakt muss mindestens einen **Vornamen** und einen
     **Nachnamen** besitzen.
   - Optional kann ein Kontakt einen **mittleren Namen** enthalten.
   - Ein Kontakt kann ein **Geburtsdatum** besitzen (optional).
   - Das Adressbuch soll Exceptions werfen, wenn die Pflichtfelder nicht
     gesetzt sind.

2. **Adressen und Telefonnummern**

   - Ein Kontakt kann **eine oder mehrere Adressen** sowie
     **eine oder mehrere Telefonnummern** besitzen.
   - Jeder Kontakt darf **maximal fünf Telefonnummern** und
     **maximal fünf Adressen** haben.
   - Das Adressbuch soll Exceptions werfen, wenn zu viele Adressen oder
     Telefonnummern übergeben werden.
   - Für die Adressen und Telefonnummern entwickeln Sie ein eigenes,
     sinnvolles Datenmodell. Beachten Sie dabei, welche Informationen
     eine Adresse und eine Telefonnummer idealerweise enthalten sollten.

3. **Altersberechnung**

   - Das System sollte für einen Kontakt, der ein Geburtsdatum hat, das
     **aktuelle Alter** berechnen und zurückgeben können.

---

## Schritte zur Umsetzung

1. **Test schreiben (Red)**

   - Beginnen Sie jede Funktionalität, indem Sie einen Test dafür
     schreiben, bevor Sie den dazugehörigen Code implementieren.
   - Beispiel: Schreiben Sie einen Test, der überprüft, ob ein Kontakt
     korrekt erstellt wird, wenn Vor- und Nachname angegeben sind.

2. **Code implementieren (Green)**

   - Implementieren Sie den minimalen Code, um die Tests erfolgreich zu
     bestehen.

3. **Refaktorisieren (Refactor)**

   - Verbessern Sie den Code, ohne die Funktionalität zu ändern, und
     stellen Sie sicher, dass alle Tests weiterhin erfolgreich sind.

---

## Vorgaben für den Testprozess

1. Verwenden Sie **JUnit 5** für das Schreiben und Ausführen der Tests.
2. Nutzen Sie **Mockito** für das Mocking von Abhängigkeiten, falls
   erforderlich (z.B. wenn Sie zwischen Service und Repository trennen).
3. **Verwenden Sie parametrisierte Tests** für das Erzeugen von
   Beispieldaten, wie z. B. Telefonnummern in unterschiedlichen
   Formaten, um sicherzustellen, dass das System flexibel auf
   verschiedene Eingaben reagiert. Dies hilft dabei, unterschiedliche
   Anwendungsfälle zu testen, ohne den Code zu duplizieren.
4. Führen Sie nach jedem Entwicklungsschritt die Testfälle aus und
   passen Sie den Code an, wenn Fehler auftreten.
