## Zadania - agenda

1. Ćwiczenie pisania plików .jsp
2. Kontynuacja zadań z poprzednich zajęć - tworzenie aplikacji imitującej Tweetera

## Zadania

**1. Ćwiczenia z jsp**

1. Napisz stronę JSP, która doda dla użytkownika dwie liczby, które poda on 
jako parametry zapytania GET w URL. Niech wynik będzie wyświetlony na ekranie.

2.  Napisz stronę jsp, która będzie działać jak lista zakupów.
    -> użytkownik wysyła przez HTTP GET wartości w parametrach `productName` i `productCount`
    -> stronaJsp zapisuje w sesji mapę produktów
    -> użytkownik widzi na stronie tabelkę z listą zakupów 

3. Do strony z zadania 2, użyj dyrektywy include aby dołączyć części strony z innych plików.
    -> header.jsp
    -> footer.jsp
4. Do strony z zdania 2 dodaj zminną, która będzie zliczać odwiedzenia strony.
(wartość ma być podnoszona po każdym odświeżeniu)    
    
5. Niech strona z zadania 2 zapisuje na przeglądarce ciasteczko z produkterm, którego
wartość `productCount` jest największa. Nich strona wyświetla tą informację.

6. Stwórz klasę PriceServiceBean, która będzie przetrzymywać statyczną mapę z 
cenami produktów oraz z metodami, które pozwolą policzyć ceny produktóœ. Niech użytkownik w tabeli z produktami zobaczy ile będzie musiał
za nie zapłacić oraz totalną cenę za wszystkie produkty z listy.

**2. Kontynuacja ćwiczeń z poprzednich zajęć**
1. Importowanie statycznych plików do jsp. Stwórz arkusze styli dla swoich stron.
Zaimportuj je tak, aby zaaplikować je w HTML.
2. Stwórz model dla Postów użytkowników. Oraz podstawowe serwisy, które umożliwią
dodawanie i wyświetlanie postów. Niech Post będzie obiektem, który ma pola
    -> dataUtworzenia
    -> userId
    -> text
    
3. Stwórz stronę jsp, która będzie wyświetlać na górze formularz za pomocą którego
użytkonik może dodać nowy post. Stwórz servlet `PostAction`, który obsłuży proces dodawania
posta.

4. Stwórz funkcjonalnoś wylogowywania się. Klasa `LogutAction` będąca servletem
powinna kasować id zalogowanego użytkownika z sesji oraz kasować ciasteczko na przeglądarce.

5. Dodaj do postów możliwość komentowania ich. Pod każdym postem powinna pojawić się możliwość komentowania 
jako osobny formularz oraz lista dodanych komentarzy. Będziesz do tego potrzebował rozszrzyć model. 
Wykorzystaj tagi biblioteki JSTL. 

6. Dodaj możliwość modyfikacji swojego profilu przez użytkownika (wgrywanie zdjęcia, dane personalzacyjne tj. kolory
wielkość czcionki w ciasteczkach)

