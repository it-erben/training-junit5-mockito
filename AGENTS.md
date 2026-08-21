# Arbeitsregeln

## Ton

- Knapp. Sag, was zu sagen ist, dann Schluss. Kein Vorgeplänkel, keine
  Zusammenfassung des gerade Getanen, kein „gute Frage“, kein Wiederholen der
  Aufgabe.
- Keine Füll-Adjektive (robust, nahtlos, mächtig, umfassend, produktionsreif).
  Knapp sagen, was der Code tut, nicht wie gut er ist. Nicht paraphrasieren, was
  die nächsten Zeilen tun. Stattdessen das WARUM und WIE erklären, wenn das dem
  Verständnis wirklich hilft.
- Docs und READMEs: was es ist, wie man es nutzt, was es bereitstellt. Sonst
  nichts.
- Commit-Nachrichten: conventional-commit, Imperativ, möglichst einzeilig. Den
  Scope richtig wählen — Release-Tooling routet unter Umständen darüber. Breaking
  Changes bekommen ein `!` (`feat(api)!: …`) oder einen `BREAKING CHANGE:`-Footer.
  Betreffzeile ≤ 72 Zeichen, Imperativ („add“, „fix“, nicht „added“, „fixes“).
  Body auf 72 Zeichen umbrechen.
- Kleine, fokussierte Commits bevorzugen. Release-Tooling leitet Versionssprünge
  und Changelog oft aus den Commit-Betreffzeilen ab.
- Keine Ticket-Nummern in Code, Commits oder Docs.
- Kommentare erklären das *Warum*, nicht das *Was*. Code-Kommentare benennen die
  Absicht oder eine Einschränkung, die der Code nicht zeigen kann. Kommentare
  löschen, die den Code nur wiederholen.
- Kommentare und Docs immer als Ganzes betrachten. Nie nur anhängen. Im Kontext
  prüfen und auf den faktischen Stand bringen. Im Zweifel im Code recherchieren.
  Veraltete und aus dem Kontext gefallene Verweise entfernen, ebenso frühere
  Beobachtungen, Schilderungen von Situationen, die zu einer früheren Änderung
  führten, Maschinennamen oder -adressen sowie jede Vermutung über die
  nachgelagerte Nutzung dieses Repos und seiner Artefakte — abgesehen von
  gültigen, aktuellen Beispielen.
- Auf ein anderes Repository oder Projekt nur verweisen, wenn dessen Zustand der
  unmittelbare Grund für die Änderung ist (ein Dependency-Bump, ein eingespielter
  Fix, ein an eine veröffentlichte Version gebundener API-Vertrag). Kontext für
  Reviewer, Dank oder Querverweise gehören in den PR-Thread oder ein Issue, nicht
  in den Commit.
- Deklarative Fakten schreiben. Keine Personalpronomen („ich“, „wir“, „du“).
  Keine Leseransprache: kein „beachte, dass…“, „wie man sieht…“, „wir haben uns
  entschieden…“, „das sollte helfen…“. Die Regel gilt für Dokumentation, die
  ein Artefakt beschreibt. Ausgenommen sind die Aufgabenstellungen unter
  `assignments/` und die Ablaufskripte in den Demos, siehe unten.
- Nicht erzählen. Keine Historie, was zuerst versucht wurde, was scheiterte oder
  welche Alternativen erwogen wurden.
- Keine Füll-Verben ohne Konkretes. „Aufräumen“, „verbessern“, „refactoren“
  allein sagen nichts; entweder die tatsächliche Änderung benennen oder die Zeile
  weglassen.
- Keine Checklisten, keine „Summary“-/„Test plan“-Abschnitte, keine
  Marketing-Sprache, keine Emojis.

## Aufgabenstellungen

Je eine `assignments/<thema>/README.md` für `junit-basic`, `junit-advanced`,
`mockito` und `tdd`.

- **Gesiezt.** „Schreiben Sie Tests“, „Stellen Sie sicher“, „Verifizieren Sie“.
  Im ganzen Repo stehen 63 Sie-Formen gegen eine geduzte Stelle.
- Titel ist `# Aufgabe: <fachliche Domäne>`, nicht das Testwerkzeug. Die Übung
  hängt an einem Fachproblem (Lagerbestandsverwaltung, nicht „Mockito üben“).
- `## Szenario` beschreibt das System under Test: die Abhängigkeiten mit einem
  Halbsatz zu ihrer Rolle, danach jede Methode als Java-Signatur im Fence, ein
  Satz zu ihrem Verhalten und darunter die Ausnahmen, die sie wirft.
- Die Signatur ist die vollständige Spezifikation. Es gibt keinen
  Vorgabe-Code — die Teilnehmer bauen gegen diese Beschreibung.
