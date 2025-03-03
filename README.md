# Plan
0. API entwickeln ✅
1. Things Datenbank bauen mit Mock Batterien etc. ✅
2. API bauen, die Things hinzufügen kann (Team Things Seite) ✅
4. API bauen, die Informationen aus Things API abrufen, verarbeiten und weitergeben kann (Team Applications API) -> Ich gehe davon aus, dass es die Applications API für eine Wohnung ist, die entweder 0/1 Batterien, Charger und Solarpanel hat
    1. Die Simulatoren können also entweder eine vorhande Batter/charger/solaparnal hinzufügen löschen oder updaten
    2. Eine ApplicationsAPI bauen, die die Strombilanz des Hauses zurückgibt
    3. Eine ApplicationsAPI bauen, die den charging status ändert, falls ein charger vorhanden ists
5. Irgendetwas bauen, dass die Applications API zufällig abruft, um Informationen zu bekommen, oder sowas wie einen Charging Status zu ändern
6. Irgendetwas bauen, dass die Things API zufällig aufruft und Dinge hinzufügt, bearbeitet oder löscht
