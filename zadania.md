## Zadania - agenda

Celem ćwiczeń jest przygotowanie funkcjonalności uproszczonego logowania użytkowników 
przez prosty formularz. Będzie to część aplikacji, która imituje serwis Tweeter.

1. Przygotowanie projektu. Konfiguracja serwera Tomacat
2. Przygotwanie infrastruktury trój-warstwowej
3. Przygotowanie strony początkowej (welcome page)
4. Stworzenie funkcji rejestracji użytkownika (widok + servlet)
5. Uporszczona funkcja logowania (widok + servlet) użytkownika w oparciu o:
    -> mechanizm sesji
    -> ciasteczka
    -> filtry
6. Przygotowanie stron błędów    
7. (*) Umożliwienie przesyłania pliku (zdjęcia użytkownika)
8. (*) Dołączenie do stron zasobów statycznych (pliki .js, .css)


## Zadania

**1. Przygotowanie projektu**

1. Stwórz nowy projekt w Intellij. Dodaj do niego wsparcie dla mavena.
2. Przykładowy plik pom.xml znajdziesz w tym projekcie. Zwróć uwagę, że musisz zaciągnąć biblioteki
do servletów.  

```xml
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>javax.servlet-api</artifactId>
            <version>3.1.0</version>
            <scope>provided</scope>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.0</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
```

Kolejną ważną cześcią jest skonfigurowanie pluginu maven, który buduje plik .war.

```xml
    <build>
        <finalName>jsptutorial</finalName>
        <sourceDirectory>src/main/java</sourceDirectory>

        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>2.3</version>
                <configuration>
                    <warSourceDirectory>src/main/java</warSourceDirectory>
                    <webappDirectory>web</webappDirectory>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
        </plugins>
    </build>
```

3. W folderze src/main stwórz swoje pakiety wg architektury 3-warstwowej.
4. W folderze web stworzysz strukturę, w których umieścisz pliki jsp i inne pliki statyczne.
Przykłądowa struktura folderu web:
```
-> web/
    -> img/
    -> jsp/
        -> errorPages/
            notFoundErrorPage.jsp
            registerErrorPage.jsp
            loginErrorPage.jsp
        login.jsp
        register.jsp
        secret.jsp
    -> META-INF/
    -> WEB-INF/
        web.xml
    index.jsp    
 ```       

**Stworzenie modelu, DAO i Serwisu**

1. Stwórz klasę User. Nadaj jej odpowiednie pola, gettery, setter, konstrukor, equals, hashCode
2. Stwórz w odpowiednim pakiecie klasę UserDAO. Będzie ona reprezentować warstwę dostępu do bazy danych.
Niech (dla uproszczenia) przechowuje ona obiekty w HashMapie.
3. Zaimplementuj podstawowe operacje dodawania/usuwania użytkowników w UserDAO.
4. Stwórz klasę service, która będzie stanowić warstę logiki biznesowej i będzie korzystać
z UserDAO

`Uwaga!` Na początku stwórz podstawowe metody createUser, getUserById, getUserByLogin. Kolejne metody, które pozwolą na bajdziej
zaawansowane wyszukiwanie/modyfikowanie użytkowników zostaw sobie na później.

**Stworzenie widoku**
1. Stwórz pliki .jsp
    * **index.jsp** - będzie on zawierał linki do login.jsp i register.jsp
    * **register.jsp** - będzie zawierał prosty formularz rejstracyjny, który będzie przyjmował od użytkownika login i hasło
    Po prawidłowym logowaniu użytkownik jest przenoszony do strony login.jsp. Po nieprawidłowym logowaniu użytkownik ma być przeniesoiny do strony błędu
    * **login.jsp** - będzie on zawierał formularz logowania
    * **secret.jsp** - będzie to strona, która jest, która nie może być oglądana przez niezalogowanych użytkowników
**Stworzenie kontrolerów**

1. Stwórz servlet ```RegisterAction.java```, który będzie obsługiwał proces rejestracji.
Servlet ten powinien w metodzie ```doPost(..)``` pobrać dane przesłane w formularzu,
zwalidować je, stworzyć obiekt używkonika i za pomocą stworzonego wcześniej serwisu
zapisać go. 

2. Stwórz serwlet ```LoginAction.java```, który będzie obsługiwał proces uproszczonego logowania.
 Niech użytkownik z każdym następnym requetm przesyła w ciasteczku swoje id, w celu identyfikacji. Dodatkowo w 
 sesji użytkowika musi być zapisana informacja o tym, że użytkownik się zalogował
3. Proces identyfikacji niech będzie przeprowadzany w filtrze ```AuthFilter.java```, który będzie sprawdzał, czy z kolejnymi requestami, czy w ciasteczku znajduje się
informacja o użytkowniku i będzie ją porównywać z informacją zapisaną w sesji.
Jeżli filter wykryje, że użytkownik nie jest zalogowany, to niech rzuca przygotowany wyjątek,
który w następnym punkcie posłuży do wygenerowania strony błędu. 
4. Przygotuj wcześniej strony błędów, na które będzie przekierowany użytkownik. Obsłuż przynajmniej 
  błąd serwera 500 i nieznalezione zasób 404 i jeden swój wyjątek.

**Zadania dodatkowe**

1. W opcji rejestracji stwórz dodakowe opcje, które użytkownik może sobie skonfigurować.
Niech te informacje będą przechowywane w ciasteczku i/lub sesji.
2. Stwórz dodatkowy filter lub zmodyfikuj istniejący, który będzie wylogowywał do pliku wszelkie nieudane logowania
3. Stwórz możliwość wgrywania zdjęcia podczas procesu rejestracji użytkownika. Nich po zalogowaniu 
użytkownik widzi to zdjęcie.