- `## Aufgabe` listet die Testfälle als `### N. Test für <Fall>
  (<methode>)`. Jeder Fall ist eine Bullet-Liste aus „Stellen Sie sicher,
  dass …“ (Zustand) und „Verifizieren Sie, dass …“ (Interaktion).
- Negativfälle nennen ausdrücklich, welche Aufrufe **nicht** stattfinden
  dürfen. Das ist bei Mock-Aufgaben die halbe Aufgabe.
- Knapp auf Satzebene gilt weiterhin: keine Füll-Adjektive, kein Marketing,
  keine Zusammenfassung des Abschnitts darüber.

## Ablaufskripte in den Demos

Zwölf READMEs liegen **im Testquellbaum** neben dem Code, den sie erklären,
etwa
`demos/mockito-introduction/src/test/java/tech/erben/captorannotation/README.md`.

- Sie sind Notizen für den Trainer, nicht für die Teilnehmer: was in dieser
  Demo in welcher Reihenfolge gezeigt wird.
- Entsprechend kurz — ein bis drei Sätze. Titel ist `# Ablauf`, `# Teil N` oder
  `# <Thema> Ablauf`.
- Sie beschreiben, was der Code demonstriert, nicht wie er funktioniert. Die
  Erklärung passiert live.
- Eine neue Demo bekommt ihr README im selben Package wie die Testklassen,
  nicht im Modulwurzelverzeichnis.

## Vor dem Abschluss

- Lint, Tests und Build des Projekts für alles Berührte ausführen.
- `pre-commit run --all-files` und `mvn -B -V verify` im Wurzelverzeichnis
  laufen lassen.
- Wurde `demos/gradle-junit-tag-filter` berührt, zusätzlich `./gradlew test`
  darin — der Maven-Reaktor fasst dieses Modul nicht an.
- Nicht „fertig“ behaupten, ohne die Prüfung ausgeführt zu haben. Belege vor
  Behauptungen.
- Alle TODO-Marker entfernen, die du in deiner Sitzung hinzugefügt hast, und
  nacharbeiten — oder dem Nutzer sagen, dass ein Follow-up nötig ist. Alle Marker
  und Verweise auf deine eigene Aufgabenliste oder historische Arbeitsschritte
  (P2, P3a, Item 1, Task A usw.) samt ihrer Erzählung entfernen. Wenn wirklich
  etwas offen bleibt, dem Nutzer außerhalb von Code, Docs, Markdown, Kommentaren,
  PR-Beschreibungen, Commit-Nachrichten oder allem anderen in diesem Repo und
  seiner angeschlossenen Pipeline Bescheid geben.

## Aufbau dieses Repos

Kurs zu JUnit 5 und Mockito. Keine Folien im Repo. Wurzel-POM mit zwei
Reaktor-Modulen:

- `assignments/` — vier Übungen: `junit-basic`, `junit-advanced`, `mockito`,
  `tdd`. Jede bringt Produktivcode mit und lässt die Tests offen.
- `demos/` — fünf Maven-Module, die im Kurs vorgeführt werden
  (`junit5-introduction`, `mockito-introduction`, `hamcrest-introduction`,
  `testcontainers-introduction`, `empty-maven-project`), plus das
  Gradle-Projekt `gradle-junit-tag-filter`.

Die Demos sind nach Thema in Packages geschnitten (`tech.erben.captormethod`,
`tech.erben.staticmocking`, …), jedes mit eigenem Ablauf-README.

## Fallstricke dieses Repos

- **`demos/gradle-junit-tag-filter` steht nicht in `demos/pom.xml`.** Es ist
  ein Gradle-Projekt und wird vom Reaktor nicht gebaut. Ein grünes
  `mvn verify` sagt über dieses Modul nichts aus; es zeigt gerade das
  Tag-Filtern in Gradle und muss deshalb Gradle bleiben.
- **Es gibt keine Lösungen.** Kein `solutions/`-Baum, kein
  `*-solution`-Modul. Die Assignments bringen je eine Testklasse als
  Ausgangspunkt mit; ein Referenzstand existiert nicht.
- **`mvn verify` läuft in der CI nur in Merge Requests**
  (`if: $CI_MERGE_REQUEST_ID`). Ein direkter Push auf `main` baut nichts.
- **Kein Release und kein Deploy.** `.gitlab-ci.yml` bindet nur die drei
  Linter-Komponenten plus den Maven-Job ein. Der Scope einer Commit-Nachricht
  routet hier nichts.
- **`.markdownlint`-Konfiguration gibt es nicht.** Der Linter läuft auf
  Defaults. Prosa an der Zeilenbreite der bestehenden READMEs ausrichten
  (rund 70 Zeichen).
- **Die Ablauf-READMEs stehen tief im Testquellbaum.** Ein Blick in das
  Modulverzeichnis findet sie nicht; sie liegen unter
  `src/test/java/tech/erben/<thema>/`. Vor dem Anlegen eines neuen READMEs
  prüfen, ob dort schon eins liegt.
