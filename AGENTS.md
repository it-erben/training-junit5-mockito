# Arbeitsregeln

Ton, Schreibweise und Commit-Regeln stehen in der Nutzer-Konfiguration
(`~/.claude/CLAUDE.md`, Abschnitte "Schreibweise in deutschen Texten" und
"Arbeitsregeln in Repos"). Hier steht nur, was in diesem Repo dazukommt oder
abweicht.

## Aufgabenstellungen

Je eine `assignments/<thema>/README.md` für `junit-basic`, `junit-advanced`,
`mockito` und `tdd`.

- **Gesiezt.** "Schreiben Sie Tests", "Stellen Sie sicher", "Verifizieren Sie".
  Im ganzen Repo stehen 63 Sie-Formen gegen eine geduzte Stelle.
- Titel ist `# Aufgabe: <fachliche Domäne>`, nicht das Testwerkzeug. Die Übung
  hängt an einem Fachproblem (Lagerbestandsverwaltung, nicht "Mockito üben").
- `## Szenario` beschreibt das System under Test: die Abhängigkeiten mit einem
  Halbsatz zu ihrer Rolle, danach jede Methode als Java-Signatur im Fence, ein
  Satz zu ihrem Verhalten und darunter die Ausnahmen, die sie wirft.
- Die Signatur ist die vollständige Spezifikation. Es gibt keinen
  Vorgabe-Code. Die Teilnehmer bauen gegen diese Beschreibung.
- `## Aufgabe` listet die Testfälle als `### N. Test für <Fall>
  (<methode>)`. Jeder Fall ist eine Bullet-Liste aus "Stellen Sie sicher,
  dass ..." (Zustand) und "Verifizieren Sie, dass ..." (Interaktion).
- Negativfälle nennen ausdrücklich, welche Aufrufe **nicht** stattfinden
  dürfen. Das ist bei Mock-Aufgaben die halbe Aufgabe.

## Ablaufskripte in den Demos

Zwölf READMEs liegen **im Testquellbaum** neben dem Code, den sie erklären,
etwa
`demos/mockito-introduction/src/test/java/tech/erben/captorannotation/README.md`.

- Sie sind Notizen für den Trainer, nicht für die Teilnehmer: was in dieser
  Demo in welcher Reihenfolge gezeigt wird.
- Entsprechend kurz: ein bis drei Sätze. Titel ist `# Ablauf`, `# Teil N` oder
  `# <Thema> Ablauf`.
- Sie beschreiben, was der Code demonstriert, nicht wie er funktioniert. Die
  Erklärung passiert live.
- Eine neue Demo bekommt ihr README im selben Package wie die Testklassen,
  nicht im Modulwurzelverzeichnis.

## Vor dem Abschluss

- `pre-commit run --all-files` und `mvn -B -V verify` im Wurzelverzeichnis
  laufen lassen.
- Wurde `demos/gradle-junit-tag-filter` berührt, zusätzlich `./gradlew test`
  darin. Der Maven-Reaktor fasst dieses Modul nicht an.

## Aufbau dieses Repos

Kurs zu JUnit 5 und Mockito. Keine Folien im Repo. Wurzel-POM mit zwei
Reaktor-Modulen:

- `assignments/`: vier Übungen: `junit-basic`, `junit-advanced`, `mockito`,
  `tdd`. Jede bringt Produktivcode mit und lässt die Tests offen.
- `demos/`: fünf Maven-Module, die im Kurs vorgeführt werden
  (`junit5-introduction`, `mockito-introduction`, `hamcrest-introduction`,
  `testcontainers-introduction`, `empty-maven-project`), plus das
  Gradle-Projekt `gradle-junit-tag-filter`.

Die Demos sind nach Thema in Packages geschnitten (`tech.erben.captormethod`,
`tech.erben.staticmocking`, ...), jedes mit eigenem Ablauf-README.

## Fallstricke dieses Repos

- **`demos/gradle-junit-tag-filter` steht nicht in `demos/pom.xml`.** Es ist
  ein Gradle-Projekt und wird vom Reaktor nicht gebaut. Ein grünes
  `mvn verify` sagt über dieses Modul nichts aus; es zeigt gerade das
  Tag-Filtern in Gradle und muss deshalb Gradle bleiben.
- **Es gibt keine Lösungen.** Kein `solutions/`-Baum, kein
  `*-solution`-Modul. Die Assignments bringen je eine Testklasse als
  Ausgangspunkt mit; ein Referenzstand existiert nicht.
- **`mvn verify` läuft auf GitLab nur in Merge Requests**
  (`if: $CI_MERGE_REQUEST_ID`). Ein direkter Push auf `main` baut dort
  nichts.
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
- **Die CI läuft auf zwei Plattformen.** `.gitlab-ci.yml` bindet die
  GitLab-Komponenten ein, `.github/workflows/ci.yml` ruft `lint.yml` und
  `maven.yml` aus `it-erben/ci`. Auf GitHub laufen beide auch bei einem Push
  auf `main`.
